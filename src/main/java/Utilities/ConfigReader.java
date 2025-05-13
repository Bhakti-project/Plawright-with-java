package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	
	public static void loadProperties() {
		try {
			FileInputStream input=new FileInputStream("src/test/resources/config.properties");
			properties=new Properties();
			properties.load(input);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void urlCheck() {
		// code to check url
	}
	
	public static String get(String Key)
	{
		 if (properties == null) {
	            loadProperties();
	        }
	        return (properties!=null)?properties.getProperty(Key):"";
		
	}
}
