package dataProviders;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private Properties properties;
	private final String propertyFilePath = "//configs//mobile.properties";
	private final String extentFilePath = "//configs//extent-config.properties";

	public Config() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("mobile.properties not found at " + propertyFilePath);
		}
	}

	public Properties getProperty() {
		Properties properties = new Properties();
		try {
			String configFilePath = System.getProperty("user.dir") + propertyFilePath;
			properties.load(new FileInputStream(configFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the mobile.properties file for the Key:reportConfigPath");
	}
}
