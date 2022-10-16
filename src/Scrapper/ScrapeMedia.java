package Scrapper;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeMedia {

   void hPage(int index) throws IOException {
	  
	   String url = null;
	   
	   if(index == 1)
		   url = "https://www.creepypasta.com/";
	   if(index > 1)
		   url = "https://www.creepypasta.com/?_page="+index;
	   if(index < 1)
		   throw new java.lang.Error("naww try again");

      Document docMain = Jsoup.connect(url).get();
      Elements contentClassAnchor = docMain
         .select("h2.pt-cv-title")
         .select("a._self.cvplbd");

      String[] titleLinks = new String[contentClassAnchor.size()];

      int i = 0;

      for (Element a: contentClassAnchor) {

         titleLinks[i++] = a.attr("href");
         //System.out.println(a.attr("href"));
      }

      tPage(titleLinks);
   }

   void tPage(String[] titleLinks) throws IOException {

      int j = 0; String contentPtag = "";
      FileCnM fOb = new FileCnM();

      do {

         Document docContent = Jsoup.connect(titleLinks[j++]).get();
         Elements titleClassDiv = docContent
        		 .select("div.entry-content.clear");
         

         String title = (String) docContent.title();

         System.out.println("\nScrapping " + title + "...");

         for (Element p: titleClassDiv) {

            contentPtag += p.text() + "\n\n";
            //System.out.println(p.getElementsByTag("p").text());
         } 
         
         fOb.fileCnM(title, contentPtag);
         contentPtag="";
         
      } while (j < titleLinks.length);      
   }

   // Incomplete ⤵

   void cPage() throws IOException {

      String urlCatg = "https://www.creepypasta.com/archive/sorted-by-category/";
      Document doc = Jsoup.connect(urlCatg).get();

      Elements catgList = doc
         .select("div.cvp-live-filter.cvp-dropdown");

      HashMap < String, String > category = new HashMap < String, String > ();

      for (Element x: catgList) {
         category.put(x.getElementsByTag("option").text(), x.getElementsByTag("option").val());
      }
   }
}