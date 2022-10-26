package tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.MainPage;
import pages.ResultPage;

public class BaseTest {
    WebDriver driver;
    protected MainPage mainPage;
    protected ResultPage resultPage;
    @BeforeSuite
    public void setUp(){
    System.setProperty("webdriver.chrome.driver","resources/chromedriver");
    driver = new ChromeDriver();
        driver.get("https://www.agoda.com");
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        resultPage = new ResultPage(driver);

    }
    @AfterSuite
    public void quit(){

    }
}
