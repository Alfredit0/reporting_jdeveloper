package test;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    /**
     * Fonts para el documento*/
        private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
        private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
             
        private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
        private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
        private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
         
        
    /** Path to the resulting PDF file. */
      public static final String RESULT
          = "/hello.pdf";
    
      /**
       * Creates a PDF file: hello.pdf
       * @param    args    no arguments needed
       */
      public static void main(String[] args)
          throws DocumentException, IOException {
          new Main().createPdf(RESULT);
      }
    
      /**
       * Creates a PDF document.
       * @param filename the path to the new PDF document
       * @throws    DocumentException 
       * @throws    IOException 
       */
      public void createPdf(String filename)
          throws DocumentException, IOException {
          // step 1
          Document document = new Document(PageSize.A4,50,50,50,50);
          // step 2
          PdfWriter.getInstance(document, new FileOutputStream(filename));
          // step 3
          document.open();
          // step 4
          document.addTitle("titulo");
          document.add(new Paragraph("Hello World! Benito cara de chango"));
          
          // step 5
          document.close();
      }
}
