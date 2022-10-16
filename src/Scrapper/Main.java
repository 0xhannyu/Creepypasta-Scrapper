package Scrapper;

import java.io.IOException;

import java.util.Scanner;

public class Main {

   public static void main(String args[]) throws IOException {

      Scanner scr = new Scanner(System.in);
      ScrapeMedia smOb = new ScrapeMedia();

      System.out.println("[0] Scrape all titles on a given page index (default val: 1).\n" +
         "[1] Enter a particular title link to Scrape.\n" +
         "[2] Choose a category to scrape. (incomplete)\n"
         +"=".repeat(61)
         +"\n");

      int ch = scr.nextInt();

      switch (ch) {

      case 0:
    	  
    	  System.out.println("\nProvide a page index:");
    	  int pIndex = scr.nextInt();
          smOb.hPage(pIndex);

         break;

      case 1:
    	  
    	  System.out.println("\nEnter the link:");
    	  
    	  String[] cUrl = new String[1];
          cUrl[0] = scr.next();
          smOb.tPage(cUrl);

         break;

      case 2:

         smOb.cPage();

         break;
         
      default:
        	
        	 System.out.println("\nNot Valid");
      }

      scr.close();
   }
}