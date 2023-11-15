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

        for (int i = 1; i <= 3; i++) { // 10 sayfa için döngü
            // Sayfa numarasına tıklama işlemi

            //  driver.get("https://www.stonecontact.com/suppliers/turkey-country/" + i);
            driver.get("https://stoneexpozone.com/companiesdb/1/tr?country=tr&type=1&pg=" + i);
            Map<String, String> dataCollection = null;


            String originalHandle = driver.getWindowHandle();

            List<WebElement> companyProfiles =dc.getWebElementList("companyProfilesOnListingPage");

            for (int j = 0; j < companyProfiles.size(); j++) {
                // Her eleman için sayfayı yeniden yüklemeden önce yeniden bul
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



                //   wait.until(ExpectedConditions.numberOfWindowsToBe(2));

                //    for (String handle : driver.getWindowHandles()) {
                //        if (!handle.equals(originalHandle)) {
                //            driver.switchTo().window(handle);
//
                //        //  String companyName=ele.getText();
                //        //   String companyCountry=driver.findElement(By.xpath("(//div[@class='profile-info-line companyinfo-item']/text())[3]")).getText();
                //        //   System.out.println("companyCountry = " + companyCountry);
                //        //   dataCollection.add(companyName,companyCountry);
                //
//
                //            // Veri toplama işlemleri burada
                //            // Örnek: collectedData.add(driver.findElement(By.id("someId")).getText());
//
                //            // Yeni sekme kapatılıyor
                //            driver.close();
                //            // Kontrolü orijinal sekme (liste sayfası) için geri al
                //            driver.switchTo().window(originalHandle);
                //            break;
                //        }
                //    }
            }
        }

    }

    @Then("Write it into an excell")
    public void writeItIntoAnExcell() {
    }
}
