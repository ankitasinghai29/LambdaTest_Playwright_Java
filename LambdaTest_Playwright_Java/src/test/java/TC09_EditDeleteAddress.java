import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import LambdaTest_Pages.EditDeleteAddressPage;
import generalLib.Base;
import generalLib.LoginCommon;
import generalLib.UtilityMethod;

public class TC09_EditDeleteAddress extends Base {

	UtilityMethod um;
	EditDeleteAddressPage ap;
	Faker fk = new Faker();
	
	
	//Positive TC User is able to get valid data on edit address page
	@Test
	public void validateUserIsAbleSeeValidDataOnEditAddressPage() throws Throwable
	{
		um = new UtilityMethod(page);
		getIntoAddressBookPage();
		String name = "Annie Cormier";
		String adress = ap.getAddressField(name).first().innerText();
		ap.getEditButton(name).click();
		String fulladdress = ap.getFirstName().inputValue()+" "+ap.getLastName().inputValue()+"\n"+ap.getAddress1().inputValue()+"\n"
				           +ap.getCity().inputValue()+" "+ap.getPostCode().inputValue()+"\n"+ap.getSelectedState()+"\n" + ap.getSelectedCountry();	
		
		um.hasSameValue(adress, fulladdress);
	}
	
	//Positive TC- User Is able to update address
	@Test
	public void validateUserIsAbleToEditAddress_WithValidData() throws Throwable
	{
		um = new UtilityMethod(page);
		getIntoAddressBookPage();
		String name = "Annie Cormier";
		ap.getEditButton(name).click();
		String address = fk.address().streetAddress();
		ap.getAddress1().fill(address);
		ap.getContinueButton().click();
		um.hasTitle("Address Book");
		um.isVisible(ap.getSuccessEditMessage());
		um.hasContains(ap.getAddressField(name).first(), address);
	}
	
	//Negative TC: User is unable to edit address with blank field
	@Test
	public void validateUserIsUnableToEditAddress_WithBlankField() throws Throwable
	{
		um = new UtilityMethod(page);
		getIntoAddressBookPage();
		String name = "Annie Cormier";
		ap.getEditButton(name).click();
		ap.getAddress1().clear();
		ap.getContinueButton().click();
		um.isVisible(ap.getWarningMessage().first());
	}
	
	//Positive TC to delete valid Address
	@Test
	public void validateUserIsAbleToDelete_SelectedAddress() throws Throwable
	{
		um = new UtilityMethod(page);
		getIntoAddressBookPage();
		String name = "Breanna Predovic";
		ap.getDeleteButton(name).click();
		um.isVisible(ap.getSuccessDeleteMessage());
	}
	
	//Negative TC- User is unable to delete address if only one is available
	@Test
	public void validateUserIsUnableToDeleteAddress_IfOnlyOneAvailable() throws Throwable
	{
		um = new UtilityMethod(page);
		getIntoAddressBookPage();
		ap.getSingleAddressField().click();
		um.isVisible(ap.getWarningDeletionMessage());
	}
	
	public void getIntoAddressBookPage() throws Throwable 
	{
		LoginCommon lc = new LoginCommon();
		lc.loginIntoApplication(page);
		ap = new EditDeleteAddressPage(page);
		ap.getAddressBookIcon().click();
		um.hasTitle("Address Book");
	}
}
