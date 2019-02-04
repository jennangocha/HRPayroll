package app.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import app.business.prototype.PayslipData;
import app.business.proxy.IPaySlipGenerator;
import app.business.proxy.PaySlipGeneratorProxy;
import app.domain.Employee;
import app.domain.PayslipPeriod;
import app.domain.User;
import app.exceptions.AuthenticationError;
import app.service.EmployeeServiceImpl;
import app.service.UserService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import report.facade.SalaryPDF;
import report.template.ApayslipProcessor;
import report.template.MonthlyPayslip;

public class SalaryReport implements Initializable{
	private User user;
	@FXML ListView empList;
	@FXML DatePicker frmDate;
	@FXML DatePicker toDate;
	@FXML ListView DisplayPayslip;
	@FXML Button btnSubmit;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		payslipScreen();
		btnSubmit.setOnAction(event -> {
			ObservableList selectedIndices = empList.getSelectionModel().getSelectedIndices();
			System.out.println(selectedIndices);
			
			int index= Integer.valueOf(selectedIndices.get(0).toString());
			System.out.println(index);
			List<Employee> e=EmployeeServiceImpl.getInstance().getAllEmployee();
			String employeeCode=e.get(index).getEmpCode();
			user=UserService.getInstance().getUserByUsername("admin");
			PayslipPeriod period=new PayslipPeriod(java.sql.Date.valueOf("2019-01-01"),java.sql.Date.valueOf("2019-02-28"));
			HashMap<String,String> list=new HashMap<String,String>();
			IPaySlipGenerator payslipProxy=new PaySlipGeneratorProxy(user);
			try {
				//e=(List<Employee>) EmployeeService.getInstance().getEmployeeById(employeeCode);
				Map<String, PayslipData> m=payslipProxy.generate(period,e );
				
				for (Object key : m.keySet()) {
					if(m.get(key).getEmployeeInfo().getEmpCode().equals(employeeCode)){
						System.out.println(m.get(key).getTotalBasicPay());
						System.out.println(m.get(key).getNetWage());
						System.out.println(m.get(key).getTotalDeducation());
						System.out.println(m.get(key).getPayslipPeriod().getFromDate());
						System.out.println(m.get(key).getPayslipPeriod().getToDate());
						//data[][]=
						Employee em=m.get(key).getEmployeeInfo();
						list.put("branch", em.getBranchName());
						list.put("department", em.getDepartmentName());
						list.put("name", em.getFirstName()+" "+em.getLastName());
						list.put("position", em.getPosition());
						list.put("empcode", em.getEmpCode());
						list.put("totalBasicPay", String.valueOf(m.get(key).getTotalBasicPay()));
						list.put("totalDeducation", String.valueOf(m.get(key).getTotalDeducation()));
						list.put("NetWage", String.valueOf(m.get(key).getNetWage()));
						list.put("formdate", m.get(key).getPayslipPeriod().getFromDate().toString());
						list.put("todate", m.get(key).getPayslipPeriod().getToDate().toString());
					}
					
				}
				ApayslipProcessor ap=new MonthlyPayslip(list, "Playslip of "+list.get("name"));
				ap.processPayslip();
				//SalaryPDF sp=new SalaryPDF();
				//sp.createPDF(list,"Playslip of "+list.get("name"));
			} catch (AuthenticationError ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		});
	}
	public void payslipScreen() {
		frmDate.setValue(LocalDate.of(2019, 01, 1));
		toDate.setValue(LocalDate.of(2019, 2, 28));
		List<Employee> e=EmployeeServiceImpl.getInstance().getAllEmployee();
		for(int i=0;i<e.size();i++)
		empList.getItems().add(e.get(i).getFirstName());
		
		empList.getSelectionModel().select(0);
	}

}
