package com.Tajawal.Flights.Tajawal_Flights_Automation_Demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseFunctions {
	private final static Logger LOGGER = LoggerFactory.getLogger(BaseFunctions.class); // For
																						// logging.
																						// Enter
																						// current
																						// class
																						// name
	public static WebDriver driver;
	public Properties prop = new Properties();
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
	WebDriverWait wait;
	JavascriptExecutor js;

	public BaseFunctions() {
		try {
			prop.load(new FileInputStream("../Tajawal_Flights_Automation_Demo/resorses/config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String DriverPath = prop.getProperty("firfoxDriverPath");

		System.setProperty("webdriver.gecko.driver", DriverPath);
		if (driver == null) {
			driver = new FirefoxDriver();
		}

		wait = new WebDriverWait(driver, 10);
		js = ((JavascriptExecutor) driver);

	}

	public void sleep(int waitInSeconds) throws InterruptedException {
		Thread.sleep(waitInSeconds * 1000);
	}

	public void closeDriver() {
		driver.quit();
		LOGGER.info("Driver closed");
	}

	public void takeScreenshot(String methodName, boolean isPassed) {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		if (!isPassed) {
			try {
				FileUtils.copyFile(scrFile, new File(("../Tajawal_Flights_Automation_Demo/Screenshots/Fail-Sreenshot/"
						+ methodName + "_" + formater.format(calendar.getTime()) + ".png")));

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (isPassed) {

			try {
				FileUtils.copyFile(scrFile, new File(("../Tajawal_Flights_Automation_Demo/Pass-Screenshots/"
						+ methodName + "_" + formater.format(calendar.getTime()) + ".png")));

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

	public void waitUntillElementVisible(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntillElementInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void waitUntillElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	
	
	
}