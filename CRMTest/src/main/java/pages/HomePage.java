package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	// Initialize the Page objects
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//td[contains(text(),'VV Vish')]")
	private WebElement header;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	private WebElement contacts;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	private WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	private WebElement tasks;

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactsLink() {
		contacts.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {

		deals.click();
		return new DealsPage();
	}

	public TaskPage clickOnTaskLink() {

		tasks.click();
		return new TaskPage();
	}

}
