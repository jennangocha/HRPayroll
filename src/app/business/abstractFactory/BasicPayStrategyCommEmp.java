package app.business.abstractFactory;

import app.business.IPayslipPeriod;
import app.domain.Employee;

public class BasicPayStrategyCommEmp implements IBasicPayStrategy{
	
	@Override
	public double calcBasic(Employee e, IPayslipPeriod p) {
		// TODO Auto-generated method stub
		double commession=0;
		double baseSalary=e.getBasicSalary();
		
		return commession+baseSalary;
	}
 
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "BasicPay";
	}

	
}
