package app.business.abstractFactory;

import java.util.List;

import app.business.IBasicPayStrategy;
import app.business.IDeductionStrategy;
import app.business.IEarningStrategy;
/*Owner: Jmmy*/
public interface IPayrollCalculationStrategyFactory {

	public List<IDeductionStrategy> getDeduStrategy();
	public List<IEarningStrategy>  getEarningStrategy();
	public List<IBasicPayStrategy>  getBasicStrategy();
}
