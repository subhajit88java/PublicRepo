package com.filereader.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyReader {

	static Logger logger = Logger.getLogger(PropertyReader.class);

	private static String propertyFileName = System.getProperty("user.dir") + File.separator
			+ "application_resources.properties";

	public static String getValue(String key) {

		logger.info("In getValue() of PropertyReader, key : " + key);
		Properties p = new Properties();

		try (FileReader reader = new FileReader(propertyFileName)) {

			p.load(reader);

		} catch (Exception e) {
			logger.error("Exception in fetching value from properties file ", e);
		}
		return p.getProperty(key);
	}
}
