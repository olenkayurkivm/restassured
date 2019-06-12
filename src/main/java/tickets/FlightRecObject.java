package tickets;

import java.util.List;

/**
 * Created by OYurkiv on 6/12/2019.
 */
public class FlightRecObject {
    private String aviaCompanyName;
    private List<String> raceNumbers;
    private String price;

    public String getAviaCompanyName() {
        return aviaCompanyName;
    }

    public void setAviaCompanyName(String aviaCompanyName) {
        this.aviaCompanyName = aviaCompanyName;
    }

    public List<String> getRaceNumbers() {
        return raceNumbers;
    }

    public void setRaceNumbers(List<String> raceNumbers) {
        this.raceNumbers = raceNumbers;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
