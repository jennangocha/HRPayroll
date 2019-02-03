package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.domain.DepartmentList;

public class DepartmentListRepositoryImpl implements IDepartmentListRepository{
	
	private List<String> listOfDepartmentName;

	public DepartmentListRepositoryImpl() {
		this.listOfDepartmentName = new ArrayList<String>();
	}

	@Override
	public List<String> getDepartmentNameList() {
		 DepartmentList listDepartment = DepartmentList.INSTANCE;
		 this.listOfDepartmentName = listDepartment.getListOfDepartmentName();
		 return this.listOfDepartmentName;
	}

}
