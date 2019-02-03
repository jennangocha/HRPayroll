package app.business.strategy;
 
import app.domain.Employee;
import app.domain.PayslipPeriod;
import app.domain.StrategyType;

/*Owner: Jmmy*/
public interface IDeductionStrategy {
	public String Type=StrategyType.Deduction.getName();	
	public double calcDedu(Employee e,PayslipPeriod p);
	public String getTitle();
}
