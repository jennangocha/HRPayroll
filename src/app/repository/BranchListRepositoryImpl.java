package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.domain.BranchList;

public class BranchListRepositoryImpl implements IBranchListRepository{
	
	private List<String> listBranchNames;
	

	public BranchListRepositoryImpl() {
		listBranchNames = new ArrayList<String>();
	}

	@Override
	public List<String> getBranchListByName() {
		BranchList branchList = BranchList.INSTANCE;
		listBranchNames = branchList.getListOfBranchName();
		return listBranchNames;
	}	

}
