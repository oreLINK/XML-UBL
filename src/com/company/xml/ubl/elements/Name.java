package com.company.xml.ubl.elements;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Name {

    private Document doc;
    private Element element;
    private String name = ElementsName.NAME.label;
    private String value;
    private String languageID;

    private Name(ElementNameBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.languageID = builder.languageID;
    }

    public static class ElementNameBuilder {

        private Document doc;
        private Element element;
        private String value;
        private String languageID;

        public ElementNameBuilder() {}

        public ElementNameBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public ElementNameBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public ElementNameBuilder value(String value){
            this.value = value;
            return this;
        }
        public ElementNameBuilder languageID(String languageID){
            this.languageID = languageID;
            return this;
        }
        public Name build(){
            Name name = new Name(this);
            return name;
        }

    }

    public Element load() {
        Element elementName = new ElementT(doc, element, name, value).load();
        if(!Tips.stringIsNull(languageID)){
            Attr elementName_Attr1 = new AttributeT(doc, elementName, AttributesName.LANGUAGE_ID.label, languageID).load();
        }
        return elementName;
    }
}
