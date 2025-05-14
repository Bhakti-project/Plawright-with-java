package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class RemoveOneProductPage {
	private Page page;

	private static final Logger logger = LogManager.getLogger(RemoveOneProductPage.class);

	public RemoveOneProductPage(Page page) {
		this.page = page;
	}

	private static String clickOnProductLink = "//a[@href='/products']";
	private static String viewDeatils = "a[href='/product_details/1']";
	private static String viewDeatils2 = "a[href='/product_details/2']";
	private static String viewDeatils3 = "a[href='/product_details/3']";
	private static String addToCart = "//button[normalize-space()='Add to cart']";
	private static String continueShoping = "//button[normalize-space()='Continue Shopping']";
	private static String clickOncartoption = "//ul[@class='nav navbar-nav']//a[contains(@href, 'view_cart')]";
	private static String proceedbutton = "//a[text()='Proceed To Checkout']";
	private static String removeProduct = "//a[@class='cart_quantity_delete']";
	private static String message = "//b[text()='Cart is empty!']";
	private static String removeproductname = "//a[text()='Blue Top']";

	public void click_OnProductOption() {
		page.waitForSelector(clickOnProductLink);
		page.click(clickOnProductLink);

	}

	public void add_ProductOn_Page() {

		page.waitForSelector(viewDeatils);
		page.click(viewDeatils);
		page.click(addToCart);
		page.click(continueShoping);

		page.waitForSelector(clickOnProductLink);
		page.click(clickOnProductLink);
		page.click(viewDeatils2);
		page.click(addToCart);
		page.click(continueShoping);

		page.waitForSelector(clickOnProductLink);
		page.click(clickOnProductLink);
		page.click(viewDeatils3);
		page.click(addToCart);
		page.click(continueShoping);

	}

	public void click_onCartOption() {
		page.click(clickOncartoption);
	}

	public void remove_OneProduct(String productname) {
		Locator productRow = page.locator("tr:has-text('" + productname + "')");
        Locator removeButton = productRow.locator("a.cart_quantity_delete");
        removeButton.click();
        page.waitForTimeout(3000);
        //page.waitForSelector("tr:has-text('" + productname + "')", 
               // new Page.WaitForSelectorOptions().setState(WaitForSelectorState.DETACHED));


	}

	public boolean verify_oneProductRemoved() {
		boolean isvisiable = page.locator("//a[text()='Blue Top']").isVisible();
		System.out.println(isvisiable);
		return isvisiable;

	}
}
