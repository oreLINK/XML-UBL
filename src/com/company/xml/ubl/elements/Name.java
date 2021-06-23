package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternLanguage;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Name
 */
public class Name {

    private Document doc;
    private Element element;
    private String name = ElementsName.NAME.label;
    private String value;
    private PatternLanguage patternLanguage;

    /**
     * Documentation is coming...
     */
    private Name(NameBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternLanguage = builder.patternLanguage;
    }

    /**
     * Builder Name
     */
    public static class NameBuilder {

        private Document doc;
        private Element element;
        private String name = ElementsName.NAME.label;
        private String value;
        private PatternLanguage patternLanguage;

        public NameBuilder() {}

        public NameBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public NameBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public NameBuilder value(String value){
            this.value = value;
            return this;
        }
        public NameBuilder attributes(PatternLanguage patternLanguage){
            this.patternLanguage = patternLanguage;
            return this;
        }
        public Name build(){
            Name name = new Name(this);
            return name;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternLanguage getPatternLanguage() {
        return patternLanguage;
    }

    public boolean isNull() {
        if(Tips.stringIsNull(value)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementName = new ElementT(doc, element, name, value).load();
        if(!(patternLanguage == null)){
            if(!(patternLanguage.getLanguageID() == null)){
                Attr elementName_Attr1 = new AttributeT(doc, elementName, AttributesName.LANGUAGE_ID.label, patternLanguage.getLanguageID()).load();
            }
        }
        return elementName;
    }
}
