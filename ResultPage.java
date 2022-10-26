package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class ResultPage {
    WebDriver driver;
    int count;
    private By controlText = By.cssSelector("a[data-element-value = '0']");
    private By hotelNames = By.xpath("*//div/header/h3");

    private By selection = By.xpath("//ul/li[1]/span/span/span/span[contains(.,'Breakfast')]");

    private  By body = By.cssSelector("div.container-agoda");
    public ResultPage(WebDriver driver){
        this.driver = driver;
    }
    public String getText(){
        return driver.findElement(controlText).getText();
    }
    public int size(){
        return driver.findElements(hotelNames).size();
    }
    public String getHotelNames(int index){
        return driver.findElements(hotelNames).get(index).getText();
    }
    public void click(){
        driver.findElement(hotelNames).click();
    }
    public void clickFilter(){
        driver.findElement(selection).click();
    }
    public void scroll(){
        JavascriptExecutor driver1 = (JavascriptExecutor)driver;
        driver1.executeScript("window.scrollBy(0,100000)");
        //driver1.executeScript("window.scrollBy(0,-100000)");
    }

}
