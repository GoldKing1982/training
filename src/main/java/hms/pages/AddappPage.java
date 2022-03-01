package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Datepicker;

public class AddappPage extends Testbase{
	
	@FindBy (css="#myModal h4[class=box-title]") WebElement AppTitle;
	@FindBy (css="input#patient_id") WebElement AppPId;
	@FindBy (css="input#patient_name") WebElement AppPName;
    @FindBy (css="select#gender") WebElement AppGen;
    @FindBy (css="input#email") WebElement AppMail; 
    @FindBy (css="input#phone") WebElement AppPhone; 
    @FindBy (css="select[name='doctor']") WebElement AppDoc;
    @FindBy (css="form#formadd textarea[name='message']") WebElement AppNote;
   // @FindBy (css="form#formadd input[id='date']") WebElement datepicker;
    //Datepicker dat=new Datepicker();
    
    
    public AddappPage() {
    	PageFactory.initElements(driver, this);
    	    }
    
    
    public String apptitlemet() {
    	waitforElement(AppTitle);
    	return AppTitle.getText();
    }
    
    public FrontofficePage appaddmet() {
    	waitforElement(AppPId);
    	AppPId.sendKeys("21231");
    	AppPName.sendKeys("John Rambo");
    	waitforElement(AppMail);
    	AppMail.sendKeys("JohnRambo@gmail.com");
    	waitforElement(AppPhone);
    	AppPhone.sendKeys("98298238222");
    	AppNote.sendKeys("The patient is underoing chemo");
    	//datepicker.click();
    	//dat.datpicker("3/4/2023");
    	
		return new FrontofficePage();
    }
    
    public void appgenmet() {
    	Select Gen = new Select(AppGen);
		Gen.selectByValue("Male");
    }
    
    public void appdocmet() {
    	waitforElement(AppDoc);
    	Select Doc = new Select(AppDoc);
		Doc.selectByIndex(2);
    }
    public void close() {
		driver.close();
	}
}
