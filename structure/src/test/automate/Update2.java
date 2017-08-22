package test.automate;

import java.util.Properties;
import  test.automate.Updateee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Update2 extends Updateee {
	/*public Update2(WebDriver driver) throws Exception {
		super(driver);
		// TODO Auto-generated constructor stub
	}*/

	//static WebDriver driver;
	
	
	public static void main(String[] args) throws Exception  {
		
		
		Test sss=new Test();
        sss.browserOpen();
		try {
			sss.logIn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Updateee up;
		up.aaa();
		
	}
}
