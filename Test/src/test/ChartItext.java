package test;

import com.itextpdf.text.Document;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;

import java.io.FileOutputStream;

import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class ChartItext {
    public static void main(String[] args) {
            final TimeSeriesCollection dataset = new TimeSeriesCollection();
            final TimeSeries s1 = new TimeSeries("Series 1", Minute.class);
            s1.add(new Minute(0, 0, 7, 12, 2003), 1.2);
            s1.add(new Minute(30, 12, 7, 12, 2003), 3.0);   // 12h30  => value = 3
            s1.add(new Minute(15, 14, 7, 12, 2003), 8.0);

            final TimeSeries s2 = new TimeSeries("Series 2", Minute.class);
            s2.add(new Minute(0, 3, 7, 12, 2003), 0.0);
            s2.add(new Minute(30, 9, 7, 12, 2003), 0.0);
            s2.add(new Minute(15, 10, 7, 12, 2003), 0.0);

            dataset.addSeries(s1);
            dataset.addSeries(s2);
            XYDataset dataset2 = dataset;

            final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                        "Sample Chart",
                        "Date", 
                        "Value",
                        dataset2,
                        true,
                        true,
                        false
            );
            chart.setBackgroundPaint(Color.white);
            java.awt.Image originalImage = chart.createBufferedImage(500, 300);
            try {           
                Document document=new Document();
                PdfWriter.getInstance(document,new FileOutputStream("hell4.pdf"));
                document.open(); 
                Image image1 = Image.getInstance(originalImage,Color.white);
                document.add(image1);
                document.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (DocumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
}
