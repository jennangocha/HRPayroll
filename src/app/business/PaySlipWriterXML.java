package app.business;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import app.business.prototype.PayslipData; 
import app.domain.Employee;
import javafx.scene.control.Alert;

public class PaySlipWriterXML implements IPaySlipWriter{
	
	PaySlipWriterXML() {}
	
	public static PaySlipWriterXML getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	private static class SingletonHelper{
	        private static final PaySlipWriterXML INSTANCE = new PaySlipWriterXML();
    }
	

	@Override
	public void write(Map<String, PayslipData> data, String exportPath) {
		// TODO Auto-generated method stub
		for (Object key : data.keySet()) {
            System.out.println("Key : " + key.toString());
            data.get(key).print();
        }
		
		for (Object key : data.keySet()) {
            
			try {
				marshalingXML(data.get(key),exportPath);
				showAlert(exportPath);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				showError(exportPath);
				e.printStackTrace();
			}
        }
		
		
	}	
	
	public void showAlert(String exportPath) {
		Alert a=new Alert(Alert.AlertType.INFORMATION, String.format("Successfully export to : %s",exportPath));
		a.setHeaderText("Generate Payslip");
		a.showAndWait();
	}
	
	public void showError(String exportPath) {
		Alert a=new Alert(Alert.AlertType.ERROR, String.format("Exporting to : %s failed !",exportPath));
		a.setHeaderText("Generate Payslip");
		a.showAndWait();
	}
	 
	private void marshalingXML(PayslipData data, String exportPath) throws JAXBException
	{
	    JAXBContext jaxbContext = JAXBContext.newInstance(PayslipData.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	     
	    //Marshal the employees list in console
	    jaxbMarshaller.marshal(data, System.out);
	    
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    File file = new File(getFileName(data.getEmployeeInfo(),exportPath));
	   // File file = new File("D:\\Java\\customer.xml");
	    jaxbMarshaller.marshal(data, file);// this line create customer.xml file in specified path.

	}
	
	private String getFileName(Employee e, String exportPath){
		return String.format("%s\\%s_%s.xml",exportPath ,e.getEmpCode(),getCurrentLocalDateTimeStamp());
	}
	private String getCurrentLocalDateTimeStamp() {
	    return LocalDateTime.now()
	       .format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss"));
	}
 

	@Override
	public String getWriterName() {
		// TODO Auto-generated method stub
		return "XML";
	}

	
}
