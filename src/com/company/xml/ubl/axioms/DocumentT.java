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

public class DocumentT {

    private String name;
    private String path;
    private Document doc;
    private List<ElementT> listElementTS = new ArrayList<>();

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

    public void initialize() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.newDocument();
    }

    public void generate() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(path+name));
        transformer.transform(source, result);
    }

    /*public void addRootElement(ElementT elementT) {
        Element element = doc.createElement(elementT.getName());
        doc.appendChild(element);
    }

    public void joinElements(ElementT elementF, ElementT elementC) {
        Element elemChild = doc.createElement(elementC.getName());
        elementF.getElemFather().appendChild(elemChild);
    }*/

}
