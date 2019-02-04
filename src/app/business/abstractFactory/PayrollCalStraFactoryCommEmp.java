package app.business.abstractFactory;

import java.util.ArrayList;
import java.util.List;

import app.business.strategy.BasicPayStrategyCommEmp;
import app.business.strategy.DeductionStrategyLeaveEmp;
import app.business.strategy.IBasicPayStrategy;
import app.business.strategy.IDeductionStrategy;
import app.business.strategy.IEarningStrategy;
/*Owner: Jmmy*/
public class PayrollCalStraFactoryCommEmp implements IPayrollCalculationStrategyFactory {
 	
	List<IDeductionStrategy> deduction= new ArrayList<IDeductionStrategy>();
	List<IEarningStrategy> earning= new ArrayList<IEarningStrategy>();
	List<IBasicPayStrategy> basicpay= new ArrayList<IBasicPayStrategy>();		
	
	@Override
	public List<IDeductionStrategy> getDeduStrategy() {
		// TODO Auto-generated method stub
		
		
		deduction.add(new DeductionStrategyLeaveEmp());
		 
		return deduction;
	}

	@Override
	public List<IEarningStrategy> getEarningStrategy() {
		// TODO Auto-generated method stub
	
		/*no earning*/
		return earning;
	}

	@Override
	public List<IBasicPayStrategy> getBasicStrategy() {
		// TODO Auto-generated method stub		
		
		basicpay.add(new BasicPayStrategyCommEmp());
		
		return basicpay;
	}

}
