package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
public class IMDB {

	private WebDriver driver;
	private String url = "https://www.imdb.com/";
	private By search = By.name("q");
	private By title = By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[1]/td[2]/a");

	public IMDB(WebDriver driver) {
		this.driver = driver;
		driver.get(url);
	}

	public IMDBSearchPage search(String movieName) throws InterruptedException {
		driver.findElement(search).sendKeys(movieName);
		driver.findElement(search).sendKeys(Keys.ENTER);
		
		driver.findElement(title).click(); //selecting desired movie from list of search results
		return new IMDBSearchPage(driver);
	}
}
