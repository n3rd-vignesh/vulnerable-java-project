package com.example;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XXEExample {
    public void run() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                     "<!DOCTYPE root [<!ENTITY xxe SYSTEM \"file:///etc/passwd\">]>" +
                     "<root>&xxe;</root>";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));
            System.out.println(document.getDocumentElement().getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
