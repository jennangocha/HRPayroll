package app.domain;

import java.time.LocalDate;
import java.util.Date;

import app.business.visitor.IEmployeePayslip;
import app.business.visitor.IPayslipVisitor;

/**
 * Owner: luungocha
 * */
public abstract class Employee implements IEmployeePayslip, Cloneable{

	private String empCode;
	private String firstName;
	private String lastName;
	private String zipcode;
	private String phone;
	private String email;
	private LocalDate dateOfBirth;
	private String ssn;
	private String position;
	private LocalDate joinDate;
	private LocalDate resignDate;
	private Boolean isRegign;
	private Boolean isPermanent;
	private Address address;
	private Department department;
	private Branch branch;
	private Double basicSalary;

	public Employee() {}
	
	public Employee(String empCode, String firstName, String lastName, String zipcode, String phone, String email,
			LocalDate dateOfBirth, String ssn, String position, LocalDate joinDate, LocalDate resignDate, Boolean isRegign,
			Boolean isPermanent, Address address, Department department, Branch branch, Double salary) {
		this.empCode = empCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipcode = zipcode;
		this.phone = phone;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.ssn = ssn;
		this.position = position;
		this.joinDate = joinDate;
		this.resignDate = resignDate;
		this.isRegign = isRegign;
		this.isPermanent = isPermanent;
		this.address = address;
		this.department = department;
		this.branch = branch;
		this.basicSalary = salary;
	}

	public Object clone() 
    { 
        Object clone = null; 
        try 
        { 
            clone = super.clone(); 
        }  
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
    } 
	

	public Double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(Double basicSalary) {
		this.basicSalary = basicSalary;
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

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public LocalDate getResignDate() {
		return resignDate;
	}

	public void setResignDate(LocalDate resignDate) {
		this.resignDate = resignDate;
	}

	public Boolean getIsRegign() {
		return isRegign;
	}

	public void setIsRegign(Boolean isRegign) {
		this.isRegign = isRegign;
	}

	public Boolean getIsPermenent() {
		return isPermanent;
	}

	public void setIsPermenent(Boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpCode() {
		return empCode;
	}
	
	public Boolean getIsPermanent() {
		return isPermanent;
	}

	public void setIsPermanent(Boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public String getDepartmentName() {
		return department.getDepartmentName();
	}
	public String getBranchName() {
		return branch.getBranchName();
	}
	@Override
	public String toString() {
		return "Employee [empCode=" + empCode + ", firstName=" + firstName + ", lastName=" + lastName + ", zipcode="
				+ zipcode + ", phone=" + phone + ", email=" + email + ", dateOfBirth=" + dateOfBirth + ", ssn=" + ssn
				+ ", position=" + position + ", joinDate=" + joinDate + ", resignDate=" + resignDate + ", isRegign="
				+ isRegign + ", isPermanent=" + isPermanent + ", address=" + address + ", department=" + department
				+ ", branch=" + branch + ", basicSalary=" + basicSalary + "]";
	}

	@Override
	public abstract void accept(IPayslipVisitor visitor);
}
