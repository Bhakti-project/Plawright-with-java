package StepDefination;





import com.microsoft.playwright.Page;

import Base.BaseTest;
import Pages.SerchProductPapge;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

public class SearchProductStep {

	private final SerchProductPapge serchproductpage;

	public SearchProductStep() {
		this.serchproductpage = new SerchProductPapge(BaseTest.getPage());
	}

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		
		//serchproductpage.clickonURL();
	}

	@When("user clicks on products link")
	public void user_clicks_on() {

		serchproductpage.clickonbyProductLink();
	}

	@When("user searches for product {string}")
	public void user_searches_for_product(String productName) {
		serchproductpage.searchProduct(productName);
	}

	@Then("products related to {string} should be visible as {string}")
	public void products_related_to_should_be_visible(String keyword, String expectedProductName) {
		
	Assertions.assertTrue(serchproductpage.areSearchResultsVisible(expectedProductName));
	}

	@Given("user is on the Products page")
	public void user_is_on_the_products_page() {
		serchproductpage.clickonURL();
		serchproductpage.clickonbyProductLink();
	}

	@Then("all product names should be printed with total count")
	public void all_product_names_should_be_printed_with_total_count() {
		serchproductpage.printAllProducts();
	}
}



