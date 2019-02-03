package app.domain;

import java.util.Date;
 

public class PayslipPeriod{

	private Date from;
	private Date to;
	
	public PayslipPeriod(Date from, Date to) {
		super();
		this.from = from;
		this.to = to;
	}
	public Date getFromDate() {
		return from;
	}
	public Date getToDate() {
		return to;
	}
	
	
}
