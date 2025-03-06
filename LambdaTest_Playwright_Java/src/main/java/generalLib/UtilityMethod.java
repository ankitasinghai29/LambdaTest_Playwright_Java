package generalLib;

import java.nio.file.Paths;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UtilityMethod {
	
	Page page;
	
	public UtilityMethod(Page page)
	{
		this.page = page;
	}
	
	public void takeScreenshot(String name)
	{
		ScreenshotOptions screenshot = new ScreenshotOptions();
		String path = "./Screenshots/"+name+".png";
		page.screenshot(screenshot.setFullPage(true).setPath(Paths.get(path)));
	}
	
	public void isVisible(Locator ele)
	{
		assertThat(ele).isVisible();
	}
	
	public void hasText(Locator ele,String value)
	{
		assertThat(ele).hasText(value);
	}
	
	public void hasTitle(String title)
	{
		assertThat(page).hasTitle(title);
	}
	
	public void hasCount(Locator ele,int count)
	{
		assertThat(ele).hasCount(count);
	}

	public void isHighlighted(Locator ele)
	{
		assertThat(ele).hasCSS("background-color", "rgb(14, 186, 197)");
	}
}
