package tests;

import org.testng.annotations.Test;

import pages.DesktopPage;
import pages.HomePage;

public class DesktopTest extends TestBase{


	HomePage homeObject;
	DesktopPage desktopObject;

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
}
