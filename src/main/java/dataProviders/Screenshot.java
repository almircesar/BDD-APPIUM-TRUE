package dataProviders;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import io.appium.java_client.android.AndroidDriver;

public class Screenshot {
	public void capture(AndroidDriver driver, Scenario scenario) {

		String screenshotName = scenario.getName().replaceAll(" ", "_");
		try {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File destinationPath = new File(System.getProperty("user.dir") + "/report/screenshot/" + screenshotName
					+ TimeDescription.horas() + ".png");
			Files.copy(sourcePath, destinationPath);

			Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (IOException e) {
			System.out.println("erro ao copiar arquivo para a pasta " + e.getMessage());
		}
	}

}