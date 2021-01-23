package com.qa.ispeakbetter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.ispeakbetter.util.ElementUtil;

public class HomePage {

	WebDriver driver;
	ElementUtil eUtil;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eUtil = new ElementUtil(driver);
		wait = new WebDriverWait(driver, 10);

	}

	By header = By.className("rsp");
	By supportBtn = By.id("zsiq_agtpic");
	By supportHeader = By.id("attname");

	public void getHomePageTitle(String expectedTitle) {
		String title = eUtil.doGetPageTitle();
		System.out.println("HomePage title is : \n" + title);
		Assert.assertEquals(title, expectedTitle);

	}

	public void getHeader(String expectedHeaderText) {
		String headerText = eUtil.getElement(header).getText();
		System.out.println("HomePage Header is : \n" + headerText);
		Assert.assertEquals(headerText, expectedHeaderText);
	}
	
	public void clickOnSupportAndGetHeader(String expectedSupportHeaderText) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(supportBtn));
		eUtil.getElement(supportBtn).click();
		driver.switchTo().frame(eUtil.getElement(By.id("siqiframe")));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(supportHeader));
		String supportHeaderText = eUtil.getElement(supportHeader).getText();
		System.out.println("Support Header Text is : \n" + supportHeaderText);
		Assert.assertEquals(supportHeaderText, expectedSupportHeaderText);
	}

}
