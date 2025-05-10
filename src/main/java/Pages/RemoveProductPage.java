package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;



public class RemoveProductPage {

	private Page page;

	private static final Logger logger = LogManager.getLogger(RemoveProductPage.class);	
	public RemoveProductPage(Page page) {
		this.page = page;
	}

	private static String clickOnProductLink = "//a[@href='/products']";
	private static String viewDeatils = "a[href='/product_details/1']";
	private static String addToCart = "//button[normalize-space()='Add to cart']";
	private static String continueShoping = "//button[normalize-space()='Continue Shopping']";
	private static String clickOncartoption="//ul[@class='nav navbar-nav']//a[contains(@href, 'view_cart')]";
	private static String proceedbutton="//a[text()='Proceed To Checkout']";
	private static String removeProduct="//a[@class='cart_quantity_delete']";
	private static String message ="//b[text()='Cart is empty!']";
	
	public void add_Product_Cart() {
		page.click(clickOnProductLink);
		page.waitForSelector(viewDeatils);
		page.click(viewDeatils);
		page.click(addToCart);
		page.click(continueShoping);
		

	}
	
	public void navigate_To_Cart() {
		// TODO Auto-generated method stub
		page.waitForSelector(clickOncartoption);
		page.click(clickOncartoption);
	
	}
	
	public void remove_product() {
		// TODO Auto-generated method stub
		
		if(page.isVisible(proceedbutton))
		{
		page.click(removeProduct);
		page.waitForTimeout(2000);
		}

		
		
	}
	
	public void verify_Product_isRemove(String expected) {
		String actual=page.textContent(message).trim();
			if(actual.equalsIgnoreCase(expected))
					{
						logger.info("Product successfulyy remove: ");
					}
			else
			{
				logger.error("product NOt remove:"+ expected + "BUt got actual "+ actual);
			}
			
	}

}
