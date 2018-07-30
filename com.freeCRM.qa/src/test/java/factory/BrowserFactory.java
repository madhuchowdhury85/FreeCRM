package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory 
{

	public static WebDriver driver;
	
	public BrowserFactory()
	{
		super();
	}
	public static WebDriver  startBrowser(String browserName, String url)
	
	{
		if(browserName.equalsIgnoreCase(new ConfigDataProvider().getBrowser()))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase(""))
		{
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase(""))
		{
			System.setProperty("webdriver.ie.driver", "");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Please provide valid browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(new ConfigDataProvider().getApplicationURL());
		return driver;
	}
	
}
