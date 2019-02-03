package app.business.strategy;
 
import app.domain.Employee;
import app.domain.PayslipPeriod;
/*Owner: Jmmy*/
public class DeductionStrategyLeaveEmp implements IDeductionStrategy{

	@Override
	public double calcDedu(Employee e, PayslipPeriod p) {
		// TODO Auto-generated method stub
		double totalAbsent=0;
		double deductionPerDay=0;
		return totalAbsent*deductionPerDay;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Leave-Absent";
	}

}
