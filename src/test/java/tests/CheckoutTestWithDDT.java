package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.DesktopPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ShoppingCartPage;

public class CheckoutTestWithDDT extends TestBase{

	HomePage homeObject;
	DesktopPage desktopObject;
	ProductDetailsPage prodtDetObject;
	ShoppingCartPage shoppingCartObject;
	CheckoutPage checkoutObject;


	@DataProvider(name = "testData")
	public static Object [] [] userData(){

		return new Object [] [] {
			
			{"Mohammad", "Tarek", "test209@gmail.com", "01098992824", "12345678", "12345678", "10th Dist", "Nasr City", "1111"},
			{"Mohammad", "Tarek", "test2010@gmail.com", "01098992824", "12345678", "12345678", "10th Dist", "Nasr City", "1111"},
		};
	}

	//Enter the mandatory fields to register and set delivering an payment details and methods and confirmation order
	@Test(priority = 1, dataProvider="testData")
	public void UserCanRegisterAndConfirmationSteps(String firstName, String lastName, String email, String telephone, 
			String password, String confirmPassword, String address, String city, String postalCode) throws InterruptedException{
		
		//Open Desktop Page
		homeObject = new HomePage(driver);
		homeObject.openShowAllDesktop();
		
		//Scroll down the page and select the product
		desktopObject = new DesktopPage(driver);
		desktopObject.openProductPage();
		
		//User enter the quantity and add the product to shopping cart
		prodtDetObject = new ProductDetailsPage(driver);
		prodtDetObject.enterQty_addToCart();
		
		//User can review the cart shopping details
		prodtDetObject = new ProductDetailsPage(driver);
		Thread.sleep(5000);
		prodtDetObject.reviewCart();
		
		//User can take action to checkout
		shoppingCartObject = new ShoppingCartPage(driver);
		Thread.sleep(2000);
		shoppingCartObject.checkout();
		
		//User can register and complete checkout
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(2000);
		checkoutObject.userRegisteraterSuccessfully(firstName, lastName, email, telephone, password, confirmPassword, 
				address, city, postalCode);
		
		//User set shipping details and method
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(2000);
		checkoutObject.shippingDeitailsAndMethod();
		
		//User set the payment method and confirm order
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(2000);
		checkoutObject.paymentAndConfirmation();
		
		//Assert that the order is placed and redirect to home page
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().contains("success"));
		Thread.sleep(3000);
		checkoutObject.redirectToHomePage();
		
		//Logout of account
		checkoutObject = new CheckoutPage(driver);
		Thread.sleep(2000);
		checkoutObject.logout();
	}
}
