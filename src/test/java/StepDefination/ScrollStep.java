package StepDefination;




import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Base.BaseTest;
import Pages.ScrollPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScrollStep {
	
	ScrollPage scrollpage;
	private static final Logger logger = LogManager.getLogger(ScrollStep.class);	
	
	public ScrollStep() {
		scrollpage=new ScrollPage(BaseTest.getPage());
	}
	@Given("user is on Product page")
	public void user_is_on_product_page() {
		scrollpage.user_Click_OnProductLink();
	}

	@When("user scroll to the bottom")
	public void user_scroll_to_the_bottom() {
	   scrollpage.user_Click_OnScroll_Bottom();
	}

	@Then("user should see the bottom of the page")
	public void user_should_see_the_bottom_of_the_page() {
	    assertTrue(scrollpage.page_isOnBottom());
	    logger.info("User is Move to the Bottom");
	}

	@When("Again user scroll to the Top")
	public void again_user_scroll_to_the_top() {
		scrollpage.user_Click_OnScroll_Top();
	}

	@Then("user should see the Top of the page")
	public void user_should_see_the_top_of_the_page() {
	    assertTrue(scrollpage.page_isOnTop());
	    logger.info("User is Move to the Top");
	    
	}

}
