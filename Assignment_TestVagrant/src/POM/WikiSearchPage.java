package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiSearchPage {
	private By releaseDate = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li");
	private By country = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td");
	private WebDriver driver;
	
	public WikiSearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String releaseDateData() {
		String extract = driver.findElement(releaseDate).getText();
		return extract;
	}
	public String countryData() {
		String extract = driver.findElement(country).getText();
		return extract;
	}

}
