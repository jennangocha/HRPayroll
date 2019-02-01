package app.business;

import java.util.List;
import java.util.Map;
import app.domain.*;
import app.exceptions.AuthenticationError;
import app.service.UserService;

public class PaySlipGeneratorProxy implements IPaySlipGenerator {

	private boolean isLoggedIn = false;
	    
    private PaySlipGenerator paySlipGenerator;

    public PaySlipGeneratorProxy(User user) {
    	  if(isAuthorized(user)) isLoggedIn = true;
    	  paySlipGenerator =new PaySlipGenerator().getInstance();
    }
	
	@Override
	public Map<String, PayslipData> generate(IPayslipPeriod period, List<Employee> e) throws AuthenticationError {
		// TODO Auto-generated method stub
		if (isLoggedIn) {
			return paySlipGenerator.generate(period, e);
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
