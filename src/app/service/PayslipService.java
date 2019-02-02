package app.service;

import java.util.List;
import java.util.Map;

import app.business.IPayslipPeriod;
import app.business.IPayslipTemplete;
import app.business.prototype.PayslipData;
import app.business.proxy.PaySlipGeneratorProxy;
import app.domain.Employee;
import app.domain.User;
import app.exceptions.AuthenticationError; 

public class PayslipService {
 
	public static void print(User user,List<Employee> e,IPayslipPeriod period,IPayslipTemplete templete,String exportPath) {
		
		PaySlipGeneratorProxy payslipProxy=new PaySlipGeneratorProxy(user);
		
		try {
			Map<String, PayslipData> data=payslipProxy.generate(period, e);
			
			templete.print(data, exportPath);
			
		} catch (AuthenticationError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
