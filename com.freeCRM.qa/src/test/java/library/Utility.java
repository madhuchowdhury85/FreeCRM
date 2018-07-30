package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{

	public static WebElement waitforElementVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public static void  sleep(int time)
	{
		try {
			Thread.sleep(time*1000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void switchtoFrame(WebDriver driver, String idOrName )
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
		
	}
	
	public static void selectByDropDown( WebDriver driver,WebElement element, Object value )
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
		Select dropdown= new Select(element);
		dropdown.selectByVisibleText((String)value);		
		
	}
	
}
