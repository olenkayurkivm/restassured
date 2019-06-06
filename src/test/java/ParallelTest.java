import driver.DriverManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Created by OYurkiv on 5/14/2019.
 */
public class ParallelTest {

    private static Logger LOG = Logger.getLogger(ParallelTest.class);

    @BeforeMethod
    public void beforeMethod() {
        DriverManager.getThread();
    }



    @Test
    public void test1(){
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/pricing");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/contactus");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
    }

    @Test
    public void test2(){
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/pricing");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/contactus");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
    }

    @Test
    public void test3(){
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/pricing");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/contactus");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
    }

    @Test
    public void test4(){
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/pricing");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
        DriverManager.getDriver().get("https://getesa.com/contactus");
        LOG.info(String.format("Thread.currentThread().getId()  %d", Thread.currentThread().getId()));
    }

    @AfterMethod
    public void afterMethod() {
        DriverManager.releaseThread();
    }

}
