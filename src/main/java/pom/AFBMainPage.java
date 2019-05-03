package pom;

import com.codeborne.selenide.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;
import java.util.Set;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;

/**
 * Created by OYurkiv on 4/8/2019.
 */
public class AFBMainPage extends AbstractPage {
    final static Logger LOG = Logger.getLogger(AFBMainPage.class);

    private List<SelenideElement> indexNameListS = $$(By.xpath("//a//div[@class='maIvLb']/span/preceding-sibling::span"));
    private List<SelenideElement> indexAbsoluteChangeListS = $$(By.xpath("//a//div[@class='maIvLb']/span/following-sibling::span/span[not(child::span)]"));
    private List<SelenideElement>  indexRelativeChangeListS = $$(By.xpath("//a//div[@class='maIvLb']/span/following-sibling::span/span[child::span]/span"));
    private List<SelenideElement>  indexDetailsLinkButtonListS = $$(By.cssSelector("g-link>.a-no-hover-decoration"));
    private SelenideElement indexOpenValueS = $(By.xpath("//g-card-section//tbody/tr[1]/td[last()]"));
    private SelenideElement indexMaxValueS = $(By.xpath("//g-card-section//tbody/tr[1]/td[last()]"));
    private SelenideElement indexMinValueS = $(By.xpath("//g-card-section//tbody/tr[2]/td[last()]"));

    private SelenideElement cssSelectorSE = $(".wrapper-color-content>h3");
    private SelenideElement xpathSelectorSE = $x("//g-card-section//tbody/tr[2]/td[last()]");

    //------------------------------------------------------------------------------------------------------------
    private SelenideElement menuItemWeDo = $x("//div[@class='nav-item'][1]/a");
    private SelenideElement menuItemWhoWeAre = $x("//div[@class='nav-item'][2]/a");
    private SelenideElement menuItemGetInTouch = $x("//div[@class='nav-item'][3]/a");
    private SelenideElement menuItemSharepointProducts = $x("//div[@class='nav-item'][4]/a");

    private SelenideElement floatMenu_00 = $x("//section[@class='floating-nav']//a[text()='00']");
    private SelenideElement floatMenu_01 = $x("//section[@class='floating-nav']//a[text()='01']");
    private SelenideElement floatMenu_02 = $x("//section[@class='floating-nav']//a[text()='02']");
    private SelenideElement floatMenu_03 = $x("//section[@class='floating-nav']//a[text()='03']");
    private SelenideElement floatMenu_04 = $x("//section[@class='floating-nav']//a[text()='04']");
    private SelenideElement floatMenu_05 = $x("//section[@class='floating-nav']//a[text()='05']");
    private SelenideElement floatMenu_FB = $x("//img[@alt='facebook logo']/parent::a");
    private SelenideElement floatMenu_IN = $x("//img[@alt='linkedin logo']/parent::a");

    private SelenideElement weAre_ExploreButton = $("#home button");

    private SelenideElement weDo_01_readButton = $x("//h3[text()='Software Development']/following-sibling::div//button");
    private SelenideElement weDo_02_readButton = $x("//h3[text()='Design']/following-sibling::div//button");
    private SelenideElement weDo_03_readButton = $x("//h3[text()='Quality Assurance']/following-sibling::div//button");

    private SelenideElement git_NameInput = $("input[name='name']");
    private SelenideElement git_EmailInput = $("input[name='email']");
    private SelenideElement git_CompanyNameInput = $("input[name='company_name']");
    private SelenideElement git_WebsiteInput = $("input[name='website']");
    private SelenideElement git_RequirementsInput = $("textarea[name='requirements']");
    private SelenideElement git_ErrorTextField = $x("//div[@class='input-area']//div");
    private SelenideElement git_SuccessTextField = $("div.contact-form__success");

    private SelenideElement git_SendButton = $x("//button[text()='send']");

    private SelenideElement geo_FullScreenViewButton = $x("//button[@title='Toggle fullscreen view']");
    private SelenideElement geo_ZoomInButton = $x("//button[@title='Zoom in']");
    private SelenideElement geo_ZoomOutButton = $x("//button[@title='Zoom out']");



    public AFBMainPage() {

    }

