package pom;

import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by OYurkiv on 10/1/2018.
 */
public class FinancePage extends AbstractPage {
    final static Logger LOG = Logger.getLogger(FinancePage.class);
    //private WebDriver driver = DriverFactory.getInstance();
    //private final WebDriverWait webDriverWait = new WebDriverWait(driver, 5);



    private List<SelenideElement> indexNameListS = $$(By.xpath("//a//div[@class='maIvLb']/span/preceding-sibling::span"));
    private List<SelenideElement> indexAbsoluteChangeListS = $$(By.xpath("//a//div[@class='maIvLb']/span/following-sibling::span/span[not(child::span)]"));
    private List<SelenideElement>  indexRelativeChangeListS = $$(By.xpath("//a//div[@class='maIvLb']/span/following-sibling::span/span[child::span]/span"));
    private List<SelenideElement>  indexDetailsLinkButtonListS = $$(By.cssSelector("g-link>.a-no-hover-decoration"));
    private SelenideElement indexOpenValueS = $(By.xpath("//g-card-section//tbody/tr[1]/td[last()]"));
    private SelenideElement indexMaxValueS = $(By.xpath("//g-card-section//tbody/tr[1]/td[last()]"));
    private SelenideElement indexMinValueS = $(By.xpath("//g-card-section//tbody/tr[2]/td[last()]"));


    public FinancePage() {

    }

    @Step
    public String getIndexNameOf(int numberOfIndex){
        return indexNameListS.get(numberOfIndex+5).getText();
    }

    @Step
    public String getIndexAbsoluteChangeOf(int numberOfIndex){
        return indexAbsoluteChangeListS.get(numberOfIndex+5).getText();
    }

    @Step
    public String getIndexRelativeChangeOf(int numberOfIndex){
        String relIndex = indexRelativeChangeListS.get(numberOfIndex+5).getText();
        return relIndex.substring(1, relIndex.length()-2);
    }

    @Step
    public void clickOnIndexOf(int numberOfIndex){
        indexDetailsLinkButtonListS.get(numberOfIndex+8).click();
    }

    @Step
    public String getIndexOpenValue(){
        return indexOpenValueS.getText();
    }

    @Step
    public String getIndexMaxValue(){
        return indexMaxValueS.getText();
    }

    @Step
    public String getIndexMinValue(){
        return indexMinValueS.getText();
    }



}
