package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Wiki {

	private WebDriver driver;
	private String url = "https://en.wikipedia.org/";
	private By search = By.name("search");
	
	public Wiki (WebDriver driver) {
		this.driver = driver;
		driver.get(url);
	}

	public WikiSearchPage search(String movieName) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(search).sendKeys(movieName);
		Thread.sleep(3000);
		driver.findElement(search).sendKeys(Keys.ENTER);
		return new WikiSearchPage(driver);
	}
}
