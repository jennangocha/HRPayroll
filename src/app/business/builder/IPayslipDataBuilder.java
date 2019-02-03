package app.business.builder;

import java.util.List;

import app.business.prototype.PayslipData;
import app.business.strategy.IBasicPayStrategy;
import app.business.strategy.IDeductionStrategy;
import app.business.strategy.IEarningStrategy;
import app.domain.Employee;
import app.domain.PayslipPeriod;
/*Owner: Jmmy*/
public interface IPayslipDataBuilder {
	public void buildEmployee(Employee e);
	public void buildPeriod(PayslipPeriod p);
	public void buildEarning(List<IEarningStrategy> s);	
	public void buildDeduction(List<IDeductionStrategy> s);
	public void buildBasicPay(List<IBasicPayStrategy> s);
	public PayslipData getPayslipData();
}
