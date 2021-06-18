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
 * Class UBLVersionID
 */
public class UBLVersionID {

    private Document doc;
    private Element element;
    private String name = ElementsName.UBL_VERSION_ID.label;
    private String value;
    private PatternScheme patternScheme;

    /**
     * Documentation is coming...
     */
    private UBLVersionID(ElementUBLVersionIDBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternScheme = builder.patternScheme;
    }

    /**
     * Builder ElementUBLVersionID
     */
    public static class ElementUBLVersionIDBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternScheme patternScheme;

        public ElementUBLVersionIDBuilder() {}

        public ElementUBLVersionIDBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public ElementUBLVersionIDBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public ElementUBLVersionIDBuilder value(String value){
            this.value = value;
            return this;
        }
        public ElementUBLVersionIDBuilder attributes(PatternScheme patternScheme){
            this.patternScheme = patternScheme;
            return this;
        }
        public UBLVersionID build(){
            UBLVersionID element = new UBLVersionID(this);
            return element;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternScheme getPatternScheme() {
        return patternScheme;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
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
