package app.business;

public interface IEmployeePayslip {

	public void accept(IPayslipVisitor visitor);
}
