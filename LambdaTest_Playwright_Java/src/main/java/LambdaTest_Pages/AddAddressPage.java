package LambdaTest_Pages;

import java.util.List;
import java.util.Random;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class AddAddressPage {
	
	Page page;
	Random rad = new Random();
	
	public AddAddressPage(Page page)
	{
		this.page = page;
	}
	
	public Locator getAddressBookIcon()
	{
		return page.getByText(" Modify your address book entries");
	}
	
	public Locator getNewAddressButton()
	{
		return page.getByText("New Address");
	}
	
	public Locator getFirstName()
	{
		return page.locator("#input-firstname");
	}
	
	public Locator getLastName()
	{
		return page.locator("#input-lastname");
	}
	
	public Locator getAddress1()
	{
		return page.locator("#input-address-1");
	}
	
	public Locator getCity()
	{
		return page.locator("#input-city");
	}
	
	public Locator getPostCode()
	{
		return page.locator("#input-postcode");
	}
	
	public Locator getCountry()
	{
		return page.locator("#input-country");
	}
	
	public Locator getState()
	{
		return page.locator("#input-zone");
	}
	
	public Locator getContinueButton()
	{
		return page.locator("[value='Continue']");
	}
	
	public Locator getWarningMessage()
	{
		return page.locator(".text-danger");
	}
	
	public Locator getNewAddressField(String name)
	{
		Locator row = page.locator("table[class='table table-bordered table-hover']").locator("tbody").locator("tr");
		Locator ele=null;
		int i=0;
		Locator ele1 = row.nth(i).locator("td").first();
		while(ele1!=null)
		{
			if((ele1.innerText()).contains(name))
			{
				ele=ele1;
				break;
			}
			else
			{
				i=i+1;
				ele1 = row.nth(i).locator("td").first();
			}
		}
		return ele;
	}
	
	public String getSelectedState()
	{
		return page.locator("//select[@id='input-zone']/option").nth(15).innerText();
	}
	
	public String getSelectedCountry()
	{
		return page.locator("//select[@id='input-country']/option").nth(106).innerText();
	}
}
