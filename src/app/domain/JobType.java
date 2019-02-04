package app.domain;

public enum JobType {
	
	SALARIED_EMPLOYEE("Salaried Employee"),
	HOURLY_EMPLOYEE("Hourly Employee"),
	COMMISSIONED_EMPLOYEE("Commissioned Employee");
	
	private String jobType;
	
	JobType(String jobType){
		this.jobType = jobType;
	}
	
	public String getJobType() {
		return jobType;
	}

}
