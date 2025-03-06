import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import LambdaTest_Pages.HeaderSection;
import LambdaTest_Pages.LoginPage;
import generalLib.Base;
import generalLib.Constants;
import generalLib.Utility;
import generalLib.UtilityMethod;

public class TC01_Login_Test extends Base{
	//This Test Case is used to validate the Login functionality of the application
	
	UtilityMethod um;
	Utility uc = new Utility();
	LoginPage lp;
	Faker fk = new Faker();	
	
	//Functionality/Component Test Case
	@Test(priority = 1)
	public void checkComponentVisibility()
	{
		um = new UtilityMethod(page);
		lp = new LoginPage(page);
		clickonLoginIcon();
		um.isVisible(lp.usernameField());
		um.isVisible(lp.passwordField());
		um.isVisible(lp.loginButton());
		
	}
	
	//Positive Test Case with valid credential
	@Test	
	public void validateUserIsAbleToLogin() throws Throwable
	{

		
		um = new UtilityMethod(page);
		lp = new LoginPage(page);
		clickonLoginIcon();
		String username = uc.readDataFromPropFile(Constants.apppropFilePath,"username");
		String password = uc.readDataFromPropFile(Constants.apppropFilePath, "password");
		lp.enterLoginDetails(username, password);
		lp.clickOnLoginButton();
		
		um.hasTitle("My Account");
	}
	
	//Negative Test Case without credential directly perform click action on login
	@Test
	public void validateUserIsUnableToLogin_WithoutCredential() 
	{
		um = new UtilityMethod(page);
		lp = new LoginPage(page);
		clickonLoginIcon();
		lp.clickOnLoginButton();
		um.isVisible(lp.getWarningMessage());
	}
	
	//Negative Test Case with one valid username and invalid password 
	@Test
	public void validateUserIsUnableToLogin_WithOnlyUsernameCredential() throws Throwable
	{
		um = new UtilityMethod(page);
		lp = new LoginPage(page);
		clickonLoginIcon();
		String username = uc.readDataFromPropFile(Constants.apppropFilePath,"username");
		String password = fk.internet().password();
		lp.enterLoginDetails(username, password);
		lp.clickOnLoginButton();
		um.isVisible(lp.getWarningMessage());
	}
	
	//Negative Test Case with invalid username and valid password
	@Test
	public void validateUserIsUnableToLogin_WithOnlyPasswordCredential() throws Throwable
	{
		um = new UtilityMethod(page);
		lp = new LoginPage(page);
		clickonLoginIcon();
		String username = fk.internet().emailAddress();
		String password = uc.readDataFromPropFile(Constants.apppropFilePath, "password");
		lp.enterLoginDetails(username, password);
		lp.clickOnLoginButton();
		um.isVisible(lp.getWarningMessage());
	}
	
	//Negative Test Case with invalid credentials 
	@Test
	public void validateUserIsUnableToLogin_WithWrongCredential()
	{
		um = new UtilityMethod(page);
		lp = new LoginPage(page);
		clickonLoginIcon();
		String username = fk.internet().emailAddress();
		String password = fk.internet().password();
		lp.enterLoginDetails(username, password);
		lp.clickOnLoginButton();
		um.isVisible(lp.getWarningMessage());
	}
	
	public void clickonLoginIcon()
	{
		HeaderSection header = new HeaderSection(page);
		header.clickLoginIcon();
		um.hasTitle("Account Login");
	}

}