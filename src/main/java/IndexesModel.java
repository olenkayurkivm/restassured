import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "indexes")
@XmlAccessorType(XmlAccessType.FIELD)
public class IndexesModel {

    @XmlElement(name = "index")
    private List<IndexModel> indexes = null;

    public List<IndexModel> getIndexes () {
        return indexes;
    }

    public void setIndexes (List<IndexModel> indexes){
        this.indexes = indexes;
    }
}
