package Scrapper;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;

public class FileCnM {

	void fileCnM(String title, String contentPtag) throws IOException {
		
		try {

			String contentFinal = contentPtag.replaceAll("Advertisements", "");
			
			String userDir = System.getProperty("user.dir");
			
			new File(userDir+"\\ScrappedCreepypasta").mkdir(); // Creates a Dir in Project Folder, all files are saved there<
			
			userDir += "\\ScrappedCreepypasta\\"; 	
			
			Writer out = new BufferedWriter(
							new OutputStreamWriter(
								new FileOutputStream(userDir+title
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