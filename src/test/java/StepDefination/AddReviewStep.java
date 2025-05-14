package StepDefination;

import static org.junit.jupiter.api.Assertions.assertTrue;

import Base.BaseTest;
import Pages.AddReviewPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddReviewStep {

	AddReviewPage addreviewpage;

	public AddReviewStep() {
		addreviewpage = new AddReviewPage(BaseTest.getPage());

	}

	@Given("user on the product details page")
	public void user_on_the_product_details_page() {
		addreviewpage.click_ON_ViewProduct();
	}

	@When("user add review with name {string}, email {string}, and review {string}")
	public void user_add_review_with_name_email_and_review(String string, String string2, String string3) {
		addreviewpage.add_review_Product(string, string2, string3);
	}

	@Then("The review should be submitted successfully")
	public void the_review_should_be_submitted_successfully() {
		addreviewpage.click_ON_SubmitButton();
	}

	@Then("Review added message should display")
	public void review_added_message_should_display() {
		assertTrue(addreviewpage.VerifyReviewNoteadded());
	}
}