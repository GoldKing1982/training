package HMS.AdminLogin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.DashboardPage;
import hms.pages.LoginPage;

public class DashboardTest extends Testbase {

	LoginPage objlog;
	DashboardPage objdash;
	
	public DashboardTest(){
		super();
		}
	
	@BeforeMethod
	public void setup() {
		initialization();
		objlog = new LoginPage();
		objdash=objlog.adminlogin(prop.getProperty("Username"), prop.getProperty("password"));
		
	}
	@Test
	public void Dashboardcheck() {
		String Expectedtitle="Smart Hospital Management System";
		Assert.assertEquals(objdash.verifypagetitle(), Expectedtitle);
		String Expectedname = "Super Admin";
		Assert.assertEquals(objdash.verifyprofilerole(), Expectedname);
				
	}
	
	@AfterMethod
	public void exitprog() {
		objdash.applogout();
	}
	
	public void close() {
		driver.close();
	}
		
}
