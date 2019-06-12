package tickets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.FinancePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by OYurkiv on 6/12/2019.
 */
public class TicketsSearchPage extends TicketsAbstractPage {

    final static Logger LOG = Logger.getLogger(TicketsSearchPage.class);

    private SelenideElement oneWayButton = $("input#oneway");
    private SelenideElement fromInputField = $("#from_name");
    private SelenideElement toInputField = $("#to_name");

    private SelenideElement fromAutoCompleteField = $("#ui-id-1>li>:first-child");
    private SelenideElement toAutoCompleteField = $("#ui-id-2>li>:first-child");

    //private SelenideElement todayDateButton = $("td.ui-datepicker-today>a");
    private SelenideElement todayDateButton = $x("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[4]");
    private SelenideElement searchFlightsButton = $(".start-search-btn");

    private List<SelenideElement> reccommendationsList = $$(By.cssSelector("section.item-block"));
    private List<SelenideElement> aviaCompanyNamesList = $$(By.xpath("//div[contains(@class, 'ac_name')]//p/following::span[1]"));
    private List<SelenideElement> pricesList = $$(By.xpath("//div[contains(@class, 'price-block') and not(contains(@class, 'regular-price'))]"));


    public TicketsSearchPage() {

    }

    @Step
    public String searchForFlights(String fromPlace, String toPlace)throws  Exception{
        //oneWayButton.shouldBe(Condition.enabled);
        $("input#oneway").toWebElement().click();
        //executeJavaScript("arguments[0].click();", $("input#oneway"));
       //fromInputField.sendKeys("Львов");
       //fromAutoCompleteField.shouldBe(Condition.visible);
       //fromAutoCompleteField.click();
        toInputField.shouldBe(Condition.visible);
       toInputField.sendKeys("Киев");
       toAutoCompleteField.shouldBe(Condition.visible);
       toAutoCompleteField.click();
       todayDateButton.shouldBe(Condition.visible);
       todayDateButton.click();
       searchFlightsButton.click();
        String parent_handle = getWebDriver().getWindowHandle();
        new WebDriverWait(getWebDriver(),10).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = getWebDriver().getWindowHandles();
        for(String handle1:handles)
            if(!parent_handle.equals(handle1))
            {
                switchTo().window(handle1);
            }
        return url();
    }

    @Step
    public void parseResults()throws  Exception{
        List<FlightRecObject> recList = new ArrayList<>();
        for (SelenideElement rec : reccommendationsList){
            FlightRecObject flightRecObject = new FlightRecObject();
            flightRecObject.setAviaCompanyName(rec.$x("//div[contains(@class, 'ac_name')]//p/following::span[1]").getText());
            flightRecObject.setPrice(rec.$x("//div[contains(@class, 'price-block') and not(contains(@class, 'regular-price'))]").getText());
            List<SelenideElement> races = rec.$$x("//*[contains(@class, 'flight-maininfo__tittle')]");
            List<String> raceNumbers = new ArrayList<>();
            for(SelenideElement race : races){
                raceNumbers.add(race.getText());
            }
            flightRecObject.setRaceNumbers(raceNumbers);
            System.out.println(flightRecObject.getAviaCompanyName() + " | " +flightRecObject.getRaceNumbers().get(0) +" | "+ flightRecObject.getPrice());
            recList.add(flightRecObject);
        }
    }




}
