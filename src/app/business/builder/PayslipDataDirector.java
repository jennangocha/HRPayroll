package app.business.builder;

import app.business.IPayslipPeriod;
import app.business.abstractFactory.IPayrollCalculationStrategyFactory;
import app.business.prototype.PayslipData;
import app.domain.Employee;
import app.domain.PayslipPeriod;
/*Owner: Jmmy*/
public class PayslipDataDirector {

	private IPayslipDataBuilder builder=null;
	
	public PayslipDataDirector(IPayslipDataBuilder builder) {
		this.builder=builder;
	}
	
	public void constructPayslipData(Employee e,PayslipPeriod p,IPayrollCalculationStrategyFactory strategys) {
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
