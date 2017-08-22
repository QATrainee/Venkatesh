package apaches;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AtFriday {
	 public static void main(String[] args) throws  IOException, Exception{
		 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver.exe");
	    	ChromeDriver driver = new ChromeDriver();

         
         FileInputStream fsIP= new FileInputStream(new File("D:\\workspace\\apache\\login.xlsx")); //Read the spreadsheet that needs to be updated
           
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
        
         for (int i = 0; i<=2;i++) {
     		
      	   
 	    	driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

 	driver.findElement(By.xpath("//.//*[@id='identifierId']")).sendKeys(worksheet.getRow(i).getCell(0).getStringCellValue());
 	driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
 	 
 	
 	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//.//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(worksheet.getRow(i).getCell(1).getStringCellValue());
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     Thread.sleep(1000);
     driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
     Thread.sleep(2000);
     try{
     WebElement web1 = driver.findElement(By.xpath("//.//*[@id='password']/div[2]/div[2]"));
     boolean a2 = web1.isDisplayed();
     if(a2 = true  ){
    	 cell = worksheet.getRow(i).getCell(2); 
    	 	cell.setCellValue("Login fail,,,");
    	    
    	    fsIP.close(); //Close the InputStream
    	     
    	    FileOutputStream output_file11 =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));  //Open FileOutputStream to write updates
    	      
    	    wb.write(output_file11); //write changes
    	      
    	    output_file11.close();
     }}
     catch (Exception e) {
    	 driver.findElement(By.cssSelector(".gb_8a.gbii")).click();
    	 	driver.findElement(By.cssSelector("#gb_71")).click();
    	 	cell = worksheet.getRow(i).getCell(2); 
    	 	cell.setCellValue("Login pass,,,");
    	     fsIP.close(); //Close the InputStream
    	    FileOutputStream output_file1 =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));  //Open FileOutputStream to write updates
     	    wb.write(output_file1); //write changes
    		    output_file1.close();
     Thread.sleep(1000);
   
     }
  
    /* else if( driver.findElement(By.cssSelector(".gb_8a.gbii")).isDisplayed()){
    	 System.out.println("currentURL");
     }
  //   ro.createCell(3).setCellValue(cell1value);
     /*driver.findElement(By.cssSelector(".gb_8a.gbii")).click();
 	driver.findElement(By.cssSelector("#gb_71")).click();
 	cell = worksheet.getRow(i).getCell(2); 
 	cell.setCellValue("Login Success");
    
    fsIP.close(); //Close the InputStream
     
    FileOutputStream output_file =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));  //Open FileOutputStream to write updates
      
    wb.write(output_file); //write changes
      
    output_file.close();*/
 	
 	//Thread.sleep(1000);
 	
         
 
}
         driver.quit();
}}
