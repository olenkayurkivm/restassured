package tickets;

import com.codeborne.selenide.Configuration;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.AbstractPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

/**
 * Created by OYurkiv on 6/12/2019.
 */
public class TicketsAbstractPage {

    final static public String TICKETS_URL = "https://tickets.ua";
    final static Logger LOG = Logger.getLogger(TicketsAbstractPage.class);
    //private WebDriver driver = DriverFactory.getInstance();
    //private final WebDriverWait webDriverWait = new WebDriverWait(driver, 5);


    public TicketsAbstractPage() {
        //PageFactory.initElements((new DefaultElementLocatorFactory(driver)), this);
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriverv2.46.exe");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriverv74.exe");
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches","--disable-search-geolocation-disclosure");
        options.addArguments("chrome.switches","--disable-notifications");
        options.addArguments("--start-maximized");
        Map<String, Object> prefs = new HashMap<>();
        //prefs.put("profile.managed_default_content_settings.geolocation", 2);
        prefs.put("profile.managed_default_content_settings.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver webDriver = new ChromeDriver(options);
        //webDriver.navigate().to(TICKETS_URL);
        setWebDriver(webDriver);
        //Configuration.browserBinary = "src/main/resources/chromedriverv2.46.exe";
        //Configuration.startMaximized = true;
        Configuration.timeout = 20000; // default : 4000 - for should / shouldNot
        //Configuration.collectionsTimeout  = 20000; // default : 6000
        //Configuration.pollingInterval = 200; // default : 200
        //Configuration.headless = true;
        //Configuration.holdBrowserOpen = true; // browser window stays open after running tests
        //Configuration.pageLoadStrategy = "normal"; // Should webdriver wait until page is completely loaded. ("none" / "eager")
        //Configuration.proxyHost = "proxyHost";
        //Configuration.proxyPort = 8080;
        //Configuration.screenshots = true; // Defines if Selenide takes screenshots on failing tests
        //Configuration.reportsFolder = "C:/Users/OYurkiv/Documents/AFBWebsiteTestProject/screens";

        //Configuration.remote = "Url"; // URL of remote web driver (in case of using Selenium Grid)

        open(TICKETS_URL);
    }
}
