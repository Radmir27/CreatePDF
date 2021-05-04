package create;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {
	

	
    public CreatePDF() {
    	
    }
    public void Create(String numberpdf) {
      	
    	Document document = new Document(); //создание класса Document
		try {
			PdfWriter.getInstance(document, new FileOutputStream("/var/apache-tomcat-9.0.39/webapps/CreatePDF/Check.pdf"));
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
			
		document.open(); 
		
		BaseFont times = null;
		try {
			times = BaseFont.createFont("/fonts/times.ttf", "cp1251", BaseFont.EMBEDDED);
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}
		
		String string_pdf = "Hello! You are cool.";
		Paragraph paragraph = new Paragraph();
	    paragraph.add(new Paragraph(string_pdf, new Font(times,14)));
	    
	    String string_pdf2 = "This test from Kazantsev with respect!";
	    paragraph.add(new Paragraph(string_pdf2, new Font(times,14)));
	
	    try {
			document.add(paragraph);
		} catch (DocumentException e1) {
			e1.printStackTrace();
		}
	    
	  //организация перехода на следующую строку
		 paragraph.clear();
		 String string_pdf3 = " ";
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
    	
	    /*
	  //добавление изображения в pdf
	    URL url = getClass().getResource("/picture/ugatu.png");
	    Image img = null;
		try {
			img = Image.getInstance(url.toString());
			
			
		} catch (BadElementException e2) {
			
			e2.printStackTrace();
		} catch (MalformedURLException e2) {
			
			e2.printStackTrace();
		} catch (IOException e2) {
			
			e2.printStackTrace();
		}
		
		img.setAbsolutePosition(90, 500); //позиционирование изображения в PDF
		
		try {
				document.add(img);
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	    
	    
		 //организация перехода на следующую строку
		 paragraph.clear();
		 String string_pdf3 = " ";
		 paragraph.add(new Paragraph(string_pdf3, new Font(times,14)));
		 
		 try {
				document.add(paragraph);
			} catch (DocumentException e1) {
				e1.printStackTrace();
			}
	    */
		 
		//добавление таблицы
		 PdfPTable table = new PdfPTable(4); //создание таблицы с 4 столбцами
		 addHeader(table);
		 addRows(table);
		 
		 try {
			document.add(table);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	    
	    document.close(); //закрытие и сохранение документа PDF
    }
    
private void addRows(PdfPTable table) {
		
		//заполнение таблицы вводимыми значения в текстовые поля на главной форме
		String cell1 = Calc.NumberGet;
		String cell2 = Calc.GroupGet;
		String cell3 = Calc.FIOGet;
		String cell4 = Calc.PointsGet;
				
		table.addCell(cell1);
	    table.addCell(cell2);
	    table.addCell(cell3);
	    table.addCell(cell4);
		
	    //выше должен быть текст на русском языке, как его вывести можно посмотреть в справке.
	}

private void addHeader(PdfPTable table) {
	Stream.of("Number", "Group", "FIO", "Points")
      .forEach(columnTitle -> {
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(columnTitle));
        table.addCell(header);
    });
}
}
