package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperFunctions {
	static String chromeKey = "webdriver.chrome.driver";
	static String geckoKey = "webdriver.chrome.driver";
	static String chromeDriverPath = ".\\drivers\\chromedriver.exe";
	static String firefoxDriverPath = ".\\drivers\\geckodriver.exe";

	public static WebDriver startBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(chromeKey, chromeDriverPath);
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-notifications");
			return new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(geckoKey, firefoxDriverPath);
			return new FirefoxDriver();
		} else
			return null;
	}
}
