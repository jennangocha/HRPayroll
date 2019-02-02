package app.business.proxy;

import java.util.List;
import java.util.Map;

import app.business.IPayslipPeriod;
import app.business.prototype.PayslipData;
import app.domain.*;
import app.exceptions.AuthenticationError;
import app.service.UserService;
/*Owner: Jmmy*/
public class PaySlipGeneratorProxy implements IPaySlipGenerator {

	private boolean isLoggedIn = false;
	 
    public PaySlipGeneratorProxy(User user) {
    	  if(isAuthorized(user)) 
    		  isLoggedIn = true; 
    }
	
	@Override
	public Map<String, PayslipData> generate(PayslipPeriod period, List<Employee> e) throws AuthenticationError {
		// TODO Auto-generated method stub
		if (isLoggedIn) {
			return PaySlipGenerator.getInstance().generate(period, e);
		}else {
			throw new AuthenticationError("Invalid User !");
		}
	}

	private boolean isAuthorized(User user) {
		UserService controller = UserService.getInstance();
		
		User userInSystem = controller.getUserByUsername(user.getUsername());				
		
		if (userInSystem != null)
		{					
			if (userInSystem.login(user.getPassword()) && userInSystem.getAccesslevel().equals(AccessLevel.ADMIN))
				return true;
			
		}	
		
		return false;
	}
}
