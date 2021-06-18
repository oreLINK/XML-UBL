package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DocumentCurrencyCode {

    private Document doc;
    private Element element;
    private String name = ElementsName.DOC_CURRENCY_CODE.label;
    private String value;
    private PatternList patternList;

    private DocumentCurrencyCode(DocumentCurrencyCodeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternList = builder.patternList;
    }

    public static class DocumentCurrencyCodeBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternList patternList;

        public DocumentCurrencyCodeBuilder() {}

        public DocumentCurrencyCodeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public DocumentCurrencyCodeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public DocumentCurrencyCodeBuilder value(String value){
            this.value = value;
            return this;
        }
        public DocumentCurrencyCodeBuilder attributes(PatternList patternList){
            this.patternList = patternList;
            return this;
        }
        public DocumentCurrencyCode build(){
            DocumentCurrencyCode element = new DocumentCurrencyCode(this);
            return element;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternList getPatternList() {
        return patternList;
    }

    public Element load() {
        Element elementRoot = new ElementT(doc, element, name, value).load();
        if(!Tips.stringIsNull(patternList.getListID())){
            Attr elementID_Attr1 = new AttributeT(doc, elementRoot, AttributesName.LIST_ID.label, patternList.getListID()).load();
        }
        if(!Tips.stringIsNull(patternList.getListAgencyID())){
            Attr elementID_Attr2 = new AttributeT(doc, elementRoot, AttributesName.LIST_AGENCY_ID.label, patternList.getListAgencyID()).load();
        }
        if(!Tips.stringIsNull(patternList.getListAgencyName())){
            Attr elementID_Attr3 = new AttributeT(doc, elementRoot, AttributesName.LIST_AGENCY_NAME.label, patternList.getListAgencyName()).load();
        }
        if(!Tips.stringIsNull(patternList.getListName())){
            Attr elementID_Attr4 = new AttributeT(doc, elementRoot, AttributesName.LIST_NAME.label, patternList.getListName()).load();
        }
        if(!Tips.stringIsNull(patternList.getListVersionID())){
            Attr elementID_Attr5 = new AttributeT(doc, elementRoot, AttributesName.LIST_VERSION_ID.label, patternList.getListVersionID()).load();
        }
        if(!Tips.stringIsNull(patternList.getName())){
            Attr elementID_Attr6 = new AttributeT(doc, elementRoot, AttributesName.NAME.label, patternList.getName()).load();
        }
        if(!Tips.stringIsNull(patternList.getLanguageID())){
            Attr elementID_Attr7 = new AttributeT(doc, elementRoot, AttributesName.LANGUAGE_ID.label, patternList.getLanguageID()).load();
        }
        if(!Tips.stringIsNull(patternList.getListURI())){
            Attr elementID_Attr6 = new AttributeT(doc, elementRoot, AttributesName.LIST_URI.label, patternList.getListURI()).load();
        }
        if(!Tips.stringIsNull(patternList.getListSchemeURI())){
            Attr elementID_Attr7 = new AttributeT(doc, elementRoot, AttributesName.LIST_SCHEME_URI.label, patternList.getListSchemeURI()).load();
        }
        return elementRoot;
    }

}
