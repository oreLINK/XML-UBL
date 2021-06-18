package com.company.xml.ubl.axioms;

import com.company.xml.ubl.modules.TaxScheme;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class ElementT
 */
public class ElementT {

    private Document doc;
    private Element elemFather;
    private String name;
    private String value;

    /**
     * Declaration of an empty element
     * @param doc document in which this element must be written.
     * @param name element name
     */
    public ElementT(Document doc, String name) {
        this.doc = doc;
        this.name = name;
    }

    /**
     * Declaration of an empty element
     * @param doc document in which this element must be written.
     * @param elemFather father element in which this element must be written.
     * @param name element name
     */
    public ElementT(Document doc, Element elemFather, String name) {
        this.doc = doc;
        this.elemFather = elemFather;
        this.name = name;
    }

    /**
     * Declaration of an empty element
     * @param doc document in which this element must be written.
     * @param elemFather father element in which this element must be written.
     * @param name element name
     * @param value element value
     */
    public ElementT(Document doc, Element elemFather, String name, String value) {
        this.doc = doc;
        this.elemFather = elemFather;
        this.name = name;
        this.value = value;
    }

    public Document getDoc() {
        return doc;
    }

    public Element getElemFather() {
        return elemFather;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    /**
     * Generation of the first completed element of the document which will contain all the other elements
     * @return root element
     */
    public Element loadDoc() {
        Element element = doc.createElement(name);
        doc.appendChild(element);
        if (value != null && !value.trim().isEmpty()) {
            element.appendChild(doc.createTextNode(value));
        }
        return element;
    }

    /**
     * Generation of an element filled with a parent element
     * @return child element
     */
    public Element load() {
        Element element = doc.createElement(name);
        elemFather.appendChild(element);
        if(value != null && !value.trim().isEmpty()){
            element.appendChild(doc.createTextNode(value));
        }
        return element;
    }
}
