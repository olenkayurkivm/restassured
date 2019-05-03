import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.AFBMainPage;
import pom.AFBSecondLevelPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by OYurkiv on 10/1/2018.
 */
public class FinanceTest {
    final static Logger LOG = Logger.getLogger(FinanceTest.class);
    //private static WebDriver driver;
    public static final String SUCCESSFULLY_SENT_MSG = "Your message successfully sent. Our manager will contact you in a few hours.";
    public static final String SOFTWARE_DEVELOPMENT_URL = "http://18.218.182.166:3000/software-development";
    public static final String DESIGN_URL = "http://18.218.182.166:3000/design";
    public static final String QUALITY_ASSURANCE_URL = "http://18.218.182.166:3000/quality-assurance";
    public static final String HOME_URL = "http://18.218.182.166:3000/";
    AFBMainPage afbMainPage;
    AFBSecondLevelPage afbSecondLevelPage;



//    @BeforeMethod
//    public static void setUp(){
//        System.out.println("Hello finance!!");
//    }


    @Test
    public void checkHeaderMenuElementsAreDisplayed() throws Exception{
        afbMainPage = new AFBMainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isHeaderWeDoDisplayed());
        softAssert.assertTrue(afbMainPage.isHeaderWhoWeAreDisplayed());
        softAssert.assertTrue(afbMainPage.isHeaderGetInTouchDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void checkHeaderMenuElementsAreClickable() throws Exception{
        afbMainPage = new AFBMainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isHeaderWeDoClickable());
        softAssert.assertTrue(afbMainPage.isHeaderWhoWeAreClickable());
        softAssert.assertTrue(afbMainPage.isHeaderGetInTouchClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkHeaderWeDoButtonNavigateToWeDoBlock() throws Exception{
        afbMainPage = new AFBMainPage();
       assertEquals(afbMainPage.clickOnHeaderWeDo(), "892");
    }

    @Test
    public void checkHeaderWhoWeAreButtonNavigateToWhoWeAreBlock() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnHeaderWhoWeAre(), "4304");
    }

//    @Test
//    public void checkHeaderCustomersSayButtonNavigateToCustomersSayBlock() throws Exception{
//        afbMainPage = new AFBMainPage();
//        assertEquals(afbMainPage.clickOnHeaderCustomersSay(), "5266");
//    }

