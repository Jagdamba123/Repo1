package loginPom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomAmazonTabs {
	WebDriver driver;
	@FindBy (xpath="//input[@dir='auto']")
	private WebElement Searchbox;
	@FindBy (xpath="(//div[@class=\"sg-col-inner\"])[34]")
	private WebElement product; 
	@FindBy (xpath="//input[@title=\"Add to Shopping Cart\"]")
	private WebElement cart;
	@FindBy (xpath="//a[@aria-label=\"Exit this panel and return to the product page. \"]")
	private WebElement cross;
	public PomAmazonTabs()
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void search()
	{
		Searchbox.sendKeys("Mobile");
		Searchbox.sendKeys(Keys.ENTER);
	}
	public void select()
	{
		product.click();
	}
	public void cart()
	{
		cart.click();
	}
	public void cross()
	{
		cross.click();
	}

}