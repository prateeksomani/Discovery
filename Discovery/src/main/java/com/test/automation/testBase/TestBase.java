package com.test.automation.testBase;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class TestBase {
	public static ExtentReports extentReports;
	public static ExtentTest test;
	public WebDriver driver;
	String url="http://automationpractice.com/index.php";
	String browser="chrome";
	public static Logger log=Logger.getLogger(TestBase.class.getName());
	static {
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extentReports=new ExtentReports(System.getProperty("user.dir")+"/src/main/java/ExecutionReport/test"+dateFormat.format(calendar.getTime())+".html",false);//false =previous reports will not be deleted
	}
	public void getExecutionResult(ITestResult result) {
		if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(LogStatus.PASS,result.getName(), "test is pass");
		} else if(result.getStatus()==ITestResult.FAILURE) {
			test.log(LogStatus.FAIL,result.getName(), "test is fail");
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(LogStatus.SKIP,result.getName(), "test is SKIP and skip reason is :"+result.getThrowable());
		}else if(result.getStatus()==ITestResult.STARTED) {
			test.log(LogStatus.INFO,result.getName(), "test is started");
		}
	}
	public void init(){
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath="log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}
	public void selectBrowser(String browser){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
		} else if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
	}
	public void getUrl(String url){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		log.info("********* chrome browser launch successfull************");
	}
	@BeforeMethod
	public void beforeMethod(Method method) {
		test=extentReports.startTest(method.getName());
		test.log(LogStatus.INFO, method.getName()+" test started");
	}
	@AfterMethod
	public void afterMethod(ITestResult iTestResult) {
		getExecutionResult(iTestResult);
	}
	@AfterClass(alwaysRun=true)
	public void endtest() {
		extentReports.endTest(test);
		extentReports.flush();
	}
}
