package stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContextSetup;

public class Hooks {
    TestContextSetup testContextSetup;

    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @AfterStep
    public void captureScreenshot(Scenario scenario){
        if(scenario.isFailed()){
            byte[] sourceScreenshot = ((TakesScreenshot) testContextSetup.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourceScreenshot,"image/png","image1");
        }
    }
}
