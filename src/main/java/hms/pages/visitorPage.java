package hms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hms.base.Testbase;
import hms.utility.Datepicker;
import hms.utility.commonutitlity;

public class visitorPage extends Testbase {
	
	@FindBy (css="h3.box-title.titlefix") WebElement vistortitle;
	@FindBy (css="a.btn.btn-primary.btn-sm") WebElement addvstr;
	@FindBy (xpath="//h4[text()=' Add Visitor']") WebElement advstrtitle;
	@FindBy (css="form#formadd select[name='purpose']") WebElement vpurpose;
	@FindBy (xpath="//input[@value='' and @name='name']") WebElement Vnme;
	@FindBy (css="form#formadd input[name='date']") WebElement datepicker;
	@FindBy (xpath="//input[@value='' and @name ='contact']") WebElement Vphone;
	@FindBy (xpath="//input[@value='' and @name='id_proof']") WebElement Vid;
	@FindBy (xpath="//input[@value='' and @name='pepples']") WebElement Vnump;
	@FindBy (xpath="//textarea[@class='form-control' and @id='description']") WebElement Vnote;
	@FindBy (css="form#formadd input[name='file']") WebElement upfile;
		
	Datepicker dat =new Datepicker();
	 
		
	public visitorPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String vistortitlecheck() {
		return vistortitle.getText();
	}
	
	public void addvisitor() {
		addvstr.click();
	}
	
	public boolean addvisitortitle() {
		waitforElement(advstrtitle);
		return advstrtitle.isDisplayed();
	}
	
	public void visitorpurpose(String data[]) {
		Select WE = new Select(vpurpose);
		WE.selectByValue(data[0]);
		}
	
	public FrontofficePage visitorpagevalue(String data[]) {
		Vnme.sendKeys(data[1]);
		Vphone.sendKeys(data[2]); 
		Vid.sendKeys(data[3]); 
		Vnump.sendKeys(data[5]); 
		Vnote.sendKeys(data[6]);
		datepicker.click();
		dat.datpicker(data[4]);
		commonutitlity.mouseclick(upfile);
		commonutitlity.fileupload(data[7]);
		
		return new FrontofficePage();
	}

	public void close() {
		driver.close();
	}


}
