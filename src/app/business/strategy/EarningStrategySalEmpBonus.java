package app.business.strategy;
 
import app.domain.Employee;
import app.domain.PayslipPeriod;
/*Owner: Jmmy*/
public class EarningStrategySalEmpBonus implements IEarningStrategy{

	@Override
	public double calcEarn(Employee e, PayslipPeriod p) {
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
