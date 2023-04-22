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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.PropertyManager;
import Utilities.WaitLib;

public class ProfilePage {

	WebDriver driver;
	Properties profilepagelocators;
	Random generator = new Random();

	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(how = How.LINK_TEXT, using = "Profile")
	public WebElement PROFILELINK;

	@FindBy(how = How.ID, using = "firstName")
	public WebElement PROFILEFIRSTNAME;

	@FindBy(how = How.ID, using = "lastName")
	public WebElement PROFILELASTNAME;

	@FindBy(how = How.ID, using = "gender")
	public WebElement GENDER;

	@FindBy(how = How.ID, using = "age")
	public WebElement AGE;

	@FindBy(how = How.ID, using = "address")
	public WebElement ADDRESS;

	@FindBy(how = How.ID, using = "phone")
	public WebElement PHONE;

	@FindBy(how = How.ID, using = "hobby")
	public WebElement HOBBY;

	@FindBy(how = How.XPATH, using = "//input [@id = 'currentPassword']")
	public WebElement CURRENTPASSWORD;

	@FindBy(how = How.XPATH, using = "//input [@id = 'newPassword']")
	public WebElement NEWPASSWORD;

	@FindBy(how = How.XPATH, using = "//input [@id = 'newPasswordConfirmation']")
	public WebElement CONFIRMNEWPASSWORD;

	@FindBy(how = How.XPATH, using = "//button [@class = 'btn btn-default']")
	public WebElement SAVEPROFILE;

	@FindBy(how = How.XPATH, using = "//div [contains(text(),'profile has been saved successful')]")
	public WebElement PROFILEUPDATIONSUCCESS;

	public void editprofile() {

		PROFILELINK.click();
		PROFILEFIRSTNAME.sendKeys("name");
		PROFILELASTNAME.sendKeys("name");
		GENDER.sendKeys("Female");
		AGE.sendKeys("29");
		ADDRESS.sendKeys("Address");
		PHONE.sendKeys("9875678765");
		HOBBY.click();
		Select dropdown = new Select(HOBBY);
		dropdown.selectByIndex(3);
		SAVEPROFILE.click();
		WaitLib.waitUntilelementlocated(By.xpath("//div [contains(text(),'profile has been saved successful')]"), 5, driver);

		Assert.assertEquals(PROFILEUPDATIONSUCCESS.getText(), "The profile has been saved successful");
	}

	public void resetpassword() {
		PROFILELINK.click();
		String newPassword = "newPass" + String.valueOf(generator.nextInt(10000)) + "@";
		CURRENTPASSWORD.sendKeys(RegisterandLoginPage.password);
		NEWPASSWORD.sendKeys(newPassword);
		CONFIRMNEWPASSWORD.sendKeys(newPassword);
		SAVEPROFILE.click();

		WaitLib.waitUntilelementlocated(By.xpath("//div [contains(text(),'profile has been saved successful')]"), 5, driver);

		Assert.assertEquals(PROFILEUPDATIONSUCCESS.getText(), "The profile has been saved successful");
	}
}
