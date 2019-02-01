package app.business;

import app.domain.Employee;

public class BasicPayStrategySalEmp implements IBasicPayStrategy {

	@Override
	public double calcBasic(Employee e, IPayslipPeriod p) {
		// TODO Auto-generated method stub
		double basicSalary=0;
		return basicSalary;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Basic Pay";
	}
	
}
