package xml;

import javax.xml.bind.JAXBException;
import java.io.*;

public class Main3 {
    public static void main(String[] args) throws IOException, JAXBException {
        System.out.println(Query.deserialize().toString());
    }
}