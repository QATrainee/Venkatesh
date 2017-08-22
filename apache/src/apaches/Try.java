package apaches;


import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Try {
	 public static void main(String[] args) throws  IOException, Exception{
		 System.setProperty("webdriver.chrome.driver","E:\\External jars\\chromedriver.exe");
	    	ChromeDriver driver = new ChromeDriver();
	    	 File file = new File("E:\\workspace\\Final.automation\\src\\finalTest\\Base.properties");
	     		FileInputStream fileInput;
	     		fileInput = new FileInputStream(file);
	     		Properties prop = new Properties();
	     		prop.load(fileInput);
         
         FileInputStream fsIP= new FileInputStream(new File("C:\\Users\\mag6\\Desktop\\Login.xlsx")); //Read the spreadsheet that needs to be updated
           
         XSSFWorkbook wb = new XSSFWorkbook(fsIP); //Access the workbook
           
         XSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
           
         Cell cell = null; // declare a Cell object
         
        // cell = worksheet.getRow(0).getCell(2);   // Access the second cell in second row to update the value
         //cell = worksheet.getRow(1).getCell(2);
        // cell.setCellValue("Login Success");  // Get current cell value value and overwrite the value
           
        // fsIP.close(); //Close the InputStream
          
         //FileOutputStream output_file =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));  //Open FileOutputStream to write updates
           
         //wb.write(output_file); //write changes
           
         //output_file.close();  //close the stream   
         
     		
        	
 	    	driver.get(prop.getProperty("URL"));
 	    	driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
 			Thread.sleep(10000);
 			driver.findElement(By.xpath(prop.getProperty("candidatelogin"))).click();
 			Thread.sleep(1000);
 			driver.findElement(By.xpath(prop.getProperty("loginbutton"))).click();
 			driver.switchTo().defaultContent();
 			driver.switchTo().frame("candidatecontentframe");
 			for (int i = 0; i<=4; i++) {
 			driver.findElement(By.xpath(prop.getProperty("mailid"))).sendKeys(worksheet.getRow(i).getCell(0).getStringCellValue());
 			driver.findElement(By.xpath(prop.getProperty("password1"))).sendKeys(worksheet.getRow(i).getCell(1).getStringCellValue());
 		
 			driver.findElement(By.xpath(prop.getProperty("submitbutton"))).click();
 			 try{  
 			      
 			   }catch(Exception e){
 				   
 				  }  
 			    
 			Thread.sleep(1000);
 			driver.switchTo().defaultContent();
/*
 	driver.findElement(By.xpath("//.//*[@id='identifierId']")).sendKeys(worksheet.getRow(i).getCell(0).getStringCellValue());
 	driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
 	cell = worksheet.getRow(i).getCell(2); 
 	cell.setCellValue("Login fail");
    
    fsIP.close(); //Close the InputStream
     
    FileOutputStream output_file1 =new FileOutputStream(new File("C:\\Users\\mag6\\Desktop\\Login.xlsx"));  //Open FileOutputStream to write updates
      
    wb.write(output_file1); //write changes
      
    output_file1.close();
 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//.//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(worksheet.getRow(i).getCell(1).getStringCellValue());
     WebElement element = driver.findElement(By.xpath("//.//*[@id='password']/div[2]/div[2]"));
     String strng = element.getText();
     System.out.println(strng);
  //   Assert.assertEquals("Google Search", strng);
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     Thread.sleep(1000);
     driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
    
     
    	 
  //   ro.createCell(3).setCellValue(cell1value);
     driver.findElement(By.cssSelector(".gb_8a.gbii")).click();
 	driver.findElement(By.cssSelector("#gb_71")).click();
 	cell = worksheet.getRow(i).getCell(2); 
 	cell.setCellValue("Login Success");
    
    fsIP.close(); //Close the InputStream
     
    FileOutputStream output_file =new FileOutputStream(new File("C:\\Users\\mag6\\Desktop\\Login.xlsx"));  //Open FileOutputStream to write updates
      
    wb.write(output_file); //write changes
      
    output_file.close();
 	
 	Thread.sleep(1000);*/
 	
         
 
}
         driver.quit();
	 }}
