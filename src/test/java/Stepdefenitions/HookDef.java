package Stepdefenitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import baseclass.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookDef {
	
	
	
	public WebDriver driver;
	TestBase base=new TestBase();
	
	@Before
	public void beforesetup() throws IOException {
		
	driver=base.initDriver();	
	
	}
	
	@After
	public void aftertest() {
		driver.quit();
	}

}
