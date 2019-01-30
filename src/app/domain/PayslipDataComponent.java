package app.domain;

import java.util.ArrayList;
import java.util.Collection;
/*Owner: Jmmy*/
public abstract class PayslipDataComponent {
	
	public Collection<PayslipDataComponent> list=new ArrayList<PayslipDataComponent>();
	
	private Data data;

	public void addItem(PayslipDataComponent component) {
		list.add(component);
	}
	
	public Data getData() {
	
		return data;
	}
	
	public abstract long Calculate();
}
