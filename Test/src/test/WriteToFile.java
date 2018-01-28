package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile{

	private static final String FILENAME = "C:\\JDeveloper\\mywork\\reporting_jdeveloper\\data\\data.html";

	public void save(String content) {
                
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			String head = "<html>\n" + 
			"<head>\n" + 
			"	<title>Countries and Movies</title>\n" + 
			"</head>\n" + 
			"<body>\n" + 
			"<h1 class=\"title\">Base de datos Calius</h1>\n" + 
			"<p>Se presantan los registros de la Base de Datos del Proyecto Calius.</p>\n" + 
			"<p>\n" + 
			"\n" + 
			"<h1 class=\"country\">Información de Alumnos</h1>\n" + 
			"<p>La siguiente tabla contiene los registros de los alumnos dados de alta en Calius:</p>\n" + 
			"</p>\n" + 
			"<table>";                      
                        String footer="</table>\n" + 
                        "</body>\n" + 
                        "</html>";
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
                        bw.write(head);
			bw.write(content);
                        bw.write(footer);
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}
