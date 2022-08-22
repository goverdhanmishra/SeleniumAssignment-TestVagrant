package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IMDBSearchPage {
	private By releaseDate = By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[1]/div/ul/li/a");
	private By country = By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[9]/div[2]/ul/li[2]/div/ul/li/a");
	private WebDriver driver;
	
	public IMDBSearchPage(WebDriver driver) {
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
