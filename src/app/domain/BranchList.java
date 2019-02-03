package app.domain;

import java.util.ArrayList;
import java.util.List;

import app.data.BranchData;

public enum BranchList {
	INSTANCE;
	
	List<Branch> listOfBranch = new ArrayList<Branch>();
	
	BranchList() {
		this.listOfBranch = BranchData.loadData();
	}
	
	public List<String> getListOfBranchName(){
		List<String> listBranchName = new ArrayList<String>();
		for(Branch b : listOfBranch) {
			listBranchName.add(b.getBranchName());
		}
		return listBranchName;
	}
	
	
}
