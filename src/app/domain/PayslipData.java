package app.domain;

import app.business.*; 
/*Owner: Jmmy*/
public class PayslipData {

	private Employee employeeInfo;
	private IPayslipPeriod payslipPeriod;
	private APayslipComponent payslipComponent;
	
	public PayslipData() {
		 createTemplete();
	}
	 
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
	
	public void createTemplete() {
		APayslipComponent root=new Composite(PayslipDataCompositeName.ROOT.name().toString(),0.0);
		
		APayslipComponent earning=new Composite(PayslipDataCompositeName.EARNING.name().toString(),0.0);
		APayslipComponent deduction=new Composite(PayslipDataCompositeName.DEDUCTION.name().toString(),0.0);
		APayslipComponent basicpay=new Composite(PayslipDataCompositeName.BASICPAY.name().toString(),0.0);
		
		root.add(PayslipDataCompositeName.EARNING.name().toString(), earning);
		root.add(PayslipDataCompositeName.DEDUCTION.name().toString(), deduction);
		root.add(PayslipDataCompositeName.BASICPAY.name().toString(), basicpay);
	}
	
	public void addEarning(Leaf leaf) {
		APayslipComponent root=payslipComponent.getComponent(PayslipDataCompositeName.ROOT.name().toString());
 
	}
	
	public void addDedu(Leaf leaf) {
		
	}
	
	public void addBasic(Leaf leaf) {
		
	}
}


