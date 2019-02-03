package app.business.abstractFactory;

import app.business.IPayslipPeriod;
import app.domain.*;

/*Owner: Jmmy*/
public interface IBasicPayStrategy {
	public String Type=StrategyType.BasicPay.getName();	
	public double calcBasic(Employee e,IPayslipPeriod p);
	public String getTitle();
	
}
