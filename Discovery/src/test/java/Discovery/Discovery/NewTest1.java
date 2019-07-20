package Discovery.Discovery;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.testBase.TestBase;
import com.test.automation.objectrepo.*;

public class NewTest1 extends TestBase{
	FavouriteList homepage;
	public static Logger log=Logger.getLogger(NewTest1.class.getName());
  @Test
  public void f() {
	  System.out.println("prateek");
	  homepage = new FavouriteList(driver);//initializing driver through pagefactory
	  homepage.lnkmore.click();
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
