package report.template;

public abstract class ApayslipProcessor {
	public final void processPayslip() { 
		String filepath =generatHeader();
		generateBody(filepath);
		generatFooter();
		openPDF(filepath);
	}
	public abstract void generateBody(String filepath);
	public abstract String generatHeader();
	public abstract void generatFooter();
	public abstract void openPDF(String filepath);
}
