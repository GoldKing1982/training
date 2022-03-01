package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hms.base.Testbase;

public class FrontofficePage extends Testbase{
	
	@FindBy(css="h3.box-title.titlefix") WebElement formtitle;
	@FindBy(xpath="//a[@href=\"http://triotend.com/tts/admin/visitors\"]") WebElement visitorbook;
	@FindBy (css="a[data-toggle='modal']") WebElement AddAppClick;
	
public FrontofficePage() {
	PageFactory.initElements(driver, this);
	
}

public String formtitlecheck() {
	return formtitle.getText();
}

public visitorPage visitorbookopen() {
	visitorbook.click();
	return new visitorPage();
	}

public AddappPage addappclick() {
	AddAppClick.click();
	return new AddappPage();
}
}
