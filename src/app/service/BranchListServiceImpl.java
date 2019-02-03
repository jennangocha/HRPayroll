package app.service;

import java.util.ArrayList;
import java.util.List;

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
	public List<String> getBranchListByName() {
		listBranchName = branchListRepository.getBranchListByName();
		return listBranchName;
	}
	
}
