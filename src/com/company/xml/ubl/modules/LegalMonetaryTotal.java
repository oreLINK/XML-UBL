package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LegalMonetaryTotal {

    private Document doc;
    private Element element;
    private String lineExtensionAmount;
    private String lineExtensionAmount_AttributeCurrencyID;
    private String taxExclusiveAmount;
    private String taxExclusiveAmount_AttributeCurrencyID;
    private String taxInclusiveAmount;
    private String taxInclusiveAmount_AttributeCurrencyID;
    private String payableAmount;
    private String payableAmount_AttributeCurrencyID;

    private LegalMonetaryTotal(LegalMonetaryTotalBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.lineExtensionAmount = builder.lineExtensionAmount;
        this.lineExtensionAmount_AttributeCurrencyID = builder.lineExtensionAmount_AttributeCurrencyID;
        this.taxExclusiveAmount = builder.taxExclusiveAmount;
        this.taxExclusiveAmount_AttributeCurrencyID = builder.taxExclusiveAmount_AttributeCurrencyID;
        this.taxInclusiveAmount = builder.taxInclusiveAmount;
        this.taxInclusiveAmount_AttributeCurrencyID = builder.taxInclusiveAmount_AttributeCurrencyID;
        this.payableAmount = builder.payableAmount;
        this.payableAmount_AttributeCurrencyID = builder.payableAmount_AttributeCurrencyID;
    }

    public static class LegalMonetaryTotalBuilder {

        private Document doc;
        private Element element;
        private String lineExtensionAmount;
        private String lineExtensionAmount_AttributeCurrencyID;
        private String taxExclusiveAmount;
        private String taxExclusiveAmount_AttributeCurrencyID;
        private String taxInclusiveAmount;
        private String taxInclusiveAmount_AttributeCurrencyID;
        private String payableAmount;
        private String payableAmount_AttributeCurrencyID;

        public LegalMonetaryTotalBuilder() {}

        public LegalMonetaryTotalBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public LegalMonetaryTotalBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public LegalMonetaryTotalBuilder lineExtensionAmount(String lineExtensionAmount){
            this.lineExtensionAmount = lineExtensionAmount;
            return this;
        }
        public LegalMonetaryTotalBuilder lineExtensionAmount_AttributeCurrencyID(String lineExtensionAmount_AttributeCurrencyID){
            this.lineExtensionAmount_AttributeCurrencyID = lineExtensionAmount_AttributeCurrencyID;
            return this;
        }
        public LegalMonetaryTotalBuilder taxExclusiveAmount(String taxExclusiveAmount){
            this.taxExclusiveAmount = taxExclusiveAmount;
            return this;
        }
        public LegalMonetaryTotalBuilder taxExclusiveAmount_AttributeCurrencyID(String taxExclusiveAmount_AttributeCurrencyID){
            this.taxExclusiveAmount_AttributeCurrencyID = taxExclusiveAmount_AttributeCurrencyID;
            return this;
        }
        public LegalMonetaryTotalBuilder taxInclusiveAmount(String taxInclusiveAmount){
            this.taxInclusiveAmount = taxInclusiveAmount;
            return this;
        }
        public LegalMonetaryTotalBuilder taxInclusiveAmount_AttributeCurrencyID(String taxInclusiveAmount_AttributeCurrencyID){
            this.taxInclusiveAmount_AttributeCurrencyID = taxInclusiveAmount_AttributeCurrencyID;
            return this;
        }
        public LegalMonetaryTotalBuilder payableAmount(String payableAmount){
            this.payableAmount = payableAmount;
            return this;
        }
        public LegalMonetaryTotalBuilder payableAmount_AttributeCurrencyID(String payableAmount_AttributeCurrencyID){
            this.payableAmount_AttributeCurrencyID = payableAmount_AttributeCurrencyID;
            return this;
        }
        public LegalMonetaryTotal build(){
            LegalMonetaryTotal legalMonetaryTotal = new LegalMonetaryTotal(this);
            return legalMonetaryTotal;
        }

    }

    public Element load() {
        Element elementLegalMonetaryTotal = new ElementT(doc, element, ElementsName.LEGAL_MONETARY_TOTAL.label).load();
        if (!Tips.stringIsNull(lineExtensionAmount)) {
            Element elementLineExtensionAmount = new ElementT(doc, elementLegalMonetaryTotal, ElementsName.LEGAL_MONETARY_TOTAL_LINE_EXTENSION_AMOUNT.label, lineExtensionAmount).load();
            if (!Tips.stringIsNull(lineExtensionAmount_AttributeCurrencyID)) {
                Attr elementLineExtensionAmount_Attr1 = new AttributeT(doc, elementLineExtensionAmount, AttributesName.CURRENCY_ID.label, lineExtensionAmount_AttributeCurrencyID).load();
            }
        }
        if (!Tips.stringIsNull(taxExclusiveAmount)) {
            Element elementTaxExclusiveAmount = new ElementT(doc, elementLegalMonetaryTotal, ElementsName.LEGAL_MONETARY_TOTAL_TAX_EXCLUSIVE_AMOUNT.label, taxExclusiveAmount).load();
            if (!Tips.stringIsNull(taxExclusiveAmount_AttributeCurrencyID)) {
                Attr elementTaxExclusiveAmount_Attr1 = new AttributeT(doc, elementTaxExclusiveAmount, AttributesName.CURRENCY_ID.label, taxExclusiveAmount_AttributeCurrencyID).load();
            }
        }
        if (!Tips.stringIsNull(taxInclusiveAmount)) {
            Element elementTaxInclusiveAmount = new ElementT(doc, elementLegalMonetaryTotal, ElementsName.LEGAL_MONETARY_TOTAL_TAX_INCLUSIVE_AMOUNT.label, taxInclusiveAmount).load();
            if (!Tips.stringIsNull(taxInclusiveAmount_AttributeCurrencyID)) {
                Attr elementTaxInclusiveAmount_Attr1 = new AttributeT(doc, elementTaxInclusiveAmount, AttributesName.CURRENCY_ID.label, taxInclusiveAmount_AttributeCurrencyID).load();
            }
        }
        if (!Tips.stringIsNull(payableAmount)) {
            Element elementPayableAmount = new ElementT(doc, elementLegalMonetaryTotal, ElementsName.LEGAL_MONETARY_TOTAL_PAYABLE_AMOUNT.label, payableAmount).load();
            if (!Tips.stringIsNull(payableAmount_AttributeCurrencyID)) {
                Attr elementPayableAmount_Attr1 = new AttributeT(doc, elementPayableAmount, AttributesName.CURRENCY_ID.label, payableAmount_AttributeCurrencyID).load();
            }
        }
        return elementLegalMonetaryTotal;
    }
}
