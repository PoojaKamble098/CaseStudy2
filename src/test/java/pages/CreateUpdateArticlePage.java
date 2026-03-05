package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUpdateArticlePage {
	
	WebDriver driver;

	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@FindBy(xpath="//div[text()='Title2']")
	WebElement usernameheader;
	
	@FindBy(linkText ="New Article")
	WebElement lnkNewArticle;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement inpArticleTitle;
	
	@FindBy(xpath="//input[@name='description']")
	WebElement inpArticledescription;
	
	@FindBy(xpath="//textarea[@name='body']")
	WebElement inpArticleBody;
	
	@FindBy(xpath="//input[@name='tags']")
	WebElement inpArticletags;
	
	@FindBy(xpath="//button[text()='Publish Article']")
	WebElement btnPublishArticle;
	
	@FindBy(xpath="//div[text()='Articles not available.']")
	WebElement deleteconfirm;
	
	@FindBy(xpath="//button[text()='Update Article']")
	WebElement Updatearticle;
	
	
	public CreateUpdateArticlePage(WebDriver driver) {

		PageFactory.initElements(driver,this);
	}
	
	public void Newclick() {
		lnkNewArticle.click();
		
	}
	
	public void NewArticle(String Title, String Description, String Body, String Tags) {
		
		inpArticleTitle.clear();
		inpArticleTitle.sendKeys(Title);
		inpArticledescription.sendKeys(Description);
		inpArticleBody.sendKeys(Body);
		inpArticletags.sendKeys(Tags);
		
	}
	
	public void publishclick() {
		btnPublishArticle.click();
		
	}
	
	public void UpdateArticle()
	{
		wait.until(ExpectedConditions.visibilityOf(Updatearticle));
		Updatearticle.click();
		
	}
	
	public boolean DeleteConfirmation()
	{
		wait.until(ExpectedConditions.visibilityOf(deleteconfirm));
		return deleteconfirm.isDisplayed();
		
	}
	
	public boolean Loginconfirmation()
	{
		wait.until(ExpectedConditions.visibilityOf(usernameheader));
		return usernameheader.isDisplayed();
		
	}
}


