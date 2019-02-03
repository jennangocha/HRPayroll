package app.business.abstractFactory;
 
import app.domain.Employee;
import app.domain.PayslipPeriod;

public class BasicPayStrategyHourEmp implements IBasicPayStrategy {

	@Override
	public double calcBasic(Employee e, PayslipPeriod p) {
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