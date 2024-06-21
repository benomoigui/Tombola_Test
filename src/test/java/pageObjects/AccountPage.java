package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
	
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	@CacheLookup
	@FindBy(xpath="//a[normalize-space()='logout']")
	WebElement logoutLink;
	
	
	public void verifypageTitle() 
	{
		String page = driver.getTitle();
		String exp = "tombola - britain's biggest bingo site";
		if (page.equals(exp)) {
			System.out.println("Page Title is correct");
		} else {
			System.out.println("Page Title is incorrect");
		}
		
	}
	
	public void accountPage() {
		boolean acc = logoutLink.isDisplayed();
		if (acc == true) {
			System.out.println("User is on Account page");
		} else {
			System.out.println("Fail");
		}
	}

}
