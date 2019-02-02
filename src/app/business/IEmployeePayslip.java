package app.business;

import app.business.visitor.IPayslipVisitor;

/*Owner: Jmmy*/
public interface IEmployeePayslip {

	public void accept(IPayslipVisitor visitor);
}
