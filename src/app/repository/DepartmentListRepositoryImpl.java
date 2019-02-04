package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.domain.Department;
import app.domain.DepartmentList;

public class DepartmentListRepositoryImpl implements IDepartmentListRepository{
	
	private List<String> listOfDepartmentName;
	DepartmentList listDepartment = DepartmentList.INSTANCE;

	public DepartmentListRepositoryImpl() {
		this.listOfDepartmentName = new ArrayList<String>();
	}

	@Override
	public List<String> getDepartmentNameList() {
		 this.listOfDepartmentName = listDepartment.getListOfDepartmentName();
		 return this.listOfDepartmentName;
	}

	@Override
	public Department getDepartmentbyName(String departmentName) {
		List<Department> list = listDepartment.getListOfDepartment();
		for(Department d: list) {
			if(departmentName.equalsIgnoreCase(d.getDepartmentName())) {
				return d;
			}
		}
		return null;
	}

}
