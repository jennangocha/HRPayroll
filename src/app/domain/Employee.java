package app.domain;

import app.business.IEmployeePayslip;
import app.business.IPayslipVisitor;

/*Owner: Jmmy*/
public abstract class Employee implements IEmployeePayslip{

	private String empCode;

	public String getEmpCode() {
		return empCode;
	}

	@Override
	public abstract void accept(IPayslipVisitor visitor);
}
