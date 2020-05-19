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

public class ValidateTitle extends Base {

	public WebDriver driver;
	private static final Logger logger = LogManager.getLogger(ValidateTitle.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();

		driver.get(prop.getProperty("url"));
	}

	@Test
	public void baseNavigation() throws IOException {

		// object creation - style 1. to inherete base class

		// object creation - style 2. create object of class and invoke method
		LandindPage lp = new LandindPage(driver);

		System.out.println(lp.getLoginPageTest().getText());

		Assert.assertEquals(lp.getLoginPageTest().getText(), "Featured Courses");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
