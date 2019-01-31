package app.business;

import app.domain.Employee;

/*Owner: Jmmy*/
public interface IEarningStrategy {
	public double calcEarn(Employee e,IPayslipPeriod p);
}
