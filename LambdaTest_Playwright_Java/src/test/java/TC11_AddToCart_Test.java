import org.testng.annotations.Test;

import LambdaTest_Pages.AddAddressPage;
import LambdaTest_Pages.AddToCartPage;
import LambdaTest_Pages.HeaderSection;
import LambdaTest_Pages.WishListPage;
import generalLib.Base;
import generalLib.LoginCommon;
import generalLib.UtilityMethod;

public class TC11_AddToCart_Test extends Base
{
	UtilityMethod um;
	AddToCartPage ac;
	HeaderSection hs;
	
	//Negative TC -User is unable to get cart list without login
	@Test
	public void validateUserIsUnableToGetCartList_WithoutLogin()
	{
		um = new UtilityMethod(page);
		ac = new AddToCartPage(page);
		hs = new HeaderSection(page);
		hs.getCartIcon();
		um.isVisible(ac.getCartPopup());
		um.isVisible(ac.getEmptyListMessage());
	}
	
	//Positive TC - User is able to add item into cart with login
	@Test
	public void validateUserIsAbleToAddItemToCart_WithLogin() throws Throwable
	{
		um = new UtilityMethod(page);
		ac = new AddToCartPage(page);
		hs = new HeaderSection(page);
		getLoginIntoTheApplication();
		hs.clickonAppleItem();
		um.hasTitle("Apple");
		String itemName = "iPod Shuffle";
		ac.addSecondAppleItemToCart();
		um.isVisible(ac.getSucessNotification());
		hs.getCartIcon();
		um.hasSameValue(itemName,ac.getCartListPageAddedItemName().innerText());
	}
	
	//Positive TC - User is able to increase the quantity of item by clicking cart icon of item which is already added into cart
	@Test
	public void validateUserIsAbleToIncreaseItemQuan_ByClickingCartIcon() throws Throwable
	{
		um = new UtilityMethod(page);
		ac = new AddToCartPage(page);
		hs = new HeaderSection(page);
		getLoginIntoTheApplication();
		hs.clickonAppleItem();
		um.hasTitle("Apple");
		String itemName = "iPod Shuffle";
		ac.addSecondAppleItemToCart();
		hs.getCartIcon();
		um.hasSameValue(itemName,ac.getCartListPageAddedItemName().innerText());
		um.hasSameValue("x2", ac.getCartListItemQuantity().innerText());
	}
	
	//Positive TC - User is able to add item to cart from wishlist
	@Test
	public void validateUserIsAbleToAddItemToCart_FromWishlist() throws Throwable
	{
		um = new UtilityMethod(page);
		ac = new AddToCartPage(page);
		hs = new HeaderSection(page);
		getLoginIntoTheApplication();
		hs.clickOnWishListIcon();
		ac.addItemToCartFromWishlist();
		um.isVisible(ac.getSucessNotification());
		hs.getCartIcon();
		um.hasSameValue("iPod Touch",ac.getCartListPageAddedItemName().innerText());
	}
	
	//Positive TC - User is able to remove item from cart
	@Test
	public void validateUserIsAbleToRemoveItemFromCart() throws Throwable
	{
		um = new UtilityMethod(page);
		ac = new AddToCartPage(page);
		hs = new HeaderSection(page);
		getLoginIntoTheApplication();
		page.waitForTimeout(2000);
		hs.getCartIcon();
		ac.clickOnEditCartButton();
		um.hasTitle("Shopping Cart");
		ac.clickOnRemoveItemFromCartButton();
		um.isVisible(ac.getCartEmptyMessage());
	}
	
	//Positive TC-User is able to edit item quantity from cart page
	@Test
	public void validateUserIsAbleToEditItemQuantity_FromCartPage() throws Throwable
	{
		um = new UtilityMethod(page);
		ac = new AddToCartPage(page);
		hs = new HeaderSection(page);
		getLoginIntoTheApplication();
		page.waitForTimeout(2000);
		hs.getCartIcon();
		ac.clickOnEditCartButton();
		um.hasTitle("Shopping Cart");
		ac.editItemQuantity("4");
		um.isVisible(ac.getSuccessModifiedItemQuantityMessage());
	}
	
	public void getLoginIntoTheApplication() throws Throwable
	{
		LoginCommon lc = new LoginCommon();
		lc.loginIntoApplication(page);
	}
}
