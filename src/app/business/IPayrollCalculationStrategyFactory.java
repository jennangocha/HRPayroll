package app.business;

import java.util.ArrayList;
import java.util.List;

public interface IPayrollCalculationStrategyFactory {

	public List<IDeductionStrategy> getDeduStrategy();
	public List<IEarningStrategy>  getEarningStrategy();
	public List<IBasicPayStrategy>  getBasicStrategy();
}
