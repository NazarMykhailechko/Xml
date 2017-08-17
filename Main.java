package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        Document document = DocumentBuilderFactory.newInstance()
                                                  .newDocumentBuilder()
                                                  .newDocument();

        Element root = document.createElement("root");
        document.appendChild(root);

        for (int i = 0; i <5; i++) {
            Element node = document.createElement("node" + i);
            for (int j = 0; j < 3; j++) {
                Element node1 = document.createElement("element" + j);
                node1.setTextContent("" + i);
                node.appendChild(node1);
            }
            root.appendChild(node);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource doms = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("D:\\test.xml"));
        transformer.transform(doms,streamResult);

    }
}
