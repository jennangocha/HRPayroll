package app.business;
/*Owner: Jmmy*/
public class Composite extends APayslipComponent{
 	 
	public Composite(String col, Double val) {
		super(col, val);
		// TODO Auto-generated constructor stub
	}

	@Override
	public APayslipComponent getComponent(String key) {
		// TODO Auto-generated method stub
		return null;
	}
 
	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return val;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	

}
