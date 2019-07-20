package Discovery.Discovery;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.apache.log4j.Logger;
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

		String strtext=homepage.btnplusfavorites.getText();
		System.out.println(strtext);
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
