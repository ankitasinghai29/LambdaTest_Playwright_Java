import java.util.Random;

import org.testng.annotations.Test;

import LambdaTest_Pages.HeaderSection;
import LambdaTest_Pages.MyAccountPage;
import generalLib.Base;
import generalLib.LoginCommon;
import generalLib.UtilityMethod;

public class TC05_MyAccount extends Base {
	UtilityMethod um;
	Random rad = new Random();
	MyAccountPage ap;

	// Functionality Test Case: Component/Link Visibility
	@Test
	public void validateUserIsAbleToGetMyAccountPage() throws Throwable {
		um = new UtilityMethod(page);
		clickToGetMyAccountPage();
		um.isHighlighted(ap.getMyAccountIcon());
		um.isVisible(ap.getEditAccountInformationIcon());
		um.isVisible(ap.getChangePasswordIcon());
		um.isVisible(ap.getModifyWishListIcon());
		um.isVisible(ap.getModifyAddressBookIcon());
		um.isVisible(ap.getOrderHistoryIcon());

		um.isVisible(ap.getEditAccountLink());
		um.isVisible(ap.getChangePasswordLink());
		um.isVisible(ap.getWishListLink());
		um.isVisible(ap.getAddressBookLink());
		um.isVisible(ap.getOrderHistoryLink());
	}

	// Checking Navigation of edit profile page
	@Test
	public void validateUserIsAbleToGetEditProfilePage() throws Throwable {
		um = new UtilityMethod(page);
		clickToGetMyAccountPage();
		int choice = rad.nextInt(1, 2);
		if (choice == 1)
			ap.getEditAccountInformationIcon().click();
		else
			ap.getEditAccountLink().click();
		um.hasTitle("My Account Information");
		um.isHighlighted(ap.getEditAccountLink());
	}

	// Checking Navigation of change Password page
	@Test
	public void validateUserIsAbleToGetChangePasswordPage() throws Throwable {
		um = new UtilityMethod(page);
		clickToGetMyAccountPage();
		int choice = rad.nextInt(1, 2);
		if (choice == 1)
			ap.getChangePasswordIcon().click();
		else
			ap.getChangePasswordLink().click();
		um.hasTitle("Change Password");
		um.isHighlighted(ap.getChangePasswordLink());
	}
	
	// Checking Navigation of Address page
	@Test
	public void validateUserIsAbleToGetAddressPage() throws Throwable {
		um = new UtilityMethod(page);
		clickToGetMyAccountPage();
		int choice = rad.nextInt(1, 2);
		if (choice == 1)
			ap.getModifyAddressBookIcon().click();
		else
			ap.getAddressBookLink().click();
		um.hasTitle("Address Book");
		um.isHighlighted(ap.getAddressBookLink());
	}	
	
	// Checking Navigation of wishlist page
	@Test
	public void validateUserIsAbleToGetWishlistPage() throws Throwable {
		um = new UtilityMethod(page);
		clickToGetMyAccountPage();
		int choice = rad.nextInt(1, 2);
		if (choice == 1)
			ap.getModifyWishListIcon().click();
		else
			ap.getWishListLink().click();
		um.hasTitle("My Wish List");
		um.isHighlighted(ap.getWishListLink());
	}		

	// Checking Navigation of order history page
	@Test
	public void validateUserIsAbleToGetOrderHistoryPage() throws Throwable {
		um = new UtilityMethod(page);
		clickToGetMyAccountPage();
		int choice = rad.nextInt(1, 2);
		if (choice == 1)
			ap.getOrderHistoryIcon().click();
		else
			ap.getOrderHistoryLink().click();
		um.hasTitle("Order History");
		um.isHighlighted(ap.getOrderHistoryLink());
	}		
	
	//checking the functionality of logout
	@Test
	public void validateUserIsAbleToLogout() throws Throwable
	{
		um = new UtilityMethod(page);
		clickToGetMyAccountPage();
		int choice = rad.nextInt(1, 2);
		if (choice == 1)
			ap.getLogoutLink().click();
		else
			{
			  HeaderSection hs = new HeaderSection(page);
			  hs.clickLogoutIcon();
			}
		
		um.hasTitle("Account Logout");
	}
	
	public void clickToGetMyAccountPage() throws Throwable {
		LoginCommon login = new LoginCommon();
		login.loginIntoApplication(page);
		ap = new MyAccountPage(page);
	}

}
