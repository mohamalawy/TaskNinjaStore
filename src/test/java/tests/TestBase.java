package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
public static WebDriver driver;
	
	@BeforeSuite
	public void openDriver() {
		
		String chromeDriverPath = System.getProperty("user.dir")+"/WebDrivers/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://tutorialsninja.com/demo/");
	}

	@AfterSuite(enabled = false)
	public void closeDriver() {
		driver.quit();
	}


}
