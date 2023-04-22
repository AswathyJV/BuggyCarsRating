package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.PropertyManager;
import Utilities.WaitLib;

public class CarRatingPage {
	WebDriver driver;
	Properties carratingpagelocators;
	public static  int rowfound;
	public static List<String> votes = new ArrayList();

	public CarRatingPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//a [@class = 'navbar-brand']")
	public WebElement BUGGYRATINGLINK;

	@FindBy(how = How.XPATH, using = "//*[text()='Popular Make']/parent::div/a")
	public WebElement POPULARMAKE;

	@FindBy(how = How.XPATH, using = "//textarea[@id='comment']")
	public WebElement VOTECOMMENTS;

	@FindBy(how = How.XPATH, using = "//button[text()='Vote!']")
	public WebElement VOTEBUTTON;

	@FindBy(how = How.XPATH, using = "//p[text()='Thank you for your vote!']")
	public WebElement THANKYOUFORVOTE;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Votes')]/strong")
	public WebElement VOTESVOTINGPAGE;

	public void navigatetocarratingtable(String identifier) {

		// Car Rating
		BUGGYRATINGLINK.click();
		driver.findElement(By.xpath("//*[text()='" + identifier + "']/parent::div/a")).click();

	}

	public void selectcarfromtable() {
		
		WaitLib.waitUntilelementlocated(By.xpath("//*[text()='Model']"), 15, driver);
		List<WebElement> columns = driver
				.findElements(By.xpath("//table[@class='cars table table-hover']/thead/tr/th"));

		System.out.println(columns.size());
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='cars table table-hover']/tbody/tr"));
		System.out.println(rows.size());

		for (int i = 1; i < rows.size(); i++) {

			// for Rank 1
			List<WebElement> Ranklist = driver
					.findElements(By.xpath("//table[@class='cars table table-hover']/tbody/tr/td[3]"));
			String rank = Ranklist.get(i - 1).getText();
			
			if (rank.equalsIgnoreCase("1")) {
				// votes count before voting
				votes.add(driver
						.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[4]"))
						.getText());
				driver.findElement(By.xpath(
						"//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[5]/a[text()='View more']"))
						.click();
				rowfound=i;
                break;       
			}
		}
	}

	public void addvote() {
		WaitLib.waitUntilelementlocated(By.xpath("//*[contains(text(),'Votes')]/strong"), 15, driver);
		// votes before voting on voting page
		votes.add(VOTESVOTINGPAGE.getText());
		VOTECOMMENTS.sendKeys("Comment");
		VOTEBUTTON.click();	
	}

	public void verifyvotecountisincremented() throws InterruptedException {
		
		Assert.assertEquals(THANKYOUFORVOTE.getText(),
				"Thank you for your vote!");
		// votes count after voting on voting page

		votes.add(VOTESVOTINGPAGE.getText());
		// navigate back to car lists page
		driver.navigate().back();
		WaitLib.waitUntilelementlocated(By.xpath("//*[text()='Model']"), 15, driver);
		votes.add(driver
				.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + rowfound + "]/td[4]"))
				.getText());
		System.out.println(votes);
		// verify whether votes are incremented on both table as well as voting page
		Assert.assertEquals(votes.get(0), String.valueOf(Integer.parseInt(votes.get(3)) - 1));
		Assert.assertEquals(votes.get(1), String.valueOf(Integer.parseInt(votes.get(2)) - 1));
	}
}
