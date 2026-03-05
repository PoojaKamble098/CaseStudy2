package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Articleactionpage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	@FindBy (xpath ="(//a[text()=' Edit Article'])[1]")
	WebElement edit;
	
	@FindBy (xpath = "(//button[text()=' Delete Article'])[1]")
	WebElement delete;
	
	@FindBy(xpath="//div/h1")
	WebElement articlename;

	public Articleactionpage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	public void editclick() {
		
		wait.until(ExpectedConditions.visibilityOf(edit)).click();;
	}
	
public void deleteclick() {
		
		wait.until(ExpectedConditions.visibilityOf(delete)).click();;
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		
	}
	
public boolean createconfirmation() {
	wait.until(ExpectedConditions.visibilityOf(articlename));
	return articlename.isDisplayed();
	
}
public String articlename() {
	wait.until(ExpectedConditions.visibilityOf(articlename));
	return articlename.getText();

	
}
}
