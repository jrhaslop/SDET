package com.jonathanhaslop.util;

import java.io.FileReader;
import java.util.Properties;

public class Propertie {

	public Propertie() {

	}

	public static String readPropertie(String propertieString) {
		String propertie = null;
		try (FileReader reader = new FileReader("./env")) {
			Properties prop = new Properties();
			prop.load(reader);
			propertie = prop.getProperty(propertieString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return propertie;
	}
}

