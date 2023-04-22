package Stepdefenitions;

import Pages.RegisterandLoginPage;
import baseclass.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterandLoginStep {
	
	RegisterandLoginPage registerlogin=new RegisterandLoginPage(TestBase.driver);
	
	@Given("Register as a new user")
	public void register_as_a_new_user() {
		
		registerlogin.registerasnewuser();
	   
	}

	@When("logs in with registered credentials")
	public void logs_in_with_registered_credentials() {
	    // Write code here that turns the phrase above into concrete actions
		registerlogin.login();
		
	}

	@Then("verify user is successfully loggedin")
	public void verify_user_is_successfully_loggedin() {
	    // Write code here that turns the phrase above into concrete actions
		 registerlogin.loginverification();
	}

	

	@Then("verify user is successfully registered")
	public void verify_user_is_successfully_registered() {
		registerlogin.verifyregister();
	}
	

	@Then("Verify user is able to logout")
	public void Verify_user_is_able_to_logoutd() {
		registerlogin.verifylogout();
	}
}
