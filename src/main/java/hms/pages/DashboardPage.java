package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class DashboardPage extends Testbase{
	@FindBy(css="img.topuser-image") WebElement profile;
	@FindBy(xpath="//h5[text()='Super Admin']") WebElement profilerole;
	@FindBy(css="div.sspass>a:nth-child(3)") WebElement logout;
	@FindBy(xpath="//*[text()='Front Office']") WebElement frntoffce;
	
public DashboardPage() {
	PageFactory.initElements(driver, this);
}

public String verifypagetitle() {
	return driver.getTitle();
}

public String verifyprofilerole() {
	profile.click();
	waitforElement(profilerole);
	return profilerole.getText();
}

public FrontofficePage frntofficeclick() {
	frntoffce.click();
	return new FrontofficePage();
}

public void applogout(){
	logout.click();
}

}
