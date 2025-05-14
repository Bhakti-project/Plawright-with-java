package StepDefination;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Base.BaseTest;
import Exception.LoginFailedException;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	LoginPage loginPage;

	private static final Logger logger = LogManager.getLogger(LoginSteps.class);

	@Given("user is on login page")
	public void user_is_on_login_page() {

		loginPage = new LoginPage(BaseTest.getPage());
		loginPage.openLoginPage();

	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
		//loginPage.enterLoginCredentials("Bhaktitest@gmail.com", "Bhakti@Test");
		try {
			loginPage.enterLoginCredentials("Bhaktitest@gmail.com", "Bhakti@Test");
			logger.info("Login successful");
		} catch (LoginFailedException e) {
			logger.error("Login failed: " + e.getMessage());
			logger.error("Login failed: " + e.getStackTrace());
			
			System.out.println("Login failed: " + e.getMessage());
			// Fail the test
			//assertTrue("Login failed due to invalid credentials", false);
		}
	}

	@Then("user should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		assertTrue(loginPage.isLoginSuccessful());
		logger.info("Done LOgin successfully and print logger");
		System.out.println("All Ok");

	}
}
