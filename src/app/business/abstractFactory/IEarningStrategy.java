package app.business.abstractFactory;

import app.business.IPayslipPeriod;
import app.domain.Employee;
import app.domain.StrategyType;

/*Owner: Jmmy*/
public interface IEarningStrategy {
	
	public String Type=StrategyType.Earning.getName();	
	public double calcEarn(Employee e,IPayslipPeriod p);
	public String getTitle();
}
