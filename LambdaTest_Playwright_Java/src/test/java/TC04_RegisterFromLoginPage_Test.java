import java.util.Random;

import org.testng.annotations.Test;

import LambdaTest_Pages.HeaderSection;
import LambdaTest_Pages.LoginPage;
import generalLib.Base;
import generalLib.UtilityMethod;

public class TC04_RegisterFromLoginPage_Test extends Base
{
	UtilityMethod um;
	LoginPage lp;
	Random rad = new Random();
	
	//Test Case: check visibility of the component
	@Test
	public void validateUserIsAbleToGetRegisterLinkOnLoginPage()
	{
		HeaderSection header = new HeaderSection(page);
		header.clickLoginIcon();
		
		um= new UtilityMethod(page);
		um.hasTitle("Account Login");
		
		lp = new LoginPage(page);
		um.isVisible(lp.getContinueButtonUnderNewUser());
		um.isVisible(lp.getRegisterLink());
	}
	
	
	//Test Case to check navigation of the register page from login page
	@Test
	public void validateUserIsAbleToRegisterFromLoginPage() throws Throwable
	{
		HeaderSection header = new HeaderSection(page);
		header.clickLoginIcon();
		
		um= new UtilityMethod(page);
		um.hasTitle("Account Login");
		
		lp = new LoginPage(page);
		int choice = rad.nextInt(1, 2);
		if (choice == 1)
			lp.getContinueButtonUnderNewUser().click();
		else
			lp.getRegisterLink().click();
		um.hasTitle("Register Account");
		um.isHighlighted(lp.getRegisterLink());
	}
}
