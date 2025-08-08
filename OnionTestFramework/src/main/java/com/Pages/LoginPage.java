package com.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait eWait;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// PageFactory.initElements(driver, this);
	}

	private By userNameTxtBox = By.id("username");
	private By passwordTxtBox = By.id("password");
	private By signInBtn = By.id("kc-login");
	private By forgotPasswordLink = By.xpath("//span/a[text()='Forgot Password?']");
	private By forgotPasswordTextOnPage = By
			.xpath("//h1[@id ='kc-page-title' and contains(text(),'Forgot Your Password?')]");
	private By homePageAvator = By.xpath("//div[text()='GO']");

	/*
	 * @FindBy(id = "username") private WebElement userNameTxtBox;
	 * 
	 * @FindBy(id = "password") private WebElement passwordTxtBox;
	 * 
	 * @FindBy(id = "kc-login") private WebElement signInBtn;
	 * 
	 * @FindBy(xpath = "//span/a[text()='Forgot Password?']") private WebElement
	 * forgotPasswordLink;
	 * 
	 * @FindBy(xpath =
	 * "//h1[@id ='kc-page-title' and contains(text(),'Forgot Your Password?')]")
	 * private WebElement forgotPasswordTextOnPage;
	 * 
	 * @FindBy(xpath = "//div[text()='GO']") private WebElement homePageAvator;
	 */

	
	

	public String getTitle() {
		eWait.until(ExpectedConditions.visibilityOfElementLocated(userNameTxtBox));
		return driver.getTitle();
	}

	public void clickForgotPasswordLink() {
		WebElement forgotPassLinkElement = eWait
				.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordLink));
		forgotPassLinkElement.click();
	}

	public boolean forgotPassWordPageShown() {
		WebElement forgotPassTextElement = eWait
				.until(ExpectedConditions.visibilityOfElementLocated(forgotPasswordTextOnPage));
		return forgotPassTextElement.isDisplayed();
	}

	public void enterUserName(String userName) {
		WebElement usrElement = eWait.until(ExpectedConditions.visibilityOfElementLocated(userNameTxtBox));
		usrElement.sendKeys(userName);
	}

	public void enterPassword(String passowrd) {
		WebElement passElement = eWait.until(ExpectedConditions.visibilityOfElementLocated(passwordTxtBox));
		passElement.sendKeys(passowrd);
	}

	public void clickSignIn() {
		WebElement signInElement = eWait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
		signInElement.click();
	}

	public String extractTitleOnHomePage() {
		eWait.until(ExpectedConditions.visibilityOfElementLocated(homePageAvator));
		return driver.getTitle();
	}

	public DashboardPage loginIntoTheTool(String username, String password) {
		WebElement usrElement = eWait.until(ExpectedConditions.visibilityOfElementLocated(userNameTxtBox));
		WebElement passElement = eWait.until(ExpectedConditions.visibilityOfElementLocated(passwordTxtBox));
		WebElement signInElement = eWait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
		usrElement.sendKeys(username);
		passElement.sendKeys(password);
		signInElement.click();
		return new DashboardPage(driver);
	}
}
