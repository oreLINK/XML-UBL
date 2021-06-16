package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TaxScheme {

    private Document doc;
    private Element element;
    private String id;
    private String id_AttributeSchemeAgencyID;
    private String id_AttributeSchemeID;
    private String id_AttributeSchemeVersionID;
    private String name;

    private TaxScheme(TaxSchemeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.id_AttributeSchemeAgencyID = builder.id_AttributeSchemeAgencyID;
        this.id_AttributeSchemeID = builder.id_AttributeSchemeID;
        this.id_AttributeSchemeVersionID = builder.id_AttributeSchemeVersionID;
        this.name = builder.name;
    }

    public static class TaxSchemeBuilder {

        private Document doc;
        private Element element;
        private String id;
        private String id_AttributeSchemeAgencyID;
        private String id_AttributeSchemeID;
        private String id_AttributeSchemeVersionID;
        private String name;

        public TaxSchemeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxSchemeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxSchemeBuilder id(String id){
            this.id = id;
            return this;
        }
        public TaxSchemeBuilder id_AttributeSchemeAgencyID(String id_AttributeSchemeAgencyID){
            this.id_AttributeSchemeAgencyID = id_AttributeSchemeAgencyID;
            return this;
        }
        public TaxSchemeBuilder id_AttributeSchemeID(String id_AttributeSchemeID){
            this.id_AttributeSchemeID = id_AttributeSchemeID;
            return this;
        }
        public TaxSchemeBuilder id_AttributeSchemeVersionID(String id_AttributeSchemeVersionID){
            this.id_AttributeSchemeVersionID = id_AttributeSchemeVersionID;
            return this;
        }
        public TaxSchemeBuilder name(String name){
            this.name = name;
            return this;
        }
        public TaxScheme build(){
            TaxScheme taxScheme = new TaxScheme(this);
            return taxScheme;
        }

    }

    public String getId() {
        return id;
    }

    public String getId_AttributeSchemeAgencyID() {
        return id_AttributeSchemeAgencyID;
    }

    public String getId_AttributeSchemeID() {
        return id_AttributeSchemeID;
    }

    public String getId_AttributeSchemeVersionID() {
        return id_AttributeSchemeVersionID;
    }

    public String getName() {
        return name;
    }

    public Element load() {
        Element elementTaxScheme = new ElementT(doc,element, ElementsName.TAX_SCHEME.label).load();
        if(!Tips.stringIsNull(id)){
            Element elementID = new ElementT(doc, elementTaxScheme, ElementsName.TAX_SCHEME_ID.label, id).load();
            if(!Tips.stringIsNull(id_AttributeSchemeAgencyID)){
                Attr elementID_Attr1 = new AttributeT(doc, elementID, AttributesName.SCHEME_AGENCY_ID.label, id_AttributeSchemeAgencyID).load();
            }
            if(!Tips.stringIsNull(id_AttributeSchemeID)){
                Attr elementID_Attr2 = new AttributeT(doc, elementID, AttributesName.SCHEME_ID.label, id_AttributeSchemeID).load();
            }
            if(!Tips.stringIsNull(id_AttributeSchemeVersionID)){
                Attr elementID_Attr3 = new AttributeT(doc, elementID, AttributesName.SCHEME_VERSION_ID.label, id_AttributeSchemeVersionID).load();
            }
        }
        if(!Tips.stringIsNull(name)){
            Element elementName = new ElementT(doc, elementTaxScheme, ElementsName.TAX_SCHEME_NAME.label, name).load();
        }
        return elementTaxScheme;
    }

}
