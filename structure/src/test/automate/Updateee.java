package test.automate;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Updateee extends Test  {
	// WebDriver driver1;

	/*public Updateee(WebDriver driver) throws Exception {
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}*/
	Updateee up=new Updateee();
	Properties prop;
	
	public void aaa() throws Exception {
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[@id='cssmenu']/ul/li[2]/a/i")).click();
	driver.getTitle();
		driver.switchTo().defaultContent();
	driver.switchTo().frame("contentframe");
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[4]/a/img")).click();
	}
	public void buy() {
	driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[4]/a/img")).click();
	//log.debug("Clicking Replacedocs");
	}
	public void hi() throws Exception {
	Thread.sleep(1000);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("replacedoccontentframe");
	Thread.sleep(1000);
	driver.findElement(By.id("resumeupload")).clear();
	driver.findElement(By.id("resumeupload")).sendKeys(prop.getProperty("path"));
	//log.debug("Uploading Resume");

	Thread.sleep(10000);

	driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
	//log.debug("Clicking Submit button");

	Thread.sleep(3000);
	driver.findElement(By.id("btnClose")).click();}
	//log.debug("Clicking Close button");}}
	

	

}
