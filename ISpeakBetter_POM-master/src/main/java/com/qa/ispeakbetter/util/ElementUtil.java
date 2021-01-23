package com.qa.ispeakbetter.util;

import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ispeakbetter.base.BasePage;




/**
 * 
 * @author szrertugrul
 *
 */

public class ElementUtil extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil jScriptUtil;
	Properties properties;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
		jScriptUtil = new JavaScriptUtil(driver);
	}

	/**
	 * Title wait method
	 * 
	 * @param title
	 * @return
	 */
	public boolean waitForTitlePresent(String title) {
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}

	/**
	 * wait element to be present
	 * @param locator
	 * @return
	 */
	public boolean waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	/**
	 * 
	 * @param locator
	 * @return
	 */
	public boolean waitForElementVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}

	/**
	 * Get title
	 * 
	 * @return
	 */
	public String doGetPageTitle() {

		try {
			return driver.getTitle();
		} catch (Exception e) {
			System.out.println("Exception occurred while getting the title");
		}
		return null;
	}

	/**
	 * This method is used to create the webElement on the basis of by locator
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		
		WebElement element = null;

		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			if(highlightelement) {
				jScriptUtil.flash(element);
			}
		} catch (Exception e) {
			System.out.println("Exception occurred while creating the web element" + locator);
		}
		return element;
	}

	/**
	 * This method is used to click the webelement on the basis of by locator
	 * 
	 * @param locator
	 */
	public void doClick(By locator) {

		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Exception occurred while clicking the web element");
		}
	}

	/**
	 * This method is used to send value in a field
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {

		try {
			WebElement element = getElement(locator);
			element.clear();
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("Exception occurred while entering values in a field");
		}
	}

	/**
	 * isDisplayed
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsDisplayed(By locator) {

		try {
			return getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Exception occurred in isDisplayed method");
		}
		return false;
	}

	/**
	 * isEnabled
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsEnabled(By locator) {

		try {
			return getElement(locator).isEnabled();
		} catch (Exception e) {
			System.out.println("Exception occurred in isEnabled method");
		}
		return false;
	}

	/**
	 * isSelected
	 * 
	 * @param locator
	 * @return
	 */
	public boolean doIsSelected(By locator) {

		try {
			return getElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("Exception occurred in isSelected method");
		}
		return false;
	}

	/**
	 * GetText()
	 * 
	 * @param locator
	 * @return
	 */
	public String doGetText(By locator) {

		try {
			return getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("Exception occurred while getting text");
		}
		return null;
	}
	/**
	 * This method is used to select dropDown Elements by TEXT
	 * 
	 * @param element
	 * @param value
	 */
	public void selectDropDownValueByText(WebDriver driver,By locator, String value) {
		try {
			waitForElementPresent(locator);
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(value);
		if(highlightelement) {
			jScriptUtil.flash(driver.findElement(locator));
		}
		}catch (Exception e) {
			System.out.println("Exception occurred while selecting by text");
		}
	}

	/**
	 * This method is used to Select by INDEX
	 * 
	 * @param element
	 * @param index
	 */
	public void selectDropDownByIndex(WebDriver driver,By locator, int index) {
		try {
			waitForElementPresent(locator);
			Select select = new Select(driver.findElement(locator));
			select.selectByIndex(index);
			}catch (Exception e) {
				System.out.println("Exception occurred while selecting by index");
			}
	}


}
