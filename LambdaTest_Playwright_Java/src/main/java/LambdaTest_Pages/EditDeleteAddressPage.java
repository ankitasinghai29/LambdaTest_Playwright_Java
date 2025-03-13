package LambdaTest_Pages;

import java.util.Random;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class EditDeleteAddressPage {
	Page page;
	Random rad = new Random();
	
	public EditDeleteAddressPage(Page page)
	{
		this.page = page;
	}
	public Locator getAddressBookIcon()
	{
		return page.getByText(" Modify your address book entries");
	}
	
	public Locator getSingleAddressField()
	{
		Locator row = page.locator("table[class='table table-bordered table-hover']").locator("tbody").locator("tr").locator("td");
		return row.last().getByText("Delete");
	}
	
	public Locator getAddressField(String name)
	{
		Locator row = page.locator("table[class='table table-bordered table-hover']").locator("tbody").locator("tr");
		Locator ele=null;
		int i=0;
		Locator ele1 = row.nth(i).locator("td");
		while(ele1!=null)
		{
			if((ele1.first().innerText()).contains(name))
			{
				ele=ele1;
				break;
			}
			else
			{
				i=i+1;
				ele1 = row.nth(i).locator("td");
			}
		}
		return ele;
	}
	
	public Locator getEditButton(String name)
	{
		Locator element = getAddressField(name);
		return element.last().getByText("Edit");
	}
	
	public Locator getDeleteButton(String name)
	{
		Locator element = getAddressField(name);
		return element.last().getByText("Delete");
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
	
	public Locator getSuccessDeleteMessage()
	{
		return page.getByText(" Your address has been successfully deleted");
	}
	
	public Locator getSuccessEditMessage()
	{
		return page.getByText(" Your address has been successfully updated");
	}
	
	public String getSelectedState()
	{
		return page.locator("//select[@id='input-zone']/option").nth(15).innerText();
	}
	
	public String getSelectedCountry()
	{
		return page.locator("//select[@id='input-country']/option").nth(106).innerText();
	}
	
	public Locator getWarningMessage()
	{
		return page.locator(".text-danger");
	}
	
	public Locator getWarningDeletionMessage()
	{
		return page.getByText(" Warning: You must have at least one address!");
	}
}
