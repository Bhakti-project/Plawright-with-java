package StepDefination;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Base.BaseTest;
import Pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductStep {
	ProductPage productsPage;
	private static final Logger logger = LogManager.getLogger(ProductStep.class);

	public ProductStep() {
		productsPage = new ProductPage(BaseTest.getPage());
	}

	@Given("user is on home page")
	public void user_is_on_home_page() {

		// BaseTest.page.navigate("https://www.automationexercise.com/");
	}

	@When("user clicks on Products link")
	public void user_clicks_on_products_link() {
		logger.info("Before click on Product LInk ");
		productsPage.clickLinkByText();
	}

	@Then("user should see the products list")
	public void user_should_see_the_products_list() {
		assertTrue(productsPage.isProductsListVisible());
	}

	@When("user clicks on {string} of the first item")
	public void user_clicks_on_of_the_first_item(String linkText) {
		productsPage.clickFirstProductView(linkText);
	}

	@Then("user should see the product detail page with title {string}")
	public void user_should_see_the_product_detail_page_with_title(String expectedTitle) {
		String actualTitle = productsPage.getProductTitle();
		assertEquals(expectedTitle, actualTitle);

	}

	// Second Scenario

	@Given("user navigate to the Products page")
	public void user_navigate_to_the_products_page() {
		productsPage.clickLinkByText();
	}

	@When("user filter products as {string} and {string}")
	public void user_filter_products_as_and(String top, String tshirt) {
		productsPage.filterProduct(top, tshirt);
	}

	@When("user naviagte to the cart")
	public void user_add_all_filtered_products_in_to_the_cart() {
		productsPage.navigateToCart();
	}

	@Then("user should see {string} and {string} products added in to the cart")
	public void user_should_see_all_selected_products_added_in_to_the_cart(String top, String tshirt) {
		productsPage.productisaddedorNot(top, tshirt);

	}
}
