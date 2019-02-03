package app.business.builder;

import java.util.List;
 
import app.business.abstractFactory.IBasicPayStrategy;
import app.business.abstractFactory.IDeductionStrategy;
import app.business.abstractFactory.IEarningStrategy;
import app.business.prototype.PayslipData;
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
