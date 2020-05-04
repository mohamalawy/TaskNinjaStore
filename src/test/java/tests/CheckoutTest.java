package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.DesktopPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;

public class CheckoutTest extends TestBase{

	HomePage homeObject;
	DesktopPage desktopObject;
	ProductDetailsPage prodtDetObject;
	ShoppingCartPage shoppingCartObject;
	CheckoutPage checkoutObject;

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

	//User can enter the quantity and add the product to shopping cart
	@Test(dependsOnMethods = {"UserCanScroll_openProductPage"})
	public void UserCanEnterQty_AddToCart() {

		prodtDetObject = new ProductDetailsPage(driver);
		prodtDetObject.enterQty_addToCart();
	}

	//User can review shopping cart
	@Test(dependsOnMethods = {"UserCanEnterQty_AddToCart"})
	public void UserCanReviewProductDetails() throws InterruptedException {

		prodtDetObject = new ProductDetailsPage(driver);
		Thread.sleep(5000);
		prodtDetObject.reviewCart();
	}

	//User can take action to checkout
	@Test(dependsOnMethods = {"UserCanReviewProductDetails"})
	public void UserCanCheckout() {

		shoppingCartObject = new ShoppingCartPage(driver);
		shoppingCartObject.checkout();
	}

	//Enter the mandatory fields to register
	@Test(dependsOnMethods = {"UserCanCheckout"})
	public void UserCanRegisterSuccessfully() throws InterruptedException{

		checkoutObject = new CheckoutPage(driver);
		checkoutObject.userRegisteraterSuccessfully("Mohammad", "Tarek", "test0130@gmail.com", "01098992824", "12345678", "12345678", 
				"10th Dist", "Nasr City", "1111");
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"})
	public void UserCanShippingOrder() throws InterruptedException {
		
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.shippingDeitailsAndMethod();
	}
	
	@Test(dependsOnMethods = {"UserCanShippingOrder"})
	public void UserCnaPayAndConfirmOrder() throws InterruptedException {
		
		checkoutObject = new CheckoutPage(driver);
		checkoutObject.paymentAndConfirmation();
	}

	@Test(dependsOnMethods = {"UserCnaPayAndConfirmOrder"})
	public void UserCanInformedWithOrderSuccess() throws InterruptedException {
		
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("success"));
		checkoutObject.redirectToHomePage();
	}
}