    @Step
    public void geo_toggleFullScreenView()throws Exception{
        geo_FullScreenViewButton.click();
        Thread.sleep(2000);
        geo_FullScreenViewButton.click();
        Thread.sleep(2000);
        git_SendButton.shouldBe(visible);
    }

    @Step
    public void geo_zoomIn()throws Exception{
        geo_ZoomInButton.click();
        Thread.sleep(2000);
    }

    @Step
    public void geo_zoomOut()throws Exception{
        geo_ZoomOutButton.click();
        Thread.sleep(2000);
    }

    @Step
    public void geo_DropTheMap(){
        actions().clickAndHold().moveByOffset(100, 100).release().perform();
        //actions().build().perform();
    }



    @Step
    public boolean isHeaderWeDoDisplayed(){
        return menuItemWeDo.isDisplayed();
    }

    @Step
    public boolean isHeaderWeDoClickable(){
        return menuItemWeDo.is(enabled);
    }

    @Step
    public String clickOnHeaderWeDo()throws  Exception{
        menuItemWeDo.click();
        Thread.sleep(2000);
        return executeJavaScript("return window.pageYOffset;").toString();
    }

    @Step
    public boolean isHeaderWhoWeAreDisplayed(){
        return menuItemWhoWeAre.isDisplayed();
    }

    @Step
    public boolean isHeaderWhoWeAreClickable(){
        return menuItemWhoWeAre.is(enabled);
    }

    @Step
    public String clickOnHeaderWhoWeAre()throws  Exception{
        menuItemWhoWeAre.click();
        Thread.sleep(2000);
        return executeJavaScript("return window.pageYOffset;").toString();
    }

    @Step
    public boolean isHeaderGetInTouchDisplayed(){
        return menuItemGetInTouch.isDisplayed();
    }

    @Step
    public boolean isHeaderGetInTouchClickable(){
        return menuItemGetInTouch.is(enabled);
    }

    @Step
    public String clickOnHeaderGetInTouch()throws  Exception{
        menuItemGetInTouch.click();
        Thread.sleep(2000);
        return executeJavaScript("return window.pageYOffset;").toString();
    }

    @Step
    public boolean isExploreButtonDisplayed(){
        return weAre_ExploreButton.isDisplayed();
    }

    @Step
    public boolean isExploreButtonClickable(){
        return weAre_ExploreButton.is(enabled);
    }

    @Step
    public String clickOnExploreButton()throws  Exception{
        weAre_ExploreButton.click();
        Thread.sleep(2000);
        return executeJavaScript("return window.pageYOffset;").toString();
    }

//--------------------------------Number Menu--------------------------------------------------------------------
    @Step
    public boolean isFloatMenuItemDisplayed(String number){
        return $$("section[class='floating-nav'] li").findBy(text(number)).isDisplayed();
    }

    @Step
    public boolean isFloatMenuItemClickable(String number){
        return $$("section[class='floating-nav'] li").findBy(text(number)).is(enabled);
    }

    @Step
    public String clickOnFloatMenuItem(String number)throws  Exception{
        $$("section[class='floating-nav'] li").findBy(text(number)).click();
        Thread.sleep(2000);
        return executeJavaScript("return window.pageYOffset;").toString();
    }

    @Step
    public boolean isFacebookButtonDisplayed(){
        return floatMenu_FB.is(exist);
    }

    @Step
    public boolean isFacebookButtonClickable(){
        return floatMenu_FB.is(enabled);
    }

