package com.cucumber.common.utils;

import java.util.Properties;
/** 
 * This Singletone ReadProperties class is for reading the config properties file
 * @author bhagyameena
 *
 */
public class ReadProperties {
	private static ReadProperties read = null;
	private static Properties readProp = Base.getProp();

	private ReadProperties() {
	}

	public static ReadProperties getReadProp() {
		if (read == null) {
			read = new ReadProperties();
		}
		return read;
	}

	/**
	 * This method gets the property value
	 * @param key
	 * @return property key value
	 */
	public String getProperty(String key) {
		return readProp.getProperty(key);
	}
}
