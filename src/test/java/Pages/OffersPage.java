package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    public WebDriver driver;
    By search=By.xpath("//input[@type='search']");
    By productName=By.xpath("//table//tr/td[1]");

    public OffersPage(WebDriver driver){
        this.driver=driver;
    }

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public void getSearchText(){
        driver.findElement(search).getText();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
