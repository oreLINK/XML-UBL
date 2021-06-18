package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Element ID
 */
public class ID {

    private Document doc;
    private Element element;
    private String name = ElementsName.ID.label;
    private String value;
    private PatternScheme patternScheme;

    private ID(IDBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternScheme = builder.patternScheme;
    }


    public static class IDBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternScheme patternScheme;

        public IDBuilder() {}

        public IDBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public IDBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public IDBuilder value(String value){
            this.value = value;
            return this;
        }
        public IDBuilder attributes(PatternScheme patternScheme){
            this.patternScheme = patternScheme;
            return this;
        }
        public ID build(){
            ID ID = new ID(this);
            return ID;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternScheme getPatternScheme() {
        return patternScheme;
    }

    public Element load() {
        Element elementRoot = new ElementT(doc, element, name, value).load();
        if(!Tips.stringIsNull(patternScheme.getSchemeID())){
            Attr elementID_Attr1 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_ID.label, patternScheme.getSchemeID()).load();
        }
        if(!Tips.stringIsNull(patternScheme.getSchemeName())){
            Attr elementID_Attr2 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_NAME.label, patternScheme.getSchemeName()).load();
        }
        if(!Tips.stringIsNull(patternScheme.getSchemeAgencyID())){
            Attr elementID_Attr3 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_AGENCY_ID.label, patternScheme.getSchemeAgencyID()).load();
        }
        if(!Tips.stringIsNull(patternScheme.getSchemeAgencyName())){
            Attr elementID_Attr4 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_AGENCY_NAME.label, patternScheme.getSchemeAgencyName()).load();
        }
        if(!Tips.stringIsNull(patternScheme.getSchemeVersionID())){
            Attr elementID_Attr5 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_VERSION_ID.label, patternScheme.getSchemeVersionID()).load();
        }
        if(!Tips.stringIsNull(patternScheme.getSchemeDataURI())){
            Attr elementID_Attr6 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_DATA_URI.label, patternScheme.getSchemeDataURI()).load();
        }
        if(!Tips.stringIsNull(patternScheme.getSchemeURI())){
            Attr elementID_Attr7 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_URI.label, patternScheme.getSchemeURI()).load();
        }
        return elementRoot;
    }

}
