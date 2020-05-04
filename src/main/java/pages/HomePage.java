package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
	
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}

	@FindBy(linkText="Desktops")
	WebElement DesktopMenu;

	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")
	WebElement ShowAllDesktop;


	public void openShowAllDesktop ()  {

		action.moveToElement(DesktopMenu).moveToElement(ShowAllDesktop).click().build().perform();
	}
}
