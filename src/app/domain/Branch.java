package app.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author luungochabui
 *
 */

public class Branch {
	
	private String branchCode;
	private String branchName;
	List<Department> listDepartment = new ArrayList<Department>();
	
	public Branch() {
		this.branchCode = "BRANCH1";
		this.branchName = "FAIRFIELD BRANCH";
	}

	public Branch(String branchCode, String branchName) {
		this.branchCode = branchCode;
		this.branchName = branchName;
	}
	
	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public List<Department> getListDepartment() {
		return listDepartment;
	}

	public void setListDepartment(List<Department> listDepartment) {
		this.listDepartment = listDepartment;
	}
	
	

}
