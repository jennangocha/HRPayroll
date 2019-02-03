package app.business.visitor;

import app.domain.CommissionedEmployee;
import app.domain.HourlyEmployee;
import app.domain.SalariedEmployee;

/*Owner: Jmmy*/
public interface IPayslipVisitor {

	public void visit(HourlyEmployee e);
	public void visit(SalariedEmployee e);
	public void visit(CommissionedEmployee e);
}
