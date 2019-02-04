package app.repository;

import java.util.List;

import app.domain.Department;

public interface IDepartmentListRepository {
	public List<String> getDepartmentNameList();
	public Department getDepartmentbyName(String departmentName);
}
