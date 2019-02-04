package app.service;

import java.util.List;

import app.domain.Branch;

public interface IBranchListService {
	public List<String> getBranchNameList();
	public Branch getBranchByName(String branchName);
}
