package LambdaTest_Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class LoginPage 
{
	
	Page page;
	public LoginPage(Page page) 
	{
		this.page = page;
	}
	
	public Locator usernameField()
	{
		return page.locator("#input-email");
	}
	
	public Locator passwordField()
	{
		return page.locator("//input[@id='input-password']");
	}
	
	public Locator loginButton()
	{
		return page.locator("//input[@value='Login']");
	}

	public void enterLoginDetails(String username,String password)
	{
		usernameField().fill(username);
		passwordField().fill(password);
	}
	
	public void clickOnLoginButton()
	{
		loginButton().click();
	}

	
	public void clickonContinueUnderNewUser()
	{
		page.getByText("Continue").click();
	}
	
	public Locator getWarningMessage()
	{
		return page.locator(" //div[contains(.,\"Warning\")]").last();
	}
}
