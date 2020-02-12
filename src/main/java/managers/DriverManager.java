package managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import dataProviders.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverManager {
	private String apkFile;
	private String deviceName;
	private static String URL = "http://127.0.0.1:4723/wd/hub";
	private AndroidDriver<AndroidElement> driver;
	private String port;

	public AndroidDriver<AndroidElement> getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private AndroidDriver<AndroidElement> createDriver() {
		Config config = new Config();
		Properties mobile = config.getProperty();
		deviceName = mobile.getProperty("deviceName");
		String platformVersion = mobile.getProperty("platformVersion");
		String platformName = mobile.getProperty("platformName");
		String appPackage = mobile.getProperty("appPackage");
		String appActivity = mobile.getProperty("appActivity");
		port = mobile.getProperty("port");
		String apkFilePath = mobile.getProperty("apkFilePath");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		try {
			driver = new AndroidDriver<AndroidElement>(new URL(URL), capabilities);
		} catch (MalformedURLException e) {
//			logger.info(e.getMessage());
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.quit();
	}

}