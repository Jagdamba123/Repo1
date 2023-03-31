package loginPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomLoginHRM {
	WebDriver driver;
	@FindBy(xpath = "(//input[contains(@class,'oxd-input')])[1]")
	private WebElement ID;
	@FindBy(xpath = "(//input[contains(@class,'oxd-input')])[2]")
	private WebElement pass;
	@FindBy(xpath = "//button[contains(@class,'oxd-button o')]")
	private WebElement login;

	public PomLoginHRM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void sendid(String SendId) {
		ID.sendKeys(SendId);

	}

	public void sendpass(String sendPass) {
		pass.sendKeys(sendPass);
	}

	public void submit() {
		login.click();
	}

}
