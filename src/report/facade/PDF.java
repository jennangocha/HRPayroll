package report.facade;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

public class PDF {
	public void createPDF(String[] column,String[][] data,String title) {
		 Document document = new Document();
	      try
	      {
	         String filename=title.replace(" ", "_");
	         String filepath="download\\"+filename+".pdf";
	         int k=1;
	         String temp="";
	         while(k<10) {
		         File f = new File(filepath);
		         if(f.exists() && !f.isDirectory()) { 
		        	 temp=filename+k;
		        	 filepath="download\\"+temp+".pdf";
		        	 k++;
		         }
		         else break;
	         }
	    	 PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filepath));
	         document.open();
	        
	         Font code = new Font(FontFamily.COURIER, 14, Font.BOLD, BaseColor.DARK_GRAY);  
	         Paragraph p=new Paragraph(title+"\n\n",code);
	         p.setAlignment(Element.ALIGN_CENTER);
	         document.add(p);
	         int numColumns = column.length;
	            PdfPTable table = new PdfPTable(numColumns);
	            PdfPCell[] cells = new PdfPCell[numColumns];
	            table.getDefaultCell().setBorderWidth(0f);
	            for (int i = 0; i < numColumns; i++) {
	                cells[i] = new PdfPCell(new Phrase(column[i]));
	                cells[i].setPadding(10);
	                cells[i].setBorder(0);  
	                cells[i].setBorderWidthBottom(1); 
	                //cells[i].setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(cells[i]);
	            }
	            table.completeRow();

	            cells = new PdfPCell[numColumns];
	            for (int i = 0; i < numColumns; i++) {
	            	 for (int j = 0; j < numColumns; j++) {
		                cells[i] = new PdfPCell(new Phrase(data[i][j]));
		                cells[i].setPadding(10);
		                cells[i].setBorder(0);   
		                cells[i].setBorderWidthBottom(1); 
		                table.addCell(cells[i]);
	            	 }
	            }
	            
	            table.completeRow();
	            document.add(table);
	         document.close();
	         writer.close();
	         if (Desktop.isDesktopSupported()) {
	        	    try {
	        	        File myFile = new File(filepath);
	        	        Desktop.getDesktop().open(myFile);
	        	    } catch (IOException ex) {
	        	        // no application registered for PDFs
	        	    }
	        	}
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
