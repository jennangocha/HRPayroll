package app.business;

import app.domain.Employee;
import app.domain.PayslipData;
import app.domain.PayslipPeriod;
/*Owner: Jmmy*/
public class PayslipDataDirector {

	private IPayslipDataBuilder builder=null;
	
	public PayslipDataDirector(IPayslipDataBuilder builder) {
		this.builder=builder;
	}
	
	public void constructPayslipData(Employee e,IPayslipPeriod p,IPayrollCalculationStrategyFactory strategys) {
		builder.buildEmployee(e);
		builder.buildPeriod(p);
		builder.buildDeduction(strategys.getDeduStrategy());
		builder.buildEarning(strategys.getEarningStrategy());
		builder.buildBasicPay(strategys.getBasicStrategy());
	}
	
	public PayslipData getPayslipData() {
		return builder.getPayslipData();
	}
}
