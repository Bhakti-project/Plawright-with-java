package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductPage {
	private Page page;

	private static String allproduct_css = ".productinfo";
	private static String productNames_css = ".productinfo p";
	private static String overlayAddcartbutton = ".product-overlay .overlay-content a:has-text('Add to cart')";
	private static String continueshopping = "button:has-text('Continue Shopping')";
	//private static String hoverimage = ".product-image-wrapper";
	//private static String Cart = "ul[@class='nav navbar-nav'] //a[contains(@herf='view_cart')]";
	private static String cartdecription = "cart_info_table tbody tr td.cart_description h4 a";

	public ProductPage(Page page) {
		this.page = page;
	}

	public void clickLinkByText() {
		page.click("//a[@href='/products']");
	}

	public boolean isProductsListVisible() {
		return page.locator("//div[@class='features_items']").isVisible();
	}

	public void clickFirstProductView(String linkText) {

		page.locator("a[href='/product_details/1']").click();
	}

	public String getProductTitle() {
		return page.locator("//h2[normalize-space()='Blue Top']").textContent();
	}

	public void filterProduct(String top, String tshirt) {

		page.waitForSelector(allproduct_css);
		Locator productnames = page.locator(productNames_css);
		int count = productnames.count();

		for (int i = 0; i < count; i++) {
			String name = productnames.nth(i).innerText();
			if (name.contains(top) || name.contains(tshirt)) {
				
				page.waitForSelector(".product-image-wrapper");
				
				Locator Eachhover = page.locator(".product-image-wrapper").nth(i);
				Eachhover.hover();
				Eachhover.scrollIntoViewIfNeeded();
				page.waitForTimeout(500); 
				Locator add = page.locator(overlayAddcartbutton).nth(i);
				add.scrollIntoViewIfNeeded();
				page.waitForSelector(overlayAddcartbutton);
				add.click();
				page.locator(continueshopping).click();
				System.out.println("Top or t shirt addded in cart");
			} else {
				System.out.println("product not match");
			}
		}
	}

	public void navigateToCart() {
		page.waitForSelector(".nav li a[href='/view_cart']");
		//page.click(".nav li a[href='/view_cart']");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart")).click();
		

	}

	public void productisaddedorNot(String top, String tshirt) {
		Locator allproduct = page.locator(cartdecription);

		int count = allproduct.count();

		for (int i = 0; i < count; i++) {
			String description = allproduct.nth(i).innerText();

			if (description.contains(top) || description.contains(tshirt)) {
				System.out.println("Added in cart");
			} else {
				System.out.println("not added in cart");
				throw new AssertionError("Expected products not found in cart");
			}
		}

	}

}