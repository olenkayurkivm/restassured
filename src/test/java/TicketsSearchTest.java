import com.codeborne.selenide.Selenide;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tickets.TicketsSearchPage;

/**
 * Created by OYurkiv on 6/12/2019.
 */
public class TicketsSearchTest {
    final static Logger LOG = Logger.getLogger(TicketsSearchTest.class);
    TicketsSearchPage ticketsSearchPage;



    @Test
    public void searchFlights() throws Exception{
        ticketsSearchPage = new TicketsSearchPage();
        String url = ticketsSearchPage.searchForFlights("from", "to");
        LOG.info(url);
        ticketsSearchPage.parseResults();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
       //DriverFactory.closeDriver();
        Selenide.close();
    }
}
