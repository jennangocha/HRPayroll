package app.service;

import java.util.ArrayList;
import java.util.List;

import app.domain.Department;
import app.repository.DepartmentListRepositoryImpl;
import app.repository.IDepartmentListRepository;

public class DepartmentListServiceImpl implements IDepartmentListService{
	
	private List<String> listDepartmentName;
	private IDepartmentListRepository departmentRepository;

	public DepartmentListServiceImpl() {
		listDepartmentName = new ArrayList<String>();
		departmentRepository = new DepartmentListRepositoryImpl();
	}

	@Override
	public List<String> getDepartmentList() {
		listDepartmentName = departmentRepository.getDepartmentNameList();
		return listDepartmentName;
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		return departmentRepository.getDepartmentbyName(departmentName);
	}


}
