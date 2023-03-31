package testPackage;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import loginPom.TestNinjaPom;
import testUtility.FetchDatafromFile;





public class TestNinja extends BaseClass {
//	WebDriver driver;
	TestNinjaPom ninja;
	FetchDatafromFile details;
	SoftAssert soft;
	@BeforeClass
	public void beforeClass ()
	{
		soft=new SoftAssert();
		ninja=new TestNinjaPom(driver);
	}
	@BeforeMethod
	public void beforeMethod()
	{	
		System.out.println("This is before method");
	}
	@Test(priority=1)
	public void checkmyaccount() throws InterruptedException
	{
		logger=report.createTest("Verify myaccount button");
		ninja.checkmyaccount();
		soft.assertTrue(true);
		
	}
	@Test(priority=2)
	public void register() 
	{
		logger=report.createTest("Verify Register button");
		ninja.clickRegister();
		soft.assertTrue(true);
		
	}
	@Test(priority=3)
	public void firstname() throws InterruptedException, EncryptedDocumentException, IOException
	{
		logger=report.createTest("Verify for correct credentials");
		ninja.enterfirstname(details.fetchdatafromfile(0, 0));
		ninja.verifylastname(details.fetchdatafromfile(1, 0));
	}

	@Test (dependsOnMethods= {"firstname"})
	public void emailbox() throws EncryptedDocumentException, IOException
	{
		logger=report.createTest("Verify emailbox");
		ninja.typeemail(details.fetchdatafromfile(2, 0));
		System.out.println("email is clickable");
	}
	@Test(dependsOnMethods={"emailbox"})
	public void verifytelephone() throws EncryptedDocumentException, IOException, InterruptedException
	{
		logger=report.createTest("Verify Mobile box");
		ninja.verifyphonebox(details.fetchdatafromfile(3, 0));
		System.out.println("Mobile box is clickable");
	}
	@Test(dependsOnMethods={"verifytelephone"})
	public void passverify() throws EncryptedDocumentException, IOException
	{
		logger=report.createTest("Verify Passwordbox");
		ninja.verifypassword(details.fetchdatafromfile(4, 0));
		System.out.println("Passwaord box is clickable");
	}
	@Test(priority=3)
	public void elementweb() throws IOException
	{
		WebElement element=driver.findElement(By.xpath("//div[@class='list-group']//a[text()='My Account']"));
		File source=element.getScreenshotAs(OutputType.FILE);
		File destiny=new File("C:\\Users\\MY WORLD\\eclipse-workspace\\HRM\\test-output\\Screenshot\\dhanno.png");
		FileHandler.copy(source, destiny);
	}
	@Test(dependsOnMethods= {"passverify"})
	public void confpass() throws EncryptedDocumentException, IOException
	{
		logger=report.createTest("Verify Confirm Password box");
		ninja.verifyconfirmpass(details.fetchdatafromfile(5, 0));
		System.out.println("Password confirmbox is clickable");
	}
	@Test(dependsOnMethods= {"confpass"})
	public void checkboxyes()
	{
	logger=report.createTest("Verify check box yes");
	boolean b=ninja.verifyyes();
//	boolean s=ninja.isenabled();
	soft.assertFalse(b);
	System.out.println(b+" checkbox yes is not selected");
	soft.assertAll();
	}
	@Test(dependsOnMethods= {"checkboxyes"})
	public void checkboxno()
	{
		logger=report.createTest("Verify check box no");
		ninja.verifycheckboxno();
		System.out.println("checkbox no is selected");


	}
	@Test(dependsOnMethods= {"checkboxno"})
	public void policybox()
	{
		logger=report.createTest("Verify policybox");
		ninja.verifypolicy();
	}

	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
	
	


}
