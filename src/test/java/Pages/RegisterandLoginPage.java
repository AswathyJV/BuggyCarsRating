package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.PropertyManager;
import Utilities.WaitLib;

public class RegisterandLoginPage {

	WebDriver driver;
	Properties registerandloginlocators;
	public static String username;
	public static String password;
	Random generator = new Random();

	public RegisterandLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-success-outline']")
	public WebElement REGISTERBUTTON;

	@FindBy(how = How.ID, using = "username")
	public WebElement USERNAME;

	@FindBy(how = How.ID, using = "firstName")
	public WebElement FIRSTNAME;

	@FindBy(how = How.ID, using = "lastName")
	public WebElement LASTNAME;

	@FindBy(how = How.ID, using = "password")
	public WebElement PASSWORD;

	@FindBy(how = How.ID, using = "confirmPassword")
	public WebElement CONFIRMPASSWORD;

	@FindBy(how = How.XPATH, using = "//button [@class = 'btn btn-default']")
	public WebElement REGISTERLINK;

	@FindBy(how = How.XPATH, using = "//div [@class ='result alert alert-success']")
	public WebElement REGISTRATIONSUCCESSMESSAGE;

	@FindBy(how = How.XPATH, using = "//input [@name = 'login']")
	public WebElement LOGINUSERNAME;

	@FindBy(how = How.XPATH, using = "//input [@name = 'password']")
	public WebElement LOGINPASSWORD;

	@FindBy(how = How.XPATH, using = "//button [@class = 'btn btn-success']")
	public WebElement LOGINBUTTON;

	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	public WebElement LOGOUTLINK;

	public void registerasnewuser() {



		REGISTERBUTTON.click();

		username = "Testuser" + String.valueOf(generator.nextInt(100000));
		password = "Pass" + String.valueOf(generator.nextInt(10000)) + "@";
		USERNAME.sendKeys(username);
		FIRSTNAME.sendKeys("First");
		LASTNAME.sendKeys("Last");
		PASSWORD.sendKeys(password);
		CONFIRMPASSWORD.sendKeys(password);

		REGISTERLINK.click();

	}

	public void verifyregister() {
		WaitLib.waitUntilelementlocated(By.xpath("//div [@class ='result alert alert-success']"), 5, driver);
		Assert.assertEquals(REGISTRATIONSUCCESSMESSAGE.getText(), "Registration is successful");

	}

	public void login() {
		// TODO Auto-generated method stub
		LOGINUSERNAME.sendKeys(username);
		LOGINPASSWORD.sendKeys(password);
		LOGINBUTTON.click();
	}

	public void loginverification() {

		LOGOUTLINK.isDisplayed();
	}

	public void verifylogout() {
		LOGOUTLINK.click();
		LOGINBUTTON.isDisplayed();
		
	}

}
