package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage login;
	HomePage home;

	@BeforeClass
	public void beforeClass() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}

	@Test(priority = 0)
	public void loginTest() {
		login.getUsername().sendKeys(prop.getProperty("username"));
		login.getPassword().sendKeys(prop.getProperty("password"));
		login.getLoginBtn().click();

	}

	@Test(priority = 1, dependsOnMethods = "loginTest")
	public void navigateToContactsPageTest() {

		ContactsPage contacts = home.clickOnContactsLink();
		System.out.println(driver.getTitle());
		System.out.println("navigateToContactsPageTest passed");
	}

}
