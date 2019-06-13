package tickets;

/**
 * Created by OYurkiv on 6/13/2019.
 */
public class TicketsSearchBO {

    TicketsSearchPage ticketsSearchPage = new TicketsSearchPage();


    public String searchForFlights(String fromCity, String toCIty)throws  Exception{
        ticketsSearchPage.chooseOneWayOption();
        ticketsSearchPage.fillFromAntTo(fromCity, toCIty);
        ticketsSearchPage.chooseTodayDate();
        return ticketsSearchPage.goToSearchResults();
    }

    public int getRecommendedFlights()throws  Exception{
        return ticketsSearchPage.parseResults();
    }
}
