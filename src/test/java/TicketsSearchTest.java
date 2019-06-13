import com.codeborne.selenide.Selenide;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tickets.TicketsSearchBO;
import tickets.TicketsSearchPage;

/**
 * Created by OYurkiv on 6/12/2019.
 */
public class TicketsSearchTest {
    final static Logger LOG = Logger.getLogger(TicketsSearchTest.class);
    //TicketsSearchPage ticketsSearchPage;
    TicketsSearchBO ticketsSearchBO;



    @Test
    public void searchFlights() throws Exception{
        ticketsSearchBO = new TicketsSearchBO();
        ticketsSearchBO.searchForFlights("from", "Киев");
//        ticketsSearchPage = new TicketsSearchPage();
//        String url = ticketsSearchPage.searchForFlights("from", "Киев");
//        LOG.info(url);
        int actualNumberOfRecommendations = ticketsSearchBO.getRecommendedFlights();
        Assert.assertTrue(actualNumberOfRecommendations>0);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
       //DriverFactory.closeDriver();
        Selenide.close();
    }
}
