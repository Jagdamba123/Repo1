package loginPom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestNinjaPom {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy (xpath="//a[@title='My Account']")
	private WebElement myaccount;
	//Click on my account
	@FindBy (xpath="//a[text()='Register']")
	private WebElement register;
	//Click on Register
	@FindBy (xpath="//input[@name='firstname']") 
	private WebElement firstname;
	//Need to send key first name
	@FindBy (xpath="//input[@name='lastname']")
	private WebElement lastname;
	//need to enter Last name
	@FindBy (xpath="//input[@name='email']")
	private WebElement email;
	//need to enter last name
	@FindBy (xpath="//input[@name='telephone']")
	private WebElement telephone;
	//need to enter telephone
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	//need to enter password;
	@FindBy (xpath="//input[@name='confirm']")
	private WebElement confirmpass;
	//need to enter confirm password
	@FindBy (xpath="//input[@name='newsletter' and @value='1']")
    private WebElement checkboxyes;
	//This check box should be disables
	@FindBy (xpath="//input[@name='newsletter' and @checked='checked']")
	private WebElement checkboxno;
	//check this check box is enables
	@FindBy (xpath="//input[@name='agree' and @value='1']")
	private WebElement policy;
	//click on that checkbox
	@FindBy (xpath="//input[@value='Continue']")
	private WebElement submit;
	//click on submit
	
	public TestNinjaPom (WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	//click on myaccount
	
	public void checkmyaccount()
	{
		myaccount.click();
		
	}
	
	
	public void clickRegister()
	{
		register.click();
		
	}
	
	public void enterfirstname(String fname)
	{
		firstname.click();
		firstname.sendKeys(fname);
	}
	
	public void verifylastname(String lname)
	{

		lastname.click();
		lastname.sendKeys(lname);
	}
	
	public void typeemail(String emailid)
	{
		email.click();
		email.sendKeys(emailid);
	}
	public void verifyphonebox(String mob)
	{

		telephone.click();
		telephone.sendKeys(mob);
	}
	public void verifypassword(String pass1)
	{

		password.click();
		password.sendKeys(pass1);
	}
	public void verifyconfirmpass(String pass2)
	{

		confirmpass.click();
		confirmpass.sendKeys(pass2);
	}
	public boolean verifyyes()
	{
		boolean b=checkboxyes.isSelected();
		return b;
	}
//	public boolean isenabled()
//	{
//		boolean b=checkboxyes.isEnabled();
//		return b;
//	}
	public void verifycheckboxno()
	{
		checkboxno.isSelected();
		
	}
	public void verifypolicy()
	{
		boolean check=policy.isSelected();
		if (check==true)
		{
		    System.out.println("Test case fail policy box sould be unchecked");
		}
		else
		{
			policy.click();
			 System.out.println("Test case pass policy box is checked");
		}
	}


}
