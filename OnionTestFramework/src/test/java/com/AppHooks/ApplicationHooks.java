package com.AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.ConfigReader;
import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {

	private DriverFactory factory;
	private WebDriver driver;
	private ConfigReader configReader;
	private Properties prop;

	@Before(order = 0)
	public void getProperties() {
		configReader = new ConfigReader();
		prop = configReader.ReadProperties();
	}

	@Before(order = 1)
	public void init_browser() {
		//String browser = prop.getProperty("browser"); //From Config.properties
		String browser = System.getenv("BROWSER");
		factory = new DriverFactory();
		driver = factory.init_driver(browser);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
		factory.m_threadWebDriver.remove();
	}

	@After(order = 1)
	public void getFailureScreenshot(io.cucumber.java.Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(bytes, "image/png", screenshotName);
		}
	}
}
