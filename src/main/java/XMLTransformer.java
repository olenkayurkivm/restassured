import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class XMLTransformer {
    private static final Logger LOG = Logger.getLogger(XMLTransformer.class);
    private static final String OUTPUT_XML_NAME = "src/main/resources/bestindexes.xml";

    public static void marshalToXML(List<IndexModel> indexes) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(IndexesModel.class, IndexModel.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            IndexesModel indexesModel = new IndexesModel();
            indexesModel.setIndexes(indexes);
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(indexes, new File(OUTPUT_XML_NAME));
            LOG.info("New XML is created");
            jaxbMarshaller.marshal(indexes, System.out);
        } catch (JAXBException e) {
            LOG.info("JAXB exception");
            e.printStackTrace();
        }
    }
}
