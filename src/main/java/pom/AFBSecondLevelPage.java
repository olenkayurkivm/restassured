package pom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.log4j.Logger;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

/**
 * Created by OYurkiv on 4/26/2019.
 */
public class AFBSecondLevelPage extends AbstractPage {
    final static Logger LOG = Logger.getLogger(AFBSecondLevelPage.class);


    private SelenideElement headerLogoButton = $x("//img[@class='logo']/parent::a");
    private SelenideElement headerHomeButton = $x("//a[text()='Home']");
    private SelenideElement headerGetInTouchButton = $x("//a[text()='Get in Touch']");


    private SelenideElement readMoreButton_1 = $x("//section[@class='tech-directions']/div[@class='short-overview content-block'][1]//button");

    private SelenideElement seeAlsoDesignButton = $x("//a[@href='/design']");
    private SelenideElement seeAlsoQualityAssuranceButton = $x("//a[@href='/quality-assurance']");
    private SelenideElement seeAlsoSoftwareDevelopmentButton = $x("//a[@href='/software-development']");


    @Step
    public void goToSecondLevelPage(String pageURL){
        open(pageURL);
    }

    @Step
    public boolean isHeaderLogoButtonDisplayed(){
        headerLogoButton.should(exist);
        return headerLogoButton.isDisplayed();
    }

    @Step
    public boolean isHeaderLogoButtonClickable(){
        headerLogoButton.shouldBe(enabled);
        return headerLogoButton.is(enabled);
    }

    @Step
    public String clickOnHeaderLogoButton()throws  Exception{
        headerLogoButton.shouldBe(enabled);
        headerLogoButton.click();
        return url();
    }

    @Step
    public boolean isHeaderHomeButtonDisplayed(){
        return headerHomeButton.isDisplayed();
    }

    @Step
    public boolean isHeaderHomeButtonClickable(){
        return headerHomeButton.is(enabled);
    }

    @Step
    public String clickOnHeaderHomeButton()throws  Exception{
        headerHomeButton.click();
        return url();
    }

    @Step
    public boolean isHeaderGetInTouchButtonDisplayed(){
        return headerGetInTouchButton.isDisplayed();
    }

    @Step
    public boolean isHeaderGetInTouchButtonClickable(){
        return headerGetInTouchButton.is(enabled);
    }

    @Step
    public String clickOnHeaderGetInTouchButton()throws  Exception{
        headerGetInTouchButton.click();
        Thread.sleep(2000);
        return executeJavaScript("return window.pageYOffset;").toString();
    }

    @Step
    public boolean isReadMoreButton1Displayed(){
        executeJavaScript("arguments[0].scrollIntoView(true);", readMoreButton_1);
        return readMoreButton_1.isDisplayed();
    }

    @Step
    public boolean isReadMoreButton1Clickable(){
        executeJavaScript("arguments[0].scrollIntoView(true);", readMoreButton_1);
        return readMoreButton_1.is(enabled);
    }

    //------------------See Also ------------------------------------------------------------------------

    @Step
    public boolean isSeeAlsoSoftwareDevelopmentButtonDisplayed(){
        return seeAlsoSoftwareDevelopmentButton.isDisplayed();
    }

    @Step
    public boolean isSeeAlsoSoftwareDevelopmentButtonClickable(){
        return seeAlsoSoftwareDevelopmentButton.is(enabled);
    }

    @Step
    public String clickOnSeeAlsoSoftwareDevelopmentButton()throws  Exception{
        seeAlsoSoftwareDevelopmentButton.click();
        return url();
    }

    @Step
    public boolean isSeeAlsoDesignButtonDisplayed(){
        return seeAlsoDesignButton.isDisplayed();
    }

    @Step
    public boolean isSeeAlsoDesignButtonClickable(){
        return seeAlsoDesignButton.is(enabled);
    }

    @Step
    public String clickOnSeeAlsoDesignButton()throws  Exception{
        seeAlsoDesignButton.click();
        return url();
    }

    @Step
    public boolean isSeeAlsoQualityAssuranceButtonDisplayed(){
        return seeAlsoQualityAssuranceButton.isDisplayed();
    }

    @Step
    public boolean isSeeAlsoQualityAssuranceButtonClickable(){
        return seeAlsoQualityAssuranceButton.is(enabled);
    }

    @Step
    public String clickOnSeeAlsoQualityAssuranceButton()throws  Exception{
        seeAlsoQualityAssuranceButton.click();
        return url();
    }

}
