package app.domain;

/**
 * 
 * @author luungochabui
 *
 */

public class Branch {
	
	private String branchCode;
	private String branchName;
	
	public Branch() {
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

}
