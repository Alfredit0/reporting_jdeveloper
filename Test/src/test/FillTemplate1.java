package test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.html.Tags;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FillTemplate1 {
        public static final String DEST = "C:\\JDeveloper\\mywork\\reporting_jdeveloper\\data\\report1.pdf";
        public static final String PDF =  "C:\\JDeveloper\\mywork\\reporting_jdeveloper\\data\\stationery.pdf";
        public static final String HTML = "C:\\JDeveloper\\mywork\\reporting_jdeveloper\\data\\data.html";
        public static final String CSS = "C:\\JDeveloper\\mywork\\reporting_jdeveloper\\data\\style1.css";
        public void createPdf(String result) throws IOException, DocumentException {
            FillTemplateHelper template = new FillTemplateHelper(PDF);
            template.setSender("Alfredo Reyes\nElvia Valladares\nMinerva Martínez\nEvelyn Fernández");
            template.setReceiver("Tecnologías de la Información\nUniversidad de la Sierra Sur\nProyecto Ordinario\nReporte PDF JDeveloper");
            // step 1
            Document document = new Document(template.getPageSize(),
                template.getmLeft(), template.getmRight(), template.getmTop(), template.getmBottom());
            // step 2
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(result));
            writer.setPageEvent(template);
            // step 3
            document.open();
            // step 4
            ElementList elements = FillTemplateHelper.parseHtml(HTML, CSS, Tags.getHtmlTagProcessorFactory());
            for (Element e : elements) {
                document.add(e);
            }
            // step 5
            document.close();
        }
        public void runTemplate() throws IOException, DocumentException {
            File file = new File(DEST);
            file.getParentFile().mkdirs();
            new FillTemplate1().createPdf(DEST);
        }
}
