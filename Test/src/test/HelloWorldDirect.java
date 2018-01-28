package test;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class HelloWorldDirect {
    /** Path to the resulting PDF file. */
      public static final String RESULT
          = "/hello1.pdf";
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    public HelloWorldDirect() {
        super();
    }
    /**
     * Creates a PDF file: hello.pdf
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
        throws DocumentException, IOException {
        new HelloWorldDirect().createPdf(RESULT);
    }
    public void createPdf(String filename)
        throws DocumentException, IOException {
        // step 1
                Document document = new Document(PageSize.A4,50,50,50,50);
                // step 2
                PdfWriter writer =
                    PdfWriter.getInstance(document, new FileOutputStream(RESULT));
                // step 3
                document.open();
                // step 4
                PdfContentByte canvas = writer.getDirectContentUnder();
                writer.setCompressionLevel(0);
                canvas.saveState();                               // q
                canvas.beginText();                               // BT
                canvas.moveText(36, 788);                         // 36 788 Td
                canvas.setFontAndSize(BaseFont.createFont(), 12); // /F1 12 Tf
                canvas.showText("Hello World");                   // (Hello World)Tj
                canvas.endText();                                 // ET
                canvas.restoreState();                            // Q
                // step 5
                document.close();
    }
    
}
