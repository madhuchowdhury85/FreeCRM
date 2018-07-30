package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;

public class VerifyDataProvider 
{

	@Test
	public void verifyConfigData()
	{
		ConfigDataProvider config= new ConfigDataProvider();
		
		Assert.assertEquals(config.getBrowser(), "chrome");
		
		Assert.assertEquals(config.getValuefromConfig("username"), "MadhuC");
		
	}
}
