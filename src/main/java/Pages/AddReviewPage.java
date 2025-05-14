package Pages;

import com.microsoft.playwright.Page;

public class AddReviewPage {

	private Page page;

	public AddReviewPage(Page page) {
		this.page = page;
	}

	private static String clickOnProductLink = "//a[@href='/products']";
	private static String viewDeatils = "a[href='/product_details/1']";

	private static String xpath_name="//input[@id='name']";
	private static String xpath_Email="//input[@id='email']";
	private static String xpath_textArea="//textarea[@id='review']";
	private static String submit_Button="//button[@id='button-review']";
	private static String successfullmsg="//span[text()='Thank you for your review.']";

	public void click_ON_ViewProduct() {
		page.waitForSelector(clickOnProductLink);
		page.click(clickOnProductLink);
		page.waitForSelector(viewDeatils);
		page.click(viewDeatils);
	}

	public void add_review_Product(String name, String email,String text) {
		page.fill(xpath_name, name);
		page.fill(xpath_Email, email);
		page.fill(xpath_textArea, text);

	}

	public void click_ON_SubmitButton() {
		page.click(submit_Button);

	}
	
	public boolean VerifyReviewNoteadded() {
		page.isVisible(successfullmsg);
		return true;
		

	}
}
