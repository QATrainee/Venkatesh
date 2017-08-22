package apaches;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Gmail {
	
WebDriver driver1;
	
@Test(enabled = false)

public void testCase1() throws InterruptedException{
	driver1.findElement(By.cssSelector(".gb_8a.gbii")).click();
	driver1.findElement(By.cssSelector("#gb_71")).click();
	Thread.sleep(1000);
//driver1.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
//driver1.findElement(By.id("identifierId")).clear();

}
@Test (dependsOnMethods={"testCase4"})
	
public void testCase2(){
driver1.findElement(By.xpath("//.//*[@id='identifierId']")).sendKeys("selvavenkattesting");
	driver1.findElement(By.cssSelector("span.RveJvd.snByac")).click();
	driver1.findElement(By.xpath("//.//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("selvavenkat30");
driver1.findElement(By.cssSelector(".RveJvd.snByac")).click();
 //driver1.findElement(By.xpath("//.//*[@id='identifierNext']/content/span")).click();
		
}
@Test
	
public void testCase3(){
	driver1.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	//driver1.get("https://accounts.google.com//signin") ;		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
}
@Test 
	public void testCase4(){
System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver.exe");
	driver1 = new ChromeDriver();
}	
}
