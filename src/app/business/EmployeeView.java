/**
 * 
 */
package app.business;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author luungocha bui
 *
 */
public class EmployeeView {
	
	private SimpleStringProperty code;
	private SimpleStringProperty name;
	private SimpleStringProperty address;
	private SimpleStringProperty phone;
	private SimpleStringProperty salary;
	private SimpleStringProperty email;
	private SimpleStringProperty department;
	private SimpleStringProperty branch;
	
	public EmployeeView() {}

	public EmployeeView(String code, String name, String address, String phone, String salary, String email, String department, String branch){
		super();
		this.code = new SimpleStringProperty(code);
		this.name = new SimpleStringProperty(name);
		this.address = new SimpleStringProperty(address);
		this.phone = new SimpleStringProperty(phone);
		this.salary = new SimpleStringProperty(salary);
		this.email = new SimpleStringProperty(email);
		this.department = new SimpleStringProperty(department);
		this.branch = new SimpleStringProperty(branch);
		
	}

	@Override
	public String toString() {
		return "EmployeeView [code=" + code + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", salary=" + salary + ", email=" + email + "]";
	}

	public String getCode() {
		return code.get();
	}

	public String getName() {
		return name.get();
	}

	public String getAddress() {
		return address.get();
	}

	public String getPhone() {
		return phone.get();
	}

	public String getSalary() {
		return salary.get();
	}

	public String getEmail() {
		return email.get();
	}


	public void setCode(String code) {
		this.code = new SimpleStringProperty(code);
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public void setAddress(String address) {
		this.address = new SimpleStringProperty(address);
	}

	public void setPhone(String phone) {
		this.phone = new SimpleStringProperty(phone);
	}

	public void setSalary(String salary) {
		this.salary = new SimpleStringProperty(salary);
	}

	public void setEmail(String email) {
		this.email = new SimpleStringProperty(email);
	}

	public String getDepartment() {
		return department.get();
	}

	public void setDepartment(String department) {
		this.department = new SimpleStringProperty(department);
	}

	public String getBranch() {
		return branch.get();
	}

	public void setBranch(String branch) {
		this.branch = new SimpleStringProperty(branch);
	}
	
}
