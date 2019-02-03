package app.domain;

public enum EmployeeType {
	
	SALARIED("Salaried Employee"),
	HOURLY("Hourly Employee"),
	COMMISSIONED("Commisioned Employee");
	
	private String type;
	
	EmployeeType(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
}
