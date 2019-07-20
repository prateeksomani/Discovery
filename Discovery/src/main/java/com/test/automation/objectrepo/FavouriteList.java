package com.test.automation.objectrepo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.test.automation.testBase.TestBase;

public class FavouriteList {
	WebDriver driver;
	public static Logger log = Logger.getLogger(FavouriteList.class.getName());

	public FavouriteList(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'More')]")
	public WebElement lnkmore;

	@FindBy(xpath = "//a[contains(text(),'My Videos')]")
	public WebElement lnkmyvideos;

	@FindBy(xpath = "//div[@class='my-favorites-button-container']//i[contains(@class,'plus')]")
	public WebElement btnplusfavorites;
	
	@FindBy(xpath = "//div[@class='showTileSquare__content']")
	public WebElement show;
	
	@FindBy(xpath="//div[@class='thumbnailTile__titleLineClamp']")
	public WebElement videotitle;
}
