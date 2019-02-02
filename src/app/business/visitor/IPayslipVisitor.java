package app.business.visitor;

import app.domain.*; 
/*Owner: Jmmy*/
public interface IPayslipVisitor {

	public void visit(HourlyEmployee e);
	public void visit(SalariedEmployee e);
	public void visit(CommissionedEmployee e);
}
