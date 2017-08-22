package RecruiterLogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class implement extends BaseClass {
	
	Logger log = Logger.getLogger("sss");

	public void DashBoard() throws Exception {
		/*
		 * @author Sakthi Praveen Kumar.k work name : DashBoard
		 */
		String mytitle="Top Jobs for Smart Talent | TechFetch.com";
		if(d.getTitle().equals(mytitle))
		{
		d.navigate().refresh();
		}
		Thread.sleep(3000);
		Properties prop;
		FileInputStream fileInput = new FileInputStream(workingDir + "\\Resources\\Dashboard.properties");
		prop = new Properties();
		prop.load(fileInput);
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe1");
		d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		css(prop.getProperty("Avaliableasof")).click();
		log.debug("Clicking Avaliable as of menu");
		

		// To display all the element from the WebPage Table WebElement table =
		xp(prop.getProperty("TableBorder"));
		log.debug("getting table border");
		// Get all rows (tr tags) List<WebElement> rows =
		/*
		 * table.findElements(By.tagName("tr"));
		 * System.out.println("No. of Rows in the WebTable: "); // Print data from each
		 * row (Data from each System.out.println(rows.size() - 1); // td tag)
		 * d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		 */

		// To Display All The Resumes according To Month Using For Loop:

		String[] months = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		for (int i = 0; i < 12; i++) {

			/*
			 * driver.findElement( By.xpath(
			 * ".//[@id='emp-col9']/div/div[2]/div[3]/div/div/div[2]/table/thead/tr[2]/td[1]/div/input"
			 * )) .clear();
			 */

			xp(prop.getProperty("AvaliableasofFieldBox")).sendKeys(months[i]);
			log.debug("getting avaliableasoffield");
			d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			WebElement table1 = xp(prop.getProperty("TableBorder"));
			log.debug("getting tableborder");
			List<WebElement> rows4 = table1.findElements(By.tagName("tr"));
			d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			System.out.println("Resumes" + months[i]);
			log.debug("printing resumes");
			System.out.println(rows4.size() - 1);
			log.debug("printing rowsize");
			xp(prop.getProperty("AvaliableasofFieldBox")).clear();
			log.debug("clearing avaliableasof field");

		}

		// Search by Name d.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		xp(prop.getProperty("SearchByNameFieldBox")).sendKeys(prop.getProperty("SearchByNameValue"));
		log.debug("getting fieldname");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("SearchByNameFieldBox")).clear();
		log.debug("clearing fieldbox");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// Search By Work Authorization

		String[] WorkAuthorization = new String[] { "US Citizen", "Green Card", "US Security Clearance" };
		for (int i = 0; i < 3; i++) {

			xp(prop.getProperty("WorkAuthorizationFieldBox")).sendKeys(WorkAuthorization[i]);
			log.debug("getting workauthorization");
			d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

			xp(prop.getProperty("WorkAuthorizationFieldBox")).clear();
			log.debug("clearing workauthorization");
			d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		} // Search By Location(City or State)

		xp(prop.getProperty("LocationFieldBox")).sendKeys(prop.getProperty("LocationSearchValue"));
		log.debug("getting location field");
		d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		xp(prop.getProperty("LocationFieldBox")).clear();
		log.debug("clearing locationfieldbox");
		// Search By Relocation

		String[] ReLocation = new String[] { "Yes", "No" };
		for (int i = 0; i < 2; i++) {

			xp(prop.getProperty("RelocationFieldBox")).sendKeys(ReLocation[i]);
			log.debug("getting relocationfield");
			d.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			xp(prop.getProperty("RelocationFieldBox")).clear();
			log.debug("clearing relocationfield");
		}

		// search By Specialized Area

		xp(prop.getProperty("SpecializedAreaFieldBox")).sendKeys(prop.getProperty("SpecializedAreaSearchValue"));
		log.debug("getting specializedarea");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		xp(prop.getProperty("SpecializedAreaFieldBox")).clear();
		log.debug("clearing specializedarea");
		// Search By Experience
		xp(prop.getProperty("ExperienceFieldBox")).sendKeys(prop.getProperty("ExperienceSearchValue"));
		log.debug("getting experiencefield");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		xp(prop.getProperty("ExperienceFieldBox")).clear();
		log.debug("clearing experiencefieldbox");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Search By Rate
		xp(prop.getProperty("RateFieldBox")).sendKeys(prop.getProperty("RateSearchValue"));
		log.debug("getting ratefieldbox");
		// Profile Click

		xp(prop.getProperty("ProfileClick")).click();
		log.debug("clicking profile");
		String window1 = d.getWindowHandle();
		System.out.println(window1);
		log.debug("printing window1 output");
		Set<String> windows = d.getWindowHandles();
		Iterator iterator = windows.iterator();
		String x;
		while (iterator.hasNext()) {
			x = iterator.next().toString();

			System.out.println(x);

			// for(String x:windows){
			if (x.equals(window1) == false) {
				d.switchTo().window(x);

				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				Thread.sleep(2000);
				xp(prop.getProperty("Email")).click();
				log.debug("clicking email");
				d.switchTo().defaultContent();
				d.switchTo().frame("empchkResumecontentframe");
				xp(prop.getProperty("Subject")).sendKeys(prop.getProperty("SubjectValue"));
				log.debug("getting subject");
				xp(prop.getProperty("EmailSend")).click();
				log.debug("clicking emailsend");
				xp(prop.getProperty("EmailNotificationClose")).click();
				log.debug("clicking emailnotification");
				Thread.sleep(500);
				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				d.switchTo().defaultContent();

				// d.close();

				d.switchTo().window(x);
				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				xp(prop.getProperty("ForwardProfile")).click();
				log.debug("clicking forward profile");
				d.switchTo().defaultContent();

				d.switchTo().frame("empforwardprofilecontentframe");
				xp(prop.getProperty("ToMailID")).sendKeys(prop.getProperty("ToMailIDValue"));
				log.debug("Getting mailid");
				xp(prop.getProperty("ForwardButton")).click();
				log.debug("clicking forward button");
				xp(prop.getProperty("ForwardCloseButton")).click();
				log.debug("Clicking forward close");
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				Thread.sleep(500);
				xp(prop.getProperty("AddFeedback")).click();
				log.debug("Clicking add feedback");
				d.switchTo().defaultContent();
				d.switchTo().frame("employerfeedbackframe");

				Thread.sleep(500);

				xp(prop.getProperty("OpenToRelocate")).click();
				log.debug("Clicking opento relocate");
				xp(prop.getProperty("Save&Close")).click();
				log.debug("Clicking Save button");
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				d.close();

				/*
				 * xp(prop.getProperty("AddNote")).click(); d.switchTo().defaultContent();
				 * 
				 * Thread.sleep(1000); d.switchTo().frame("addnotesframe");
				 * 
				 * xp(prop.getProperty("TextBoxField")).sendKeys(prop.getProperty("TextBoxValue"
				 * )); xp(prop.getProperty("Save&close")).click();
				 */

			}
		}
		d.switchTo().window(window1);
		Thread.sleep(1000);
	}

	public void postjob() throws Exception {

		/**
		 * @author surya Balapriya work name : postjobs
		 */
		String workingDir;

		workingDir = System.getProperty("user.dir");

		File file = new File(workingDir + "\\Resources\\postjob.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		id(prop.getProperty("postjobs")).click();

		d.switchTo().defaultContent();

		d.switchTo().frame("Iframe2");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		id(prop.getProperty("Jobtitle")).clear();
		log.debug("clearing title");
		id(prop.getProperty("Jobtitle")).sendKeys(prop.getProperty("jobtitle"));
		log.debug("getting title");
		id(prop.getProperty("Requiredskills")).clear();
		log.debug("clearing skills");
		id(prop.getProperty("Requiredskills")).sendKeys(prop.getProperty("requiredskills"));
		log.debug("getting skills");
		id(prop.getProperty("Preferredskill")).clear();
		log.debug("clearing preferredskills ");
		id(prop.getProperty("Preferredskill")).sendKeys(prop.getProperty("preferredskill"));
		log.debug("getting preferredskills");
		id(prop.getProperty("explevel")).click();
		log.debug("clicking explevel");
		id(prop.getProperty("Jobdescription")).clear();
		log.debug("clearing jobdescription");
		id(prop.getProperty("Jobdescription")).sendKeys(prop.getProperty("jobdescription"));
		log.debug("getting jobdescription");
		id(prop.getProperty("Clientname")).clear();
		log.debug("clearing clientname");
		id(prop.getProperty("Clientname")).sendKeys(prop.getProperty("clientname"));
		log.debug("getting clientname");
		id(prop.getProperty("Buttonclick")).click();
		log.debug("clicking button");
		Thread.sleep(7000);
		id(prop.getProperty("City")).sendKeys(prop.getProperty("city"));
		log.debug("getting city");
		Thread.sleep(7000);
		css(prop.getProperty("citylist")).click();
		log.debug("clicking citylist");
		Thread.sleep(7000);

		new Select(id(prop.getProperty("Jobexp"))).selectByVisibleText("1 Week");
		log.debug("selecting jobexp");
		id(prop.getProperty("consulting")).click();
		log.debug("clicking consulting");
		id(prop.getProperty("workauthori")).click();
		log.debug("clicking workauthor");
		id(prop.getProperty("preferemp")).click();
		log.debug("clicking preferemp");
		id(prop.getProperty("Duration")).clear();
		log.debug("clearing duration");
		id(prop.getProperty("Duration")).sendKeys(prop.getProperty("duration"));
		log.debug("getting duration");
		Select select = new Select(xp(prop.getProperty("splarea")));
		log.debug("selecting splarea");
		Select select1 = new Select(xp(prop.getProperty("splskills")));
		log.debug("selecting splskills");
		for (int i = 0; i <= 27; i++) {
		select.selectByIndex(i);
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		}

		select.selectByIndex(1);
		select1.selectByIndex(1);

		id(prop.getProperty("savebtn")).click();
		log.debug("clicking savebtn");
		id(prop.getProperty("others")).click();
		log.debug("clicking others");
		id(prop.getProperty("domainexpo")).click();
		log.debug("domainexpo");
		id(prop.getProperty("domainexpo1")).click();
		log.debug("getting domainexpo1");
		id(prop.getProperty("domainexpo2")).click();
		log.debug("getting domainexpo2");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		id(prop.getProperty("postmyjob")).click();
		log.debug("clicking postmyjob");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		xp(prop.getProperty("closebtn")).click();
		log.debug("clicking closebutton");
		d.switchTo().defaultContent();
	}

	public void Jobresponse() throws Exception {

		/**
		 * @author Santhalakshmi work name :Jobresponse
		 */

		File file = new File(workingDir + "\\Resources\\jobresponse.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);

		// jobresponse tab
		css(prop.getProperty("jobresponse")).click();
		log.debug("clicking jobresponse");
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		d.switchTo().defaultContent();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.switchTo().frame("Iframe4");
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Select Select = new Select(id(prop.getProperty("resumetitle")));
		// d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		// resumelink click
		css(prop.getProperty("resumelink")).click();
		log.debug("clicking resumelink");
		String window1 = d.getWindowHandle();
		System.out.println(window1);

		Set<String> windows = d.getWindowHandles();
		Iterator iterator = windows.iterator();
		String x;
		while (iterator.hasNext()) {
			x = iterator.next().toString();

			System.out.println(x);

			// for(String x:windows){
			if (x.equals(window1) == false) {
				// switch to window
				d.switchTo().window(x);
				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// forwarding

				Thread.sleep(2000);
				css(prop.getProperty("forward")).click();
				log.debug("clicking forward");
				Thread.sleep(500);
				d.switchTo().defaultContent();
				d.switchTo().frame("empforwardprofilecontentframe");
				d.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				css(prop.getProperty("toaddress")).sendKeys(prop.getProperty("tomailid"));
				log.debug("getting toaddress ");
				css(prop.getProperty("send")).click();
				log.debug("clicking send");
				d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				css(prop.getProperty("close")).click();
				log.debug("clicking close");
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				Thread.sleep(2000);
				// d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// downloading
				//css(prop.getProperty("download")).click();
				
				d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// check email availability
				css(prop.getProperty("checkmail")).click();
				log.debug("clicking checkmail");
				d.switchTo().defaultContent();
				d.switchTo().frame("empchkResumecontentframe");
				css(prop.getProperty("subject")).sendKeys(prop.getProperty("Resume"));
				log.debug("clicking postmyjob");
				css(prop.getProperty("submit")).click();
				log.debug("clicking submit");
				css(prop.getProperty("close")).click();
				log.debug("clicking close");
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				d.close();
			}
			d.switchTo().window(window1);
			Thread.sleep(1000);
		}

	}

	public void fetchresume() throws InterruptedException, IOException {

		/**
		 * @author Karthigavalli work name :Fetch Resume
		 */

		File file = new File(workingDir + "\\Resources\\rec.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		
		d.switchTo().defaultContent();
		
		xp(prop.getProperty("fetch")).click();
		log.debug("clicking postmyjob");
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe5");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		id(prop.getProperty("key")).sendKeys(prop.getProperty("keyword"));
		log.debug("getting key");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		id(prop.getProperty("all")).click();
		log.debug("clicking all");
		id(prop.getProperty("workAuthority")).click();
		log.debug("clicking workAuthority");
		id(prop.getProperty("workAuthority1")).click();
		log.debug("clicking workAuthority1");
		id(prop.getProperty("workAuthority2")).click();
		log.debug("clicking workAuthority2");
		id(prop.getProperty("workAuthority3")).click();
		log.debug("clicking workAuthority3");
		id(prop.getProperty("preferedEmployment")).click();
		log.debug("clicking preferedEmployment");
		id(prop.getProperty("preferedEmployment1")).click();
		log.debug("clicking preferedEmployment1");
		id(prop.getProperty("preferedEmployment2")).click();
		log.debug("clicking preferedEmployment2");
		id(prop.getProperty("preferedEmployment3")).click();
		log.debug("clicking preferedEmployment3");
		id(prop.getProperty("preferedEmployment4")).click();
		log.debug("clicking preferedEmployment4");
		id(prop.getProperty("workAuthority")).click();
		log.debug("clicking workAuthority");
		id(prop.getProperty("workAuthority1")).click();
		log.debug("clicking workAuthority1");
		id(prop.getProperty("preferedEmployment")).click();
		log.debug("clicking preferedEmployment ");
		id(prop.getProperty("preferedEmployment1")).click();
		log.debug("clicking prefered employment1");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		new Select(id(prop.getProperty("area"))).selectByVisibleText("Java, J2EE");
		log.debug("getting area");
		new Select(id(prop.getProperty("skill"))).selectByVisibleText("Java Server Side");
		log.debug("getting skill");
		id(prop.getProperty("advancedSearch")).click();
		log.debug("clicking advanced search");
		Thread.sleep(1000);
		xp(prop.getProperty("domain1")).click();
		log.debug("clicking domain1");
		xp(prop.getProperty("domain2")).click();
		log.debug("clicking domain2");
		id(prop.getProperty("country")).click();
		log.debug("clicking country");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		new Select(id(prop.getProperty("degree"))).selectByVisibleText("Bachelor");
		log.debug("getting degree");
		Select select = new Select(id(prop.getProperty("state")));
		log.debug("getting state");
		List<WebElement> l = select.getOptions();
		for (int i = 0; i < 6; i++) {
			select.selectByIndex(i);
			xp(prop.getProperty("arrow")).click();
			log.debug("clicking arrow");
		}
		id(prop.getProperty("Experience")).click();
		log.debug("clicking experience");
		id(prop.getProperty("usExperience")).click();
		log.debug("clicking usExperience");
		id(prop.getProperty("askill1")).sendKeys(prop.getProperty("skill1"));
		log.debug("getting askill1");
		new Select(id(prop.getProperty("year1"))).selectByVisibleText("4");
		log.debug("getting year1");
		id(prop.getProperty("askill2")).sendKeys(prop.getProperty("skill1"));
		log.debug("getting askill2");
		new Select(id(prop.getProperty("year2"))).selectByVisibleText("2");
		log.debug("getting year2");
		id(prop.getProperty("askill3")).sendKeys(prop.getProperty("skill1"));
		log.debug("getting askill3");
		new Select(id(prop.getProperty("year3"))).selectByVisibleText("4");
		log.debug("getting year");
		xp(prop.getProperty("save")).sendKeys(prop.getProperty("fetching"));
		log.debug("getting save");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		new Select(id(prop.getProperty("days"))).selectByVisibleText("90 Days");
		log.debug("getting days");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		id(prop.getProperty("fetched")).click();
		log.debug("clicking fetched");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		 d.switchTo().defaultContent();
		     Thread.sleep(4000);
		         xp(prop.getProperty("loggggggg")).click();
		         log.debug("clicking logg");
		         Thread.sleep(4000);
		         xp(prop.getProperty("logggggggoooo")).click();
		         log.debug("clicking log");
		         }
		
	public void Jobs() throws Exception {
		File file = new File(workingDir + "\\Resources\\myjob.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		d.switchTo().defaultContent();
		css(prop.getProperty("jobmenu")).click();
		log.debug("clicking jobmenu");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");
		xp(prop.getProperty("updateddate")).sendKeys(prop.getProperty("month"));
		log.debug("getting updatedate");
		xp(prop.getProperty("jobtitle")).sendKeys(prop.getProperty("lang"));
		log.debug("getting jobtitle");
		xp(prop.getProperty("location")).sendKeys(prop.getProperty("cty4"));
		log.debug("clicking location");
		d.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		xp(prop.getProperty("preview")).click();
		log.debug("clicking preview");
		String window1 = d.getWindowHandle();
		System.out.println(window1);

		Set<String> windows = d.getWindowHandles();
		Iterator iterator = windows.iterator();
		String x;
		while (iterator.hasNext()) {
			x = iterator.next().toString();

			System.out.println(x);

			// for(String x:windows){
			if (x.equals(window1) == false) {
				d.switchTo().window(x);
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

				xp(prop.getProperty("applynow")).click();
				log.debug("clicking applynow");
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				new Select(d.findElement(By.id(prop.getProperty("selectfromprofile")))).selectByVisibleText("Doles Pierre (Pierre) [Active]");
				log.debug("getting selectfromprofile");
				css(prop.getProperty("optionvalue")).click();
				log.debug("clicking optionvalue");
				id(prop.getProperty("cc")).clear();
				log.debug("clearing cc");
				id(prop.getProperty("cc")).sendKeys(prop.getProperty("tooo"));
				log.debug("getting cc");
				id(prop.getProperty("coveringletter")).click();
				log.debug("clicking coveringletter");
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				id(prop.getProperty("fileupload")).clear();
				log.debug("clearing fileupload");
				// d.findElement(By.xpath(".//*[@id='uploaddiv']/div/div/div")).click();
				id(prop.getProperty("fileupload")).sendKeys(workingDir +"\\Resources\\ram.docx");
				log.debug("getting file");
				// d.findElement(By.id("uploadvalue2")).sendKeys("C:\\Users\\mag8\\Desktop\\res.docx");
				id(prop.getProperty("sendemail")).click();
				log.debug("clicking sendmail");
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				d.switchTo().defaultContent();
				d.switchTo().frame("applyemailframe");
				xp(prop.getProperty("btnclose")).click();
				log.debug("clicking btnclose");
				// forward
				Thread.sleep(5000);
				d.switchTo().defaultContent();
				d.switchTo().window(x);
				xp(prop.getProperty("forwardjob")).click();
				log.debug("clicking fwdjob");
				d.switchTo().defaultContent();
				d.switchTo().frame("jsfwdjobcontentframe");
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				xp(prop.getProperty("toaddr")).sendKeys(prop.getProperty("tooo"));
				log.debug("getting toaddr");
				Thread.sleep(2000);
				xp(prop.getProperty("sendmail")).click();
				log.debug("clicking sendmail");
				d.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			d.close();
			}
		}
		
		//FORWARD
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().window(window1);
		css(prop.getProperty("jobmenu")).click();
		log.debug("clicking jobmenu");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");

		xp(prop.getProperty("updateddate")).clear();
		log.debug("clearing updatedate");
		xp(prop.getProperty("jobtitle")).clear();
		log.debug("clearing jobtitle");
		xp(prop.getProperty("location")).clear();
		log.debug("clearing location");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		xp(prop.getProperty("updateddate")).sendKeys(prop.getProperty("month8"));
		log.debug("getting updatedate");
		xp(prop.getProperty("jobtitle")).sendKeys(prop.getProperty("lang8"));
		log.debug("getting jobtitle");
		xp(prop.getProperty("location")).sendKeys(prop.getProperty("cty8"));
		log.debug("getting location");
		//xp(prop.getProperty("fwd")).click();
		//d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//d.switchTo().frame(d.findElement(By.xpath(prop.getProperty("forwardmain"))));
		//d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//xp(prop.getProperty("toaddr")).sendKeys(prop.getProperty("tooo"));
		//Thread.sleep(1000);
		//css(prop.getProperty("sendmail1")).click();
		//d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	

		// EDIT

		// @author surya Balapriya work name : edit
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe7");
		xp(prop.getProperty("updateddate")).clear();
		log.debug("clearing uodatedate");
		xp(prop.getProperty("jobtitle")).clear();
		log.debug("clearing jobtitle");
		xp(prop.getProperty("location")).clear();
		log.debug("clearing location");
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		xp(prop.getProperty("edit")).click();
		log.debug("clicking edit");
		d.switchTo().defaultContent();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.switchTo().frame("Iframe8");

		id(prop.getProperty("jobtitle5")).clear();
		log.debug("clicking jobtitle5");
		id(prop.getProperty("jobtitle5")).sendKeys(prop.getProperty("Title"));
		log.debug("getting jobtitle5");
		Thread.sleep(1000);
		
		id(prop.getProperty("skillreq")).clear();
		log.debug("clicking skillreq");
		id(prop.getProperty("skillreq")).sendKeys(prop.getProperty("Title"));
		log.debug("getting skillreq");
		id(prop.getProperty("exlevel")).click();
		log.debug("clicking exlevel");
		id(prop.getProperty("exlevel1")).click();
		log.debug("clicking exlevel1");
		id(prop.getProperty("exlevel2")).click();
		log.debug("clicking exlevel2");
		id(prop.getProperty("exlevel3")).click();
		log.debug("clicking exlevel3");
		id(prop.getProperty("exlevel4")).click();
		log.debug("clicking exlevel4");
		d.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		xp(prop.getProperty("permanenttype")).click();
		log.debug("clicking Parametertype");
		id(prop.getProperty("Work1")).click();
		log.debug("clicking work1");
		Thread.sleep(1000);
		
		id(prop.getProperty("PreferredEmployment5")).click();
		log.debug("clicking PreferredEmployment5");
		Thread.sleep(1000);
		
		new Select(id(prop.getProperty("splarea1"))).selectByVisibleText("Java, J2EE");
		log.debug("getting splarear1");
		new Select(id(prop.getProperty("splskill1"))).selectByVisibleText("Java, J2EE");
		log.debug("getting splskill1");
		id(prop.getProperty("domainlist0")).click();
		log.debug("clicking domainlist0 ");
		id(prop.getProperty("domainlist2")).click();
		log.debug("clicking domianlist2");
		id(prop.getProperty("preview1")).click();
		log.debug("clicking preview1");
		Thread.sleep(5000);
		
		d.findElement(By.linkText(prop.getProperty("closebutton"))).click();
		log.debug("clicking clsbutton");
		Thread.sleep(5000);
		
		d.switchTo().defaultContent();
	xp(prop.getProperty("matchclose")).click();
	log.debug("clicking matchclose");
	xp(prop.getProperty("jobclose")).click();
	log.debug("clicking jobclose");
	//id(prop.getProperty("updatebutton")).click();
		//Thread.sleep(5000);
		//xp(".//*[@id='tabs']/ul/li[3]/span").click();
		//d.close();
	}
	
	public void myaccount() throws Exception
	{
		File file = new File(workingDir + "\\Resources\\myaccount.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		String winHandleBefore = d.getWindowHandle();
		for(String winHandle : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle);
	
		xp(prop.getProperty("myaccount")).click();
		log.debug("clicking myaccount");
		Thread.sleep(1000);
	
		d.switchTo().frame("Iframe9");
		xp(prop.getProperty("txt_mail")).clear();
		log.debug("clearing txtmail");
		xp(prop.getProperty("txt_mailid")).sendKeys(prop.getProperty("username"));
		log.debug("getting txtmail");
		Thread.sleep(1000);
		xp(prop.getProperty("Firstname")).clear();
		log.debug("clearing firstname ");
		xp(prop.getProperty("Firstname")).sendKeys("Trainee");
		log.debug("getting firstname");
		Thread.sleep(1000);
		xp(prop.getProperty("Lastname")).clear();
		log.debug("clearing lastname");
		xp(prop.getProperty("Lastname")).sendKeys("One");
		log.debug("getting lastname");
		Thread.sleep(1000);
		xp(prop.getProperty("companyname")).clear();
		log.debug("clearing companyname");
		xp(prop.getProperty("companyname")).sendKeys("Techpark");;
		log.debug("getting companyname");
		Thread.sleep(1000);
		xp(prop.getProperty("country")).sendKeys("India");
		log.debug("getting country");
		Thread.sleep(1000);
		xp(prop.getProperty("city")).clear();
		log.debug("clearing city");
		xp(prop.getProperty("city")).sendKeys("Mumbai, Maharashtra");
		Thread.sleep(1000);
		xp(prop.getProperty("personalid")).clear();
		log.debug("clearing personalid");
		xp(prop.getProperty("personalid")).sendKeys("qatraining1@tiliconveli.com");
		log.debug("getting personalid");
		Thread.sleep(1000);
	
		xp(prop.getProperty("ph_area")).sendKeys("+91");
		log.debug("getting ph area");
		Thread.sleep(1000);
		xp(prop.getProperty("phno")).clear();
		log.debug("clearing phno");
		xp(prop.getProperty("phno")).sendKeys("9487525100");
		log.debug("getting phno");
		Thread.sleep(1000);
		xp(prop.getProperty("update")).click();
		log.debug("clicking update");
		Thread.sleep(5000);
		
		}
		String winHandleBefore1 = d.getWindowHandle();
		for(String winHandle1 : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle1);
	
		
		css(prop.getProperty("passclick")).click();  
		log.debug("clicking Passclick");
		d.switchTo().frame("Iframe10");
		xp(prop.getProperty("passreset")).sendKeys(prop.getProperty("password"));
		log.debug("getting passreset");
		Thread.sleep(2000);
		css(prop.getProperty("passreset1")).sendKeys(prop.getProperty("password"));
		log.debug("getting passreset1");
		Thread.sleep(2000);
		xp(prop.getProperty("resetbutton")).click();
		log.debug("clicking resetbutton");
		Thread.sleep(5000);
	
		}
	
		
		String winHandleBefore2 = d.getWindowHandle();
		for(String winHandle2 : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle2);
		
		
		css(prop.getProperty("preference")).click();
		log.debug("clicking preferences");
		d.switchTo().defaultContent();
		d.switchTo().frame("Iframe11");
		
		Thread.sleep(2000);
		
		css(prop.getProperty("radio2")).click();
		log.debug("clicking radio2");
		Thread.sleep(2000);
		css(prop.getProperty("radio1")).click();
		log.debug("clicking radio1");
		Thread.sleep(2000);
		css(prop.getProperty("radio4")).click();
		log.debug("clicking radio4");
		Thread.sleep(2000);
		css(prop.getProperty("radio3")).click();
		log.debug("clicking radio3");
		Thread.sleep(2000);
		css(prop.getProperty("radio6")).click();
		log.debug("clicking radio6");
		Thread.sleep(2000);
		css(prop.getProperty("radio5")).click();
		log.debug("clicking radion5");
		Thread.sleep(2000);
		css(prop.getProperty("radio_button")).click();
		log.debug("clicking radiobutton");
		Thread.sleep(2000);
		}

		String winHandleBefore3 = d.getWindowHandle();
		for(String winHandle3 : d.getWindowHandles())
		{
		    d.switchTo().window(winHandle3);
		    xp(prop.getProperty("user")).click();
		    log.debug("clicking user");
		    Thread.sleep(2000);
		   
		}	   
		}
		

		
	

}