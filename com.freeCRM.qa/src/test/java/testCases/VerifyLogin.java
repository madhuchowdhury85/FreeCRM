package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.ContactsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class VerifyLogin extends BaseTest
{

	WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	ContactsPage contactsP;
	
	@Test
	public void verifyLogintoApp() 
	{
		driver= BaseTest.startBrowser();
		loginP= new LoginPage();
		
		homeP= loginP.logintoApp(prop.getProperty("username"), prop.getProperty("password"));
		
					
	}
	
	/*@Test
	public void createContact()
	{
		contactsP= homeP.navigatetoContacts();
		contactsP.createContact("madhu", "chowdhury");
	}*/
}
