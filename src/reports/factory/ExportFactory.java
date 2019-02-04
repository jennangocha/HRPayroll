package reports.factory;

public class ExportFactory implements IFactory{
	 public ExportReport getReport(String exportType){
	      if(exportType == null){
	         return null;
	      }		
	      if(exportType.equalsIgnoreCase("pdf")){
	         return new ExportPdf();
	         
	      } else if(exportType.equalsIgnoreCase("excel")){
	         return new ExportExcel();
	         
	      } 	      
	      return null;
	   }
}
