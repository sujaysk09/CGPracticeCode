package stepDefinitions;

import Pages.OffersPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestContextSetup;

import java.util.Set;

public class OffersPageStepDefinition {
    TestContextSetup testContextSetup;
    public String offersPageProductName;

    public OffersPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @Then("User searched with {string} shortname in offers page")
    public void user_searched_with_same_shortname_in_offers_page(String shortname) {
        switchToOffersPage();
        OffersPage offersPage=new OffersPage(testContextSetup.driver);
        offersPage.searchItem(shortname);
        offersPageProductName=offersPage.getProductName();
        //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        //offersPageProductName = testContextSetup.driver.findElement(By.xpath("//table//tr/td[1]")).getText();
    }

    public void switchToOffersPage(){
        testContextSetup.driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
        String parentWindow = testContextSetup.driver.getWindowHandle();
        Set<String> s1 = testContextSetup.driver.getWindowHandles();
//        Iterator<String> i1 = s1.iterator();
//        String parentWin=i1.next();
//        String childWin=i1.next();
        for(String w1:s1){
            if(!w1.equals(parentWindow)){
                testContextSetup.driver.switchTo().window(w1);
            }
        }
    }

    @Then("Validate product name in offers page matches with landing page")
    public void validate_product_name_in_offers_page(){
        Assert.assertEquals(offersPageProductName,testContextSetup.landingPageProductName);

        System.out.println("america guy added code1");
        System.out.println("america guy added code2");
        System.out.println("america guy added code3");
        System.out.println("america guy added code4");
    }
}
