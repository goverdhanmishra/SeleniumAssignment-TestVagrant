package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BaseClass {
	public static WebDriver driver;
	String browser = "chrome";

	@BeforeTest
	public void beforeTest() throws FileNotFoundException, IOException {
		driver = HelperFunctions.startBrowser(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
