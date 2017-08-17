package xml;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseXml {

    private String path;
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public ParseXml() {}
    public ParseXml(String path) {
        this.path = path;
    }
    public Document getXmlDocument() {
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(this.path);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }

        return document;
    }
    public Element getXmlDocumentRootElement() {
        return getXmlDocument().getDocumentElement();
    }
    public NodeList getXmlNodeList() {
        return getXmlDocumentRootElement().getChildNodes();
    }
    public void printAllXmlElements() {
        NodeList nodeList = getXmlNodeList();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                NodeList elements = node.getChildNodes();
                for (int j = 0; j < elements.getLength(); j++) {
                    Node element = elements.item(j);
                    if (element.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(element.getNodeName() + ": "
                                + element.getChildNodes().item(0).getTextContent());
                    }
                }
                System.out.println("------------------------");
            }
        }
    }
}