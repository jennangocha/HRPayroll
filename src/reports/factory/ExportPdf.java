package reports.factory;

import report.facade.PDF;

public class ExportPdf implements ExportReport{

	@Override
	public void export(String[] column,String[][] data,String title) {
		// TODO Auto-generated method stub
		//System.out.println("PDF");
		PDF p=new PDF();
		p.createPDF(column, data, title);
		
	}

}
