package app.domain;

public class PayslipInfo {

	private String type;
	private String title;
	private double amount;
	 
	public PayslipInfo(String type, String title, double amount) {
		super();
		this.type = type;
		this.title = title;
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}	
	
	 @Override
    public boolean equals(Object o) { 
          
        if (o == this) { 
            return true; 
        }   
      
        if (!(o instanceof PayslipInfo)) { 
            return false; 
        } 
          
        // typecast o to Complex so that we can compare data members  
        PayslipInfo c = (PayslipInfo) o; 
          
        // Compare the data members and return accordingly  
	        return  c.title.equals(title) && c.type.equals(type);
	    } 
}
