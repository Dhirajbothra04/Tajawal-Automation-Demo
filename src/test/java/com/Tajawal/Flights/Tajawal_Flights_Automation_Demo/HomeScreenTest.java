package com.Tajawal.Flights.Tajawal_Flights_Automation_Demo;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(com.Tajawal.Flights.Tajawal_Flights_Automation_Demo.ListenersMethods.class)
public class HomeScreenTest extends BaseFunctions {

	HomeScreen HS_Obj = new HomeScreen();

	@Test
	public void OpenURL() {
		HS_Obj.openUrl();
	}

	@AfterSuite
	public void closeBrowser() {
		closeDriver();
	}

}