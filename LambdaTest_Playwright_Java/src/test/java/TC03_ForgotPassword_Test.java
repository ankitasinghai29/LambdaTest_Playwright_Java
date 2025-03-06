import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import LambdaTest_Pages.ForgotPasswordPage;
import LambdaTest_Pages.HeaderSection;
import generalLib.Base;
import generalLib.Constants;
import generalLib.Utility;
import generalLib.UtilityMethod;

public class TC03_ForgotPassword_Test extends Base
{
	
	Utility uc= new Utility();
	UtilityMethod um;
	ForgotPasswordPage fp;
	
	//Functionality/Component Test Case
	@Test(priority = 1)
	public void checkComponentVisibilty()
	{
        um = new UtilityMethod(page);	
		getLoginPage();
		fp= new ForgotPasswordPage(page);
		um.isVisible(fp.getForgotPasswordLink());	
	}
	
	//Check the page navigation and new page components
	@Test(priority = 2)
	public void checkTheNavigationPage()
	{
		 um = new UtilityMethod(page);	
		 getLoginPage();
		 fp= new ForgotPasswordPage(page);
		 fp.clickonForgotPasswordLink();
		 um.hasTitle("Forgot Your Password?");
		 um.isVisible(fp.getEmailField());
	}
	
	//Positive Test Case: with valid email id
	@Test
	public void validateUserIsAbleToDoForgotPassword() throws Throwable
	{
		um = new UtilityMethod(page);
		getLoginPage();		
		fp= new ForgotPasswordPage(page);
		fp.clickonForgotPasswordLink();
		String username = uc.readDataFromPropFile(Constants.apppropFilePath,"username");
		fp.enterEmail(username);
		fp.clickonContinue();
		um.hasTitle("Account Login");
		um.isVisible(fp.displayMessage());
	}
	
	//Negative TestCase: with invalid email id
	@Test
	public void validateUserIsUnableToDoForgotPassword_withInvalidEmail()
	{
		um = new UtilityMethod(page);
		getLoginPage();
		
		fp= new ForgotPasswordPage(page);
		fp.clickonForgotPasswordLink();
		Faker fk = new Faker();
		String email = fk.internet().emailAddress();
		fp.enterEmail(email);
		fp.clickonContinue();
		um.isVisible(fp.getWarningMessage());
	}
	
	public void getLoginPage()
	{
		HeaderSection header = new HeaderSection(page);
		header.clickLoginIcon();
		um.hasTitle("Account Login");
	}

}
