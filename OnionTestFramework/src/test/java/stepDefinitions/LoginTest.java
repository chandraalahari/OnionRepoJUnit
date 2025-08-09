package stepDefinitions;

import java.util.Properties;

import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginTest {

	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	String actualTitle;

	@Given("user opens the onion url on the browser")
	public void user_open_the_onion_url_on_the_browser() {

		DriverFactory.getDriver().get(System.getenv("BASE_URL"));
	}

	@When("user is able to read the title")
	public void user_is_able_to_read_the_title() {
		actualTitle = loginPage.getTitle();
	}

	@Then("user should be displayed the title {string}")
	public void user_should_be_displayed_the_title(String exptitleName) {
		Assert.assertEquals(exptitleName, actualTitle);
	}

	@When("user clicks on forgot password")
	public void user_clicks_on_forgot_password() {
		loginPage.clickForgotPasswordLink();
	}

	@Then("user should be displayed forgot password page")
	public void user_should_be_displayed_forgot_password_page() {
		boolean forgotPageText = loginPage.forgotPassWordPageShown();
		Assert.assertEquals(forgotPageText, true);
	}

	@When("user inputs {string} and {string}")
	public void user_inputs_and(String username, String password) {
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);

	}

	@When("Clicks on Sign In button")
	public void clicks_on_sign_in_button() {
		loginPage.clickSignIn();
	}
 
	@Then("user should be allowed to login and navigate to home page and tile should be {string}")
	public void user_should_be_allowed_to_login_and_navigate_to_home_page(String titleDashBoard) {
		String homePageTitle = loginPage.extractTitleOnHomePage();
		Assert.assertEquals(titleDashBoard, homePageTitle);
	}

}
