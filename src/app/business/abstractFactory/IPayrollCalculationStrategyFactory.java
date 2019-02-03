package app.business.abstractFactory;

import java.util.List;

import app.business.strategy.IBasicPayStrategy;
import app.business.strategy.IDeductionStrategy;
import app.business.strategy.IEarningStrategy;
/*Owner: Jmmy*/
public interface IPayrollCalculationStrategyFactory {

	public List<IDeductionStrategy> getDeduStrategy();
	public List<IEarningStrategy>  getEarningStrategy();
	public List<IBasicPayStrategy>  getBasicStrategy();
}
