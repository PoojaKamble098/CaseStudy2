package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	
	@FindBy (linkText = "Login")
	WebElement lnkLogin;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement inpEmail;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement inpPassword;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement btnLogin;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void LoginintoApp2(String Email, String Password) {
		lnkLogin.click();
		inpEmail.sendKeys(Email);
		inpPassword.sendKeys(Password);
		btnLogin.click();
		
		
	}

}
