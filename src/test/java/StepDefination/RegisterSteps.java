package StepDefination;



import static org.junit.jupiter.api.Assertions.assertEquals;

import Base.BaseTest;
import Pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps {
	RegisterPage registerPage;

	@Given("user is on registration page")
	public void user_is_on_registration_page() {
		registerPage = new RegisterPage(BaseTest.getPage());
		registerPage.openSignupPage();
	}

	@When("user enters name {string} and email {string}")
	public void user_enters_name_and_email(String name, String email) {
		long uniqueNumber = System.currentTimeMillis();
		String uniqueName = name + "_" + uniqueNumber;
		String uniqueEmail = email.replace("@", "+" + uniqueNumber + "@");
		registerPage.enterSignupDetails(uniqueName, uniqueEmail);
	}

	@When("fills out all required registration details")
	public void fills_out_registration_details() {
		registerPage.completeRegistrationForm();
	}

	@Then("registration should be successful with message {string}")
	public void registration_should_be_successful(String expectedMsg) {
		String actualMsg = registerPage.getConfirmationMessage();
		assertEquals(expectedMsg, actualMsg);
	}
}
