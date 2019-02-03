package app.business.abstractFactory;
 
import app.domain.Employee;
import app.domain.PayslipPeriod;
import app.domain.StrategyType;

/*Owner: Jmmy*/
public interface IEarningStrategy {
	
	public String Type=StrategyType.Earning.getName();	
	public double calcEarn(Employee e,PayslipPeriod p);
	public String getTitle();
}
