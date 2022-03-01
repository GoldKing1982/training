package HMS.AdminLogin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.LoginPage;

public class LoginTest extends Testbase{

	LoginPage objlog;

	public LoginTest() {
		super();
	}
	
		
	@BeforeMethod
	public void setup() {
		initialization();
		objlog = new LoginPage();
		}
	
	@Test
	public void loginpagetest()
	{
		Assert.assertTrue(objlog.verifylogo());
		String expectedtitle="Admin Login";
		Assert.assertEquals(objlog.verifylogintxt(), expectedtitle);
	//	objlog.Forgotpass(prop.getProperty("Username"));
		objlog.adminlogin(prop.getProperty("Username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown() {
	//	driver.close();
	}
	
	
	
}
