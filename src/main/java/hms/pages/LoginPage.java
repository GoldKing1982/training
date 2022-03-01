package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class LoginPage extends Testbase{
	@FindBy(tagName="img") WebElement logo; 
	@FindBy(css="h3.font-white.bolds") WebElement logtxt;
	@FindBy(css="input#email") WebElement usertxt;
	@FindBy(css="input#password") WebElement pwdtxt;
	@FindBy(xpath="//button[text()='Sign In']") WebElement SigninBtn;
	//@FindBy(xpath="//a[@class='forgot']") WebElement Forgotpwd;
	//@FindBy(css="input#form-username") WebElement emal;
	//@FindBy(xpath="//button[@type='submit']") WebElement Submit;
	
	
		
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifylogo() {
		return logo.isDisplayed();
	}
	
	public String verifylogintxt() {
		return logtxt.getText();
	}
	
//	public void Forgotpass(String Uname) {
//		Forgotpwd.click();
//		emal.sendKeys(Uname);
//		Submit.click();
//					}
	
	public DashboardPage adminlogin(String Uname, String Upass) {
		usertxt.sendKeys(Uname);
		pwdtxt.sendKeys(Upass);
		SigninBtn.click();
		return new DashboardPage(); 
		
		
	}
}
