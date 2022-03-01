package hms.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hms.utility.Activitycapture;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Activitycapture actcap;
	public static EventFiringWebDriver event;
	
	public Testbase(){
		try {
			FileInputStream ipconfig = new FileInputStream("./src/main/java/hms/config/appconfig.properties");
			prop = new Properties();
			prop.load(ipconfig);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		}
	
	public static void initialization()
	{
	 	String browser = prop.getProperty("Browser");
	 	if(browser.equals("chrome"))
	 	{
	 		String headless = prop.getProperty("Headless");
	 		if (headless.equals("true"))
	 		{
	 			WebDriverManager.chromedriver().setup();
	 			ChromeOptions options = new ChromeOptions();
	 			options.addArguments("--Headless");
	 			driver = new ChromeDriver(options);
	 			
	 		}else
	 		{
	 			WebDriverManager.chromedriver().setup();
	 			driver = new ChromeDriver();
	 		}	 		
	 		
	 		 
	 	} else if (browser.equals("edge")) {
	 		WebDriverManager.edgedriver().setup();
	 		driver= new EdgeDriver();
	 		
	 	}
		 
	 	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
	 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	 	driver.manage().window().maximize();
	 	driver.manage().deleteAllCookies();
	 	driver.get(prop.getProperty("URL"));
	 	event = new EventFiringWebDriver(driver);
	 	actcap = new Activitycapture();
	 	event.register(actcap);
	 	driver=event;
	}
	
	
public void waitforElement(WebElement el) { 
	
	WebDriverWait wt= new WebDriverWait(driver, Duration.ofSeconds(50));
	wt.until(ExpectedConditions.visibilityOf(el));
}

}

