package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesktopPage extends PageBase{

	public DesktopPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}


	@FindBy(linkText = "Sony VAIO")
	WebElement LaptopSonyVaio;

	public void openProductPage() {
		
		jse.executeScript("scrollTo(0,2000)");
		LaptopSonyVaio.click();
	}

}
