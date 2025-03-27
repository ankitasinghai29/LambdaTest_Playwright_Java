package LambdaTest_Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AddToCartPage {
	
	Page page;
	
	public AddToCartPage(Page page)
	{
		this.page = page;
	}
	
	public Locator getCartPopup()
	{
		return page.locator("#cart-total-drawer").first();
	}
	
	public Locator getEmptyListMessage()
	{
	    return page.getByText("Your shopping cart is empty!");
	}
	
	public Locator getSecondAppleItem()
	{
		return page.locator(".lazy-load").nth(6);
	}
	
	public void addSecondAppleItemToCart()
	{
		getSecondAppleItem().hover();
		
		Locator ele = page.locator("div[class='product-thumb-top']").nth(1).locator("div[class='product-action']").locator("button[title='Add to Cart']");
		ele.click();
	}
	
	public Locator getSucessNotification()
	{
		return page.getByText("Success: You have added ");
	}
	
	public Locator getCartListPageAddedItemName()
	{
		Locator ele = page.locator("table[class='table']").locator("tbody").locator("tr").first().locator("td").nth(1).locator("a");
		return ele;
	}

	public Locator getCartListItemQuantity()
	{
		Locator ele = page.locator("table[class='table']").locator("tbody").locator("tr").first().locator("td").nth(2);
		return ele;
	}
	
	public void addItemToCartFromWishlist()
	{
		Locator ele = page.locator("table[class='table table-hover border']").locator("tbody").locator("tr").first().locator("td").nth(5).locator("button");
		ele.click();
	}
	
	public void clickOnEditCartButton()
	{
		page.locator("#entry_217850").locator("a").click();
	}
	
	public void clickOnRemoveItemFromCartButton()
	{
		Locator table = page.locator("//table[@class='table table-bordered']").locator("tbody").locator("tr").locator("td").nth(3);
		table.locator(".input-group-append").locator("button").last().click();
	}
	
	public Locator getCartEmptyMessage()
	{
		return page.getByText("Your shopping cart is empty!").last();
	}
	
	public void editItemQuantity(String num)
	{
		Locator table = page.locator("//table[@class='table table-bordered']").locator("tbody").locator("tr").locator("td").nth(3);
		table.locator("div").locator("input").fill(num);
		table.locator(".input-group-append").locator("button").first().click();
	}
	
	public Locator getSuccessModifiedItemQuantityMessage()
	{
		return page.getByText(" Success: You have modified your shopping cart!");
	}
	
}
