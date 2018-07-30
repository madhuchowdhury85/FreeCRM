package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import factory.DataProviderFactory;
import pageObjects.ContactsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

//@Listeners(listenerPackage.listeners.class)
public class CreateContacts2 extends BaseTest
{
	WebDriver driver;
	LoginPage loginP;
	HomePage homeP;
	ContactsPage contactsP;
	
	
	
	@AfterClass
	public void logOut()
	{
		homeP.logoutApp();
		driver.quit();
		
	}
	
	@Test 
	public void applogin() 
	{
		driver= BaseTest.startBrowser();
		loginP= new LoginPage();
		
		homeP= loginP.logintoApp(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertEquals(12, expected);
		
							
	}
	@Test (dependsOnMethods="applogin")
	public void createContact()
	{
		contactsP= homeP.navigatetoContacts();
		
		contactsP.createContact(DataProviderFactory.getExcel().getstringdata("Contact", 2, 0), 
				DataProviderFactory.getExcel().getstringdata("Contact", 2, 1), 
				DataProviderFactory.getExcel().getstringdata("Contact", 2, 2), 
				(String.valueOf(DataProviderFactory.getExcel().getnumericintdata("Contact", 2, 3))), 
				(String.valueOf(DataProviderFactory.getExcel().getnumericintdata("Contact", 2, 4))));
	}
	
	@Test (dependsOnMethods="createContact")
	public void verifyContact()
	{
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		String excontactname= DataProviderFactory.getExcel().getstringdata("Contact", 2, 0);
		String actualname= contactsP.practicegetname();
		if(actualname.contains(excontactname))
		{System.out.println("Test case passed");}
		
	}
}
