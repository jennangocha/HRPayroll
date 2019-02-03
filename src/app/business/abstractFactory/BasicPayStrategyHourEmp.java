package app.business.abstractFactory;

import app.business.IPayslipPeriod;
import app.domain.Employee;

public class BasicPayStrategyHourEmp implements IBasicPayStrategy {

	@Override
	public double calcBasic(Employee e, IPayslipPeriod p) {
		// TODO Auto-generated method stub
		double hourlyWage=e.getBasicSalary();
		double totalWorkingHr=0;
		return hourlyWage*totalWorkingHr;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Basic Pay";
	}
}