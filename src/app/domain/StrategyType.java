package app.domain;

public enum StrategyType {

	Deduction("Deduction"),Earning("Earning"),BasicPay("BasicPay"),Other("Other");
	
	String name;
	
	StrategyType(String s){
		name=s;
	}
	
	public String getName() {
		return name;
	}
}
