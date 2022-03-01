package HMS.AdminLogin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.DashboardPage;
import hms.pages.FrontofficePage;
import hms.pages.LoginPage;

public class FrontofficeTest extends Testbase {
	
	LoginPage objlog;
	DashboardPage objdash;
	FrontofficePage objfrnt;
	
 public FrontofficeTest() {
	 super();
 }

 @BeforeMethod
	public void setup() {
		initialization();
		objlog = new LoginPage();
		objdash=objlog.adminlogin(prop.getProperty("Username"), prop.getProperty("password"));
		objfrnt= objdash.frntofficeclick();
 }
@Test
public void frontofficerun() {
	String pgtitle= "Appointment Details";
	Assert.assertEquals(pgtitle, objfrnt.formtitlecheck());;
	objfrnt.visitorbookopen();
	                         }

public void close() {
	driver.close();
}
}
