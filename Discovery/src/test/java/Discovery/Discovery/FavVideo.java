package Discovery.Discovery;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.test.automation.testBase.TestBase;
import com.test.automation.objectrepo.*;

public class FavVideo extends TestBase {
	FavouriteList homepage;
	public static Logger log = Logger.getLogger(FavVideo.class.getName());

	@Test
	public void AddTwoVideos() {
		homepage = new FavouriteList(driver);// initializing driver through pagefactory
												
		homepage.lnkmore.click();
		homepage.lnkmyvideos.click();

		for (String handle : driver.getWindowHandles()) {

			driver.switchTo().window(handle);
		}
		//Take all the recommended videos in list
		List <WebElement> listfav=driver.findElements(By.xpath("//div[@class='my-favorites-button-container']//i[contains(@class,'plus')]"));
		// add tow videos to favourite list
		for(int i=0;i<2;i++)
		{
			WebElement Favshow = listfav.get(i);
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder
				.moveToElement(Favshow)
				.pause(3000)
				.click(Favshow)
				.pause(3000)
				.build();
			seriesOfActions.perform() ;
			
		}
		
	}

	@BeforeTest
	void setup() {
		init();
		log.info("***************initialization done************");
	}

	@AfterMethod
	public void afterMethod() {
	}

}
