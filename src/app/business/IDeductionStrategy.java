package app.business;

import app.domain.Employee;

/*Owner: Jmmy*/
public interface IDeductionStrategy {
	public double calcDedu(Employee e,IPayslipPeriod p);
}
