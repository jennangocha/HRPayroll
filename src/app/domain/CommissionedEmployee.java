package app.domain;

import app.business.IPayslipVisitor;

public class CommissionedEmployee extends Employee{

	@Override
	public void accept(IPayslipVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

}
