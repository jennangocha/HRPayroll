package app.business;

import app.domain.Employee;
import app.domain.StrategyType;

/*Owner: Jmmy*/
public interface IDeductionStrategy {
	public String Type=StrategyType.Deduction.getName();	
	public double calcDedu(Employee e,IPayslipPeriod p);
	public String getTitle();
}
