package app.business.strategy;
 
import app.domain.Employee;
import app.domain.PayslipPeriod;
/*Owner: Jmmy*/
public class BasicPayStrategyCommEmp implements IBasicPayStrategy{
	
	@Override
	public double calcBasic(Employee e, PayslipPeriod p) {
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
