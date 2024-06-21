package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class Login extends BasePage {
	
	public Login(WebDriver driver)
	{
		super(driver);
	}
	

	@CacheLookup
	@FindBy(xpath="//input[@name='LoginCredential']")
	WebElement Username;
	
	@CacheLookup
	@FindBy(xpath="//input[@name='Password']")
	WebElement Password;
	
	@CacheLookup
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/button[1]")
	WebElement LoginBtn;
	
	@CacheLookup
	@FindBy(css="#onetrust-accept-btn-handler")
	WebElement AcceptCookies;
	
	@CacheLookup
	@FindBy(id="tombola")
	WebElement TombolaImg;
	
	
	
	public void verifyTombolaImg() {
		boolean img = TombolaImg.isDisplayed();
		System.out.println("Tombola Image is displayed: " + img);
	}
	
	
	public void clickAcceptCookies() {
		AcceptCookies.click();
	}
	
	public void setUserName(String uname) {
		Username.clear();
		Username.isEnabled();
		Username.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		Password.clear();
		Password.isEnabled();
		Password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		LoginBtn.click();
	}
}
