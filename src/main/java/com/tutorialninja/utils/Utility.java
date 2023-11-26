package com.tutorialninja.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Utility {

	public static String generateUniqueEmailString() {
		Date date = new Date();

		String dateString = date.toString().replace(" ", "_").replace(":", "_");
		String emailString = dateString + "@test.com";

		return emailString;

	}

	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\com\\tutorialninja\\config\\config.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		
		return prop;

	}

}
