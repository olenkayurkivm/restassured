package tickets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.FinancePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by OYurkiv on 6/12/2019.
 */
public class TicketsSearchPage extends TicketsAbstractPage {

    final static Logger LOG = Logger.getLogger(TicketsSearchPage.class);
    private final static  String recBlockSelector = "//section[contains(@class, 'item-block')]";
    private final static String companyNameSelector = "//div[contains(@class, 'ac_name')]//p/following::span[1]";
    private final static String priceSelector = "//div[contains(@class, 'price-block') and not(contains(@class, 'regular-price'))]";
    private final static String racesSelector = "//*[contains(@class, 'flight-maininfo__tittle')]";
    private final static String moreRacesButtonSelector = "//a[@class='more_segments' and not(@style='display: none')]";

    private SelenideElement oneWayButton = $("input#oneway");
    private SelenideElement fromInputField = $("#from_name");
    private SelenideElement toInputField = $("#to_name");

    private SelenideElement fromAutoCompleteField = $("#ui-id-1>li>:first-child");
    private SelenideElement toAutoCompleteField = $("#ui-id-2>li>:first-child");

    //private SelenideElement todayDateButton = $("td.ui-datepicker-today>a");
    private SelenideElement todayDateButton = $x("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[6]/a");
    private SelenideElement searchFlightsButton = $(".start-search-btn");


    public TicketsSearchPage() {

    }

    @Step
    public void chooseOneWayOption()throws  Exception {
        //oneWayButton.click();
        $("input#oneway").toWebElement().click(); //workaround
    }

    @Step
    public void fillFromAntTo(String fromCity, String toCity)throws  Exception {
        //fromInputField.sendKeys(fromCity);
        //fromAutoCompleteField.shouldBe(Condition.visible);
        //fromAutoCompleteField.click();
        toInputField.shouldBe(visible);
        toInputField.sendKeys(toCity);
        toAutoCompleteField.shouldBe(visible);
        toAutoCompleteField.click();
    }

    @Step
    public void chooseTodayDate()throws  Exception {
        todayDateButton.shouldBe(visible);
        todayDateButton.click();
    }

    @Step
    public String goToSearchResults()throws  Exception {
        searchFlightsButton.click();
        switchToAnotherWindow();
        return url();
    }

    @Step
    public int parseResults()throws  Exception{
        List<FlightRecObject> recList = new ArrayList<>();
        int i = 1;
        while(true){
            FlightRecObject flightRecObject = new FlightRecObject();

            String companyNameLocator = String.format("%s[%d]%s", recBlockSelector, i, companyNameSelector);
            String priceLocator = String.format("%s[%d]%s", recBlockSelector , i, priceSelector);
            String racesLocator = String.format("%s[%d]%s", recBlockSelector , i, racesSelector);
            String moreRacesButtonLocator = String.format("%s[%d]%s", recBlockSelector , i, moreRacesButtonSelector);
            String nextRecLocator = String.format("%s[%d]", recBlockSelector, i+1);

            flightRecObject.setAviaCompanyName($x(companyNameLocator).getText());

            if(!$$x(moreRacesButtonLocator).isEmpty()){
                $x(moreRacesButtonLocator).click();
            }

            List<SelenideElement> races = $$x(racesLocator);
            List<String> raceNumbers = new ArrayList<>();
            races.forEach(race -> raceNumbers.add(StringUtils.substringAfter(race.getText(), " ")));
//
            flightRecObject.setRaceNumbers(raceNumbers);

            flightRecObject.setPrice(($x(priceLocator).getText().replaceAll("\\D+","")));

            LOG.info(String.format("%s | %s", flightRecObject.getAviaCompanyName(), flightRecObject.getPrice()));
            flightRecObject.getRaceNumbers().forEach(LOG::info);
            recList.add(flightRecObject);
            if(!$$x(nextRecLocator).isEmpty()){
                executeJavaScript("arguments[0].scrollIntoView(true);", $x(nextRecLocator));
                i++;
                Thread.sleep(1000);
            } else{
                break;
            }
        }
        LOG.info(String.format("Number of recommendations : %d", recList.size()));
        saveResultsToFile(recList);
        return recList.size();
    }

    @Step
    public void saveResultsToFile(List<FlightRecObject> recList)throws  Exception {
           
    }




}
