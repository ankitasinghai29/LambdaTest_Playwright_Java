package LambdaTest_Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class WishListPage {
	
	Page page;
	
	public WishListPage(Page page) 
	{
		this.page = page;
	}
	
	public Locator getFirstAppleItemName()
	{
		Locator ele = page.locator("[class='product-thumb']").first();
		return ele.locator("[class='caption']").locator("h4 a");
	}
	
	public Locator getWishlistPageAddedItemName()
	{
		Locator ele = page.locator("table[class='table table-hover border']").locator("tbody").locator("tr").first().locator("td").nth(1).locator("a");
		return ele;
	}
	
	public void clickOnRemoveItemFromWishlistPage()
	{
		Locator ele = page.locator("table[class='table table-hover border']").locator("tbody").locator("tr").first().locator("td").nth(5).locator("a").locator("i");
		ele.click();
	}
	
	public Locator getFirstAppleItem()
	{
		return page.locator(".lazy-load").first();
	}
	
	public void clickOnWishlistIconOfItem()
	{
		page.locator("//button[@title='Add to Wish List']/i[2]").first().click();
		page.waitForTimeout(5000);
	}
	
	public void clickOnDeselectWishlistIcon()
	{
		page.locator("//button[@title='Remove']/i").first().click();
		page.waitForTimeout(5000);
	}
	
	public Locator emptyWishlistMessage()
	{
		return page.getByText("No results!");
	}
	
	public void addItemToWishList()
	{
		getFirstAppleItem().hover();
		
		Locator ele = page.locator("div[class='product-thumb-top']").first().locator("div[class='product-action']").locator("button[title='Add to Wish List']");
		ele.click();
	}
	
	public Locator getSucessNotification()
	{
		return page.getByText("Success: You have added ");
	}
	
	public Locator getSuccessUpdateWishlistMessage()
	{
		return page.getByText(" Success: You have modified your wish list!");
	}
	
	public Locator getLoginRegisterNotification()
	{
		return page.locator("#notification-box-top");
	}

}
