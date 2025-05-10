package StepDefination;

import Base.BaseTest;
import Pages.RemoveProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveProductStep {
	RemoveProductPage removeproductpage;
	public RemoveProductStep() {
		removeproductpage= new RemoveProductPage(BaseTest.getPage());
	}
	
	@Given("I have added a product to the cart")
	public void i_have_added_a_product_to_the_cart() {
		removeproductpage.add_Product_Cart();
	}

	@When("I navigate to the cart page")
	public void i_navigate_to_the_cart_page() {
		removeproductpage.navigate_To_Cart();
	}

	@When("I remove the product from the cart")
	public void i_remove_the_product_from_the_cart() {
		removeproductpage.remove_product();
	}

	

	@Then("The cart should be empty and should see a message {string}")
	public void the_cart_should_be_empty_and_should_see_a_message(String msg) {
		removeproductpage.verify_Product_isRemove(msg);
	}


}
