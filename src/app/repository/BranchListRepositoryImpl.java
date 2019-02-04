package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.domain.Branch;
import app.domain.BranchList;

public class BranchListRepositoryImpl implements IBranchListRepository{
	
	private List<String> listBranchNames;
	BranchList branchList = BranchList.INSTANCE;
	

	public BranchListRepositoryImpl() {
		listBranchNames = new ArrayList<String>();
	}

	@Override
	public List<String> getBranchNameList() {
		listBranchNames = branchList.getListOfBranchName();
		return listBranchNames;
	}

	@Override
	public Branch getBranchByName(String branchName) {
		List<Branch> list = branchList.getListOfBranch();
		for(Branch branch: list) {
			if(branchName.equalsIgnoreCase(branch.getBranchName())){
				return branch;
			}
		}
		return null;
	}	

}
