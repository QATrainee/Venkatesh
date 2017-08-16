package hotels;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PhpTravels {
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\External jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.phptravels.net");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".select2-chosen")).click();
		driver.findElement(By.cssSelector(".select2-input.select2-focused")).sendKeys("Dub");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li/ul/li[1]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.name(".form.input-lg.dpd1")).click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//tr[5]/td[7]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[14]/div/table/tbody/tr[2]/td[2]")).click();
		driver.findElement(By.id("adults")).click();
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("adults"))).selectByVisibleText("4");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#adults > option[value=\"1\"]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//h4/a/b")).click();
		driver.findElement(By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]")).click();
		driver.quit();
	}	
}
