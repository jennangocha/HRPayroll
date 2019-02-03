package app.business.abstractFactory;

import app.business.IPayslipPeriod;
import app.domain.Employee;

public class EarningStrategySalEmpBonus implements IEarningStrategy{

	@Override
	public double calcEarn(Employee e, IPayslipPeriod p) {
		// TODO Auto-generated method stub
		double bonus=0;
		
		return bonus;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Bonus";
	}

}
