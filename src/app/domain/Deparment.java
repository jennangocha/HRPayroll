package app.domain;

/**
 * 
 * @author luungochabui
 *
 */

public class Deparment {
	
	private String departmentCode;
	private String departmentName;

	public Deparment() {
	}
	
	public Deparment(String departmentCode, String departmentName) {
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
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
