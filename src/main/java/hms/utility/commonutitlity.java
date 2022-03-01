package hms.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import hms.base.Testbase;

public class commonutitlity extends Testbase {
	
//mouse click
	public static void mouseclick(WebElement el)
	{
		Actions act=new Actions(driver);
		act.click(el).build().perform();
		
		
	}
	
	
//File Upload script	
		public static void fileupload(String loc)
		{
			 //file Location to upload
		    StringSelection sel = new StringSelection(loc);
		    //Copy to clipboard
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		    //Create object of Robot class
		    Robot robot;
		    
			try {
				robot = new Robot();
				Thread.sleep(1000);
			         
		     // Press Enter
		    robot.keyPress(KeyEvent.VK_ENTER);
		    
		   // Release Enter
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
		     // Press CTRL+V
		    robot.keyPress(KeyEvent.VK_CONTROL);
		    robot.keyPress(KeyEvent.VK_V);
		    
		   // Release CTRL+V
		    robot.keyRelease(KeyEvent.VK_CONTROL);
		    robot.keyRelease(KeyEvent.VK_V);
		    //Thread.sleep(1000);
		           
		   //Press Enter 
		    robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
			} catch (AWTException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}
		
//Screenshot
		public static void takescreenshot()
		{
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    File desig=new File(System.getProperty("user.dir")+"./screens/"+System.currentTimeMillis()+".png");

		try {
			FileHandler.copy(source, desig);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		

}
