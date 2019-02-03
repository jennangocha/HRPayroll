package app.business.abstractFactory;

import java.util.List;
/*Owner: Jmmy*/
public interface IPayrollCalculationStrategyFactory {

	public List<IDeductionStrategy> getDeduStrategy();
	public List<IEarningStrategy>  getEarningStrategy();
	public List<IBasicPayStrategy>  getBasicStrategy();
}
