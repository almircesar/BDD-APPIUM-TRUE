package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", glue = "stepDefinition", plugin = { "pretty", "json:target/cucumber-reports/json-report.json", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extent-report.html"}, monochrome = true)

public class TestRunner {

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/test/java/configs/extent-config.xml"));
		Reporter.setSystemInfo("OS", "Windows10");

		Reporter.setSystemInfo("Tester Name", "Celso Eron");

	}
}
