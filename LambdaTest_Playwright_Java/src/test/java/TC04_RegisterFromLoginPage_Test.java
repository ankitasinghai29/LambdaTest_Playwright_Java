import org.testng.annotations.Test;

import LambdaTest_Pages.HeaderSection;
import LambdaTest_Pages.LoginPage;
import generalLib.Base;
import generalLib.UtilityMethod;

public class TC04_RegisterFromLoginPage_Test extends Base
{
	@Test
	public void validateUserIsAbleToRegisterFromLoginPage() throws Throwable
	{
		HeaderSection header = new HeaderSection(page);
		header.clickLoginIcon();
		
		UtilityMethod um = new UtilityMethod(page);
		um.hasTitle("Account Login");
		
		LoginPage lp = new LoginPage(page);
		lp.clickonContinueUnderNewUser();
		um.hasTitle("Register Account");
		TC02_Register_Test rt = new TC02_Register_Test();
		//rt.enterRegistrationDetails(page);
	}
}
