package pom;

import com.codeborne.selenide.Configuration;

import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.*;



/**
 * Created by OYurkiv on 10/1/2018.
 */
public class AbstractPage {

    final static public String WEB_URL = "https://finance.google.com/finance";
    final static public String AFB_URL = "http://18.218.182.166:3000/";
    final static Logger LOG = Logger.getLogger(AbstractPage.class);
    //private WebDriver driver = DriverFactory.getInstance();
    //private final WebDriverWait webDriverWait = new WebDriverWait(driver, 5);



    public AbstractPage()  {
        //PageFactory.initElements((new DefaultElementLocatorFactory(driver)), this);
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriverv2.46.exe");
        Configuration.browser = "chrome";
        //Configuration.browserBinary = "src/main/resources/chromedriverv2.46.exe";
        Configuration.startMaximized = true;
        Configuration.timeout = 20000; // default : 4000 - for should / shouldNot
        //Configuration.collectionsTimeout  = 20000; // default : 6000
        //Configuration.pollingInterval = 200; // default : 200
        //Configuration.headless = true;
        //Configuration.holdBrowserOpen = true; // browser window stays open after running tests
        //Configuration.pageLoadStrategy = "normal"; // Should webdriver wait until page is completely loaded. ("none" / "eager")
        //Configuration.proxyHost = "proxyHost";
        //Configuration.proxyPort = 8080;
        Configuration.screenshots = true; // Defines if Selenide takes screenshots on failing tests
        Configuration.reportsFolder = "C:/Users/OYurkiv/Documents/AFBWebsiteTestProject/screens";

        //Configuration.remote = "Url"; // URL of remote web driver (in case of using Selenium Grid)

        open(AFB_URL);
    }

}
