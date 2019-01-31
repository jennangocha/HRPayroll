package app.domain;

import java.util.Date;

import app.business.IPayslipPeriod;

public class PayslipPeriod implements IPayslipPeriod{

	private Date from;
	private Date to;
	
	public PayslipPeriod(Date from, Date to) {
		super();
		this.from = from;
		this.to = to;
	}
	public Date getFrom() {
		return from;
	}
	public Date getTo() {
		return to;
	}
	
	
}
