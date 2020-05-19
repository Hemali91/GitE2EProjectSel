package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandindPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavBar extends Base {
	public WebDriver driver;
	private static final Logger logger = LogManager.getLogger(ValidateNavBar.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		logger.info("driver initial");
		driver.get(prop.getProperty("url"));
		logger.info("getting url");
	}

	@Test
	public void baseNavigation() throws IOException {

		// object creation - style 2. create object of class and invoke method
		LandindPage lp = new LandindPage(driver);

		Assert.assertTrue(lp.getNavBar().isDisplayed());
		logger.info("succesfully validated nav bar");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
