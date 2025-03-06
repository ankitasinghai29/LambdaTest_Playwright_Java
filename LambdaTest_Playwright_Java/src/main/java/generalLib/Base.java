package generalLib;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;

import java.nio.file.Paths;
import java.time.LocalDateTime;

import org.testng.annotations.*;

public class Base {

	public Playwright playwright;
	public Browser browser;
	public BrowserContext context;
	public Page page;
	UtilityMethod um;
	Utility uc = new Utility();
	
	
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		playwright = Playwright.create();
		String brow_info = uc.readDataFromPropFile(Constants.BrowserPropFilePath,"browser");
		String headless_info = uc.readDataFromPropFile(Constants.BrowserPropFilePath,"headless");
		BrowserType bt=null;
		if(brow_info.equals("chromium"))
		{
			bt = playwright.chromium();
		}
		else if (brow_info.equals("firefox")) 
		{
			bt = playwright.firefox();
		}
		if(headless_info.equals("false"))
			browser = bt.launch(new LaunchOptions().setHeadless(false));
		else
			browser = bt.launch(new LaunchOptions().setHeadless(true));
	}
	
	@AfterClass
	public void closeBrowser()
	{
		browser.close();
		playwright.close();
	}
	
	@BeforeMethod
	public void OpenContextandPage() throws Throwable
	{
		context = browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("./videos/")));
		page = context.newPage();
		String url = uc.readDataFromPropFile(Constants.apppropFilePath, "url");
		String home_title = uc.readDataFromPropFile(Constants.apppropFilePath,"HomeTitle");
		page.navigate(url);
		um = new UtilityMethod(page);
		um.hasTitle(home_title);
	}
	
	@AfterMethod
	public void closeContextandPage()
	{
		LocalDateTime localDateTime = LocalDateTime.now();
		String name = localDateTime.toString().replace(":", "-");
		um.takeScreenshot(name);
		page.close();
	}	
	
}
