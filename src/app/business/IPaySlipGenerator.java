package app.business;

import java.util.List;
import java.util.Map;

import app.domain.*;
import app.exceptions.AuthenticationError; 

public interface IPaySlipGenerator {
	public Map<String, PayslipData> generate(IPayslipPeriod period,List<Employee> e) throws AuthenticationError ;
}
