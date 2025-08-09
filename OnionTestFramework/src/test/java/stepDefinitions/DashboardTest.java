package stepDefinitions;

import java.util.List;
import java.util.Map;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardTest {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private DashboardPage dashboardPage;

	@Given("user login into the account using login creds")
	public void user_login_into_the_account_using_login_creds(DataTable dataTable) {

		List<Map<String, String>> creds = dataTable.asMaps();
		String username = creds.get(0).get("username");
		String password = creds.get(0).get("password");
		DriverFactory.getDriver().get(System.getenv("BASE_URL"));
		dashboardPage = loginPage.loginIntoTheTool(username, password);
	}

	@Given("user is on dashboard")
	public void user_is_on_dashboard() {

	}

	@When("user enters project name {string}")
	public void user_enters_project_name(String projectName) {
		dashboardPage.selectProject(projectName);
	}

	@When("clicks enter")
	public void clicks_enter() {

	}

	@Then("user should be navigated to Test page")
	public void user_should_be_navigated_to_test_page() {

	}

}
