package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {

			try {
				prop = new Properties();
				fis = new FileInputStream("./src/test/resources/config/config.properties");
				prop.load(fis);
			} catch (IOException e) {

			}

			System.out.println(prop.getProperty("browser"));
			
			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();

			}

		} else if (prop.getProperty("firefox").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		driver.get(prop.getProperty("url"));

	}

	//@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}
}
