import org.apache.log4j.Logger;
import pom.FinancePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.back;

/**
 * Created by OYurkiv on 10/1/2018.
 */
public class FinanceBO {
    final static Logger LOG = Logger.getLogger(FinanceBO.class);

    private FinancePage financePage;

    List<String> indxNames = new ArrayList<>();
    List<String> absChanges = new ArrayList<>();
    List<String> relChanges = new ArrayList<>();
    HashMap<Integer, List<String>> indexesOHLValues = new HashMap<>();

    public FinanceBO() {
        financePage = new FinancePage();
    }

    public List<String> getWorldIndexesNames(){
        IntStream.range(0,5).forEach(i ->  indxNames.add(financePage.getIndexNameOf(i)));
        LOG.info(String.format("Index Name : %s", indxNames));
        return indxNames;
    }

    public List<String> getWorldIndexesAbsoluteChanges(){
        IntStream.range(0,5).forEach(i ->  absChanges.add(financePage.getIndexAbsoluteChangeOf(i)));
        LOG.info(String.format("Abs Change : %s", absChanges));
        return absChanges;
    }

    public List<String> getWorldIndexesRelativeChanges(){
        IntStream.range(0,5).forEach(i ->  relChanges.add(financePage.getIndexRelativeChangeOf(i)));
        LOG.info(String.format("Rel Change : %s", relChanges));
        return relChanges;
    }

    public void savePriceChanges(){
        DBProcessor.updatePriceChanges(getWorldIndexesNames(), getWorldIndexesAbsoluteChanges(), getWorldIndexesRelativeChanges());
    }

    public boolean transformPriceChangesToXML(){
        List<IndexModel> selectedIndexes = DBProcessor.selectIndexes();
        XMLTransformer.marshalToXML(selectedIndexes);
        return true;
    }

    public boolean sendPriceChanges(){
        List<IndexModel> selectedIndexes = DBProcessor.selectIndexes();
        EmailSender.sendMail(selectedIndexes.toArray());
        return true;
    }

    public HashMap<Integer,List<String>> getIndexOpenHighLowValues(){

        IntStream.range(0,5).forEach(i -> {
            List<String> indxOHLValues = new ArrayList<>();
            financePage.clickOnIndexOf(i);
            indxOHLValues.add(financePage.getIndexOpenValue());
            indxOHLValues.add(financePage.getIndexMaxValue());
            indxOHLValues.add(financePage.getIndexMinValue());
            LOG.info(String.format("Open-High-Low Values of %d-st index: %s", i, indxOHLValues));
            indexesOHLValues.put(i, indxOHLValues);
            back();
        });
        return indexesOHLValues;
    }

    public void saveHOLValues(){
        DBProcessor.updateIndexesValues(getIndexOpenHighLowValues());
    }

}
