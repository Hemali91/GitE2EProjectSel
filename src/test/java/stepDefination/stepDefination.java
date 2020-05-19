package stepDefination;

import cucumber.api.java.en.Given;
import java.util.concurrent.TimeUnit;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import pageObjects.LandindPage;
import pageObjects.LoginPage;
import resources.Base;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class stepDefination extends Base {

	public WebDriver driver;
	public static LandindPage lp;
	String actualText;
	String expectedText = "Featured Courses";
	WebElement navBar;
	public static LoginPage l;
	String loginFailText;
	String loginText;

	@Given("^webpage link is given$")
	public void webpage_link_is_given() throws Throwable {

		driver = initializeBrowser();

		driver.get(prop.getProperty("url"));
	}

	@When("^search for home page text$")
	public void search_for_home_page_text() throws Throwable {

		lp = new LandindPage(driver);

		actualText = lp.getLoginPageTest().getText();
	}

	@Then("^validate the text matches with home page text or not$")
	public void validate_the_text_matches_with_home_page_text_or_not() throws Throwable {

		Assert.assertEquals(actualText, expectedText);

	}

	@Then("^close driver$")
	public void close_driver() throws Throwable {

		driver.close();
	}

	@When("^search for navigation bar$")
	public void search_for_navigation_bar() throws Throwable {

		lp = new LandindPage(driver);

		lp.getNavBar();
		// System.out.println(navBar.toString());

	}

	@Then("^validate navigation bar is present or not$")
	public void validate_navigation_bar_is_present_or_not() throws Throwable {

		Assert.assertTrue(lp.getNavBar().isDisplayed());
	}

	// @Given("^user is on login page$")
	// public void user_is_on_login_page() throws Throwable {
	// lp = new LandindPage(driver);
	// lp.getLogin().click();
	//
	// }

	@When("^user login into application with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_login_into_application_with_and(String email, String password) throws Throwable {

		System.out.println(email + " , " + password);
		lp = new LandindPage(driver);
		lp.getLogin().click();
		l = new LoginPage(driver);
		l.getEmail().sendKeys(email);
		l.getPassword().sendKeys(password);
		l.getLogin().click();

	}

	@Then("^login should fail and validate login fail text$")
	public void login_should_fail_and_validate_login_fail_text() throws Throwable {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		loginFailText = l.getLoginFailText().getText();
		System.out.println("invalid login text: " + loginFailText);
		Assert.assertEquals(loginFailText, "Invalid email or password.");

	}

	@Then("^validate login page text$")
	public void validate_login_page_text() throws Throwable {
		
		loginText = l.getLoginText().getText();
		System.out.println("login text: " + loginText);
		Assert.assertEquals(loginText, "Log In to Rahul Shetty Academy");

	}

}