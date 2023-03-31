package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import loginPom.PomLoginHRM;

public class TestClassHRM {
	WebDriver driver;
	PomLoginHRM hrm;
	SoftAssert soft;
	@BeforeClass
	public void beforeClass()
	{
		hrm=new PomLoginHRM(driver);
	}
	@BeforeMethod
	public void beforeMethod()
	{	
		System.out.println("This is before method");
	}
	@Test
	public void verifyidpass() throws InterruptedException
	{
		hrm.sendid("Admin");
		Assert.assertFalse(false);
		hrm.sendpass("admin123");
		Assert.assertTrue(true);
		hrm.submit();

	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
	@AfterMethod
	public void afterMethod()
	{
		
	}

}
