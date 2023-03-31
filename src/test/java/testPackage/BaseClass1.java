package testPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import testUtility.StaticBrowser;

public class BaseClass1 {
	static WebDriver driver;
	 @Parameters({"browser"})
	 
	 @BeforeTest
	 public void beforeTest(String browser)
	 {
	 driver=StaticBrowser.openBrowser(browser,"https://www.amazon.in/");
	 this.driver=driver;
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }

	 @AfterTest
	 public void afterTest()
	 {
	
	 }

}
