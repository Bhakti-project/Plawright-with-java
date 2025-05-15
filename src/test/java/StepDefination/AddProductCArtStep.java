package StepDefination;


import static org.junit.jupiter.api.Assertions.assertTrue;

import com.microsoft.playwright.Page;

import Base.BaseTest;
import Pages.AddCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProductCArtStep {
	
	AddCartPage addcartpage;
	
	@Given("User is on HomePage")
	public void user_is_on_home_page() {
		addcartpage=new AddCartPage(BaseTest.getPage());
		//BaseTest.page.navigate("https://www.automationexercise.com/");
	}

	@When("User click on product link")
	public void user_click_on_product_link() {
	
	    addcartpage.click_On_TheProductslink();
	}

	@When("User Add the first product in to the Cart")
	public void user_add_the_first_product_in_to_the_cart() {
	   addcartpage.select_Product();
	}

	@When("User navigate to the cart")
	public void user_navigate_to_the_cart() {
	   addcartpage.Product_Added_Cart();
	}

	@Then("product should be visiable in the cart")
	public void product_should_be_visiable_in_the_cart() {
	   assertTrue(addcartpage.verify_Added_Itam()) ;
	}


}
