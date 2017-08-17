package xml;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="rate")
public class Rate {

    private String id;
    private String name;
    private double rate;
    private String date;
    private String time;
    private double ask;
    private double bid;

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name="Name")
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name="Rate")
    public void setRate(double rate) {
        this.rate = rate;
    }
    @XmlElement(name="Date")
    public void setDate(String date) {
        this.date = date;
    }
    @XmlElement(name="Time")
    public void setTime(String time) {
        this.time = time;
    }
    @XmlElement(name="Ask")
    public void setAsk(double ask) {
        this.ask = ask;
    }
    @XmlElement(name="Bid")
    public void setBid(double bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return  "\r\n" +
                "id=" + id + "\r\n" +
                "name=" + name + "\r\n" +
                "rate=" + rate + "\r\n" +
                "date=" + date + "\r\n" +
                "time=" + time + "\r\n" +
                "ask=" + ask + "\r\n" +
                "bid=" + bid + "\r\n";
    }
}
