package testUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	public static String screenshot1(WebDriver driver) throws IOException
	{
	String path= System.getProperty("user.dir")+"\\test-output\\Screenshot"+System.currentTimeMillis()+".png";
	File Source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File Destiny=new File(path);
	FileHandler.copy(Source, Destiny);
	return path;
	}
}
