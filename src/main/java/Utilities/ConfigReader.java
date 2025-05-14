package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ConfigReader {

	private static Properties properties;
	

	public static void loadProperties() {
		try {
			FileInputStream input = new FileInputStream("src/test/resources/confi.properties");
			properties = new Properties();
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	public static String get(String Key) {

		if (properties == null) {
			loadProperties();
		}

		return (properties != null) ? properties.getProperty(Key) : "";

		/*
		 * if(properties!=null) { properties.getProperty(Key); }
		 * 
		 * String value = properties.getProperty(Key); if(value!=null ||
		 * value.trim().isEmpty()) { System.err.println("Value not found"); } else
		 * System.out.println("value found"); return value;
		 */

	}
}
