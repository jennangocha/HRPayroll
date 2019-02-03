package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.domain.JobType;

public class JobTypeRepositoryImpl implements IJobTypeRepository{
	
	private List<String> listJobType;

	public JobTypeRepositoryImpl() {
		listJobType = new ArrayList<String>();
	}

	@Override
	public List<String> getJobTypeList() {
		listJobType.add(JobType.SALARIED_EMPLOYEE.getJobType());
		listJobType.add(JobType.HOURLY_EMPLOYEE.getJobType());
		listJobType.add(JobType.COMMISSIONED_EMPLOYEE.getJobType());
		return listJobType;
	}

}
