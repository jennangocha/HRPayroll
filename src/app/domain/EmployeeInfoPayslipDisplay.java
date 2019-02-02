package app.domain;

public class EmployeeInfoPayslipDisplay {

	private String firstName;
	private String lastName;
	private String code;
	private String department;
	private String branch; 
	private String basicPay;
	public EmployeeInfoPayslipDisplay(String firstName, String lastName, String code, String department, String branch,
			String basicPay) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
		this.department = department;
		this.branch = branch;
		this.basicPay = basicPay;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getBasicPay() {
		return basicPay;
	}
	public void setBasicPay(String basicPay) {
		this.basicPay = basicPay;
	} 
	
	
}
