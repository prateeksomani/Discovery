package Discovery.Discovery;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

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
		log.info("***************add videos to favourite ************");
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
		
		//assertion of video title and description
		List <WebElement> lstvideotitle=driver.findElements(By.xpath("//div[@class='thumbnailTile__titleLineClamp']"));
		List <WebElement> lstvideodesc=driver.findElements(By.xpath("//div[@class='overlayInner__overlayDescription description']"));
		
		for(WebElement videotit:lstvideotitle)
			
		{    //String actualTitle="FAST N' LOUD";   // we can parametrize this using excel and poi
			  String videotitl = videotit.getText();       // get one by one video title
			 //Assert.assertEquals(videotitl, actualTitle); //Validate video title
			 
		}
		
		for(WebElement videodec:lstvideodesc)
		{
			 String videodesc = videodec.getText();
				//System.out.println(videodesc);
		}
		
		log.info("***************assert functionality************");
		String videotl= homepage.videotitle.getText();
		String actualTitle="FAST N' LOUD";
		Assert.assertEquals(videotl, actualTitle);
		
		
		
	}

	@BeforeTest
	void setup() {
		// Launching discovery.com
		init();
		log.info("***************initialization done************");
	}

	@AfterTest
	void endTest() {
		log.info("*******closing browser******");
		driver.quit();
	}

}
