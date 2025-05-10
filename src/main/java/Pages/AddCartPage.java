package Pages;

import com.microsoft.playwright.Page;

public class AddCartPage {

	private Page page;
	
	public AddCartPage(Page page) {
		this.page=page;
	}

	public void click_On_TheProductslink()
	{
		page.waitForSelector("//a[@href='/products']");
		page.click("//a[@href='/products']");
	}
	
	public void select_Product()
	{
		page.click("a[href='/product_details/1']");
		page.click("//button[normalize-space()='Add to cart']");
		page.click("//button[normalize-space()='Continue Shopping']");
		
		
	}
	
	public void Product_Added_Cart()
	{
		page.click("//ul[@class='nav navbar-nav']//a[contains(@href, 'view_cart')]");
		
	}
	public boolean verify_Added_Itam()
	{
		return page.locator("//tr[@id='product-1']").isVisible();
	
	}
}
