package Stepdefenitions;

import org.openqa.selenium.WebDriver;

import Pages.ProfilePage;
import Pages.RegisterandLoginPage;
import baseclass.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps {
	
	ProfilePage profile=new ProfilePage(TestBase.driver);
	

	@And("verify user is able to update profile details")
	public void verify_user_is_able_to_update_profile_details() {
		
		profile.editprofile();
	   
	}
	
	@And("verify user is able to reset password")
	public void verify_user_is_able_to_reset_password() {
		
		profile.resetpassword();
	   
	}
	
	
	
}
