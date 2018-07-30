package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import library.Utility;

public class LoginPage extends BaseTest{
	
	public LoginPage()
	
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="username") WebElement userName;
	
	 @FindBy (name="password") WebElement password;
	 
	 @FindBy (xpath="//input[@value='Login']") WebElement loginBtn;
	 
	 public HomePage logintoApp(String uName, String pwd) 
	 {
		 Utility.waitforElementVisible(driver, userName).sendKeys(uName);
		 Utility.waitforElementVisible(driver, password).sendKeys(pwd);
		 Utility.sleep(3);
		 loginBtn.click();
		 		 		 
		 return new HomePage();
	 }

}
