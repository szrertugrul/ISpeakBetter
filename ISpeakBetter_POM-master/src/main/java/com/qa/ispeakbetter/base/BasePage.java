package com.qa.ispeakbetter.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	public static boolean highlightelement;


	public WebDriver init_driver(String browserName) {
		highlightelement = prop.getProperty("highlight").equals("yes") ? true : false;
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		} else {
			System.out.println("Browser name : " + browserName + " is not FOUND");
		}
		System.out.println("Browser name : " + browserName);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;

	}

	public Properties init_properties() {
		prop = new Properties();
		String path = "/Users/szr/eclipse-workspace/ISpeakBetter_POM/src/main/java/com/qa/ispeakbetter/config/config.properties";

		try {
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Some issue has occured with config properties... Correct the File");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}
