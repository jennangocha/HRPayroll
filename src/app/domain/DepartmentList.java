package app.domain;

import java.util.ArrayList;
import java.util.List;

import app.data.DepartmentData;

public enum DepartmentList {
	
	INSTANCE;
	
	List<Department> listOfDepartment = new ArrayList<Department>();
	
	DepartmentList(){
		this.listOfDepartment = DepartmentData.loadData();
	}

	public List<String> getListOfDepartmentName() {
		List<String> listDepartmentName = new ArrayList<String>();
		for(Department d : listOfDepartment) {
			listDepartmentName.add(d.getDepartmentName());
		}
		return listDepartmentName;
	}
	
	public List<Department> getListOfDepartment() {
		return listOfDepartment;
	}

	public void setListOfDepartment(List<Department> listOfDepartment) {
		this.listOfDepartment = listOfDepartment;
	}
	
}
