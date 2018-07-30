package unitTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import factory.BrowserFactory;

public class VerifyBrowser 

{
    @Test
	public void verifyStartBrowser()
	{
		WebDriver driver= BrowserFactory.startBrowser(new ConfigDataProvider().getBrowser(),
				new ConfigDataProvider().getApplicationURL());
		Assert.assertFalse(driver==null);
	}
}
