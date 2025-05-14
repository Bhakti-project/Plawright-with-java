package Pages;

import com.microsoft.playwright.Page;

public class ScrollPage {
	
	private Page page;
		
	public ScrollPage(Page page) {
		this.page=page;	
	}
	
	private static String clickOnProductLink = "//a[@href='/products']";
	//private static String bottom_text="//p[@class='pull-left']";
	private static String Top_Text="//img[@alt='Website for automation practice']";
	
	public void user_Click_OnProductLink() {
		// TODO Auto-generated method stub

		page.click(clickOnProductLink);
	}
	
	public void user_Click_OnScroll_Bottom() {
		// TODO Auto-generated method stub
		page.evaluate("window.scrollTo(0,document.body.scrollHeight)");
		

	}
	public boolean page_isOnBottom() {
			
		page.getByText("Copyright © 2021 All rights reserved").isVisible();
			return true;
		

	}
	public void user_Click_OnScroll_Top() {
		// TODO Auto-generated method stub
		page.evaluate("window.scrollTo(0,0)");
	}
	
	public boolean page_isOnTop()
	{
		
		page.getByAltText("Website for automation practice").isVisible();
		return true;
	}

}
