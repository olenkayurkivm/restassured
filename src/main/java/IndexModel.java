import javax.xml.bind.annotation.XmlElement;

public class IndexModel {

    private String indexName;
    private String indexPriceChange;


    public String getIndexName() {
        return indexName;
    }
    @XmlElement
    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getIndexPriceChange() {
        return indexPriceChange;
    }
    @XmlElement
    public void setIndexPriceChange(String indexPriceChange) {
        this.indexPriceChange = indexPriceChange;
    }

    @Override
    public String toString() {
        return "IndexModel{" +
               "indexName='" + indexName + '\'' +
                ", indexPriceChange=" + indexPriceChange +
                '}';
    }

}
