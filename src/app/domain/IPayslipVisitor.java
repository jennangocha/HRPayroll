package app.domain;

public interface IPayslipVisitor {

	public void visit(HourlyEmployee e);
	public void visit(SalariedEmployee e);
}
