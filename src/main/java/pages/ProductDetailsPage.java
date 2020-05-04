package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id = "input-quantity")
	WebElement QtyTextBox;

	@FindBy(id = "button-cart")
	WebElement AddToCartBtn;

	@FindBy(xpath = "//*[@id=\"cart\"]/button")
	WebElement ShoppingCart;

	@FindBy(xpath= "//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
	WebElement ViewCart;

	public void enterQty_addToCart() {

		QtyTextBox.clear();
		QtyTextBox.sendKeys("2");
		AddToCartBtn.click();
	}

	public void reviewCart() {

		ShoppingCart.click();
		ViewCart.click();
	}

}
