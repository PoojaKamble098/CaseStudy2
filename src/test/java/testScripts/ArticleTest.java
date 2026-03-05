package testScripts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BasePage;
import pages.Articleactionpage;
import pages.CreateUpdateArticlePage;
import pages.LoginPage;


public class ArticleTest {
	WebDriver driver;
WebDriverWait wait;	
	LoginPage loginpage;
	Articleactionpage articleactionpage;
	CreateUpdateArticlePage createupdatearticlepage;
	
	
	@BeforeClass
	
	public void setup() {
		BasePage.initDriver();
		driver = BasePage.getdriver();
		BasePage.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
		loginpage=new LoginPage(driver);
		articleactionpage =new Articleactionpage(driver);
		createupdatearticlepage = new CreateUpdateArticlePage(driver);
		
	}
		
		@Test(priority =1)
		
		public void loginTest() {
			loginpage.LoginintoApp2("Pooja123@gmail.com", "Pooja123");
			Assert.assertTrue(createupdatearticlepage.Loginconfirmation());
		}
		
		
		@Test(priority =2)
		
		public void createArticleTest() {
			createupdatearticlepage.Newclick();
			createupdatearticlepage.NewArticle ("Title2","Desc1","Body1","Tags1");
			createupdatearticlepage.publishclick();
			Assert.assertEquals(articleactionpage.articlename(),"Title2");
			
		}
		
		
		@Test(priority =3)
		
		public void editArticleTest() {
			
			articleactionpage.editclick();
			createupdatearticlepage.NewArticle("UpdatedTitle2","Desc1","Body1","Tags1");		
			createupdatearticlepage.UpdateArticle();
			Assert.assertEquals(articleactionpage.articlename(), "UpdatedTitle2");
			
		}
		
		@Test(priority =4)
		
		public void deleteArticleTest() {
			articleactionpage.deleteclick();
			Assert.assertTrue(createupdatearticlepage.DeleteConfirmation());
			
			
		}
		
		@AfterTest
		
		public void closeApp()
		{
			BasePage.tearDown();
		}
}
		