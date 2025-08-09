package com.Pages;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	private WebDriver driver;
	private WebDriverWait eWait;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		eWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	private By searchProject = By.xpath("//button[text()='Add Project']/preceding-sibling::div//input[@placeholder='Search projects']");

	private By searchProjectOnion = By.xpath("//li/div[text()='Onion']");
			
	public void selectProject(String projectName) {
		By searchProjectOnion = By.xpath("//li[@id=':rjd:-option-0']");
		WebElement searchWebElement = eWait.until(ExpectedConditions.visibilityOfElementLocated(searchProject));
		Actions actionSearch = new Actions(driver);
		actionSearch.moveToElement(searchWebElement).click().perform();
		//actionSearch.sendKeys(projectName);
		actionSearch.sendKeys(projectName).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	}
}
