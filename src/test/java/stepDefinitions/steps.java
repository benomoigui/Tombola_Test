package stepDefinitions;

import java.time.Duration;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountPage;
import pageObjects.Login;
import utilities.DataReader;


public class steps {
	
	WebDriver driver;
	
	
	Login Lg;
	Logger logger;
	ResourceBundle rb;
	String br;
	AccountPage Ap;
	Alert alert;
	
	List<HashMap<String, String>> datamap; //Data driven
	
	@Before
	public void setup() 
	{
		 //for logging
        logger= LogManager.getLogger(this.getClass());
        
        //Reading config.properties (for browser)
        rb=ResourceBundle.getBundle("config");
        br=rb.getString("browser");
	}
	
	@After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }
       driver.quit();
    }
	
	
	
	
	@Given("User launch browser")
	public void user_launch_browser() {
		if(br.equals("chrome"))
        {
           driver=new ChromeDriver();
        }
        else if (br.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (br.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
	}

	

	@Given("opens URL {string}")
	public void opens_url(String URL) throws InterruptedException {
		logger.info("Opening URL");
		driver.get(URL);
		logger.info("Maximizing window");
		driver.manage().window().maximize();
		logger.info("Waiting for page to load");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		
	    
	}

	@Given("User enters email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
		Lg = new Login(driver);
		logger.info("Verifying Tombola Image");
		Lg.verifyTombolaImg();
		logger.info("Clicking Accept Cookies");
		Lg.clickAcceptCookies();
		logger.info("Entering Username and Password");
		Lg.setUserName(string);
		Lg.setPassword(string2);
		
	   
	}

	@Given("Clicks on Login button")
	public void clicks_on_login_button() {
		logger.info("Clicking Login button");
		Lg.clickLogin();

	}
	    
	

	@Then("User navigates to Account Page")
	public void user_navigates_to_account_page() {
		Ap = new AccountPage(driver);
		logger.info("Verifying Page Title");
		Ap.verifypageTitle();
		logger.info("Verifying Account Page");
		Ap.accountPage();
	    
	}

	
	    
	    

}
