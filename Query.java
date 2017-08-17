package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

@XmlRootElement(name="query")
public class Query {

    @XmlElement(name="results")
    private Results[] results;

    public static Query deserialize(){
        Query query = new Query();
        String url = "http://query.yahooapis.com/v1/public/yql?format=xml" +
                     "&q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20"+
                     "(%22USDEUR%22,%20%22USDUAH%22)&env=store://datatables.org/alltableswithkeys";
        try {
            query = (Query) JAXBContext.newInstance(Query.class)
                                       .createUnmarshaller()
                                       .unmarshal(new URL(url));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public String toString() {
        return Arrays.toString(results);
    }
}
