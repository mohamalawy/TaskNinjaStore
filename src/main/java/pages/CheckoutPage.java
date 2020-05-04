package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
	}

	@FindBy(id = "button-account")
	WebElement ContinueBtn;

	@FindBy(id = "input-payment-firstname")
	WebElement fnTextbox;

	@FindBy(id = "input-payment-lastname")
	WebElement lnTextbox;

	@FindBy(id = "input-payment-email")
	WebElement emailTextbox;

	@FindBy(id = "input-payment-telephone")
	WebElement telTextbox;

	@FindBy(id = "input-payment-password")
	WebElement passwordTextbox;

	@FindBy(id = "input-payment-confirm")
	WebElement confpasswordTextbox;

	@FindBy(id = "input-payment-address-1")
	WebElement addressTextbox;

	@FindBy(id = "input-payment-city")
	WebElement cityTextbox;

	@FindBy(id = "input-payment-postcode")
	WebElement postalcodeTextbox;

	@FindBy(xpath = "//*[@id=\"input-payment-country\"]")
	WebElement countryDropdownlist;

	@FindBy(xpath = "//*[@id=\"input-payment-zone\"]")
	WebElement stateDropdownlist;

	@FindBy(name = "agree")
	WebElement regAgreementCheckbox;

	@FindBy(id = "button-register")
	WebElement registercontBtn;

	@FindBy(xpath = "//*[@id=\"button-shipping-address\"]")
	WebElement deliveryDetailsBtn;
	
	@FindBy(id = "button-shipping-method")
	WebElement deliveryMethodBtn;
	
	@FindBy(name = "agree")
	WebElement payAgreementCheckbox;
	
	@FindBy(id = "button-payment-method")
	WebElement payContinueBtn;
	
	@FindBy(id = "button-confirm")
	WebElement confirmBtn;
	
	@FindBy(linkText = "Continue")
	WebElement lastcontinueBtn;
	
	@FindBy(linkText = "My Account")
	WebElement myaccountList;
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	


	public void userRegisteraterSuccessfully(String FirstName, String LastName, String Email, String Telepnhone, String Password,
			String ConfirmPassword, String Adress, String City, String PostalCode) throws InterruptedException {

		ContinueBtn.click();

		Thread.sleep(3000);
		jse.executeScript("scrollTo(0,488)");

		fnTextbox.sendKeys(FirstName);
		lnTextbox.sendKeys(LastName);
		emailTextbox.sendKeys(Email);
		telTextbox.sendKeys(Telepnhone);
		passwordTextbox.sendKeys(Password);
		confpasswordTextbox.sendKeys(ConfirmPassword);
		addressTextbox.sendKeys(Adress);
		cityTextbox.sendKeys(City);
		postalcodeTextbox.sendKeys(PostalCode);

		select = new Select(countryDropdownlist);
		Thread.sleep(3000);
		select.selectByValue("63");
		Thread.sleep(3000);
		select = new Select(stateDropdownlist);
		select.selectByValue("1011");
		
		Thread.sleep(3000);
		regAgreementCheckbox.click();
		Thread.sleep(3000);
		registercontBtn.click();

	}
	
	public void shippingDeitailsAndMethod() throws InterruptedException {
		Thread.sleep(3000);
		deliveryDetailsBtn.click();
		Thread.sleep(3000);
		deliveryMethodBtn.click();
	}
	
	
	public void paymentAndConfirmation() throws InterruptedException {
		
		Thread.sleep(3000);
		payAgreementCheckbox.click();
		Thread.sleep(3000);
		payContinueBtn.click();
		Thread.sleep(3000);
		confirmBtn.click();
	}
	
	public void redirectToHomePage() {
		
		lastcontinueBtn.click();
	}
	
	public void logout() throws InterruptedException {
		myaccountList.click();
		Thread.sleep(2000);
		logout.click();
	}
}