    @Step
    public String clickOnFacebookButton()throws  Exception{
        String parent_handle = getWebDriver().getWindowHandle();
        Thread.sleep(2000);
        executeJavaScript("arguments[0].click();", floatMenu_FB);
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
    public boolean isLinkedInButtonDisplayed(){
        return floatMenu_IN.is(exist);
    }

    @Step
    public boolean isLinkedInButtonClickable(){
        return floatMenu_IN.is(enabled);
    }

    @Step
    public String clickOnLinkedInButton()throws  Exception{
        String parent_handle = getWebDriver().getWindowHandle();
        Thread.sleep(2000);
        executeJavaScript("arguments[0].click();", floatMenu_IN);
        new WebDriverWait(getWebDriver(),10).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = getWebDriver().getWindowHandles();
        for(String handle1:handles)
            if(!parent_handle.equals(handle1))
            {
                switchTo().window(handle1);
            }
        return url();
    }



    //-----------------------We Do-------------------------------------------------------------------------------

    @Step
    public boolean isWeDo_01_ReadButtonDisplayed()throws Exception{
        $x("//h3[text()='Software Development']/parent::div").hover();
        Thread.sleep(2000);
        return weDo_01_readButton.isDisplayed();
    }

    @Step
    public boolean isWeDo_01_ReadButtonClickable()throws Exception{
        return weDo_01_readButton.is(enabled);
    }

    @Step
    public String clickOnWeDo_01_ReadButton()throws  Exception{
        weDo_01_readButton.hover().click();
        Thread.sleep(2000);
        return getWebDriver().getCurrentUrl();
    }

    @Step
    public boolean isWeDo_02_ReadButtonDisplayed()throws Exception{
        $x("//h3[text()='Design']/parent::div").hover();
        Thread.sleep(2000);
        return weDo_02_readButton.isDisplayed();
    }

    @Step
    public boolean isWeDo_02_ReadButtonClickable()throws Exception{
        return weDo_02_readButton.is(enabled);
    }

    @Step
    public String clickOnWeDo_02_ReadButton()throws  Exception{
        weDo_02_readButton.hover().click();
        Thread.sleep(2000);
        return getWebDriver().getCurrentUrl();
    }

    @Step
    public boolean isWeDo_03_ReadButtonDisplayed()throws Exception{
        $x("//h3[text()='Quality Assurance']/parent::div").hover();
        Thread.sleep(2000);
        return weDo_03_readButton.isDisplayed();
    }

    @Step
    public boolean isWeDo_03_ReadButtonClickable()throws Exception{
        return weDo_03_readButton.is(enabled);
    }

    @Step
    public String clickOnWeDo_03_ReadButton()throws  Exception{
        weDo_03_readButton.hover().click();
        Thread.sleep(2000);
        return getWebDriver().getCurrentUrl();
    }

    //--------------------Get In Touch------------------------------------------------------------------------------

    @Step
    public boolean isGIT_NameInputDisplayed(){
        return git_NameInput.isDisplayed();
    }

    @Step
    public boolean writeGIT_Name(String ... name){
        git_NameInput.click();
        if(name.length!=0) {
            git_NameInput.sendKeys(name);
        }
        return git_NameInput.is(focused);
    }

    @Step
    public String getGIT_Name(){
        return git_NameInput.getAttribute("value");
    }

    @Step
    public boolean isGIT_EmailInputDisplayed(){
        return git_EmailInput.isDisplayed();
    }

    @Step
    public boolean writeGIT_Email(String ... email){
        git_EmailInput.click();
        if(email.length!=0) {
            git_NameInput.sendKeys(email);
        }
        return git_EmailInput.is(focused);
    }

    @Step
    public String getGIT_Email(){
        return git_EmailInput.getAttribute("value");
    }

    @Step
    public boolean isGIT_CompanyNameInputDisplayed(){
        return git_CompanyNameInput.isDisplayed();
    }

    @Step
    public boolean writeGIT_CompanyName(String ... companyName){
        git_CompanyNameInput.click();
        if(companyName.length!=0) {
            git_NameInput.sendKeys(companyName);
        }
        return git_CompanyNameInput.is(focused);
    }

    @Step
    public String getGIT_CompanyName(){
        return git_CompanyNameInput.getAttribute("value");
    }

    @Step
    public boolean isGIT_WebsiteInputDisplayed(){
        return git_WebsiteInput.isDisplayed();
    }

    @Step
    public boolean writeGIT_Website(String ... website){
        git_WebsiteInput.click();
        if(website.length!=0) {
            git_NameInput.sendKeys(website);
        }
        return git_WebsiteInput.is(focused);
    }

    @Step
    public String getGIT_Website(){
        return git_WebsiteInput.getAttribute("value");
    }

    @Step
    public boolean isGIT_RequirementsInputDisplayed(){
        return git_RequirementsInput.isDisplayed();
    }

    @Step
    public boolean writeGIT_Requirements(String ... requirements){
        git_RequirementsInput.click();
        if(requirements.length!=0) {
            git_RequirementsInput.sendKeys(requirements);
        }
        return git_RequirementsInput.is(focused);
    }

    @Step
    public String getGIT_Requirements(){
        return git_RequirementsInput.getAttribute("value");
    }

    @Step
    public void fillContactForm(String name, String email, String companyName, String website, String requirements)throws Exception{
        //git_NameInput.setValue("Artfulbits").pressEnter();
        git_NameInput.sendKeys(name);
        git_EmailInput.sendKeys(email);
        git_CompanyNameInput.sendKeys(companyName);
        git_WebsiteInput.sendKeys(website);
        git_RequirementsInput.sendKeys(requirements);
        //git_SendButton.click();

    }

    @Step
    public void fillContactFormWithoutCompanyName(String name, String email, String website, String requirements)throws Exception{
        git_NameInput.sendKeys(name);
        git_EmailInput.sendKeys(email);
        git_WebsiteInput.sendKeys(website);
        git_RequirementsInput.sendKeys(requirements);
        //git_SendButton.click();

    }

    @Step
    public void fillContactFormWithoutWebsite(String name, String email, String companyName, String requirements)throws Exception{
        git_NameInput.sendKeys(name);
        git_EmailInput.sendKeys(email);
        git_CompanyNameInput.sendKeys(companyName);
        git_RequirementsInput.sendKeys(requirements);
        //git_SendButton.click();
    }

    @Step
    public boolean isGIT_SendButtonDisplayed(){
        return git_SendButton.isDisplayed();
    }

    @Step
    public boolean isGIT_SendButtonClickable(){
        return git_SendButton.is(enabled);
    }

    @Step
    public void clickOnGIT_SendButton(){
        git_SendButton.click();
    }

    @Step
    public String getGIT_ErrorText(){
        git_ErrorTextField.shouldBe(visible);
        return  git_ErrorTextField.getText();
    }

    @Step
    public String getGIT_SuccessText(){
        git_SuccessTextField.shouldBe(visible);
        return  git_SuccessTextField.getText();
    }












    @Step
    public void openTest(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        getUserAgent();
        sleep(1000);
        executeJavaScript("", cssSelectorSE);
        open("https://selenide.org/documentation.html");
        cssSelectorSE.setValue("qwerty").pressEnter();
        cssSelectorSE.should(exactText("qwerty"));
        cssSelectorSE.shouldHave(Condition.value("qwerty"));

        $(By.xpath("//*[@id='search-results']//a[contains(text(),'selenide.org')]")).click();
        $$("#search-results a").findBy(text("selenide.org")).click(); //same

        // Inner elements search methods
        cssSelectorSE.find(".inner");
        cssSelectorSE.$(".inner");
        cssSelectorSE.findAll(By.xpath("//inner"));
        cssSelectorSE.$$x("//inner");

        // you can specify the search path step by step, building the “locators chain”
        $("#header").find("#menu").findAll(".item").last().click();

        $("input").shouldBe(Condition.enabled);

        // Assertions play role of explicit waits in Selenide.
        // They wait for condition (visible, enabled, text("some text")) to be satisfied until timeout reached (the value of Configuration.timeout that is set to 4000 ms by default).
        $("#submit").shouldBe(enabled).click();

        //text() // returns “visible text on a page”
        //innerText() // returns “text of element in DOM”

        //selectors that may be missed in standard Selenium WebDriver API
        $(Selectors.byText("Login")).shouldBe(enabled);
        $(Selectors.withText("Login")).shouldBe(enabled);
        $(Selectors.byAttribute("attribute", "value")).shouldBe(enabled);
        $(Selectors.byTitle("Login")).shouldBe(enabled);
        $(Selectors.byValue("Login")).shouldBe(enabled);

        $$(".collection").shouldBe(CollectionCondition.sizeGreaterThan(1));
        $$(".collection").shouldBe(empty);

        //returns the WebDriver instance (created by Selenide automatically or set up by the user), thus giving to the user the raw API to Selenium if needed
        getWebDriver();
        WebDriverRunner.isChrome();



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
