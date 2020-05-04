package tests;

import org.testng.annotations.Test;

import pages.DesktopPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;

public class ShoppingCartTest extends TestBase{

	HomePage homeObject;
	DesktopPage desktopObject;
	ProductDetailsPage prodtDetObject;
	ShoppingCartPage shoppingCartObject;

	//Open Show all desktop page from Desktop menu
	@Test(priority = 1,alwaysRun = true)
	public void UserCanOpenShowAllDesktopPage ()  {

		homeObject = new HomePage(driver);
		homeObject.openShowAllDesktop();
	}
	
	//Scroll down the desktop page and open the desired product page
	@Test(dependsOnMethods = {"UserCanOpenShowAllDesktopPage"})
	public void UserCanScroll_openProductPage() throws InterruptedException {

		desktopObject = new DesktopPage(driver);
		desktopObject.openProductPage();
	}
	
	//Scroll down the desktop page and open the desired product page
	@Test(dependsOnMethods = {"UserCanScroll_openProductPage"})
	public void UserCanEnterQty_AddToCart() {
		
		prodtDetObject = new ProductDetailsPage(driver);
		prodtDetObject.enterQty_addToCart();
	}
	
	//Enter quantity and add product to shop cart
	@Test(dependsOnMethods = {"UserCanEnterQty_AddToCart"})
	public void UserCanReviewProductDetails() throws InterruptedException {

		prodtDetObject = new ProductDetailsPage(driver);
		Thread.sleep(5000);
		prodtDetObject.reviewCart();
	}
	
	//Enter quantity and add product to shop cart
	@Test(dependsOnMethods = {"UserCanReviewProductDetails"})
	public void UserCanCheckout() {
		
		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.checkout();
	}
}
