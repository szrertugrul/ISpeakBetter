package com.qa.ispeakbetter.test;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.page.HomePage;


public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;

	@BeforeTest
	public void setUp() throws InterruptedException {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
	}
	@Test(priority = 1, description = "---Verifies HomePage Title---")
	public void verifyHomePageTitleTest() {
		homePage = new HomePage(driver);
		homePage.getHomePageTitle(prop.getProperty("homePageTitle"));
	}
	
	@Test(priority = 2, description = " ---Verifies the Header Text---")
	public void verifyHeaderTest() {
		homePage.getHeader(prop.getProperty("homePageHeader"));
	}
	
	@Test(priority = 3, description = "---Click On Support and Get SupportHeader Text---")
	public void doClickOnSupportAndVerifyHeaderTest() {
		homePage.clickOnSupportAndGetHeader(prop.getProperty("supportHeaderText"));
	}
	

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}