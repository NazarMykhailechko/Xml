package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name="results")
public class Results {

    @XmlElement(name="rate")
    private Rate[] rate;

    @Override
    public String toString() {
        return Arrays.toString(rate);
    }
}
