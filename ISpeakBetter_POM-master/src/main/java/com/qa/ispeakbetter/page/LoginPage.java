package com.qa.ispeakbetter.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.ispeakbetter.util.ElementUtil;

public class LoginPage {
	WebDriver driver;
	ElementUtil eUtil;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eUtil = new ElementUtil(driver);
		wait = new WebDriverWait(driver, 10);
	}

	By loginSection = By.id("cmdSiginLink");
	By username = By.id("_email");
	By password = By.id("_password");
	By loginBtn = By.id("cmdSignin");
	By errorMessage = By.id("crendentialsError");
	By welcomeMessage = By.id("dashboard_goodday");
	

	public void clickOnLoginSection() throws InterruptedException {

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loginSection));
		eUtil.getElement(loginSection).click();;
	}

	public void invalidCredentials(String invalidUsername, String invalidPassword, String expectedErrorMessageText) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(username));
		eUtil.doSendKeys(username, invalidUsername);
		eUtil.doSendKeys(password, invalidPassword);
		eUtil.doClick(loginBtn);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(errorMessage));
		String errorMessageText = eUtil.getElement(errorMessage).getText();
		System.out.println("Error Message is : \n" +errorMessageText);
		Assert.assertEquals(errorMessageText, expectedErrorMessageText);

	}
	
	public void validCredentials(String validUsername, String validPassword, String expectedWelcomeMessageText) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(username));
		eUtil.doSendKeys(username, validUsername);
		eUtil.doSendKeys(password, validPassword);
		eUtil.doClick(loginBtn);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(welcomeMessage));
		String welcomeMessageText = eUtil.getElement(welcomeMessage).getText();
		System.out.println(welcomeMessageText);
		Assert.assertEquals(welcomeMessageText, expectedWelcomeMessageText);

	}


}
