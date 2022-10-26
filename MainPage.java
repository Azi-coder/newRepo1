package pages;

import io.opentelemetry.internal.shaded.jctools.queues.MessagePassingQueue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver ;
    private By textSelect = By.xpath("//div/input[@aria-label = 'Enter a destination or property']");
    private By selectCity = By.xpath("(//ul/li[@data-element-search-type= '1'])[1]");
    private By date = By.xpath("//div[1]/div[3]/div[2]/div[1]/div/div/span");
    private By secondDate = By.cssSelector("div[aria-label= 'Thu Dec 01 2022']");
    private By type = By.cssSelector("div[data-selenium = 'occupancyBox']");
    private By search = By.cssSelector("button[data-selenium = 'searchButton']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickText(){
        driver.findElement(textSelect).click();
    }
    public void clickCity(){
        driver.findElement(selectCity).click();
    }
    public void clickDate(){

        driver.findElement(date).click();
    }
    public void clickSecondDate(){
        driver.findElement(secondDate).click();
    }
    public void clickType(){
        driver.findElement(type).click();
    }
    public void clickSearch(){
        driver.findElement(search).click();
    }

}
