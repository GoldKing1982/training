package HMS.AdminLogin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hms.base.Testbase;
import hms.pages.DashboardPage;
import hms.pages.FrontofficePage;
import hms.pages.LoginPage;
import hms.pages.visitorPage;
import hms.utility.ReadExcel;

public class VisitorTest extends Testbase {
	
	LoginPage objlog;
	DashboardPage objdash;
	FrontofficePage objfrnt;
	visitorPage objvst;
	
	public VisitorTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		objlog = new LoginPage();
		objdash=objlog.adminlogin(prop.getProperty("Username"), prop.getProperty("password"));
		objfrnt= objdash.frntofficeclick();
		objvst=objfrnt.visitorbookopen();
	}
	
	@Test(dataProvider="visdata")
	public void visitorpagerun(String vdata[]) {
		String expectitle = "Visitor List";
		Assert.assertEquals(expectitle, objvst.vistortitlecheck());
		objvst.addvisitor();
		Assert.assertTrue(objvst.addvisitortitle());
		objvst.visitorpurpose(vdata);
		objfrnt=objvst.visitorpagevalue(vdata);

	}
	
	@DataProvider
	public Object[][] visdata(){
		Object[][] data=ReadExcel.getTestData("testdata");
		return data; 
	}
	
	
	@AfterMethod
	public void entervalue() {
		objvst.close();

	}
	public void close() {
		driver.close();
	}
		
	}


