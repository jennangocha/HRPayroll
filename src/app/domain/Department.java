package app.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author luungochabui
 *
 */

public class Department {
	
	private String departmentCode;
	private String departmentName;
	private List<Employee> listEmployee = new ArrayList<Employee>();
	
	public Department() {
	}
	
	public Department(String departmentCode, String departmentName) {
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
	}

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
