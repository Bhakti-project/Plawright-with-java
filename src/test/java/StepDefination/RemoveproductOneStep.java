package StepDefination;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import Base.BaseTest;
import Pages.RemoveOneProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RemoveproductOneStep {
	
	RemoveOneProductPage removeoneproductpage;
	private static final Logger logger = LogManager.getLogger(LoginSteps.class);
	public RemoveproductOneStep() {
		removeoneproductpage=new RemoveOneProductPage(BaseTest.getPage());
	}
	
	@Given("user is on the product listing page")
	public void user_is_on_the_product_listing_page() {
		removeoneproductpage.click_OnProductOption();
		//logger.info("Working on product page");
	}

	@When("user adds multiple products to the cart")
	public void user_adds_multiple_products_to_the_cart() {
		removeoneproductpage.add_ProductOn_Page();
	}

	@When("user navigates to the cart page")
	public void user_navigates_to_the_cart_page() {
		removeoneproductpage.click_onCartOption();
	}

	@When("user removes the product named {string}")
	public void user_removes_the_product_named(String top) {
		removeoneproductpage.remove_OneProduct(top);
		
	}

	@Then("the cart should not contain the product")
	public void the_cart_should_not_contain_the_product() {
	assertFalse(removeoneproductpage.verify_oneProductRemoved());
	}

}
