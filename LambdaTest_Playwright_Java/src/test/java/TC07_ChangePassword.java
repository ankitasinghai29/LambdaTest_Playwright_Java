import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import LambdaTest_Pages.ChangePasswordPage;
import generalLib.Base;
import generalLib.Constants;
import generalLib.LoginCommon;
import generalLib.Utility;
import generalLib.UtilityMethod;

public class TC07_ChangePassword extends Base {

	UtilityMethod um;
	ChangePasswordPage cp;
	Utility uc = new Utility();
	Faker fk = new Faker();

	// Check the visibility of the component on edit profile page
	@Test
	public void validateUserIsAbleToGetChangePasswordField() throws Throwable {
		um = new UtilityMethod(page);
		getIntoChangePasswordPage();
		um.isVisible(cp.getNewPassword());
		um.isVisible(cp.getConfirmNewPassword());
		um.isVisible(cp.getContinueButton());
		um.isVisible(cp.getBackButton());
	}

	// Positive TC: User is able to change password successfully with valid data
	@Test
	public void validateUserIsAbleToChangePassword() throws Throwable {
		um = new UtilityMethod(page);
		getIntoChangePasswordPage();
		String newPassword = fk.internet().password();
		cp.getNewPassword().fill(newPassword);
		cp.getConfirmNewPassword().fill(newPassword);
		cp.getContinueButton().click();
		um.isVisible(cp.getSucessMessage());
		um.hasTitle("My Account");
		uc.setDataIntoPropFile(Constants.apppropFilePath, "password", newPassword);
	}

	// Negative TC: User is unable to change password with different password and
	// confirm password
	@Test
	public void validateUserIsUnableToChangePassword_WithDifferentPassword() throws Throwable {
		um = new UtilityMethod(page);
		getIntoChangePasswordPage();
		String newPassword = fk.internet().password();
		String confirmPassword = fk.internet().password();
		cp.getNewPassword().fill(newPassword);
		cp.getConfirmNewPassword().fill(confirmPassword);
		cp.getContinueButton().click();
		um.isVisible(cp.getWarningMessage());
		um.hasTitle("Change Password");
	}

	// Negative TC: User is unable to change password with empty fields
	@Test
	public void validateUserIsUnableToChangePassword_WithEmptyFields() throws Throwable {
		um = new UtilityMethod(page);
		getIntoChangePasswordPage();
		cp.getNewPassword().clear();
		cp.getConfirmNewPassword().clear();
		cp.getContinueButton().click();
		um.isVisible(cp.getWarningMessage());
		um.hasTitle("Change Password");
	}

	// Negative TC: User is unable to change password with less number of character in password
	@Test
	public void validateUserIsUnableToChangePassword_WithLessNoOfCharInPassword() throws Throwable {
		um = new UtilityMethod(page);
		getIntoChangePasswordPage();
		String newPassword = fk.internet().password(1, 3);
		cp.getNewPassword().fill(newPassword);
		cp.getConfirmNewPassword().fill(newPassword);
		cp.getContinueButton().click();
		um.isVisible(cp.getWarningMessage());
		um.hasTitle("Change Password");
	}
	
	//Go back to my account page from my account page
	@Test
	public void validateUserIsAbleToGoBackToMyAccountPage() throws Throwable
	{
		um= new UtilityMethod(page);
		getIntoChangePasswordPage();
		cp.getBackButton().click();
		um.hasTitle("My Account");
	}

	public void getIntoChangePasswordPage() throws Throwable 
	{
		LoginCommon lc = new LoginCommon();
		lc.loginIntoApplication(page);
		cp = new ChangePasswordPage(page);
		cp.getChangePasswordIcon().click();
		um.hasTitle("Change Password");
	}

}
