package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {

		prop = new Properties();
		
		// to give project path dynamically use System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		
		
//		for only one user
//		FileInputStream fis = new FileInputStream(
//				"C:\\Users\\Rohan\\workspace\\E2EFramework\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		
		// to run from mvn dynamically   use cmd command as : "mvn test -Dbrowser=chrome"
		String browserName = System.getProperty("browser");

		// to run with proprties file
//		String browserName = prop.getProperty("browser");

		System.out.println(browserName);

		if (browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rohan\\workspace\\chromedriver.exe");
			// to make head less 
			ChromeOptions options = new ChromeOptions();
			
			if (browserName.contains("chromeheadless")) {
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);

		}

		else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rohan\\workspace\\geckodriver.exe");

			driver = new FirefoxDriver();

		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	}

}
