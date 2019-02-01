package app.business;
/*Owner: Jmmy*/
public class Leaf extends APayslipComponent{
		
	public Leaf(String col, Double val) {
		super(col, val);
		// TODO Auto-generated constructor stub
	}

	@Override
	public APayslipComponent getComponent(String key) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void add(String key,APayslipComponent value) {
		throw new UnsupportedOperationException();
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
