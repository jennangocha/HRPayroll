package app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import app.business.*; 
/*Owner: Jmmy*/
public class PayslipData {

	private Employee employeeInfo;
	private IPayslipPeriod payslipPeriod;
	private List<PayslipInfo> payslipInfo;
	
	public PayslipData() {
		payslipInfo=new ArrayList<PayslipInfo>();
	}
	 
	public Employee getEmployeeInfo() {
		return employeeInfo;
	}
	public void setEmployeeInfo(Employee employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
 
	public IPayslipPeriod getPayslipPeriod() {
		return payslipPeriod;
	}
	public void setPayslipPeriod(IPayslipPeriod payslipPeriod) {
		this.payslipPeriod = payslipPeriod;
	}
	
	public void addEarning(List<IEarningStrategy> earnings) {
		 
		for(IEarningStrategy e : earnings) {
			 
			 PayslipInfo payInfo=new PayslipInfo(IEarningStrategy.Type,e.getTitle(), e.calcEarn(employeeInfo, payslipPeriod));
			 
			 payslipInfo.add(payInfo);
		 }
	}

	public void addDeduction(List<IDeductionStrategy> deductions) {
		
		for(IDeductionStrategy e : deductions) {
			 
			 PayslipInfo payInfo=new PayslipInfo(IDeductionStrategy.Type,e.getTitle(), e.calcDedu(employeeInfo, payslipPeriod));
			 
			 payslipInfo.add(payInfo);
		 }
	}
	
	public void addBasicPay(List<IBasicPayStrategy> basicpays) {
		
		for(IBasicPayStrategy e : basicpays) {
			 
			 PayslipInfo payInfo=new PayslipInfo(IBasicPayStrategy.Type,e.getTitle(), e.calcBasic(employeeInfo, payslipPeriod));
			 
			 payslipInfo.add(payInfo);
		 }
	}	 
	
	public void add(PayslipInfo e) {
		payslipInfo.add(e);
	}
	
	public boolean remove(PayslipInfo e) {
		for(PayslipInfo p : payslipInfo) {
			if(p.equals(e)) {
				payslipInfo.remove(e);				
				return true;
			}
		}		
		return false;
	}
	
	public PayslipInfo get(String type,String title) {
		return payslipInfo.stream()
				.filter(x->x.getType().equals(type))
				.filter(x->x.getTitle().equals(title))
				.findAny().orElse(null);
	}
	
	public List<PayslipInfo> get(String type) {
		return payslipInfo.stream()
				.filter(x->x.getType().equals(type)) 
				.collect(Collectors.toList());
	}
	

	public double getTotal(String type) {
		return payslipInfo.stream()
				.filter(x->x.getType().equals(type)) 
				.mapToDouble(x->x.getAmount())
				.sum();
	}
	
	public List<PayslipInfo> getDeduction(){
		return get(StrategyType.Deduction.getName());
	}
	
	public List<PayslipInfo> getEarning(){
		return get(StrategyType.Earning.getName());
	}
	
	public List<PayslipInfo> getBasicPay(){
		return get(StrategyType.BasicPay.getName());
	}
	
	public double getTotalDeducation(){
		return getTotal(StrategyType.Deduction.getName());
	}
	
	public double getTotalEarning(){
		return getTotal(StrategyType.Earning.getName());
	}
	
	public double getTotalBasicPay(){
		return getTotal(StrategyType.BasicPay.getName());
	}
	
	public double getNetWage() {
		return getTotalBasicPay()+getTotalEarning()-getTotalDeducation();
	}
	
	public void print() {
		
	}
}


