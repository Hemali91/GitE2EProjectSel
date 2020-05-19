package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public  WebDriver driver;

	 By userEmail = By.id("user_email");
	 By userPassword = By.id("user_password");
	 By logIn = By.cssSelector("input[name='commit']");
	 By logInText = By.cssSelector(".content-box>h1");
	 By logInFailText = By.xpath("//div[@class='content-box']/div/div/div");
	 

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public  WebElement getEmail() {

		return driver.findElement(userEmail);
	}

	public  WebElement getPassword() {

		return driver.findElement(userPassword);
	}
	
	public  WebElement getLogin() {

		return driver.findElement(logIn);
	}
	
	public  WebElement getLoginFailText() {

		return driver.findElement(logInFailText);
	}
	
	public  WebElement getLoginText() {

		return driver.findElement(logInText);
	}

}
