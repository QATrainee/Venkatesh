package structtes;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Subclass1 extends  Baseclass{
	
	public void upload() throws Exception {
		// uploading a resume from external path
		/**
		 * @author karthiga balapriya work name : upload
		 */
		Properties prop ;
		FileInputStream fileInput = new FileInputStream("E:\\workspace\\Structtestng\\Locator.properties");
		prop = new Properties();
		prop.load(fileInput);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");

		driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[4]/a/img")).click();
		log.debug("Clicking Replacedocs");

		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("replacedoccontentframe");
		Thread.sleep(1000);
		driver.findElement(By.id("resumeupload")).clear();
		driver.findElement(By.id("resumeupload")).sendKeys(prop.getProperty("path"));
		log.debug("Uploading Resume");

		Thread.sleep(10000);

		driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
		log.debug("Clicking Submit button");

		Thread.sleep(3000);
		driver.findElement(By.id("btnClose")).click();
		log.debug("Clicking Close button");

	}

}

