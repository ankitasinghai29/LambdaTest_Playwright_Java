package LambdaTest_Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ChangePasswordPage {
	
	Page page;
	
	public ChangePasswordPage(Page page)
	{
		this.page = page;
	}
	
	public Locator getChangePasswordIcon()
	{
		return page.getByText(" Change your password");
	}
	
	public Locator getNewPassword()
	{
		return page.locator("#input-password");
	}
	
	public Locator getConfirmNewPassword()
	{
		return page.locator("#input-confirm");
	}
	
	public Locator getContinueButton()
	{
		return page.locator("[value='Continue']");
	}
	
	public Locator getBackButton()
	{
		return page.getByText(" Back").first();
	}
	
	public Locator getSucessMessage()
	{
		return page.locator("//div[contains(text(),'Success')]");
	}
	
	public Locator getWarningMessage()
	{
		return page.locator(".text-danger");
	}

}
