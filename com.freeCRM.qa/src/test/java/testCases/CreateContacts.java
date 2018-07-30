package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import factory.DataProviderFactory;
import pageObjects.ContactsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class CreateContacts extends BaseTest
{
	WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	ContactsPage contactsP;
	
	
	
	@AfterMethod
	public void logOut()
	{
		homeP.logoutApp();
		driver.quit();
		
	}
	
	@BeforeMethod
	public void averifyLogintoApp() 
	{
		driver= BaseTest.startBrowser();
		loginP= new LoginPage();
		
		homeP= loginP.logintoApp(prop.getProperty("username"), prop.getProperty("password"));
					
	}
	@Test
	public void createContact()
	{
		contactsP= homeP.navigatetoContacts();
		
		contactsP.createContact(DataProviderFactory.getExcel().getstringdata("Contact", 2, 0), 
				DataProviderFactory.getExcel().getstringdata("Contact", 2, 1), 
				DataProviderFactory.getExcel().getstringdata("Contact", 2, 2), 
				(String.valueOf(DataProviderFactory.getExcel().getnumericintdata("Contact", 2, 3))), 
				(String.valueOf(DataProviderFactory.getExcel().getnumericintdata("Contact", 2, 4))));
	}
}
