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

public class TestUserWithDataProvide extends Base {

	public WebDriver driver;

	private static final Logger logger = LogManager.getLogger(TestUserWithDataProvide.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
	}

	@Test(dataProvider = "getData")
	public void baseNavigation(String username, String password) throws IOException {

		driver.get(prop.getProperty("url"));

		// object creation - style 2. create object of class and invoke method
		LandindPage lp = new LandindPage(driver);
		lp.getLogin().click();

		LoginPage l = new LoginPage(driver);
		l.getEmail().sendKeys(username);
		l.getPassword().sendKeys(password);
		l.getLogin().click();
		logger.info("succesfully validated entered userdata and id");

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];

		// 0th row
		data[0][0] = "nonrestricted@hbbu.com";
		data[0][1] = "ssjbvvssbv";

		// 1st row
		data[1][0] = "restricted@hbbu.com";
		data[1][1] = "ssjbvvssbv";

		return data;

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
