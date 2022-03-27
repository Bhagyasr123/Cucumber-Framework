package com.cucumber.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	private static LoadProperties load = null;
	private static Properties prop = null;
	private static File file = null;
	private static FileInputStream fis = null;

	private LoadProperties() {
	}

	public static LoadProperties getReadProp() {
		if (load == null) {
			load = new LoadProperties();
		}
		return load;
	}

	/**
	 * This method is to load the config propertie file.
	 * @return the property
	 */
	public static Properties loadProp() {
		file = new File(System.getProperty("user.dir") + "\\resources\\config.properties");
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
