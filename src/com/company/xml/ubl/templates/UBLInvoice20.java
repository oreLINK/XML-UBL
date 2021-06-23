package com.company.xml.ubl.templates;

import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.data.NamespacesName;
import com.company.xml.ubl.elements.*;
import com.company.xml.ubl.modules.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public class UBLInvoice20 {

    private Document doc;
    private UBLVersionID ublVersionID;
    private CustomizationID customizationID;
    private ProfileID profileID;
    private ID id;
    private IssueDate issueDate;
    private InvoiceTypeCode invoiceTypeCode;
    private DocumentCurrencyCode documentCurrencyCode;
    private OrderReference orderReference;
    private List<AdditionalDocumentReference> additionalDocumentReferenceList;
    private AccountingSupplierParty accountingSupplierParty;
    private AccountingCustomerParty accountingCustomerParty;
    private List<PaymentMeans> paymentMeansList;
    private List<TaxTotal> taxTotalList;
    private LegalMonetaryTotal legalMonetaryTotal;
    private List<InvoiceLine> invoiceLineList;

    /**
     * Documentation is coming...
     */
    private UBLInvoice20(UBLInvoice20Builder builder) {
        this.doc = builder.doc;
        this.ublVersionID = builder.ublVersionID;
        this.customizationID = builder.customizationID;
        this.profileID = builder.profileID;
        this.id = builder.id;
        this.issueDate = builder.issueDate;
        this.invoiceTypeCode = builder.invoiceTypeCode;
        this.documentCurrencyCode = builder.documentCurrencyCode;
        this.orderReference = builder.orderReference;
        this.additionalDocumentReferenceList = builder.additionalDocumentReferenceList;
        this.accountingSupplierParty = builder.accountingSupplierParty;
        this.accountingCustomerParty = builder.accountingCustomerParty;
        this.paymentMeansList = builder.paymentMeansList;
        this.taxTotalList = builder.taxTotalList;
        this.legalMonetaryTotal = builder.legalMonetaryTotal;
        this.invoiceLineList = builder.invoiceLineList;
    }

    /**
     * Builder UBLInvoice20
     */
    public static class UBLInvoice20Builder {

        private Document doc;
        private UBLVersionID ublVersionID;
        private CustomizationID customizationID;
        private ProfileID profileID;
        private ID id;
        private IssueDate issueDate;
        private InvoiceTypeCode invoiceTypeCode;
        private DocumentCurrencyCode documentCurrencyCode;
        private OrderReference orderReference;
        private List<AdditionalDocumentReference> additionalDocumentReferenceList;
        private AccountingSupplierParty accountingSupplierParty;
        private AccountingCustomerParty accountingCustomerParty;
        private List<PaymentMeans> paymentMeansList;
        private List<TaxTotal> taxTotalList;
        private LegalMonetaryTotal legalMonetaryTotal;
        private List<InvoiceLine> invoiceLineList;

        public UBLInvoice20Builder() {}

        public UBLInvoice20Builder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public UBLInvoice20Builder ublVersionID(UBLVersionID ublVersionID){
            this.ublVersionID = ublVersionID;
            return this;
        }
        public UBLInvoice20Builder customizationID(CustomizationID customizationID){
            this.customizationID = customizationID;
            return this;
        }
        public UBLInvoice20Builder profileID(ProfileID profileID){
            this.profileID = profileID;
            return this;
        }
        public UBLInvoice20Builder id(ID id){
            this.id = id;
            return this;
        }
        public UBLInvoice20Builder issueDate(IssueDate issueDate){
            this.issueDate = issueDate;
            return this;
        }
        public UBLInvoice20Builder invoiceTypeCode(InvoiceTypeCode invoiceTypeCode){
            this.invoiceTypeCode = invoiceTypeCode;
            return this;
        }
        public UBLInvoice20Builder documentCurrencyCode(DocumentCurrencyCode documentCurrencyCode){
            this.documentCurrencyCode = documentCurrencyCode;
            return this;
        }
        public UBLInvoice20Builder orderReference(OrderReference orderReference){
            this.orderReference = orderReference;
            return this;
        }
        public UBLInvoice20Builder additionalDocumentReferenceList(List<AdditionalDocumentReference> additionalDocumentReferenceList){
            this.additionalDocumentReferenceList = additionalDocumentReferenceList;
            return this;
        }
        public UBLInvoice20Builder accountingSupplierParty(AccountingSupplierParty accountingSupplierParty){
            this.accountingSupplierParty = accountingSupplierParty;
            return this;
        }
        public UBLInvoice20Builder accountingCustomerParty(AccountingCustomerParty accountingCustomerParty){
            this.accountingCustomerParty = accountingCustomerParty;
            return this;
        }
        public UBLInvoice20Builder paymentMeansList(List<PaymentMeans> paymentMeansList){
            this.paymentMeansList = paymentMeansList;
            return this;
        }
        public UBLInvoice20Builder taxTotalList(List<TaxTotal> taxTotalList){
            this.taxTotalList = taxTotalList;
            return this;
        }
        public UBLInvoice20Builder legalMonetaryTotal(LegalMonetaryTotal legalMonetaryTotal){
            this.legalMonetaryTotal = legalMonetaryTotal;
            return this;
        }
        public UBLInvoice20Builder invoiceLineList(List<InvoiceLine> invoiceLineList){
            this.invoiceLineList = invoiceLineList;
            return this;
        }
        public UBLInvoice20 build(){
            UBLInvoice20 ublInvoice20 = new UBLInvoice20(this);
            return ublInvoice20;
        }

    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementInvoice = new ElementT(doc, ElementsName.INVOICE.label).loadDoc();
        Attr elementInvoice_Attr1 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS.label, NamespacesName.XMLNS_IMPORT.label).load();
        Attr elementInvoice_Attr2 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_CAC_ATTR.label, NamespacesName.XMLNS_CAC_IMPORT.label).load();
        Attr elementInvoice_Attr3 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_CBC_ATTR.label, NamespacesName.XMLNS_CBC_IMPORT.label).load();
        Attr elementInvoice_Attr4 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_CCTS_ATTR.label, NamespacesName.XMLNS_CCTS_IMPORT.label).load();
        Attr elementInvoice_Attr5 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_EXT_ATTR.label, NamespacesName.XMLNS_EXT_IMPORT.label).load();
        Attr elementInvoice_Attr6 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_NS7_ATTR.label, NamespacesName.XMLNS_NS7_IMPORT.label).load();
        Attr elementInvoice_Attr7 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_SDT_ATTR.label, NamespacesName.XMLNS_SDT_IMPORT.label).load();
        Attr elementInvoice_Attr8 = new AttributeT(doc, elementInvoice, NamespacesName.XMLNS_UDT_ATTR.label, NamespacesName.XMLNS_UDT_IMPORT.label).load();

        if(!Tips.stringIsNull(ublVersionID.getValue())){
            if(!(ublVersionID.getPatternScheme() == null)){
                Element elementUBLVersionID = new UBLVersionID.ElementUBLVersionIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(ublVersionID.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(ublVersionID.getPatternScheme().getSchemeID())
                                .schemeName(ublVersionID.getPatternScheme().getSchemeName())
                                .schemeAgencyID(ublVersionID.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(ublVersionID.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(ublVersionID.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(ublVersionID.getPatternScheme().getSchemeDataURI())
                                .schemeURI(ublVersionID.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementUBLVersionID = new UBLVersionID.ElementUBLVersionIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(ublVersionID.getValue())
                        .build().load();
            }
        }
        if(!Tips.stringIsNull(customizationID.getValue())){
            if(!(customizationID.getPatternScheme() == null)){
                Element elementCustomizationID = new CustomizationID.CustomizationIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(customizationID.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(customizationID.getPatternScheme().getSchemeID())
                                .schemeName(customizationID.getPatternScheme().getSchemeName())
                                .schemeAgencyID(customizationID.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(customizationID.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(customizationID.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(customizationID.getPatternScheme().getSchemeDataURI())
                                .schemeURI(customizationID.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementCustomizationID = new CustomizationID.CustomizationIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(customizationID.getValue())
                        .build().load();
            }
        }
        if(!Tips.stringIsNull(profileID.getValue())){
            if(!(profileID.getPatternScheme() == null)){
                Element elementProfileID = new ProfileID.ProfileIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(profileID.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(profileID.getPatternScheme().getSchemeID())
                                .schemeName(profileID.getPatternScheme().getSchemeName())
                                .schemeAgencyID(profileID.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(profileID.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(profileID.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(profileID.getPatternScheme().getSchemeDataURI())
                                .schemeURI(profileID.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementProfileID = new ProfileID.ProfileIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(profileID.getValue())
                        .build().load();
            }
        }
        if(!Tips.stringIsNull(id.getValue())){
            Element elementID = new ID.IDBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(id.getValue())
                    .attributes(new PatternScheme.PatternSchemeBuilder()
                            .schemeID(id.getPatternScheme().getSchemeID())
                            .schemeName(id.getPatternScheme().getSchemeName())
                            .schemeAgencyID(id.getPatternScheme().getSchemeAgencyID())
                            .schemeAgencyName(id.getPatternScheme().getSchemeAgencyName())
                            .schemeVersionID(id.getPatternScheme().getSchemeVersionID())
                            .schemeDataURI(id.getPatternScheme().getSchemeDataURI())
                            .schemeURI(id.getPatternScheme().getSchemeURI())
                            .build())
                    .build().load();
        }
        if(!Tips.stringIsNull(issueDate.getValue())){
            Element elementIssueDate = new IssueDate.IssueDateBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(issueDate.getValue())
                    .build().load();
        }
        if(!Tips.stringIsNull(invoiceTypeCode.getValue())){
            Element elementInvoiceTypeCode = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(invoiceTypeCode.getValue())
                    .attributes(new PatternList.PatternListBuilder()
                            .listID(invoiceTypeCode.getPatternList().getListID())
                            .listAgencyID(invoiceTypeCode.getPatternList().getListAgencyID())
                            .listAgencyName(invoiceTypeCode.getPatternList().getListAgencyName())
                            .listName(invoiceTypeCode.getPatternList().getListName())
                            .listVersionID(invoiceTypeCode.getPatternList().getListVersionID())
                            .name(invoiceTypeCode.getPatternList().getName())
                            .languageID(invoiceTypeCode.getPatternList().getLanguageID())
                            .listURI(invoiceTypeCode.getPatternList().getListURI())
                            .listSchemeURI(invoiceTypeCode.getPatternList().getListSchemeURI())
                            .build())
                    .build().load();
        }
        if(!Tips.stringIsNull(documentCurrencyCode.getValue())){
            Element elementCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(documentCurrencyCode.getValue())
                    .attributes(new PatternList.PatternListBuilder()
                            .listID(documentCurrencyCode.getPatternList().getListID())
                            .listAgencyID(documentCurrencyCode.getPatternList().getListAgencyID())
                            .listAgencyName(documentCurrencyCode.getPatternList().getListAgencyName())
                            .listName(documentCurrencyCode.getPatternList().getListName())
                            .listVersionID(documentCurrencyCode.getPatternList().getListVersionID())
                            .name(documentCurrencyCode.getPatternList().getName())
                            .languageID(documentCurrencyCode.getPatternList().getLanguageID())
                            .listURI(documentCurrencyCode.getPatternList().getListURI())
                            .listSchemeURI(documentCurrencyCode.getPatternList().getListSchemeURI())
                            .build())
                    .build().load();
        }
        if(!Tips.stringIsNull(orderReference.getId().getValue())){
            Element elementOrderReference = new OrderReference.OrderReferenceBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .id(id)
                    .build().load();
        }
        if(!Tips.listIsNull(additionalDocumentReferenceList)){
            for (AdditionalDocumentReference additionalDocumentReference : additionalDocumentReferenceList) {
                Element elementAdditionalDocumentReference = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .id(additionalDocumentReference.getId())
                        .documentTypeCode(additionalDocumentReference.getDocumentTypeCode())
                        .attachment(additionalDocumentReference.getAttachment())
                        .build().load();
            }
        }
        if(!(accountingSupplierParty == null)){
            Element elementAccountingSupplierParty = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .party(accountingSupplierParty.getParty())
                    .build().load();
        }
        if(!Tips.listIsNull(paymentMeansList)){
            for (PaymentMeans paymentMeans : paymentMeansList) {
                Element paymentMeans1 = new PaymentMeans.PaymentMeansBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .id(paymentMeans.getId())
                        .paymentMeansCode(paymentMeans.getPaymentMeansCode())
                        .paymentDueDate(paymentMeans.getPaymentDueDate())
                        .paymentChannelCode(paymentMeans.getPaymentChannelCode())
                        .payeeFinancialAccount(paymentMeans.getPayeeFinancialAccount())
                        .build().load();
            }
        }
        if(!Tips.listIsNull(invoiceLineList)){
            for (InvoiceLine invoiceLine : invoiceLineList) {
                Element invoiceLine1 = new InvoiceLine.InvoiceLineBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .id(invoiceLine.getId())
                        .invoicedQuantity(invoiceLine.getInvoicedQuantity())
                        .lineExtensionAmount(invoiceLine.getLineExtensionAmount())
                        .taxTotal(invoiceLine.getTaxTotal())
                        .item(invoiceLine.getItem())
                        .price(invoiceLine.getPrice())
                        .build().load();
            }
        }
        return elementInvoice;
    }

}
