package app.data;

import java.util.ArrayList;
import java.util.List;

import app.domain.Branch;

public class BranchData {

	public static List<Branch> loadData() {
		Branch branch1 = new Branch("BR1", "Fairfield");
		Branch branch2 = new Branch("BR2", "Ottumwa");
		Branch branch3 = new Branch("BR3", "Cedar Rapid");
		Branch branch4 = new Branch("BR4", "Des Moines");
		Branch branch5 = new Branch("BR5", "Iowa City");
		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(branch1);
		branchList.add(branch2);
		branchList.add(branch3);
		branchList.add(branch4);
		branchList.add(branch5);
		return branchList;
	}
}
