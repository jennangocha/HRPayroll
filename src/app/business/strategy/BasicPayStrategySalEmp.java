package app.business.strategy;
 
import app.domain.Employee;
import app.domain.PayslipPeriod;

public class BasicPayStrategySalEmp implements IBasicPayStrategy {

	@Override
	public double calcBasic(Employee e, PayslipPeriod p) {
		// TODO Auto-generated method stub
		double basicSalary=e.getBasicSalary();
		return basicSalary;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Basic Pay";
	}
	
}
