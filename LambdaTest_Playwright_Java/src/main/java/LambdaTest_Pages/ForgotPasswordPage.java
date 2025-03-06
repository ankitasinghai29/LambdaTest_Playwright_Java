package LambdaTest_Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ForgotPasswordPage {
	
	Page page;
	
	public ForgotPasswordPage(Page page)
	{
		this.page=page;
	}
	
	public Locator getForgotPasswordLink()
	{
		return page.getByText("Forgotten Password").first();
	}
	
	public void clickonForgotPasswordLink()
	{
			getForgotPasswordLink().click();		
	}
	
	public Locator getEmailField()
	{
		return page.locator("#input-email");
	}
	
	public void enterEmail(String username)
	{
		getEmailField().fill(username);
	}

	public void clickonContinue()
	{
		page.getByText("Continue").click();
	}
	
	public Locator displayMessage()
	{
		return page.getByText(" An email with a confirmation link has been sent your email address.");
	}
	
	public Locator getWarningMessage()
	{
		return page.locator("//div[contains(.,\"Warning\")]").last();
	}
}
