package apaches;

import java.io.*;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample{

 public static void main(String[] args) throws InterruptedException { 

	 System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver.exe");
 	ChromeDriver driver = new ChromeDriver();

 	driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

        driver.manage().window().maximize();  
       
        
        
       

 try {
    
  FileInputStream file = new FileInputStream(new File("D:\\workspace\\apache\\login.xlsx")); 
  XSSFWorkbook workbook = new XSSFWorkbook(file);

  XSSFSheet sheet = workbook.getSheetAt(0);

        Cell resultCell= sheet.getRow(0).getCell(2);
        //Cell resultcell1=sheet.getRow(2).getCell(3);
        WebElement username = driver.findElement(By.xpath("//.//*[@id='identifierId']"));
        String usernamevalue = sheet.getRow(0).getCell(0).getStringCellValue();
        driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement password=driver.findElement(By.xpath("//.//*[@id='password']/div[1]/div/div[1]/input"));
        String passwordvalue=sheet.getRow(0).getCell(1).getStringCellValue();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        username.sendKeys(usernamevalue);
        password.sendKeys(passwordvalue);

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        String usernametext=  username.getAttribute("value");
        String passwordtext= password.getAttribute("value");

        if(usernametext.equals(usernamevalue)){
           System.out.println("set is successful.");
            resultCell.setCellValue("PASS");
            }
     else {
            System.out.println("set is not successful.");
            resultCell.setCellValue("FAIL");
    }

  
  file.close();

  FileOutputStream outFile =new FileOutputStream(new File("D:\\workspace\\apache\\login.xlsx"));
  workbook.write(outFile);
  outFile.close();

 } catch (FileNotFoundException fnfe) {
  fnfe.printStackTrace();
 } catch (IOException e) {
  e.printStackTrace();
 }
 driver.findElement(By.name("signIn")).click();

 }
}