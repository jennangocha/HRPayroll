package app.repository;

import java.util.List;

import app.domain.Branch;

public interface IBranchListRepository {
	public List<String> getBranchNameList();
	public Branch getBranchByName(String branchName);
}
