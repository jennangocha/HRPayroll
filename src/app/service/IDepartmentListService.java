package app.service;

import java.util.List;

import app.domain.Department;

public interface IDepartmentListService {
	public List<String> getDepartmentList();
	public Department getDepartmentByName(String departmentName);
}
