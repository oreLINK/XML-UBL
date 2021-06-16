package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class TaxCategory {

    private Document doc;
    private Element element;
    private String id;
    private String id_AttributeSchemeAgencyID;
    private String id_AttributeSchemeID;
    private String id_AttributeSchemeVersionID;
    private String percent;
    private List<TaxScheme> taxSchemeList = new ArrayList<>();

    private TaxCategory(TaxCategoryBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.id_AttributeSchemeAgencyID = builder.id_AttributeSchemeAgencyID;
        this.id_AttributeSchemeID = builder.id_AttributeSchemeID;
        this.id_AttributeSchemeVersionID = builder.id_AttributeSchemeVersionID;
        this.percent = builder.percent;
        this.taxSchemeList = builder.taxSchemeList;
    }

    public static class TaxCategoryBuilder {

        private Document doc;
        private Element element;
        private String id;
        private String id_AttributeSchemeAgencyID;
        private String id_AttributeSchemeID;
        private String id_AttributeSchemeVersionID;
        private String percent;
        private List<TaxScheme> taxSchemeList = new ArrayList<>();

        public TaxCategoryBuilder() {}

        public TaxCategoryBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxCategoryBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxCategoryBuilder id(String id){
            this.id = id;
            return this;
        }
        public TaxCategoryBuilder id_AttributeSchemeAgencyID(String id_AttributeSchemeAgencyID){
            this.id_AttributeSchemeAgencyID = id_AttributeSchemeAgencyID;
            return this;
        }
        public TaxCategoryBuilder id_AttributeSchemeID(String id_AttributeSchemeID){
            this.id_AttributeSchemeID = id_AttributeSchemeID;
            return this;
        }
        public TaxCategoryBuilder id_AttributeSchemeVersionID(String id_AttributeSchemeVersionID){
            this.id_AttributeSchemeVersionID = id_AttributeSchemeVersionID;
            return this;
        }
        public TaxCategoryBuilder percent(String percent){
            this.percent = percent;
            return this;
        }
        public TaxCategoryBuilder taxSchemeList(List<TaxScheme> taxSchemeList){
            this.taxSchemeList = taxSchemeList;
            return this;
        }
        public TaxCategory build(){
            TaxCategory taxCategory = new TaxCategory(this);
            return taxCategory;
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

    public String getPercent() {
        return percent;
    }

    public List<TaxScheme> getTaxSchemeList() {
        return taxSchemeList;
    }

    public Element load() {
        Element elementTaxCategory = new ElementT(doc, element, ElementsName.TAX_CATEGORY.label).load();
        if(!Tips.stringIsNull(id)){
            Element elementID = new ElementT(doc, elementTaxCategory, ElementsName.TAX_CATEGORY_ID.label, id).load();
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
        if(!Tips.stringIsNull(percent)){
            Element elementPercent = new ElementT(doc, elementTaxCategory, ElementsName.TAX_CATEGORY_PERCENT.label, percent).load();
        }
        if(!Tips.listIsNull(taxSchemeList)){
            for (TaxScheme taxScheme : taxSchemeList) {
                Element elementTaxScheme = new TaxScheme.TaxSchemeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxCategory)
                        .id(taxScheme.getId())
                        .id_AttributeSchemeAgencyID(taxScheme.getId_AttributeSchemeAgencyID())
                        .id_AttributeSchemeID(taxScheme.getId_AttributeSchemeID())
                        .id_AttributeSchemeVersionID(taxScheme.getId_AttributeSchemeVersionID())
                        .build().load();
            }
        }
        return elementTaxCategory;
    }

}
