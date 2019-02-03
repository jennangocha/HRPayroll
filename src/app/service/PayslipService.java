package app.service;
 
import java.util.List;
import java.util.Map;

import app.business.IPaySlipWriter; 
import app.business.prototype.PayslipData;
import app.business.proxy.IPaySlipGenerator;
import app.business.proxy.PaySlipGeneratorProxy;
import app.domain.Employee;
import app.domain.PayslipPeriod;
import app.domain.User;
import app.exceptions.AuthenticationError; 

public class PayslipService {
 
	public static void print(User user,List<Employee> e,PayslipPeriod period,IPaySlipWriter writer,String exportPath) {
		
		IPaySlipGenerator payslipProxy=new PaySlipGeneratorProxy(user);
		
		try {
			Map<String, PayslipData> data=payslipProxy.generate(period, e);
			 
			writer.write(data, exportPath);
			
		} catch (AuthenticationError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
