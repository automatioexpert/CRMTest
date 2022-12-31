package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name= "password")
	private WebElement password;

	@FindBy(css  = "input[value='Login']")
	private WebElement loginBtn;

	public WebElement getUsername() {
		return username;

	}
	
	public WebElement getPassword() {
		
		return password;
	}

	public WebElement getLoginBtn()
	{
		return loginBtn;
		
	}
	
	
	
	
	
}
