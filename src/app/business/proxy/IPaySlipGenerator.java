package app.business.proxy;

import java.util.List;
import java.util.Map;

import app.business.IPayslipPeriod;
import app.domain.*;
import app.exceptions.AuthenticationError; 
/*Owner: Jmmy*/
public interface IPaySlipGenerator {
	public Map<String, PayslipData> generate(IPayslipPeriod period,List<Employee> e) throws AuthenticationError ;
}
