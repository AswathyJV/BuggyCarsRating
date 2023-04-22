package Stepdefenitions;

import org.openqa.selenium.WebDriver;

import Pages.CarRatingPage;
import Pages.RegisterandLoginPage;
import baseclass.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarRatingSteps {
	
CarRatingPage popularMakeCars=new CarRatingPage(TestBase.driver);
	

	@Given("user selects the {string}")
	public void user_selects_the_popular_make_car(String identifier) {
		
		popularMakeCars.navigatetocarratingtable(identifier);
	   
	}
	
	
	@And("user selects the first ranked car")
	public void user_selects_the_first_ranked_car() {
		
		popularMakeCars.selectcarfromtable();
	   
	}
	
	@When("user add comments and click vote")
	public void user_add_comments_and_click_vote() {
		popularMakeCars.addvote();
	}
	
	@Then("verify if vote is incremented successfully")
	public void verify_if_vote_is_added_successfully() throws InterruptedException {
		popularMakeCars.verifyvotecountisincremented();  
	}
}
