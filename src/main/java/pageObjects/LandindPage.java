package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandindPage {

	public WebDriver driver;

	By login = By.cssSelector("a[href*='sign_in']");

	By loginPageText = By.cssSelector(".pull-left>h2");

	By naviBar = By.cssSelector(".navigation.clearfix>li>a");

	public LandindPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getLogin() {

		return driver.findElement(login);
	}

	public WebElement getLoginPageTest() {

		return driver.findElement(loginPageText);
	}

	public WebElement getNavBar() {

		return driver.findElement(naviBar);
	}

}
