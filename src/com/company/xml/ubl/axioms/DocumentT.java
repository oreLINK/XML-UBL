package com.company.xml.ubl.axioms;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class DocumentT
 */
public class DocumentT {

    private String name;
    private String path;
    private Document doc;
    private List<ElementT> listElementTS = new ArrayList<>();

    /**
     * Declaration of an empty document
     * @param name document name
     * @param path document path
     */
    public DocumentT(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public Document getDoc() {
        return doc;
    }

    public List<ElementT> getListElementTS() {
        return listElementTS;
    }

    /**
     * Initializing an empty document
     * @throws ParserConfigurationException
     */
    public void initialize() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.newDocument();
    }

    /**
     * Generation of the completed document
     * @throws TransformerException
     */
    public void generate() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(path+name));
        transformer.transform(source, result);
    }

}
