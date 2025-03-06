package LambdaTest_Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class MyAccountPage {
	
	Page page;
	public MyAccountPage(Page page)
	{
		this.page = page;
	}
	
	public Locator getEditAccountInformationIcon()
	{
		return page.getByText(" Edit your account information");
	}
	
	public Locator getChangePasswordIcon()
	{
		return page.getByText(" Change your password");
	}
	
	public Locator getModifyWishListIcon()
	{
		return page.getByText(" Modify your wish list");
	}
	
	public Locator getOrderHistoryIcon()
	{
		return page.getByText(" View your order history");
	}
	
	public Locator getModifyAddressBookIcon()
	{
		return page.getByText(" Modify your address book entries");
	}
	
	public Locator getEditAccountLink()
	{
		return page.getByText("Edit Account");
	}
	
	public Locator getChangePasswordLink()
	{
		return page.getByText(" Password").last();
	}
	
	public Locator getWishListLink()
	{
		return page.getByText(" Wish List").last();
	}
	
	public Locator getOrderHistoryLink()
	{
		return page.getByText(" Order History").last();
	}
	
	public Locator getAddressBookLink()
	{
		return page.getByText(" Address Book").last();
	}
	
	public Locator getMyAccountIcon()
	{
		return page.getByText(" My Account").last();
	}

	public Locator getLogoutLink()
	{
		return page.getByText(" Logout").last();
	}

}
