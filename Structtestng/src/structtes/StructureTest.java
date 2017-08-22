package structtes;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StructureTest extends Subclass1 {
	Subclass1 ii = new Subclass1();

	@BeforeTest
	public void f() throws Exception {
		ii.browserOpen();
		ii.logIn();
	}

	@Test
	public void g() throws Exception {

		ii.upload();

	}

	@AfterTest
	public void h() throws Exception {

		ii.logOut1();
		ii.browserClose();

	}
}
