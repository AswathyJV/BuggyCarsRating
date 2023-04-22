package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	
	
	public static Properties getLocators(String filename) throws IOException {
		Properties propertylocator=new Properties();
		FileInputStream fileinput=new FileInputStream("./src/main/resources/Locators/"+filename+".properties");
		propertylocator.load(fileinput);
		return propertylocator;
		
	}

}
