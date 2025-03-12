import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.microsoft.playwright.options.SelectOption;

import LambdaTest_Pages.AddAddressPage;
import generalLib.Base;
import generalLib.LoginCommon;
import generalLib.UtilityMethod;

public class TC08_AddAddress extends Base
{
	UtilityMethod um;
	AddAddressPage ap;
	Faker fk = new Faker();
	
	@Test
	//Test Case for verifying visibility of the component
	public void validateUserIsAbleToGetAddressBookField() throws Throwable
	{
		um = new UtilityMethod(page);
		getIntoAddressBookPage();
		um.isVisible(ap.getNewAddressButton());
		ap.getNewAddressButton().click();
		um.isVisible(ap.getFirstName());
		um.isVisible(ap.getLastName());
		um.isVisible(ap.getAddress1());
		um.isVisible(ap.getCity());
		um.isVisible(ap.getCountry());
		um.isVisible(ap.getState());
		um.isVisible(ap.getPostCode());
		um.isVisible(ap.getContinueButton());
	}
	
	//Test Case: Add new address with valid data
	@Test
	public void validateUserIsAbleToAddNewAddress_withValidData() throws Throwable
	{
		um = new UtilityMethod(page);
		getIntoAddressBookPage();
		ap.getNewAddressButton().click();
		
		String fname = fk.name().firstName();
		String lname = fk.name().lastName();
		String address = fk.address().streetAddress();
		String city = fk.address().cityName();
		String postcode = fk.address().zipCode();
		
		ap.getFirstName().fill(fname);
		ap.getLastName().fill(lname);
		ap.getAddress1().fill(address);
		ap.getCity().fill(city);
		ap.getPostCode().fill(postcode);
		ap.getCountry().selectOption(new SelectOption().setLabel("India"));
		ap.getState().selectOption(new SelectOption().setLabel("Karnataka"));
        String fullname = fname + " " + lname;
		String fullAddress= fullname + address + city + " " + postcode + 
		                   ap.getSelectedState() + ap.getSelectedCountry();	
		ap.getContinueButton().click();	
		um.hasTitle("Address Book");
		um.hasText(ap.getNewAddressField(fullname), fullAddress);
	}
	
	//Negative TC : Unable to add new address with blank fields
	@Test
	public void validateUserIsUnableToAddNewAddress_WithBlankFields() throws Throwable
	{
		um = new UtilityMethod(page);
		getIntoAddressBookPage();
		ap.getNewAddressButton().click();
		ap.getContinueButton().click();
		um.hasCount(ap.getWarningMessage(), 6);
	}
	
	public void getIntoAddressBookPage() throws Throwable 
	{
		LoginCommon lc = new LoginCommon();
		lc.loginIntoApplication(page);
		ap = new AddAddressPage(page);
		ap.getAddressBookIcon().click();
		um.hasTitle("Address Book");
	}
}
