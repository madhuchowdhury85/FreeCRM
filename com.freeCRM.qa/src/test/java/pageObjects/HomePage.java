package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Utility;

public class HomePage extends LoginPage {
	
	 public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[contains(text(),'Logout')]") WebElement logoutBtn;
	@FindBy (xpath="//a[text()='Contacts']") WebElement contacts;
	
	public void logoutApp()
	{
		//Utility.switchtoFrame(driver, "mainpanel");
		logoutBtn.click();
	}
	
	public ContactsPage navigatetoContacts()
	{
		Utility.switchtoFrame(driver, "mainpanel");
		Utility.waitforElementVisible(driver, contacts).click();
		return new ContactsPage();
	}

}
