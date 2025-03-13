import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import LambdaTest_Pages.EditProfilePage;
import LambdaTest_Pages.HeaderSection;
import generalLib.Base;
import generalLib.Constants;
import generalLib.LoginCommon;
import generalLib.Utility;
import generalLib.UtilityMethod;

public class TC06_EditProfile_Test extends Base{

	UtilityMethod um;
	EditProfilePage ep;
	Utility uc = new Utility();
	Faker fk = new Faker();
	String path = Constants.apppropFilePath;
	
	//Check the visibility of the component on edit profile page
	@Test
	public void validateUserIsAbleToGetEditProfileField() throws Throwable
	{
		um= new UtilityMethod(page);
		ep = new EditProfilePage(page);
		getEditProfilePage();
		um.isVisible(ep.getFirstName());
		um.isVisible(ep.getLastName());
		um.isVisible(ep.getEmailId());
		um.isVisible(ep.getTelephone());
		um.isVisible(ep.getContinueButton());
		um.isVisible(ep.getBackButton());
	}
	
	//check the value of the component on edit profile page
	@Test
	public void validateUserIsAbleToGetProfileInformation() throws Throwable
	{
		um= new UtilityMethod(page);
		ep = new EditProfilePage(page);
		getEditProfilePage();
		
		String firstname = uc.readDataFromPropFile(path, "firstname");
		String lastname = uc.readDataFromPropFile(path, "lastname");
		String email = uc.readDataFromPropFile(path, "username");
		String telephone = uc.readDataFromPropFile(path, "telephone");
		um.hasValue(ep.getFirstName(), firstname);
		um.hasValue(ep.getLastName(), lastname);
		um.hasValue(ep.getEmailId(), email);
		um.hasValue(ep.getTelephone(), telephone);
	}
	
	//update profile with valid data
	@Test
	public void validateUserIsAbleToEditProfile() throws Throwable
	{
		um= new UtilityMethod(page);
		ep = new EditProfilePage(page);
		getEditProfilePage();
		String telephone = fk.phoneNumber().cellPhone();
		ep.getTelephone().fill(telephone);
		uc.setDataIntoPropFile(path, "telephone", telephone);
		ep.getContinueButton().click();
		um.hasTitle("My Account");
		um.isVisible(ep.getSucessMessage());
	}
	
	//Go back to my account page from edit profile page
	@Test
	public void validateUserIsAbleToGoBackToMyAccountPage() throws Throwable
	{
		um= new UtilityMethod(page);
		ep = new EditProfilePage(page);
		getEditProfilePage();
		ep.getBackButton().click();
		um.hasTitle("My Account");
	}

	//Negative TC: User is unable to edit profile with blank fields
	@Test
	public void validateUserIsUnableToEditProfile_WithBlankFields() throws Throwable
	{
		um= new UtilityMethod(page);
		ep = new EditProfilePage(page);
		getEditProfilePage();
		ep.getFirstName().clear();
		ep.getLastName().clear();
		ep.getEmailId().clear();
		ep.getTelephone().clear();
		ep.getContinueButton().click();
		um.hasCount(ep.getWarningMessage(), 4);
	}
	
//	//Negative Tc: User is unable to edit profile with invalid email id
//	@Test
//	public void validateUserIsUnableToEditProfile_WithInvalidEmail() throws Throwable
//	{
//		um= new UtilityMethod(page);
//		ep = new EditProfilePage(page);
//		getEditProfilePage();
//		String email = fk.name().username(); //username without @
//		ep.getEmailId().fill(email);
//		ep.getContinueButton().click();
//		um.hasTitle("My Account Information");
//		
//	}
	
	public void getEditProfilePage() throws Throwable
	{
		LoginCommon lc = new LoginCommon();
		lc.loginIntoApplication(page);
		ep.getEditAccountInformationIcon().click();
		um.hasTitle("My Account Information");
	}
}
