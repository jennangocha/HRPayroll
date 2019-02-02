package app.domain;

import java.util.Date;

import app.business.IEmployeePayslip;
import app.business.IPayslipVisitor;

/**
 * Owner: Jmmy, luungocha
 * */
public abstract class Employee implements IEmployeePayslip{

	private String empCode;
	private String firstName;
	private String lastName;
	private String zipcode;
	private String phone;
	private String email;
	private Date dateOfBirth;
	private String ssn;
	private String position;
	private Date joinDate;
	private Date resignDate;
	private Boolean isRegign;
	private Boolean isPermanent;
	private Address address;
	private Deparment department;
	private Branch branch;

	public Employee() {}
	
	
	
	public Employee(String empCode, String firstName, String lastName, String zipcode, String phone, String email,
			Date dateOfBirth, String ssn, String position, Date joinDate, Date resignDate, Boolean isRegign,
			Boolean isPermanent, Address address, Deparment department, Branch branch) {
		super();
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getResignDate() {
		return resignDate;
	}

	public void setResignDate(Date resignDate) {
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

	public Deparment getDepartment() {
		return department;
	}

	public void setDepartment(Deparment department) {
		this.department = department;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public abstract void accept(IPayslipVisitor visitor);
}
