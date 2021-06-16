package com.company.xml.ubl.axioms;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AttributeT {

    private Document doc;
    private Element element;
    private String name;
    private String value;

    public AttributeT(Document doc, Element element, String name, String value) {
        this.doc = doc;
        this.element = element;
        this.name = name;
        this.value = value;
    }

    public AttributeT(String name, String value) {
        this.name = name;
        this.value = value;
    }

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
