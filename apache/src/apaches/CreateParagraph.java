package apaches;


import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateParagraph {
   public static void main(String[] args)throws Exception {
      //Blank Document
      XSSFWorkbook workbook= new XSSFWorkbook(); 
      //Write the Document in file system
      FileOutputStream out = new FileOutputStream(new File("createparagraph.xlsx"));
        
     /* //create Paragraph
      XWPFParagraph paragraph = document.createParagraph();
      XWPFRun run=paragraph.createRun();
      run.setText("Welcome to SeleniumLearner Founded in 2017 by the websites mission is ‘to Test easy’. Keeping this mission in mind, we come up with appropriate initiatives from time to time. My fresh, conversational website style resonates with today’s readers.I look forward to developing a long-term relationship with you. …… mail us:  admin@seleniumlearner.tk");
		*/	
    //  document.write(out);
      out.close();
      System.out.println("createparagraph.docx written successfully");
   }
}