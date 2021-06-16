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

public class PartyTaxScheme {

    private Document doc;
    private Element element;
    private String companyId;
    private String companyId_AttributeSchemeId;
    private List<TaxScheme> taxSchemeList = new ArrayList<>();

    private PartyTaxScheme(PartyTaxSchemeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.companyId = builder.companyId;
        this.companyId_AttributeSchemeId = builder.companyId_AttributeSchemeId;
        this.taxSchemeList = builder.taxSchemeList;
    }

    public static class PartyTaxSchemeBuilder {

        private Document doc;
        private Element element;
        private String companyId;
        private String companyId_AttributeSchemeId;
        private List<TaxScheme> taxSchemeList = new ArrayList<>();

        public PartyTaxSchemeBuilder(){}

        public PartyTaxSchemeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PartyTaxSchemeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyTaxSchemeBuilder companyId(String companyId){
            this.companyId = companyId;
            return this;
        }
        public PartyTaxSchemeBuilder companyId_AttributeSchemeId(String companyId_AttributeSchemeId){
            this.companyId_AttributeSchemeId = companyId_AttributeSchemeId;
            return this;
        }
        public PartyTaxSchemeBuilder taxSchemeList(List<TaxScheme> taxSchemeList){
            this.taxSchemeList = taxSchemeList;
            return this;
        }
        public PartyTaxScheme build(){
            PartyTaxScheme partyTaxScheme = new PartyTaxScheme(this);
            return partyTaxScheme;
        }

    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyId_AttributeSchemeId() {
        return companyId_AttributeSchemeId;
    }

    public List<TaxScheme> getTaxSchemeList() {
        return taxSchemeList;
    }

    public Element load() {
        Element elementPartyTaxScheme = new ElementT(doc,element, ElementsName.PARTY_TAX_SCHEME.label).load();
        if(!Tips.stringIsNull(companyId)){
            Element elementCompanyId = new ElementT(doc, elementPartyTaxScheme, ElementsName.PARTY_TAX_SCHEME_COMPANY_ID.label, companyId).load();
            if(!Tips.stringIsNull(companyId_AttributeSchemeId)) {
                Attr elementCompanyId_Attr1 = new AttributeT(doc, elementCompanyId, AttributesName.COMPANY_ID_SCHEME_ID.label, companyId_AttributeSchemeId).load();
            }
        }
        if(!Tips.listIsNull(taxSchemeList)){
            for (TaxScheme taxScheme : taxSchemeList) {
                Element elementTaxScheme = new TaxScheme.TaxSchemeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyTaxScheme)
                        .name(taxScheme.getName())
                        .build().load();
            }
        }
        return elementPartyTaxScheme;
    }

}
