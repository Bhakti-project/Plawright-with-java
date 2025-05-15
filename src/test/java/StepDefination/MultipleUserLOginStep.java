package StepDefination;

import Base.BaseTest;
import Pages.MultipleuserLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleUserLOginStep {

	MultipleuserLoginPage mulloginpage;

	@Given("User navigates to home page")
	public void user_navigates_to_home_page() {
		mulloginpage = new MultipleuserLoginPage(BaseTest.getPage());
		mulloginpage.goToURl();

	}

	@And("User clicks on SignIN button")
	public void user_clicks_on_sign_in_button() {
		mulloginpage.slecttheSignINOption();
	}

	@When("User enters the email as {string} and password as {string}")
	public void user_enters_the_email_as_and_password_as(String email, String password) {
		mulloginpage.enterTheCredentials(email, password);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		mulloginpage.selectTheLogInOption();
	}

	@Then("user should navigate to home page")
	public void user_should_navigate_to_home_page() {
		mulloginpage.UserIsHomePage();
	}

}
