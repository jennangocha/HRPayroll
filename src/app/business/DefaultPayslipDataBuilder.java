package app.business;

import java.util.List;

import app.domain.Employee;
import app.domain.PayslipData;
/*Owner: Jmmy*/
public class DefaultPayslipDataBuilder implements IPayslipDataBuilder{

	private PayslipData payslipData;
	
	public DefaultPayslipDataBuilder() {
		payslipData=new PayslipData();
	}

	public void buildEmployee(Employee e) {
		payslipData.setEmployeeInfo(e);
	}
	
	@Override
	public void buildPeriod(IPayslipPeriod p) {
		// TODO Auto-generated method stub
		payslipData.setPayslipPeriod(p);
	}
	 
	@Override
	public void buildEarning(List<IEarningStrategy> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildDeduction(List<IDeductionStrategy> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buildBasicPay(List<IBasicPayStrategy> s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PayslipData getPayslipData() {
		// TODO Auto-generated method stub
		return payslipData;
	}

	
	
	 
}
