package app.business.abstractFactory;

import app.business.IPayslipPeriod;
import app.domain.Employee;

public class DeductionStrategyLeaveEmp implements IDeductionStrategy{

	@Override
	public double calcDedu(Employee e, IPayslipPeriod p) {
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
