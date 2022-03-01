package HMS.AdminLogin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.AddappPage;
import hms.pages.DashboardPage;
import hms.pages.FrontofficePage;
import hms.pages.LoginPage;

public class AddappTest extends Testbase {
	
	LoginPage objlog;
	DashboardPage objdash;
	FrontofficePage objfrnt;
	AddappPage objaddapp;
	
	public AddappTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		objlog = new LoginPage(); 
		objdash=objlog.adminlogin(prop.getProperty("Username"), prop.getProperty("password"));
		objfrnt= objdash.frntofficeclick();
		objaddapp=objfrnt.addappclick();
	}
	
	@Test
	public void addapprunpage() {
		String expectone = "Add Appointment";
		Assert.assertEquals(expectone, objaddapp.apptitlemet());
	}
	
	@AfterMethod
	public void appaddpage() {
		objfrnt=objaddapp.appaddmet();
		//objaddapp.appgenmet();
		objaddapp.appdocmet();
		objaddapp.close();
	}
		
	public void close() {
		driver.close();
	}
}
