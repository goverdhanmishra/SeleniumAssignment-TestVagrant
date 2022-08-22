/*
 * 22-Aug-2022
 * @Author: Goverdhan Mishra
 * Email: goverdhan.mishra.dbg@gmail.com
 */
package Runner;

import POM.IMDB;
import POM.IMDBSearchPage;
import POM.Wiki;
import POM.WikiSearchPage;
import utils.BaseClass;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class TestRunner extends BaseClass {
	
	//Initialization of webpage classes
	IMDB imdb;
	IMDBSearchPage imdbsp;
	Wiki wiki;
	WikiSearchPage wikisp;
	
	//Storing extracted data
	String extractedDateIMDB, extractedCountryIMDB, extractedDateWiki, extractedCountryWiki;
	
	//Test data (moviename)
	String movieName = "Pushpa: The Rise";
	
	@Test(priority = 1)
	public void dataExtraction() throws InterruptedException {
		//Navigating to IMDB Website
		System.out.println("---- Navigating to IMDB Website ----");
		imdb = new IMDB(driver);
		imdbsp = imdb.search(movieName);
		
		extractedDateIMDB = imdbsp.releaseDateData();
		extractedCountryIMDB = imdbsp.countryData();
		
		System.out.println("IMDB Data:");
		System.out.println("\t" + extractedDateIMDB);
		System.out.println("\t" + extractedCountryIMDB);
		
		//Navigating to Wikipedia website
		System.out.println("---- Navigating to Wikipedia Website ----");
		wiki = new Wiki(driver);
		wikisp = wiki.search(movieName);
		extractedDateWiki = wikisp.releaseDateData();
		extractedCountryWiki = wikisp.countryData();
		
		System.out.println("Wikipedia Data:");
		System.out.println("\t" + extractedDateWiki);
		System.out.println("\t" + extractedCountryWiki);
	}
	
	@Test(priority = 2)
	public void matchCountryOfOrigin() {
		Assert.assertTrue(extractedCountryIMDB.matches(extractedCountryWiki));
	}
	
	@Test(priority = 2)
	public void matchReleaseDate() {
		Assert.assertTrue(extractedDateIMDB.matches(extractedDateWiki));
	}

}