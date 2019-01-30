package app.business;
 
import app.domain.*;

public interface IPayrollDataStrategy {

	public PayslipDataComponent createPayrollData(HourlyEmployee e); 
}
