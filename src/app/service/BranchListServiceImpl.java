package app.service;

import java.util.ArrayList;
import java.util.List;

import app.domain.Branch;
import app.repository.BranchListRepositoryImpl;
import app.repository.IBranchListRepository;

public class BranchListServiceImpl implements IBranchListService{
	
	private List<String> listBranchName;
	private IBranchListRepository branchListRepository;

	public BranchListServiceImpl() {
		listBranchName = new ArrayList<String>();
		branchListRepository = new BranchListRepositoryImpl();
	}

	@Override
	public List<String> getBranchNameList() {
		listBranchName = branchListRepository.getBranchNameList();
		return listBranchName;
	}

	@Override
	public Branch getBranchByName(String branchName) {
		return branchListRepository.getBranchByName(branchName);
	}
	
}
