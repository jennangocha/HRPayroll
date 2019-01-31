package app.business;

import app.domain.Employee;
import app.domain.PayslipData;

public class PayslipDataDirector {

	private IPayslipDataBuilder builder=null;
	
	public PayslipDataDirector(IPayslipDataBuilder builder) {
		this.builder=builder;
	}
	
	public void constructPayslipData(Employee e,IPayrollCalculationStrategyFactory strategys) {
		builder.buildEmployee(e);
		builder.buildDeduction(strategys.getDeduStrategy());
		builder.buildEarning(strategys.getEarningStrategy());
		builder.buildBasicPay(strategys.getBasicStrategy());
	}
	
	public PayslipData getPayslipData() {
		return builder.getPayslipData();
	}
}
