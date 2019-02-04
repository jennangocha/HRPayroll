package report.template;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class MonthlyPayslip extends  ApayslipProcessor{
	String title="";
	HashMap<String,String> list=null;
	Document document = null;
	public MonthlyPayslip(HashMap<String,String> list,String title){
		this.list=list;
		this.title=title;
		this.document = new Document();
	}
	@Override
	public void generateBody(String filepath) {
		// TODO Auto-generated method stub
		 try
	      {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filepath));
	        document.open();
	       
	        Font font1 = new Font(FontFamily.COURIER, 9, Font.NORMAL, BaseColor.BLACK);  
	        Font code = new Font(FontFamily.COURIER, 14, Font.BOLD, BaseColor.DARK_GRAY);  
	        Paragraph p=new Paragraph(title+"\n\n",code);
	        p.setAlignment(Element.ALIGN_CENTER);
	        document.add(p);
	       
	        document.add(new Paragraph(""));
	        p=new Paragraph("From : "+list.get("formdate"),font1);
	        p.setAlignment(Element.ALIGN_RIGHT);
	        document.add(p);
	        
	        p=new Paragraph("To : "+list.get("todate"),font1);
	        p.setAlignment(Element.ALIGN_RIGHT);
	        document.add(p);
	        document.add(new Paragraph(" "));
	        
	        p=new Paragraph("Employee Name: "+list.get("name"));
	        document.add(p);
	        
	        p=new Paragraph("Position: "+list.get("position"));
	        document.add(p);
	        
	        p=new Paragraph("Department: "+list.get("department"));
	        document.add(p);
	        
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph(" "));
	       
	        PdfPTable table = new PdfPTable(2);
	        PdfPCell[] cells = new PdfPCell[2];
	        
	        cells[0] = new PdfPCell(new Phrase("Description"));
	        cells[0].setBorder(0);
	        cells[0].setBorderWidthBottom(1);
	        cells[0].setPadding(10);
	        table.addCell(cells[0]);
	        
	        cells[1] = new PdfPCell(new Phrase("Amount"));
	        cells[1].setHorizontalAlignment(Element.ALIGN_RIGHT);
	        cells[1].setBorder(0);
	        cells[1].setBorderWidthBottom(1);
	        cells[1].setPadding(10);
	        table.addCell(cells[1]);
	        
	        table.completeRow();
	
	        cells = new PdfPCell[2];
	        cells[0] = new PdfPCell(new Phrase("Basic Pay"));   
	        cells[1] = new PdfPCell(new Phrase(list.get("totalBasicPay")));
	        cells[1].setHorizontalAlignment(Element.ALIGN_RIGHT);
	        cells[0].setBorder(0);
	        cells[1].setBorder(0);
	        cells[0].setPadding(10);cells[1].setPadding(10);
	        table.addCell(cells[0]);
	        table.addCell(cells[1]);
	        
	        table.completeRow();
	        
	        cells = new PdfPCell[2];
	        cells[0] = new PdfPCell(new Phrase("Deducation"));   
	        cells[1] = new PdfPCell(new Phrase(list.get("totalDeducation")));
	        cells[1].setHorizontalAlignment(Element.ALIGN_RIGHT);
	        cells[0].setBorder(0);
	        cells[1].setBorder(0);
	        cells[0].setPadding(10);cells[1].setPadding(10);
	        table.addCell(cells[0]);
	        table.addCell(cells[1]);
	        table.completeRow();
	        
	        cells = new PdfPCell[2];
	        cells[0] = new PdfPCell(new Phrase("Gross Pay"));   
	        cells[1] = new PdfPCell(new Phrase(list.get("NetWage")));
	        cells[1].setHorizontalAlignment(Element.ALIGN_RIGHT);
	        cells[0].setBorder(0);
	        cells[0].setBorderWidthTop(1);
	        cells[1].setBorder(0);
	        cells[1].setBorderWidthTop(1);
	        cells[0].setPadding(10);cells[1].setPadding(10);
	        table.addCell(cells[0]);
	        table.addCell(cells[1]);
	        table.completeRow();
	        
	        table.setWidthPercentage(100);
	        document.add(table);
	        document.close();
	        writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public String generatHeader() {
		// TODO Auto-generated method stub
		String filename=title.replace(" ", "_");
        String filepath="download\\"+filename+".pdf";
        int k=1;
        String temp="";
        while(k<50) {
	         File f = new File(filepath);
	         if(f.exists() && !f.isDirectory()) { 
	        	 temp=filename+k;
	        	 filepath="download\\"+temp+".pdf";
	        	 k++;
	         }
	         else break;
        }
        return filepath;
	}

	@Override
	public void generatFooter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openPDF(String filepath) {
		// TODO Auto-generated method stub
		 if (Desktop.isDesktopSupported()) {
     	    try {
     	        File myFile = new File(filepath);
     	        Desktop.getDesktop().open(myFile);
     	    } catch (IOException ex) {
     	        // no application registered for PDFs
     	    }
     	}
	}

}
