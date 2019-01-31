package app.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/*Owner: Jmmy*/
public abstract class APayslipComponent {
 
	private Map<String, APayslipComponent> components = new HashMap<String, APayslipComponent>();

	Double amount;
	
	public APayslipComponent(Double amount) {
		this.amount=amount;
	}
	
	public void add(String key,APayslipComponent value) {
		components.put(key, value);
	}
	
	public abstract APayslipComponent getComponent(String key);
	
	public abstract long getAmount();
}
