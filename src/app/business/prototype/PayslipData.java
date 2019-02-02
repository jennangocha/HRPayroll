package app.business.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import app.business.*;
import app.domain.Employee;
import app.domain.PayslipInfo;
import app.domain.PayslipPeriod;
import app.domain.StrategyType; 
/*Owner: Jmmy*/

@XmlRootElement(name = "payslipdata")
@XmlAccessorType (XmlAccessType.FIELD)
public class PayslipData implements IPrototype{

	private Employee employeeInfo;
	
	@XmlElement(name = "payslipPeriod")
	private PayslipPeriod payslipPeriod;
	
	 @XmlElement(name = "payslipInfo")
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
	public void setPayslipPeriod(PayslipPeriod payslipPeriod) {
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
		
		System.out.println(String.format("FirstName:%s LastName:%s",employeeInfo.getFirstName(),employeeInfo.getLastName()));
		System.out.println("--------------------------------\n");
	}
	
	public Object clone() {
		
		PayslipData clone=new PayslipData();
		Employee e=this.employeeInfo;
		PayslipPeriod p=new PayslipPeriod(this.payslipPeriod.getFromDate(), this.payslipPeriod.getToDate());		 
		clone.setEmployeeInfo(e);
		clone.setPayslipPeriod(p);
		for(PayslipInfo i : this.payslipInfo)
			clone.payslipInfo.add(i);
		
		return clone;
	}
}


