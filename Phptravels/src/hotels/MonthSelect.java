package hotels;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MonthSelect {

	
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\External jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.phptravels.net");
		//driver.findElement(By.xpath("html/body/nav[1]/div/div/div/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".select2-chosen")).click();
		driver.findElement(By.cssSelector(".select2-input.select2-focused")).sendKeys("Dub");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li/ul/li[1]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".form.input-lg.dpd1")).click();
		Thread.sleep(2000);
		String ExpMonth = "November 2017";
		driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[3]")).click();
		String CurrMonth=driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[2]")).getText();
		if (ExpMonth.equals(CurrMonth)) {
			System.out.println("Already Selected"); 
		}
		else {
			for(int i=1;i<12;i++) {
				driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(2000);
				CurrMonth=driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[2]")).getText();
				if (ExpMonth.equals(CurrMonth)) {
					System.out.println("Month Selected"); 
					break;
			}
		}
	}
		Thread.sleep(2000);
		WebElement datepicker = driver.findElement(By.xpath("html/body/div[13]/div[1]/table/tbody/tr[3]/td[3]"));
		datepicker.click();
		Thread.sleep(2000);	
		driver.findElement(By.cssSelector(".form.input-lg.dpd2")).clear();
		Thread.sleep(2000);
		String ExpsMonth = "December 2017";
		driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
		String CurrsMonth=driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
		if (ExpsMonth.equals(CurrsMonth)) {
		System.out.println("Already Selected"); 
	}
		else {
		for(int i=1;i<12;i++) {
			driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
			Thread.sleep(2000);
			CurrsMonth=driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
			if (ExpsMonth.equals(CurrsMonth)) {
				System.out.println("Month Selected"); 
				break;
		}
	}
}
	Thread.sleep(2000);
	WebElement datepicker1 = driver.findElement(By.xpath("html/body/div[14]/div[1]/table/tbody/tr[3]/td[5]"));
	datepicker1.click();
	Thread.sleep(3000);
	driver.findElement(By.id("adults")).click();
	Thread.sleep(2000);
	new Select(driver.findElement(By.id("adults"))).selectByVisibleText("4");
	//driver.findElement(By.cssSelector("#adults > option[value=\"4\"]")).click();
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("//h4/a/b")).click();
	for(int i=0;i<10;i++) {
	driver.findElement(By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]")).click();
	Thread.sleep(1000);
}
	driver.quit();
}
}

