package com.company.xml.ubl.axioms;

import com.company.xml.ubl.modules.TaxScheme;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ElementT {

    protected Document doc;
    protected Element elemFather;
    protected String name;
    protected String value;

    protected ElementT(ElementTBuilder builder) {
        this.doc = builder.doc;
        this.elemFather = builder.elemFather;
        this.name = builder.name;
        this.value = builder.value;
    }

    public static class ElementTBuilder {

        private Document doc;
        private Element elemFather;
        private String name;
        private String value;

        public ElementTBuilder() {}

        public ElementTBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public ElementTBuilder elementFather(Element element){
            this.elemFather = elemFather;
            return this;
        }
        public ElementTBuilder name(String name){
            this.name = name;
            return this;
        }
        public ElementTBuilder value(String value){
            this.value = value;
            return this;
        }
        public ElementT build(){
            ElementT elementT = new ElementT(this);
            return elementT;
        }

    }

    public ElementT(Document doc, String name) {
        this.doc = doc;
        this.name = name;
    }

    public ElementT(Document doc, Element elemFather, String name) {
        this.doc = doc;
        this.elemFather = elemFather;
        this.name = name;
    }

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

    public Element loadDoc() {
        Element element = doc.createElement(name);
        doc.appendChild(element);
        if (value != null && !value.trim().isEmpty()) {
            element.appendChild(doc.createTextNode(value));
        }
        return element;
    }

    public Element load() {
        Element element = doc.createElement(name);
        elemFather.appendChild(element);
        if(value != null && !value.trim().isEmpty()){
            element.appendChild(doc.createTextNode(value));
        }
        return element;
    }

    public void addAttr(AttributeT attributeT) {
        Attr attr = doc.createAttribute(attributeT.getName());
        attr.setValue(attributeT.getValue());
        elemFather.setAttributeNode(attr);
    }
}
