import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by OYurkiv on 10/1/2018.
 */
public class FinanceTest {
    final static Logger LOG = Logger.getLogger(FinanceTest.class);
    //private static WebDriver driver;


//    @BeforeMethod
//    public static void setUp(){
//        System.out.println("Hello finance!!");
//    }

    @Test
    public void testFinance() throws Exception{
        FinanceBO financeBO = new FinanceBO();
        financeBO.savePriceChanges();
        financeBO.saveHOLValues();
        financeBO.transformPriceChangesToXML();
        financeBO.sendPriceChanges();
    }



//    @AfterMethod(alwaysRun = true)
//    public void tearDown() throws Exception {
//       DriverFactory.closeDriver();
//    }
}
