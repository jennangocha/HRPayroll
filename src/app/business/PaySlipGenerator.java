package app.business;

import java.util.List;
import java.util.Map;

import app.domain.Employee;
import app.domain.PayslipData;

public class PaySlipGenerator {
 
	private PaySlipGenerator() {}
	
	public static PaySlipGenerator getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	private static class SingletonHelper{
	        private static final PaySlipGenerator INSTANCE = new PaySlipGenerator();
    }
	
	public Map<String, PayslipData> generate(IPayslipPeriod period,List<Employee> e) {
		
		 PayslipDataVisitor visitor=new PayslipDataVisitor();
		 visitor.setPayslipPeriod(period);
		 
		 for(Employee emp : e)
			 emp.accept(visitor);
		 
		 return visitor.getPayslipCol();
	}
}
