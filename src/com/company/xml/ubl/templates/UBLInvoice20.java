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

/**
 * Class UBLInvoice20
 */
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
     * <h2>Template "UBLInvoice20"</h2>
     * <p>A document used to request payment. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[UBLVersionID] <b>ublVersionID</b> <b>[0..1]</b> : The earliest version of the UBL 2 schema for this document type that defines all of the elements that might be encountered in the current instance.</li>
     *         <li>[CustomizationID] <b>customizationID</b> <b>[0..1]</b> : Identifies a user-defined customization of UBL for a specific use.</li>
     *         <li>[ProfileID] <b>profileID</b> <b>[0..1]</b> : Identifies a user-defined profile of the customization of UBL being used.</li>
     *         <li>[ID] <b>id</b> <b>[1..1]</b> : An identifier for the Credit Note assigned by the Creditor.</li>
     *         <li>[IssueDate] <b>issueDate</b> <b>[1..1]</b> : The date assigned by the Creditor on which the Credit Note was issued.</li>
     *         <li>[InvoiceTypeCode] <b>invoiceTypeCode</b> <b>[0..1]</b> : Code specifying the type of the Invoice.</li>
     *         <li>[DocumentCurrencyCode] <b>documentCurrencyCode</b> <b>[0..1]</b> : The default currency for the Credit Note.</li>
     *         <li>[OrderReference] <b>orderReference</b> <b>[0..1]</b> : An association to Order Reference.</li>
     *         <li>[List] <b>additionalDocumentReferenceList</b> <b>[0..*]</b> : [AdditionalDocumentReference] elements list.</li>
     *         <li>[AccountingSupplierParty] <b>accountingSupplierParty</b> <b>[1..1]</b> : An association to the Accounting Supplier Party.</li>
     *         <li>[AccountingCustomerParty] <b>accountingCustomerParty</b> <b>[1..1]</b> : An association to the Accounting Customer Party.</li>
     *         <li>[List] <b>paymentMeansList</b> <b>[0..*]</b> : [PaymentMeans] elements list.</li>
     *         <li>[List] <b>taxTotalList</b> <b>[0..*]</b> : [TaxTotal] elements list.</li>
     *         <li>[LegalMonetaryTotal] <b>legalMonetaryTotal</b> <b>[1..1]</b> : An association to the total amount payable on the Credit Note, including Allowances, Charges, and Taxes.</li>
     *         <li>[List] <b>invoiceLineList</b> <b>[1..*]</b> : [InvoiceLine] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
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

        if(!(ublVersionID == null)){
            if(!(ublVersionID.getPatternScheme() == null)){
                Element elementUBLVersionID = new UBLVersionID.UBLVersionIDBuilder()
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
                Element elementUBLVersionID = new UBLVersionID.UBLVersionIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(ublVersionID.getValue())
                        .build().load();
            }
        }
        if(!(customizationID == null)){
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
        if(!(profileID == null)){
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
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
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
            } else {
                Element elementID = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(id.getValue())
                        .build().load();
            }
        }
        if(!(issueDate == null)){
            Element elementIssueDate = new IssueDate.IssueDateBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .value(issueDate.getValue())
                    .build().load();
        }
        if(!(invoiceTypeCode == null)){
            if(!(invoiceTypeCode.getPatternList() == null)){
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
            } else {
                Element elementInvoiceTypeCode = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(invoiceTypeCode.getValue())
                        .build().load();
            }
        }
        if(!(documentCurrencyCode == null)){
            if(!(documentCurrencyCode.getPatternList() == null)){
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
            } else {
                Element elementCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoice)
                        .value(documentCurrencyCode.getValue())
                        .build().load();
            }
        }
        if(!(orderReference == null)){
            Element elementOrderReference = new OrderReference.OrderReferenceBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoice)
                    .id(id)
                    .build().load();
        }
        if(!(additionalDocumentReferenceList == null)){
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
        if(!(paymentMeansList == null)){
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
        if(!(invoiceLineList == null)){
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
