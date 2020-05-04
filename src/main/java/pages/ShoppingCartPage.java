package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}

	@FindBy(linkText = "Checkout")
	WebElement CheckoutBtn;
	
	public void checkout() {
		
		jse.executeScript("scrollTo(0,3000)");
		CheckoutBtn.click();
	}
	
}