    @Test
    public void checkHeaderGetInTouchButtonNavigateToGetInTouchBlock() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnHeaderGetInTouch(), "6576");
    }

    @Test
    public void checkFloatMenuElementsAreDisplayed() throws Exception{
        afbMainPage = new AFBMainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isFloatMenuItemDisplayed("00"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemDisplayed("01"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemDisplayed("02"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemDisplayed("03"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemDisplayed("04"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemDisplayed("05"));
        softAssert.assertAll();
    }

    @Test
    public void checkFloatMenuElementsAreClickable() throws Exception{
        afbMainPage = new AFBMainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isFloatMenuItemClickable("00"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemClickable("01"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemClickable("02"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemClickable("03"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemClickable("04"));
        softAssert.assertTrue(afbMainPage.isFloatMenuItemClickable("05"));
        softAssert.assertAll();
    }

    @Test
    public void checkFloatMenu_00_ButtonNavigateToFirstBlock() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnFloatMenuItem("01");
        assertEquals(afbMainPage.clickOnFloatMenuItem("00"), "0");
    }

    @Test
    public void checkFloatMenu_01_ButtonNavigateToWeDoBlock() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnFloatMenuItem("01"), "892");
    }

    @Test
    public void checkFloatMenu_02_ButtonNavigateToHowWeDoBlock() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnFloatMenuItem("02"), "1784");
    }

    @Test
    public void checkFloatMenu_03_ButtonNavigateToWhoWeAreBlock() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnFloatMenuItem("03"), "4304");
    }

    @Test
    public void checkFloatMenu_04_ButtonNavigateToCustomersSayBlock() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnFloatMenuItem("04"), "5266");
    }

    @Test
    public void checkFloatMenu_05_ButtonNavigateToGetInTouchBlock() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnFloatMenuItem("05"), "6576");
    }

    @Test
    public void checkWeAreExploreButtonDisplayedAndClickable() throws Exception {
        afbMainPage = new AFBMainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isExploreButtonDisplayed());
        softAssert.assertTrue(afbMainPage.isExploreButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkWeAreExploreButtonNavigateToWeDoBlock() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnExploreButton(), "892");
    }

    @Test
    public void checkWeDoReadButtonsAreDisplayed() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnExploreButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isWeDo_01_ReadButtonDisplayed());
        softAssert.assertTrue(afbMainPage.isWeDo_02_ReadButtonDisplayed());
        softAssert.assertTrue(afbMainPage.isWeDo_03_ReadButtonDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void checkWeDoReadButtonsAreClickable() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnExploreButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isWeDo_01_ReadButtonClickable());
        softAssert.assertTrue(afbMainPage.isWeDo_02_ReadButtonClickable());
        softAssert.assertTrue(afbMainPage.isWeDo_03_ReadButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkWeDo_01_ReadButtonNavigateToSoftwareDevelopmentPage() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnExploreButton();
        assertTrue(afbMainPage.clickOnWeDo_01_ReadButton().contains("/software-development"));
    }

    @Test
    public void checkWeDo_02_ReadButtonNavigateToDesignPage() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnExploreButton();
        assertTrue(afbMainPage.clickOnWeDo_02_ReadButton().contains("/design"));
    }

    @Test
    public void checkWeDo_03_ReadButtonNavigateToQualityAssurancePage() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnExploreButton();
        assertTrue(afbMainPage.clickOnWeDo_03_ReadButton().contains("/quality-assurance"));
    }

    @Test
    public void checkGetInTouchFormElementsAreDisplayed() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isGIT_NameInputDisplayed());
        softAssert.assertTrue(afbMainPage.isGIT_EmailInputDisplayed());
        softAssert.assertTrue(afbMainPage.isGIT_CompanyNameInputDisplayed());
        softAssert.assertTrue(afbMainPage.isGIT_WebsiteInputDisplayed());
        softAssert.assertTrue(afbMainPage.isGIT_RequirementsInputDisplayed());
        softAssert.assertAll();
    }

    @Test
    public void checkGetInTouchFormElementsBecomeFocusedAfterClickingOnThem() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.writeGIT_Name());
        softAssert.assertTrue(afbMainPage.writeGIT_Email());
        softAssert.assertTrue(afbMainPage.writeGIT_CompanyName());
        softAssert.assertTrue(afbMainPage.writeGIT_Website());
        softAssert.assertTrue(afbMainPage.writeGIT_Requirements());
        softAssert.assertAll();
    }

    @Test
    public void checkUserCanEnterDataInGetInTouchFormInputFields() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        afbMainPage.fillContactForm("Test Test", "test@test.com", "TestCompanyName", "https://testcompany.com", "Test Requirements");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(afbMainPage.getGIT_Name(), "Test Test");
        softAssert.assertEquals(afbMainPage.getGIT_Email(), "test@test.com");
        softAssert.assertEquals(afbMainPage.getGIT_CompanyName(), "TestCompanyName");
        softAssert.assertEquals(afbMainPage.getGIT_Website(), "https://testcompany.com");
        softAssert.assertEquals(afbMainPage.getGIT_Requirements(), "Test Requirements");
        softAssert.assertAll();
    }

    @Test
    public void checkErrorMessageAppearsIfUserTriesToSendRequestWithEmptyNameField() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.fillContactForm("", "test@test.com", "TestCompanyName", "https://testcompany.com", "Test Requirements");
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_ErrorText(), "Name is required");
    }

    @Test
    public void checkErrorMessageAppearsIfUserTriesToSendRequestWithEmptyEmailField() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.fillContactForm("Test Test", "", "TestCompanyName", "https://testcompany.com", "Test Requirements");
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_ErrorText(), "Email is required");
    }

    @Test
    public void checkErrorMessageAppearsIfUserTriesToSendRequestWithEmptyRequirementsField() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.fillContactForm("Test Test", "test@test.com", "TestCompanyName", "https://testcompany.com", "");
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_ErrorText(), "Requirements are required");
    }

    @Test
    public void checkUserCanSendRequestWithEmptyCompanyNameField() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.fillContactForm("Test Test", "test@test.com", "", "https://testcompany.com", "Test Requirements");
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_SuccessText(), SUCCESSFULLY_SENT_MSG);
    }

    @Test
    public void checkUserCanSendRequestWithEmptyWebsiteField() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.fillContactForm("Test Test", "test@test.com", "TestCompanyName", "", "Test Requirements");
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_SuccessText(), SUCCESSFULLY_SENT_MSG);
    }

    @Test
    public void checkGetInTouchSendButtonIsDisplayedAndClickable() throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isGIT_SendButtonDisplayed());
        softAssert.assertTrue(afbMainPage.isGIT_SendButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkFacebookButtonIsDisplayedAndClickable() throws Exception{
        afbMainPage = new AFBMainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isFacebookButtonDisplayed());
        softAssert.assertTrue(afbMainPage.isFacebookButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkLinkedInButtonIsDisplayedAndClickable() throws Exception{
        afbMainPage = new AFBMainPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbMainPage.isLinkedInButtonDisplayed());
        softAssert.assertTrue(afbMainPage.isLinkedInButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkFacebookPageOpensAfterClickingOnFacebookButton() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnFacebookButton(), "https://www.facebook.com/ArtfulBits/");
    }

    @Test
    public void checkLinkedInPageOpensAfterClickingOnLinkedInButton() throws Exception{
        afbMainPage = new AFBMainPage();
        assertEquals(afbMainPage.clickOnLinkedInButton(), "https://www.linkedin.com/company/artfulbits/");
    }

    @DataProvider(name="StringToType")
    public Object[][] getStringToType(){
        return new Object[][]
                {
                        { "тест"},
                        { "test"},
                        { "12345"},
                        { "test12345"},
                        { "!@#$%^&*"},
                };
    }

    @Test (dataProvider = "StringToType")
    public void checkUserCanTypeInNameField(String nameToType) throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        afbMainPage.fillContactForm(nameToType, "test@test.com", "TestCompanyName", "https://testcompany.com", "Test Requirements");
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_SuccessText(), SUCCESSFULLY_SENT_MSG);
    }

    @DataProvider(name="EmailToType")
    public Object[][] getEmailToType(){
        return new Object[][]
                {
                        { "test@test.com"},
                        { "123@123.com"},
                        { "test@123.com"},
                        { "!#$%@test.com"}
                };
    }

    @Test (dataProvider = "EmailToType")
    public void checkUserCanTypeInEmailField(String emailToType) throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        afbMainPage.fillContactForm("Test Test", emailToType, "TestCompanyName", "https://testcompany.com", "Test Requirements");
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_SuccessText(), SUCCESSFULLY_SENT_MSG);
    }

    @Test (dataProvider = "StringToType")
    public void checkUserCanTypeInCompanyNameField(String companyNameToType) throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        afbMainPage.fillContactForm("Test Test", "test@test.com", companyNameToType, "https://testcompany.com", "Test Requirements");
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_SuccessText(), SUCCESSFULLY_SENT_MSG);
    }

    @Test (dataProvider = "StringToType")
    public void checkUserCanTypeInWebsiteField(String websiteToType) throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        afbMainPage.fillContactForm("Test Test", "test@test.com", "TestCompanyName", websiteToType, "Test Requirements");
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_SuccessText(), SUCCESSFULLY_SENT_MSG);
    }

    @Test (dataProvider = "StringToType")
    public void checkUserCanTypeInRequirementsField(String requirementsToType) throws Exception{
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        afbMainPage.fillContactForm("Test Test", "test@test.com", "TestCompanyName", "https://testcompany.com", requirementsToType);
        afbMainPage.clickOnGIT_SendButton();
        assertEquals(afbMainPage.getGIT_SuccessText(), SUCCESSFULLY_SENT_MSG);
    }

    //--------------------Second Level ------------------------------------------------------------------

    @Test
    public void checkHeaderLogoButtonIsDisplayedAndClickableFor_SD_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isHeaderLogoButtonDisplayed());
        softAssert.assertTrue(afbSecondLevelPage.isHeaderLogoButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkUserIsDirectedToHomePageAfterClickingOnHeaderLogoButtonFor_SD_Page() throws Exception {
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        assertEquals(afbSecondLevelPage.clickOnHeaderLogoButton(), HOME_URL);
    }

    @Test
    public void checkHeaderHomeButtonIsDisplayedAndClickableFor_SD_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isHeaderHomeButtonDisplayed());
        softAssert.assertTrue(afbSecondLevelPage.isHeaderHomeButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkUserIsDirectedToHomePageAfterClickingOnHeaderHomeButtonFor_SD_Page() throws Exception {
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        assertEquals(afbSecondLevelPage.clickOnHeaderHomeButton(), HOME_URL);
    }

    @Test
    public void checkHeaderGetInTouchButtonIsDisplayedAndClickableFor_SD_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isHeaderGetInTouchButtonDisplayed());
        softAssert.assertTrue(afbSecondLevelPage.isHeaderGetInTouchButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkUserIsDirectedToGITBlockAfterClickingOnHeaderHomeButtonFor_SD_Page() throws Exception {
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        assertEquals(afbSecondLevelPage.clickOnHeaderGetInTouchButton(), "6563");
    }

    //to continue
    @Test
    public void check2LevelReadMoreButton1IsDisplayedAndClickableFor_SD_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isReadMoreButton1Displayed());
        softAssert.assertTrue(afbSecondLevelPage.isReadMoreButton1Clickable());
        softAssert.assertAll();
    }

    @Test
    public void checkSeeAlsoDesignButtonIsDisplayedAndClickableFor_SD_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoDesignButtonDisplayed());
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoDesignButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkUserIsDirectedToDesignPageAfterClickingOnSeeAlsoDesignButtonFor_SD_Page() throws Exception {
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        assertEquals(afbSecondLevelPage.clickOnSeeAlsoDesignButton(), DESIGN_URL);
    }

    @Test
    public void checkSeeAlsoQualityAssuranceButtonIsDisplayedAndClickableFor_SD_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoQualityAssuranceButtonDisplayed());
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoQualityAssuranceButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkUserIsDirectedToQualityAssurancePageAfterClickingOnSeeAlsoQualityAssuranceButtonFor_SD_Page() throws Exception {
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(SOFTWARE_DEVELOPMENT_URL);
        assertEquals(afbSecondLevelPage.clickOnSeeAlsoQualityAssuranceButton(), QUALITY_ASSURANCE_URL);
    }

    @Test
    public void checkSeeAlsoSoftwareDevelopmentButtonIsDisplayedAndClickableFor_D_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(DESIGN_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoSoftwareDevelopmentButtonDisplayed());
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoSoftwareDevelopmentButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkUserIsDirectedToSoftwareDevelopmentPageAfterClickingOnSeeAlsoSoftwareDevelopmentButtonFor_D_Page() throws Exception {
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(DESIGN_URL);
        assertEquals(afbSecondLevelPage.clickOnSeeAlsoSoftwareDevelopmentButton(), SOFTWARE_DEVELOPMENT_URL);
    }

    @Test
    public void checkSeeAlsoQualityAssuranceButtonIsDisplayedAndClickableFor_D_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(DESIGN_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoQualityAssuranceButtonDisplayed());
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoQualityAssuranceButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkUserIsDirectedToQualityAssurancePageAfterClickingOnSeeAlsoQualityAssuranceButtonFor_D_Page() throws Exception {
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(DESIGN_URL);
        assertEquals(afbSecondLevelPage.clickOnSeeAlsoQualityAssuranceButton(), QUALITY_ASSURANCE_URL);
    }

    @Test
    public void checkSeeAlsoSoftwareDevelopmentButtonIsDisplayedAndClickableFor_QA_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(QUALITY_ASSURANCE_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoSoftwareDevelopmentButtonDisplayed());
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoSoftwareDevelopmentButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkUserIsDirectedToSoftwareDevelopmentPageAfterClickingOnSeeAlsoSoftwareDevelopmentButtonFor_QA_Page() throws Exception {
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(QUALITY_ASSURANCE_URL);
        assertEquals(afbSecondLevelPage.clickOnSeeAlsoSoftwareDevelopmentButton(), SOFTWARE_DEVELOPMENT_URL);
    }

    @Test
    public void checkSeeAlsoDesignButtonIsDisplayedAndClickableFor_QA_Page() throws Exception{
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(QUALITY_ASSURANCE_URL);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoDesignButtonDisplayed());
        softAssert.assertTrue(afbSecondLevelPage.isSeeAlsoDesignButtonClickable());
        softAssert.assertAll();
    }

    @Test
    public void checkUserIsDirectedToDesignPageAfterClickingOnSeeAlsoDesignButtonFor_QA_Page() throws Exception {
        afbSecondLevelPage = new AFBSecondLevelPage();
        afbSecondLevelPage.goToSecondLevelPage(QUALITY_ASSURANCE_URL);
        assertEquals(afbSecondLevelPage.clickOnSeeAlsoDesignButton(), DESIGN_URL);
    }

    @Test
    public void checkUserCanToggleFullScreenView() throws Exception {
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        afbMainPage.geo_toggleFullScreenView();
        assertTrue(afbMainPage.isGIT_SendButtonDisplayed());
    }

    @Test
    public void checkUserCanZoomTheMapInAndOut() throws Exception {
        afbMainPage = new AFBMainPage();
        afbMainPage.clickOnHeaderGetInTouch();
        afbMainPage.geo_zoomIn();
        afbMainPage.geo_zoomOut();
        assertTrue(afbMainPage.isGIT_SendButtonDisplayed());
    }











//    @Test
//    public void testFinance() throws Exception{
//        FinanceBO financeBO = new FinanceBO();
//        financeBO.savePriceChanges();
//        financeBO.saveHOLValues();
//        financeBO.transformPriceChangesToXML();
//        financeBO.sendPriceChanges();
//    }



//    @AfterMethod(alwaysRun = true)
//    public void tearDown() throws Exception {
//       DriverFactory.closeDriver();
//    }
}
