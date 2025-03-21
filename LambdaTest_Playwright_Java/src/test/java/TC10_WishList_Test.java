import org.testng.annotations.Test;

import LambdaTest_Pages.HeaderSection;
import LambdaTest_Pages.WishListPage;
import generalLib.Base;
import generalLib.LoginCommon;
import generalLib.UtilityMethod;

public class TC10_WishList_Test extends Base
{

	UtilityMethod um;
	WishListPage wp;
	HeaderSection hs;
	
	//Positive TC- User is able to add item to wishlist from all item page
	@Test
	public void validateUserIsAbleToAddItemInWishlist_FromAllItemPage() throws Throwable
	{
		wp = new WishListPage(page);
		um = new UtilityMethod(page);
		getLoginIntoTheApplication();
		hs = new HeaderSection(page);
		hs.clickonAppleItem();
		um.hasTitle("Apple");
		String itemName = wp.getFirstAppleItemName().innerText();
		wp.addItemToWishList();
		um.isVisible(wp.getSucessNotification());
		hs.clickOnWishListIcon();
		um.hasSameValue(itemName,wp.getWishlistPageAddedItemName().innerText());	
	}
	
	//Positive TC - User is able to add item to wishlist from item page
	@Test
	public void validateUserIsAbleToAddItemInWishlist_FromItemPage() throws Throwable
	{
		wp = new WishListPage(page);
		um = new UtilityMethod(page);
		getLoginIntoTheApplication();
		hs = new HeaderSection(page);
		hs.clickonAppleItem();
		um.hasTitle("Apple");
		String itemName = wp.getFirstAppleItemName().innerText();
		wp.getFirstAppleItem().click();
		um.hasTitle(itemName);
		page.waitForTimeout(5000);
		wp.clickOnWishlistIconOfItem();	
		um.isVisible(wp.getSucessNotification());
		hs.clickOnWishListIcon();
		um.hasSameValue(itemName,wp.getWishlistPageAddedItemName().innerText());	
	}
	
	//Positive TC - user is able to remove item from wishlist once again click on wishlist icon of item
	@Test
	public void validateUserIsAbleToRemoveFromWishlist_AfterDeselectingIcon() throws Throwable
	{
		wp = new WishListPage(page);
		um = new UtilityMethod(page);
		getLoginIntoTheApplication();
		hs = new HeaderSection(page);
		hs.clickonAppleItem();
		um.hasTitle("Apple");
		String itemName = wp.getFirstAppleItemName().innerText();
		wp.getFirstAppleItem().click();
		um.hasTitle(itemName);
		page.waitForTimeout(5000);
		wp.clickOnDeselectWishlistIcon();
		hs.clickOnWishListIcon();
		um.isVisible(wp.emptyWishlistMessage());
	}
	
	//Positive Tc - user is able to remove item from wishlist page
	@Test
	public void validateUserIsAbleToRemoveFromWishlist() throws Throwable
	{
		wp = new WishListPage(page);
		um = new UtilityMethod(page);
		getLoginIntoTheApplication();
		hs = new HeaderSection(page);
		hs.clickOnWishListIcon();
		wp.clickOnRemoveItemFromWishlistPage();
		um.isVisible(wp.getSuccessUpdateWishlistMessage());
		
	}
	
	//Negative TC - user is unable to add item in wishlist without login
	@Test
	public void validateUserIsUnableToAddItemIntoWishlist_WithoutLogin()
	{
		wp = new WishListPage(page);
		um = new UtilityMethod(page);
		hs = new HeaderSection(page);
		hs.clickonAppleItem();
		um.hasTitle("Apple");
		wp.addItemToWishList();
		page.waitForTimeout(2000);
		um.isVisible(wp.getLoginRegisterNotification());
	}
	
	//Negative TC - user is unable to see wishlist without login
	@Test
	public void validateUserIsUnableToSeeWishlist_WithoutLogin()
	{
		um = new UtilityMethod(page);
		hs = new HeaderSection(page);
		hs.clickOnWishListIcon();
		um.hasTitle("Account Login");
	}
	
	public void getLoginIntoTheApplication() throws Throwable
	{
		LoginCommon lc = new LoginCommon();
		lc.loginIntoApplication(page);
	}
}
