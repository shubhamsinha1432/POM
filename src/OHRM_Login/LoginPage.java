package OHRM_Login;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginButton;
	
	
	public void login(String Username,String Password)
	{
		username.sendKeys(Username);
		username.clear();
		password.sendKeys(Password);
		password.clear();
		loginButton.click();
		
	}
	

}
