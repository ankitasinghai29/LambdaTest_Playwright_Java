import java.util.Random;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import LambdaTest_Pages.HeaderSection;
import LambdaTest_Pages.RegisterPage;
import generalLib.Base;
import generalLib.UtilityMethod;

public class TC02_Register_Test extends Base {
	
	
	UtilityMethod um;
	Faker fk = new Faker();
	RegisterPage rp;
	
	//Functionality/Component Test Case
	@Test (priority = 1)
	public void checkComponentVisibility()
	{
		um = new UtilityMethod(page);
		clickOnRegisterIcon();
		rp = new RegisterPage(page);
		um.isVisible(rp.getFirstName());
		um.isVisible(rp.getLastName());
		um.isVisible(rp.getEmail());
		um.isVisible(rp.getTelephone());
		um.isVisible(rp.getPassword());
		um.isVisible(rp.getConfirmPassword());
		um.isVisible(rp.getPrivacyPolicy());
	}
	
	
	//Positive test case with valid data
	@Test
	public void validateUserIsAbleToRegister() throws Throwable
	{
		um = new UtilityMethod(page);
		clickOnRegisterIcon();
		rp = new RegisterPage(page);
		enterRegistrationDetails(rp);
		rp.getPrivacyPolicy().check();
		rp.clickonContinue();
		um.hasTitle(" Your Account Has Been Created!");
	}
	
	//Negative TestCase:registering with existing username
	@Test
	public void validateUserIsUnableToRegister_WithExistingEmailId()
	{	
		um = new UtilityMethod(page);
		clickOnRegisterIcon();
		
        RegisterPage rp = new RegisterPage(page);
		
		String firstname = fk.name().firstName();
		String lastname = fk.name().lastName();
		String email = "ankis123@gmail.com";
		String number = fk.phoneNumber().cellPhone();
		String password = fk.internet().password();
		rp.registerUserAccount(firstname,lastname,email,number,password);
		rp.clickonContinue();
		
		um.isVisible(rp.warningMessage());
		
	}
	
	//Negative TestCase: Registering without checking privacy policy
	@Test
	public void validateUserIsUnableToRegister_WithoutCheckingPrivacyPolicy() throws Throwable
	{
		um = new UtilityMethod(page);
		clickOnRegisterIcon();
		rp = new RegisterPage(page);
		enterRegistrationDetails(rp);
		rp.clickonContinue();
		
		um.isVisible(rp.warningMessage());
	}
	
	//Negative TestCase: Registering with partial data
	@Test
	public void validateUserIsUnableToRegister_WithPartialData()
	{
		um = new UtilityMethod(page);
		clickOnRegisterIcon();
		rp = new RegisterPage(page);
		Random rad = new Random();
		int noOfFields = rad.nextInt(1, 5);
		enterPartialRegistrationDetails(rp,noOfFields);
		rp.clickonContinue();
		um.hasCount(rp.isMandatoryWarningMessage(), noOfFields);
	}

	
	public void enterPartialRegistrationDetails(RegisterPage rp,int num)
	{
		String firstname = fk.name().firstName();
		String lastname = fk.name().lastName();
		String email = fk.internet().emailAddress();
		String number = fk.phoneNumber().cellPhone();
		String password = fk.internet().password();
		rp.registerUserAccountWithPartialData(firstname,lastname,email,number,password,num);
	}
	
	
	public void enterRegistrationDetails(RegisterPage rp) throws Throwable
	{		
		String firstname = fk.name().firstName();
		String lastname = fk.name().lastName();
		String email = fk.internet().emailAddress();
		String number = fk.phoneNumber().cellPhone();
		String password = fk.internet().password();
		rp.registerUserAccount(firstname,lastname,email,number,password);
		
		
//		Utility uc = new Utility();
//		uc.setDataIntoPropFile(Constants.apppropFilePath,"username","ankis123@gmail.com");
//		uc.setDataIntoPropFile(Constants.apppropFilePath, "password", "ankitas123");	
	}
	
	public void clickOnRegisterIcon()
	{
		HeaderSection hc = new HeaderSection(page);
		hc.clickRegisterIcon();
		um.hasTitle("Register Account");
	}

}
