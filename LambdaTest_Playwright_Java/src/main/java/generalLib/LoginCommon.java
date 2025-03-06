package generalLib;

import com.microsoft.playwright.Page;

import LambdaTest_Pages.HeaderSection;
import LambdaTest_Pages.LoginPage;

public class LoginCommon {

	public void loginIntoApplication(Page page) throws Throwable
	{
		HeaderSection header = new HeaderSection(page);
		header.clickLoginIcon();
		
		UtilityMethod um = new UtilityMethod(page);
		um.hasTitle("Account Login");
		
		LoginPage lp = new LoginPage(page);
		Utility uc = new Utility();
		String username = uc.readDataFromPropFile(Constants.apppropFilePath,"username");
		String password = uc.readDataFromPropFile(Constants.apppropFilePath, "password");
		lp.enterLoginDetails(username, password);
		lp.clickOnLoginButton();;
		
		um.hasTitle("My Account");
	}
}
