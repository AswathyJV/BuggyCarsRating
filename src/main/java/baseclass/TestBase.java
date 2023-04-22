package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;





public class TestBase {
	
	public static WebDriver driver;
	public static Properties configprop=new Properties();
	
	public WebDriver initDriver() throws IOException {
	
	   WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		FileInputStream fileinput=new FileInputStream("./src/main/resources/Properties/ConfigUI.properties");
		configprop.load(fileinput);
		driver.get(configprop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}
	

}
