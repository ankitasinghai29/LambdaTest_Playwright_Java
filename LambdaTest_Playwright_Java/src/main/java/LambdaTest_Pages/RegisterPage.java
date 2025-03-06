package LambdaTest_Pages;

import java.util.HashSet;
import java.util.Random;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class RegisterPage {
	
	Page page;
	public RegisterPage(Page page) 
	{
		this.page = page;
	}
	
	public void clickonContinue()
	{
		page.locator("[value='Continue']").click();
		
	}
	
	
	public Locator isMandatoryWarningMessage() 
	{
		return page.locator(".text-danger");
	}
	
	public Locator warningMessage()
	{
		return page.locator(" //div[contains(.,\"Warning\")]").last();
	}

	public Locator getFirstName()
	{
		return page.locator("#input-firstname");
	}
	
	public Locator getLastName()
	{
		return page.locator("#input-lastname");
	}
	
	public Locator getEmail()
	{
		return page.locator("#input-email");
	}
	
	public Locator getTelephone()
	{
		return page.locator("#input-telephone");
	}
	
	public Locator getPassword()
	{
		return page.locator("#input-password");
	}
	
	public Locator getConfirmPassword()
	{
		return page.locator("#input-confirm");
	}
	
	public Locator getPrivacyPolicy()
	{
		return page.locator(".custom-control-label").last();
	}
	
	public void registerUserAccount(String fname, String lname, String email, String telephone, String password)
	{
		getFirstName().fill(fname);
		getLastName().fill(lname);
	    getEmail().fill(email);
	    getTelephone().fill(telephone);
	    getPassword().fill(password);
	    getConfirmPassword().fill(password);
	    page.locator("#input-newsletter-no").check();
	}
	
	public void registerUserAccountWithPartialData(String fname, String lname, String email, String telephone, String password,int num)
	{
		registerUserAccount(fname, lname, email, telephone, password);
		Random rad = new Random();
		HashSet<Integer> set = new HashSet<Integer>();

        while(set.size()< num) {
            while (set.add(rad.nextInt(1, 5)) != true)
                ;
        }

        if(set.contains(1))
        	getFirstName().clear();
        if(set.contains(2))
        	getLastName().clear();
        if(set.contains(3))
        	getEmail().clear();
        if(set.contains(4))
        	getTelephone().clear();
        if(set.contains(5))
        	getPassword().clear();

	}
}
