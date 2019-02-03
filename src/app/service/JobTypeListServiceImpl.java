package app.service;

import java.util.ArrayList;
import java.util.List;

import app.repository.IJobTypeRepository;
import app.repository.JobTypeRepositoryImpl;

public class JobTypeListServiceImpl implements IJobTypeService{
	
	private List<String> listJobType;
	private IJobTypeRepository jobTypeRepository;

	public JobTypeListServiceImpl() {
		listJobType = new ArrayList<String>();
		jobTypeRepository = new JobTypeRepositoryImpl();
	}

	@Override
	public List<String> getJobTypeList() {
		listJobType = jobTypeRepository.getJobTypeList();
		return listJobType;
	}

}
