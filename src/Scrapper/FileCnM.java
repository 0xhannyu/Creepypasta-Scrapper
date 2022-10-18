package Scrapper;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;

public class FileCnM {

	void fileCnM(String title, String contentPtag) throws IOException {
		
		try {

			String contentFinal = contentPtag.replaceAll("Advertisements", "");
			Writer out = new BufferedWriter(
							new OutputStreamWriter(
								new FileOutputStream("C:\\Users\\dell\\Desktop\\ScrappedCreepypasta\\"+title
									.replaceAll("\\?", "")
									.replaceAll("<", "")
									.replaceAll(":", "")
									.replaceAll(">", "")
									+".txt"),
								"UTF8"));

			out.write(contentFinal);
			out.close();
		} catch(Exception e) { System.out.println("Maybe Path Error? ["+e+"]"); }
	}
}