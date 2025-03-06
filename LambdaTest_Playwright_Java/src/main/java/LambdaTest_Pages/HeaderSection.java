package LambdaTest_Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import generalLib.UtilityMethod;


public class HeaderSection {
	
	//in the website header section is common to all test case thats why creating seperate class for it
	
	public Page page = null; //page variable for performing action on current page
	UtilityMethod um = new UtilityMethod(page);
	
	public HeaderSection(Page page)
	{
		this.page = page;
	}
	
	Locator getmyAccount()
	{
		Locator myaccount = page.locator("//a[contains(.,'My account')][@role='button']");
		um.isVisible(myaccount);
		return myaccount;
	}
	
	public void clickLoginIcon()
	{
		getmyAccount().hover();
		page.click("//a[contains(.,'Login')]"); 
	}

	public void clickRegisterIcon()
	{
		getmyAccount().hover();
		page.click(" //span[text()[normalize-space()=\"Register\"]]");
	}
	
	public void clickLogoutIcon()
	{
		getmyAccount().hover();
		page.click(" //span[text()[normalize-space()=\"Logout\"]]");
	}
}
