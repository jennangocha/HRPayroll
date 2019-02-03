package app.business.builder;

import java.util.List;

import app.business.prototype.PayslipData;
import app.business.strategy.IBasicPayStrategy;
import app.business.strategy.IDeductionStrategy;
import app.business.strategy.IEarningStrategy;
import app.domain.Employee;
import app.domain.PayslipPeriod;
/*Owner: Jmmy*/
public class PayslipDataBuilder implements IPayslipDataBuilder{

	private PayslipData payslipData;
	
	public PayslipDataBuilder() {
		payslipData=new PayslipData();
	}

	public void buildEmployee(Employee e) {
		payslipData.setEmployeeInfo(e);
	}
	
	@Override
	public void buildPeriod(PayslipPeriod p) {
		// TODO Auto-generated method stub
		payslipData.setPayslipPeriod(p);
	}
	 
	@Override
	public void buildEarning(List<IEarningStrategy> s) {
		// TODO Auto-generated method stub
		payslipData.addEarning(s);
	}

	@Override
	public void buildDeduction(List<IDeductionStrategy> s) {
		// TODO Auto-generated method stub
		payslipData.addDeduction(s);
	}

	@Override
	public void buildBasicPay(List<IBasicPayStrategy> s) {
		// TODO Auto-generated method stub
		payslipData.addBasicPay(s);
	}

	@Override
	public PayslipData getPayslipData() {
		// TODO Auto-generated method stub
		return payslipData;
	}		
	 
}
