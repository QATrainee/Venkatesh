package apaches;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class FridayMorning{
 
 public static void main(String[] args) throws InterruptedException { 
 
	 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver.exe");
 	ChromeDriver driver = new ChromeDriver();

 
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
 
       // driver.manage().window().maximize();  
       
     
 
 try {
    
  FileInputStream file = new FileInputStream(new File("D:\\workspace\\apache\\login.xlsx")); 
  XSSFWorkbook workbook = new XSSFWorkbook(file);
 
  XSSFSheet sheet = workbook.getSheetAt(0);
 
for (int i=0; i <=2; i++){
 
        Cell resultCell= sheet.getRow(i).getCell(2);
        WebElement searchbox = driver.findElement(By.xpath("//.//*[@id='identifierId']"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchbox1= driver.findElement(By.xpath("//.//*[@id='password']/div[1]/div/div[1]/input"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String keyword = sheet.getRow(i).getCell(0).getStringCellValue();
        String keyword1 = sheet.getRow(i).getCell(1).getStringCellValue();
 
        //searchbox.clear();
 
        searchbox.sendKeys(keyword);
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        searchbox1.sendKeys(keyword1);
        Thread.sleep(1000);
        
        driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
              
  
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
 
        String searchText =  searchbox1.getAttribute("value");
 
        if(searchText.equals(keyword1)){
        	
              //  System.out.println("Search is successful.");
                resultCell.setCellValue("PASS");
        } else {
              //  System.out.println("Search is not successful.");
                resultCell.setCellValue("FAIL");
        }
 
}
 
  workbook.close();
  file.close();
 
  FileOutputStream outFile =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));
  workbook.write(outFile);
  outFile.close();
 
 } catch (FileNotFoundException fnfe) {
  fnfe.printStackTrace();
 } catch (IOException ioe) {
  ioe.printStackTrace();
 }
 }
}
	

