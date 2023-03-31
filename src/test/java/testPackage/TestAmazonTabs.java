package testPackage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginPom.PomAmazonTabs;

public class TestAmazonTabs extends BaseClass {
	PomAmazonTabs am;
	@BeforeClass
	public void beforeclass()
	{
		am= new PomAmazonTabs();
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	@Test(priority=1)
	public void searchbox()
	{
		am.search();
	}
	@Test (priority=2)
	public void product()
	{
		am.select();
	}
	@Test (priority=3)
	public void cartb()
	{
		am.cart();
	}
	@Test (priority=4)
	public void cros()
	{
		am.cross();
	}
}
