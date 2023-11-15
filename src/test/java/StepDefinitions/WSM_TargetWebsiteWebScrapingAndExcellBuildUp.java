package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class WSM_TargetWebsiteWebScrapingAndExcellBuildUp {


    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    WebDriver driver = GWD.getDriver();


    @When("Go and Collect data as a Array list")
    public void goAndCollectDataAsAArrayList() throws InterruptedException {

        for (int i = 1; i <=2 ; i++) {                      // i PAGE CYCLE
            driver.get("https://stoneexpozone.com/companiesdb/1/tr?country=tr&type=1&pg=" + i);



            List<WebElement> companyProfiles =dc.getWebElementList("companyProfilesOnListingPage");

            for (int j = 0; j < companyProfiles.size(); j++) {
                companyProfiles =dc.getWebElementList("companyProfilesOnListingPage");
                WebElement ele = companyProfiles.get(j);


                System.out.println("ele.getText() = " + ele.getText());


                try {
                    dc.myClick(ele);
                    driver.navigate().back();

                } catch (StaleElementReferenceException st) {
                    companyProfiles =dc.getWebElementList("companyProfilesOnListingPage");
                    ele = companyProfiles.get(j);
                    dc.myClick(ele);
                    driver.navigate().back();

                } catch (WebDriverException we) {
                    we.printStackTrace();
                }


               // THE PLACE OF DATA COLLECTION FROM WEBELEMENTS IN COMPANY PROFILES




            }
        }

    }

    @Then("Write it into an excell")
    public void writeItIntoAnExcell() {
    }
}
