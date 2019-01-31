package app.domain;

import app.business.*; 
/*Owner: Jmmy*/
public class PayslipData {

	private Employee employeeInfo;
	private IPayslipPeriod payslipPeriod;
	private APayslipComponent payslipComponent;
	 
	public Employee getEmployeeInfo() {
		return employeeInfo;
	}
	public void setEmployeeInfo(Employee employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
	public APayslipComponent getPayslipComponent() {
		return payslipComponent;
	}
	public void setPayslipComponent(APayslipComponent payslipComponent) {
		this.payslipComponent = payslipComponent;
	}
	public IPayslipPeriod getPayslipPeriod() {
		return payslipPeriod;
	}
	public void setPayslipPeriod(IPayslipPeriod payslipPeriod) {
		this.payslipPeriod = payslipPeriod;
	}
	
}
