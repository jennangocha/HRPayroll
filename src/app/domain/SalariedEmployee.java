package app.domain;

import app.business.IPayslipVisitor;

/*Owner: Jmmy*/
public class SalariedEmployee  extends Employee{

	@Override
	public void accept(IPayslipVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}
