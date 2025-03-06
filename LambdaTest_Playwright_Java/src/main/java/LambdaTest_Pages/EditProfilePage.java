package LambdaTest_Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class EditProfilePage {
	
	Page page;
	
	public EditProfilePage(Page page)
	{
		this.page=page;
	}
	
	public Locator getEditAccountInformationIcon()
	{
		return page.getByText(" Edit your account information");
	}
	
	
	public Locator getFirstName()
	{
		return page.locator("#input-firstname");
	}
	
	public Locator getLastName()
	{
		return page.locator("#input-lastname");
	}
	
	public Locator getEmailId()
	{
		return page.locator("#input-email");
	}

	public Locator getTelephone()
	{
		return page.locator("#input-telephone");
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
		return page.locator("//div[contains(.,'Success')]").last();
	}
	
	public Locator getWarningMessage()
	{
		return page.locator(".text-danger");
	}
}
