package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WSM_TargetWebsiteWebScrapingAndExcellBuildUp {


    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    WebDriver driver = GWD.getDriver();


    @When("Go and Collect data as a Array list")
    public void goAndCollectDataAsAArrayList() throws InterruptedException {

        for (int i = 1; i <= 3; i++) { // 10 sayfa için döngü
            // Sayfa numarasına tıklama işlemi

            driver.get("https://www.stonecontact.com/suppliers/turkey-country/" + i);


            String originalHandle = driver.getWindowHandle();


            for (WebElement ele : dc.companyProfilesOnListingPage) {
                System.out.println("ele.getText() = " + ele.getText());
                dc.myClick(ele);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 saniye bekleme süresi
                wait.until(ExpectedConditions.numberOfWindowsToBe(2));

                for (String handle : driver.getWindowHandles()) {
                    if (!handle.equals(originalHandle)) {
                        driver.switchTo().window(handle);

                        // Veri toplama işlemleri burada
                        // Örnek: collectedData.add(driver.findElement(By.id("someId")).getText());

                        // Yeni sekme kapatılıyor
                        driver.close();
                        // Kontrolü orijinal sekme (liste sayfası) için geri al
                        driver.switchTo().window(originalHandle);
                        break;
                    }
                }
            }
        }

    }

    @Then("Write it into an excell")
    public void writeItIntoAnExcell() {
    }
}
