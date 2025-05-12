package Pages;



import static org.junit.Assert.assertEquals;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class MultipleuserLoginPage {
	private Page page;

	public MultipleuserLoginPage(Page page) {
		this.page = page;
	}

	public void goToURl() {

		System.out.println("Navigate to LOgin Page");
	}

	public void slecttheSignINOption() {

		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Signup / Login")).click();

	}

	public void enterTheCredentials(String email, String password) {
		page.fill("//input[@data-qa='login-email']", email);
		page.fill("//input[@data-qa='login-password']", password);

	}

	public void selectTheLogInOption() {
		page.click("//form[@action='/login']//button[@type='submit']");
		// String p = page.title();
		// System.out.println("Title is:"+p);

	}

	public void UserIsHomePage() {

		String p = page.title();
		System.out.println("Title is:" + p);
		String expectedTitle = "Automation Exercise";
		assertEquals(expectedTitle, p);

	}

}
