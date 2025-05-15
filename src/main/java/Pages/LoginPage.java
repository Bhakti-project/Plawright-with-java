package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import Exception.LoginFailedException;
import Utilities.ConfigReader;

public class LoginPage {
	private Page page;

	public LoginPage(Page page) {
		this.page = page;
	}

	private static String clikonLoginPage = "//a[normalize-space()='Signup / Login']";
	private static String emailPlaceholder = "//input[@data-qa='login-email']";
	private static String passwordPlaceholderText = "//input[@data-qa='login-password']";
	private static String clickonLoginoption = "//button[normalize-space()='Login']";
	private static String logoutoption = "//a[normalize-space()='Logout']";

	public void openLoginPage()   {
		
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(" Signup / Login")).click();
	
       
	}

	public void enterLoginCredentials(String email, String password) throws LoginFailedException {
		page.fill(emailPlaceholder, email);
		page.fill(passwordPlaceholderText, password);
		page.click(clickonLoginoption);
		
		if (!isLoginSuccessful()) {
			throw new LoginFailedException("Login failed for user: " + email);
		}
	}

	public boolean isLoginSuccessful() {
		return page.locator(logoutoption).isVisible();
	}
}
