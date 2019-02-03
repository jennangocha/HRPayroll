package app.business.strategy;

import app.domain.Employee;
import app.domain.PayslipPeriod;
import app.domain.StrategyType;

/*Owner: Jmmy*/
public interface IBasicPayStrategy {
	public String Type=StrategyType.BasicPay.getName();	
	public double calcBasic(Employee e,PayslipPeriod p);
	public String getTitle();
	
}
