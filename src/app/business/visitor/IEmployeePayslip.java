package app.business.visitor;

/*Owner: Jmmy*/
public interface IEmployeePayslip {

	public void accept(IPayslipVisitor visitor);
}
