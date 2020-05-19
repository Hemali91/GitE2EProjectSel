package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObjects.LandindPage;
import resources.Base;



public class HomePage extends Base {

	public WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();

		driver.get(prop.getProperty("url"));
	}

	@Test
	public void baseNavigation() throws IOException {

		// object creation - style 2. create object of class and invoke method
		LandindPage lp = new LandindPage(driver);
		lp.getLogin().click();
//		logger.info("succesfully landed on homepage");

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
