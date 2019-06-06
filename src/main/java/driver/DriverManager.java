package driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by OYurkiv on 5/14/2019.
 */
public class DriverManager {

    private static final Logger LOG = Logger.getLogger(DriverManager.class);

    private static Map<Long, WebDriver> drivers = new HashMap<>();
    private static Semaphore semaphore = new Semaphore(3);

    private DriverManager() {
    }

    private static WebDriver getInstance() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriverv2.46.exe");
        return new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            }
        };
    }

    public static WebDriver getDriver() {
        Long currentThread = Thread.currentThread().getId();
        WebDriver driver = drivers.get(currentThread);
        if (driver == null) {
            driver = getInstance();
            //LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
            drivers.put(currentThread, driver);
        }
        return driver;
    }

    public static void getThread() {
        LOG.info(String.format("In getDriverForThread : Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        getDriver();
//        try {
//            semaphore.acquire();
//            getDriver();
//        } catch (InterruptedException ex){
//            ex.printStackTrace();
//        }

    }

    public static void releaseThread() {
        LOG.info(String.format("In releaseDriverForThread : Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        if (DriverManager.getDriver() != null)
            DriverManager.getDriver().quit();
        drivers.remove(Thread.currentThread().getId());
        //semaphore.release();
    }

}
