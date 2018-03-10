package com.Tajawal.Flights.Tajawal_Flights_Automation_Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeScreen  extends BaseFunctions {

	public Properties prop = new Properties();

	@FindBy(css = "input[name = email]")
	private WebElement usernameTextbox;

	@FindBy(css = "input[name = password]")
	private WebElement passwordTextbox;

	@FindBy(css = ".login_btn")
	private WebElement loginButton;

	@FindBy(css = ".flywheel_icon")
	private WebElement flywheelIcon;

	@FindBy(css = ".loader")
	private WebElement LoginLoader;

	@FindBy(css = ".Select-placeholder")
	private WebElement AssociateViewSearchBar;

	@FindBy(css = ".light_blue")
	private WebElement hiText;

	public HomeScreen() {
		PageFactory.initElements(driver, this);
	}

	public void openUrl() {

		try {
			prop.load(new FileInputStream("../Tajawal_Flights_Automation_Demo/resorses/config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String URL = prop.getProperty("URL");

		driver.get(URL);
	}

}
