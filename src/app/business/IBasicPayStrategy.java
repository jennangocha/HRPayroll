package app.business;

import app.domain.*;

/*Owner: Jmmy*/
public interface IBasicPayStrategy {

	public double calcBasic(Employee e,IPayslipPeriod p);
}
