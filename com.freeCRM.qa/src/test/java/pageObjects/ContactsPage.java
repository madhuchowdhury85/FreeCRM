package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import library.Utility;

public class ContactsPage extends HomePage
{

	public ContactsPage()
	
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//a[text()='Contacts']") WebElement contacts;
	
	@FindBy (xpath="//a[text()='New Contact']") WebElement newContacts;
	
	@FindBy (name="title") WebElement title;
	@FindBy (id="first_name") WebElement firstName;
	@FindBy (id="surname") WebElement lastName;
	@FindBy (id="company_position") WebElement comPosition;
	@FindBy (name="mobile") WebElement mobile;
	@FindBy (name="im_id") WebElement messengerID;
	@FindBy (name="contact_lookup_ref") WebElement referredByTxt;
	@FindBy (xpath="//input[@value='Lookup']") WebElement referredByLookUp;
	@FindBy (xpath="//img[@title='Date selector']") WebElement dateCal;
	//@FindBys (xpath="//div[@class='calendar']//tr[@class='daysrow']//td[not(contains(@class, 'day wn'))]") WebElement calData;
	@FindBy (xpath="//input[@type='button' and @value='Load From Company']//following::input[1]")
	WebElement saveBTN;
	
	@FindBy (xpath="//form[@id='vContactsForm']//tr[4]//td//a[last()]")
	WebElement practice_name;
	
	public void createContact(String fName, String lName, String comP, String mob, String msgID)
	{
		//Utility.switchtoFrame(driver, "mainpanel");
		
		String name= "madhurima";
		Actions act= new Actions(driver);
		act.moveToElement(contacts).pause(3000).moveToElement(newContacts).click().build().perform();
			
		Utility.selectByDropDown(driver, title, "Mrs.");
		Utility.waitforElementVisible(driver, firstName).sendKeys(fName);
		Utility.waitforElementVisible(driver, lastName).sendKeys(lName);
		Utility.waitforElementVisible(driver, comPosition).sendKeys(comP);
			
		Utility.waitforElementVisible(driver, mobile).sendKeys(mob);
		Utility.waitforElementVisible(driver, messengerID).sendKeys(msgID);
		
		Utility.waitforElementVisible(driver, dateCal).click();
		List<WebElement> dates= driver.findElements(By.xpath("//div[@class='calendar']//tr[@class='daysrow']"
				+ "//td[not(contains(@class,'day wn'))]"));
		for(int i=0; i<dates.size();i++)
		{
			if (dates.get(i).getText().equals("21"))
			{
				dates.get(i).click();
			}
		}
		
		Utility.waitforElementVisible(driver, saveBTN).click();
	}
	
	public String practicegetname()
	{
		return practice_name.getText();
	}


		
	
}
