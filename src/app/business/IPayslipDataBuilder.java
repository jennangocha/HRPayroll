package app.business;

import java.util.List;

import app.domain.Employee;
import app.domain.PayslipData;
/*Owner: Jmmy*/
public interface IPayslipDataBuilder {
	public void buildEmployee(Employee e);
	public void buildEarning(List<IEarningStrategy> s);	
	public void buildDeduction(List<IDeductionStrategy> s);
	public void buildBasicPay(List<IBasicPayStrategy> s);
	public PayslipData getPayslipData();
}
