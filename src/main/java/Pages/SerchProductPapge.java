package Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class SerchProductPapge {
	private Page page;

	public SerchProductPapge(Page page) {
		this.page = page;
	}

	public void clickonURL() {
		page.navigate("https://www.automationexercise.com/");
	}

	public void clickonbyProductLink() {

		page.click("//a[@href='/products']");
	}

	public void searchProduct(String productName) {
		page.fill("//input[@id='search_product']", productName);
		page.click("//button[@id='submit_search']");
	}

	public boolean areSearchResultsVisible(String expectedProductName) {
		String s=page.getByRole(AriaRole.HEADING,new Page.GetByRoleOptions().setName("Searched Products")).textContent();
			if(s.equalsIgnoreCase(expectedProductName))
			{
				return true;
			}
			return false;
		
				
		/*
		 * page.waitForSelector("div.features_items");
		 * 
		 * Locator productNames = page.locator("div.productinfo");
		 * 
		 * int count = productNames.count(); for (int i = 0; i < count; i++) { String
		 * name = productNames.nth(i).textContent(); System.out.println(name); if (name
		 * != null && name.toLowerCase().contains(expectedProductName.toLowerCase())) {
		 * System.out.println("Get The NAme As: "); return true; } } return false;
		 */
	}

	public void printAllProducts() {
		page.waitForSelector("div.features_items");
		Locator productNames = page.locator("div.productinfo");

		int count = productNames.count();
		for (int i = 0; i < count; i++) {
			System.out.println("Product " + (i + 1) + ": " + productNames.nth(i).textContent());
		}
		System.out.println("Total product count: " + count);
	}
}