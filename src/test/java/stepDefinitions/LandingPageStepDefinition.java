package stepDefinitions;

import Pages.LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

    public TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @Given("User is on GreenKart Landing Page")
    public void user_is_on_green_kart_landing_page() {
        testContextSetup.driver=new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    }
    @When("User searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) {
        LandingPage landingPage=new LandingPage(testContextSetup.driver);
        landingPage.searchItem(shortname);
        //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(testContextSetup.landingPageProductName+" is extracted from Home Page");
    }
}
