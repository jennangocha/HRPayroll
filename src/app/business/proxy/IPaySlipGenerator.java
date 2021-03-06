package app.business.proxy;

import java.util.List;
import java.util.Map;
 
import app.business.prototype.PayslipData;
import app.domain.Employee;
import app.domain.PayslipPeriod;
import app.exceptions.AuthenticationError; 
/*Owner: Jmmy*/
public interface IPaySlipGenerator {
	public Map<String, PayslipData> generate(PayslipPeriod period,List<Employee> e) throws AuthenticationError ;
}
