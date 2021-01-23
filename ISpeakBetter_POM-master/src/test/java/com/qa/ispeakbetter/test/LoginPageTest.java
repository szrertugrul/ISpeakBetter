package com.qa.ispeakbetter.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.page.HomePage;
import com.qa.ispeakbetter.page.LoginPage;

public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	Properties prop;
	HomePage homePage;
	

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	
	@Test(priority=1, description = "---Clicks on Login Section---")
	public void doclickOnLoginSectionTest() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.clickOnLoginSection();
	}
	
	@Test(priority=2, description="---Tries to login with Invalid Username/Password---")
	public void doInvalidCredentialsTest() {
		loginPage.invalidCredentials(prop.getProperty("invalidUsername"),
				prop.getProperty("invalidPassword"), prop.getProperty("errorMessage"));
		
	}
	@Test(priority=3, description="Tries to login with valid Username/Password")
	public void dovalidCredentialsTest() {
		loginPage.validCredentials(prop.getProperty("validUsername"), 
				prop.getProperty("validPassword"), prop.getProperty("welcomeMessageText"));
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
