package StepDefinitions;

import Model.Company;
import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utilities.ExcelWriter.writeMapToExcel;

public class WSM_TargetWebsiteWebScrapingAndExcellBuildUp {


    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    WebDriver driver = GWD.getDriver();


    @When("Go and Collect data as a Array list")
    public void goAndCollectDataAsAArrayList() throws InterruptedException, IOException {

        Map<String, Company> companyMap = new HashMap<>();


        for (int i = 1; i <= 1; i++) {                      // i PAGE CYCLE
            driver.get("https://stoneexpozone.com/companiesdb/1/tr?country=tr&type=1&pg=" + i);


            List<WebElement> companyProfiles = dc.getWebElementList("companyProfilesOnListingPage");
            System.out.println("companyProfiles.size() = " + companyProfiles.size());               // DAHA SONRA SİLİNECEK


            // Liste boş mu kontrol et
              if (companyProfiles.isEmpty()) {
                  System.out.println("No company profiles found on page " + i);
                  continue;
              }


            for (int j = 0; j < companyProfiles.size(); j++) {
               // companyProfiles = dc.getWebElementList("companyProfilesOnListingPage");
                WebElement ele = companyProfiles.get(j);
                Company company = new Company();


                //  System.out.println("ele.getText() = " + ele.getText());


                try {
                    dc.myClick(ele);

                 //////////////////   company.setDescription(driver.findElement(By.xpath("//div[@class='span-11 last']")).getText());
                 //////////////////   company.setCompanyAddress(driver.findElement(By.xpath("//p[@itemprop=\"address\"]")).getText());
//////////////////
                 //////////////////   companyMap.put(ele.getText(), company);


                    driver.navigate().back();

                    Thread.sleep(1000); // Sayfa yeniden yüklendikten sonra beklemek için

                    ////////////////////////////////////////////////////////////////////////////////////////////  companyProfiles = dc.getWebElementList("companyProfilesOnListingPage"); // Sayfa geri döndükten sonra liste yenileniyor


                } catch (StaleElementReferenceException st) {
                    System.out.println("StaleElementReferenceException caught, retrying...");
                  //////////////////////////  Thread.sleep(1000); // Hata durumunda yeniden yüklenmek için bekleyin
                  //////////////////////////  companyProfiles = dc.getWebElementList("companyProfilesOnListingPage"); // Hata yakalandığında, listeyi yeniden al ve işlemi tekrar dene
                  //////////////////////////  ele = companyProfiles.get(j);
                    dc.myClick(ele);

                 ///////////////////////////  company.setDescription(driver.findElement(By.xpath("//div[@class='span-11 last']")).getText());
                 ///////////////////////////  company.setCompanyAddress(driver.findElement(By.xpath("//p[@itemprop=\"address\"]")).getText());

                 ///////////////////////////  companyMap.put(ele.getText(), company);

                 ///////////////////////////  j--; // Mevcut elemanı tekrar işlemek üzere indeksi azalt
                    driver.navigate().back();


                } catch (WebDriverException we) {
                    we.printStackTrace();
                }


            }
        }

      //(((((((((((((((//////////////////////////  for (Map.Entry<String, Company> entry : companyMap.entrySet()) {
      //(((((((((((((((//////////////////////////      System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
      //(((((((((((((((//////////////////////////  }


        writeMapToExcel("C:\\Users\\Casper Excalibur\\IdeaProjects\\WorldStoneMarket15112023\\src\\test\\java\\Utilities\\VERILER.xlsx", companyMap);

    }

    @Then("Write it into an excell")
    public void writeItIntoAnExcell() {

    }
}
