package com.company.xml.ubl.axioms;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class AttributeT
 */
public class AttributeT {

    private Document doc;
    private Element element;
    private String name;
    private String value;

    /**
     * Declaration of an empty attribute
     * @param doc document in which this attribute must be written.
     * @param element element in which this attribute must be written.
     * @param name attribute name
     * @param value attribute value
     */
    public AttributeT(Document doc, Element element, String name, String value) {
        this.doc = doc;
        this.element = element;
        this.name = name;
        this.value = value;
    }

    /**
     * Declaration of an empty attribute
     * @param name attribute name
     * @param value attribute value
     */
    public AttributeT(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Generating the filled attribute
     * @return the filled attribute
     */
    public Attr load() {
        Attr attr = doc.createAttribute(name);
        attr.setValue(value);
        element.setAttributeNode(attr);
        return attr;
    }

    public Document getDoc() {
        return doc;
    }

    public Element getElement() {
        return element;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
