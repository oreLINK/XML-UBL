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
 * Class CustomizationID
 */
public class CustomizationID {

    private Document doc;
    private Element element;
    private String name = ElementsName.CUSTOMIZATION_ID.label;
    private String value;
    private PatternScheme patternScheme;

    /**
     * Documentation is coming...
     */
    private CustomizationID(CustomizationIDBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternScheme = builder.patternScheme;
    }

    /**
     * Builder CustomizationID
     */
    public static class CustomizationIDBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternScheme patternScheme;

        public CustomizationIDBuilder() {}

        public CustomizationIDBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public CustomizationIDBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public CustomizationIDBuilder value(String value){
            this.value = value;
            return this;
        }
        public CustomizationIDBuilder attributes(PatternScheme patternScheme){
            this.patternScheme = patternScheme;
            return this;
        }
        public CustomizationID build(){
            CustomizationID element = new CustomizationID(this);
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
        if(!(patternScheme == null)){
            if (!(patternScheme.getSchemeID() == null)) {
                Attr elementID_Attr1 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_ID.label, patternScheme.getSchemeID()).load();
            }
            if (!(patternScheme.getSchemeName() == null)) {
                Attr elementID_Attr2 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_NAME.label, patternScheme.getSchemeName()).load();
            }
            if (!(patternScheme.getSchemeAgencyID() == null)) {
                Attr elementID_Attr3 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_AGENCY_ID.label, patternScheme.getSchemeAgencyID()).load();
            }
            if (!(patternScheme.getSchemeAgencyName() == null)) {
                Attr elementID_Attr4 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_AGENCY_NAME.label, patternScheme.getSchemeAgencyName()).load();
            }
            if (!(patternScheme.getSchemeVersionID() == null)) {
                Attr elementID_Attr5 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_VERSION_ID.label, patternScheme.getSchemeVersionID()).load();
            }
            if (!(patternScheme.getSchemeDataURI() == null)) {
                Attr elementID_Attr6 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_DATA_URI.label, patternScheme.getSchemeDataURI()).load();
            }
            if (!(patternScheme.getSchemeURI() == null)) {
                Attr elementID_Attr7 = new AttributeT(doc, elementRoot, AttributesName.SCHEME_URI.label, patternScheme.getSchemeURI()).load();
            }
        }
        return elementRoot;
    }

}
