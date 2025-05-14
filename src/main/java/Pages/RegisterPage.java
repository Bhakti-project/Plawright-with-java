package Pages;

import com.microsoft.playwright.Page;

public class RegisterPage {
	private Page page;

	public RegisterPage(Page page) {
		this.page = page;
	}

	public void openSignupPage() {
		//page.navigate("https://www.automationexercise.com/login");
		page.click("//a[normalize-space()='Signup / Login']");
	}

	public void enterSignupDetails(String name, String email) {
		page.fill("//input[@placeholder='Name']", name);
		page.fill("//input[@data-qa='signup-email']", email);
		page.click("//button[normalize-space()='Signup']");
	}

	public void completeRegistrationForm() {
		page.click("//input[@id='id_gender2']");
		page.fill("//input[@id='password']", "check123@123");
		page.selectOption("//select[@id='days']", "2");
		page.selectOption("//select[@id='months']", "March");
		page.selectOption("//select[@id='years']", "2020");

		page.click("//input[@id='newsletter']");
		page.click("//input[@id='optin']");

		page.fill("//input[@id='first_name']", "FirstNew");
		page.fill("//input[@id='last_name']", "User");
		page.fill("//input[@id='company']", "NewCompany");
		page.fill("//input[@id='address1']", "wagholi");
		page.selectOption("//select[@id='country']", "India");
		page.fill("//input[@id='state']", "Maharashtra");
		page.fill("//input[@id='city']", "pune");
		page.fill("//input[@id='zipcode']", "412216");
		page.fill("//input[@id='mobile_number']", "1234567800");

		page.click("//button[normalize-space()='Create Account']");
	}

	public String getConfirmationMessage() {
		return page.locator("//b[normalize-space()='Account Created!']").textContent();
	}
}
