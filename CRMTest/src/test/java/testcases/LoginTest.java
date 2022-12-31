package testcases;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage login;

	@BeforeClass
	public void beforeClass() {
		login = new LoginPage(driver);
		System.out.println("BeforeClass -- Login Page is initialized");
	}

	@Test
	public void loginTest() throws InterruptedException {

		System.out.println("Login Test started");
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		login.getUsername().clear();
		login.getUsername().sendKeys(prop.getProperty("username"));
		
		login.getPassword().clear();
		login.getPassword().sendKeys(prop.getProperty("password")+Keys.ENTER);
		//login.getLoginBtn().click();

		//Thread.sleep(4000);
		System.out.println("Login Test Passed!!");
	}

}
