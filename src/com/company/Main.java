package com.company;

import com.company.xml.ubl.attributes.PatternCode;
import com.company.xml.ubl.attributes.PatternCurrency;
import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.DocumentT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.data.NamespacesName;
import com.company.xml.ubl.elements.*;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.modules.*;
import com.company.xml.ubl.templates.UBLCreditNote20;
import com.company.xml.ubl.templates.UBLInvoice20;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        /**
         * SANS TEMPLATE UBL CREDIT NOTE 2.0
         */

        DocumentT doc = new DocumentT("cars3.xml", "");
        doc.initialize();

        //ROOT (CREDIT NOTE)
        Element elementCreditNote = new CreditNote20.CreditNote20Builder()
                .documentLinked(doc.getDoc())
                .build().load();

        //CREDIT NOTE > UBL VERSION ID
        Element elementUBLVersionID = new UBLVersionID.ElementUBLVersionIDBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .value("2.0")
                .attributes(new PatternScheme.PatternSchemeBuilder().build())
                .build().load();

        //... > CUSTOMIZATION ID
        Element eleCustomizationId = new ElementT(doc.getDoc(), elementCreditNote, ElementsName.CUSTOMIZATION_ID.label, "urn:tradeshift.com:ubl-2.0-customizations:2010-06").load();

        //> PROFILE ID
        Element eleProfileID = new ElementT(doc.getDoc(), elementCreditNote, ElementsName.PROFILE_ID.label, "urn:www.cenbii.eu:profile:bii04:ver1.0").load();
        Attr attrEleProfileID1 = new AttributeT(doc.getDoc(), eleProfileID, AttributesName.PROFIL_ID_SCHEMA_AGENCY_ID.label, "CEN/ISSS WS/BII").load();
        Attr attrEleProfileID2 = new AttributeT(doc.getDoc(), eleProfileID, AttributesName.PROFIL_ID_SCHEMA_ID.label, "CWA 16073:2010").load();
        Attr attrEleProfileID3 = new AttributeT(doc.getDoc(), eleProfileID, AttributesName.PROFIL_ID_SCHEMA_VERSION_ID.label, "urn:www.cenbii.eu:profile:bii04:ver1.0").load();

        //ID
        Element elementID = new ID.IDBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .value("038/01162972222222")
                .attributes(new PatternScheme.PatternSchemeBuilder()
                        .schemeAgencyID("lala")
                        .build())
                .build().load();

        //ISSUE DATE
        Element eleIssueDate = new ElementT(doc.getDoc(), elementCreditNote, ElementsName.ISSUE_DATE.label, "2020-01-22").load();

        //DOCUMENT CURRENCY CODE
        Element eleDocCurrencyCode = new ElementT(doc.getDoc(), elementCreditNote, ElementsName.DOC_CURRENCY_CODE.label, "EUR").load();

        //ORDER REFERENCE
        Element elementOrderReference = new OrderReference.OrderReferenceBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .id(new ID.IDBuilder()
                        .value("C180001053_888")
                        .attributes(new PatternScheme.PatternSchemeBuilder().build())
                        .build())
                .build().load();

        //BILLING REFERENCE > INVOICE DOCUMENT REFERENCE
        List<InvoiceDocumentReference> invoiceDocumentReferenceListBR = new ArrayList<>();
        InvoiceDocumentReference invoiceDocumentReferenceBR = new InvoiceDocumentReference.InvoiceDocumentReferenceBuilder()
                .id("038/0115616")
                .build();
        invoiceDocumentReferenceListBR.add(invoiceDocumentReferenceBR);

        //BILLING REFERENCE
        Element elementBillingReference = new BillingReference.BillingReferenceBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .invoiceDocumentReferenceList(invoiceDocumentReferenceListBR)
                .build().load();

        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT
        List<Attachment> attachmentListADR = new ArrayList<>();
        Attachment attachmentADR = new Attachment.AttachmentBuilder()
                .embeddedDocumentBinaryObject("JVBERi0xLjQKJeTjz9IKMyAwIG9iago8PC9[...]")
                .embeddedDocumentBinaryObject_AttributeEncodingCode("Base64")
                .embeddedDocumentBinaryObject_AttributeFilename("avoir eiffage 1.pdf")
                .embeddedDocumentBinaryObject_AttributeMimeCode("application/pdf")
                .build();
        attachmentListADR.add(attachmentADR);

        //ADDITIONAL DOCUMENT REFERENCE
        Element elementAdditionalDocumentReference1 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .id("1100000 EUR")
                .documentTypeCode("SenderShareCapital")
                .documentTypeCode_AttributeListID("urn:tradeshift.com:api:1.0:documenttypecode")
                .build().load();

        Element elementAdditionalDocumentReference2 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .id("attachment-0")
                .documentTypeCode("attachment")
                .documentTypeCode_AttributeListID("urn:tradeshift.com:api:1.0:documenttypecode")
                .attachmentList(attachmentListADR)
                .build().load();

        //ACCOUNTING SUPPLIER PARTY

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY IDENTIFICATION
        List<PartyIdentification> partyIdentificationList = new ArrayList<>();
        PartyIdentification partyIdentification1 = new PartyIdentification.PartyIdentificationBuilder()
                .id("FR21314887126")
                .id_AttributeSchemeName("SIRET")
                .id_AttributeSchemeID("FR:VAT")
                .build();
        PartyIdentification partyIdentification2 = new PartyIdentification.PartyIdentificationBuilder()
                .id("31488712600253")
                .id_AttributeSchemeID("FR:VAT")
                .build();
        partyIdentificationList.add(partyIdentification1);
        partyIdentificationList.add(partyIdentification2);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY NAME
        List<PartyName> partyNameList = new ArrayList<>();
        PartyName partyName1 = new PartyName.PartyNameBuilder()
                .name("Groupe Sovitrat")
                .build();
        partyNameList.add(partyName1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
        List<Country> countryList = new ArrayList<>();
        Country country1 = new Country.CountryBuilder().identificationCode("FR").build();
        countryList.add(country1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS
        List<PostalAddress> postalAddressList = new ArrayList<>();
        PostalAddress postalAddress1 = new PostalAddress.PostalAddressBuilder()
                .addressFormatCode("5")
                .addressFormatCode_AttributeListAgencyID("6")
                .addressFormatCode_AttributeListID("UN/ECE 3477")
                .addressFormatCode_AttributeListVersionID("D08B")
                .postBox("69006")
                .streetName("4 RUE DUGUESCLIN")
                .buildingNumber("")
                .cityName("LYON")
                .postalZone("69006")
                .countryList(countryList)
                .build();
        postalAddressList.add(postalAddress1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
        List<TaxScheme> taxSchemeList = new ArrayList<>();
        TaxScheme taxScheme1 = new TaxScheme.TaxSchemeBuilder()
                .name("VAT")
                .build();
        taxSchemeList.add(taxScheme1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME
        List<PartyTaxScheme> partyTaxSchemeList = new ArrayList<>();
        PartyTaxScheme partyTaxScheme1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                .companyId("FR21314887126")
                .companyId_AttributeSchemeId("FR:VAT")
                .taxSchemeList(taxSchemeList)
                .build();
        partyTaxSchemeList.add(partyTaxScheme1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > REGISTRATION ADDRESS
        List<RegistrationAddress> registrationAddressList = new ArrayList<>();
        RegistrationAddress registrationAddress1 = new RegistrationAddress.RegistrationAddressBuilder()
                .id("LYON")
                .id_AttributeSchemeId("FR:RCS")
                .addressFormatCode("5")
                .addressFormatCode_AttributeListAgencyId("6")
                .addressFormatCode_AttributeListId("UN/ECE 3477")
                .postBox("69006")
                .streetName("4 RUE DUGUESCLIN")
                .buildingNumber("NOVALI")
                .cityName("LYON")
                .postalZone("69006")
                .build();
        registrationAddressList.add(registrationAddress1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > CORPORATE REGISTRATION SCHEME
        List<CorporateRegistrationScheme> corporateRegistrationSchemeList = new ArrayList<>();
        CorporateRegistrationScheme corporateRegistrationScheme1 = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                .id("PUBLIC_LIMITED").build();
        corporateRegistrationSchemeList.add(corporateRegistrationScheme1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY
        List<PartyLegalEntity> partyLegalEntityList = new ArrayList<>();
        PartyLegalEntity partyLegalEntity1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                .registrationName("Groupe SOVITRAT")
                .companyId("31488712600253")
                .companyId_AttributeSchemeId("FR:SIRET")
                .registrationAddressList(registrationAddressList)
                .corporateRegistrationSchemeList(corporateRegistrationSchemeList)
                .build();
        partyLegalEntityList.add(partyLegalEntity1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > CONTACT
        List<Contact> contactList = new ArrayList<>();
        Contact contact1 = new Contact.ContactBuilder()
                .id("5a59bb3c-adf8-4b72-b45b-f4f2f33676f1")
                .id_AttributeSchemeURI("http://tradeshift.com/api/1.0/userId")
                .name("Amor BOUGHZALA")
                .telephone("0472699760")
                .electronicMail("master@sovitrat.fr")
                .note("Groupe SOVITRAT PUBLIC_LIMITED with share capital 1100000...")
                .build();
        contactList.add(contact1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PERSON
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person.PersonBuilder()
                .firstName("Amor")
                .familyName("BOUGHZALA")
                .build();
        personList.add(person1);

        //ACCOUNTING SUPPLIER PARTY > PARTY
        List<Party> partyList = new ArrayList<>();
        Party elementParty = new Party.PartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .partyIdentificationList(partyIdentificationList)
                .partyNameList(partyNameList)
                .postalAddressList(postalAddressList)
                .partyTaxSchemeList(partyTaxSchemeList)
                .partyLegalEntityList(partyLegalEntityList)
                .contactList(contactList)
                .personList(personList)
                .build();
        partyList.add(elementParty);

        //ACCOUNTING SUPPLIER PARTY
        Element elementAccountingSupplierParty = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .partyList(partyList)
                .build().load();

        //TAX TOTAL

        //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY > TAX SCHEME
        List<TaxScheme> taxSchemeListFromTaxTotal = new ArrayList<>();
        TaxScheme taxScheme10 = new TaxScheme.TaxSchemeBuilder()
                .id("VAT")
                .id_AttributeSchemeAgencyID("6")
                .id_AttributeSchemeID("UN/ECE 5153 Subset")
                .id_AttributeSchemeVersionID("D08B")
                .name("FR TVA 20%")
                .build();
        taxSchemeList.add(taxScheme10);

        //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY
        List<TaxCategory> taxCategoryListFromTaxTotal = new ArrayList<>();
        TaxCategory taxCategory1 = new TaxCategory.TaxCategoryBuilder()
                .id("S")
                .id_AttributeSchemeAgencyID("6")
                .id_AttributeSchemeID("UN/ECE 5305")
                .id_AttributeSchemeVersionID("D08B")
                .percent("20")
                .taxSchemeList(taxSchemeListFromTaxTotal)
                .build();
        taxCategoryListFromTaxTotal.add(taxCategory1);

        //TAX TOTAL > TAX SUB TOTAL
        List<TaxSubTotal> taxSubTotalListFromTaxTotal = new ArrayList<>();
        TaxSubTotal taxSubTotal1 = new TaxSubTotal.TaxSubTotalBuilder()
                .taxableAmount("245.74")
                .taxableAmount_AttributeCurrencyID("EUR")
                .taxAmount("49.15")
                .taxAmount_AttributeCurrencyID("EUR")
                .taxCategoryList(taxCategoryListFromTaxTotal)
                .build();
        taxSubTotalListFromTaxTotal.add(taxSubTotal1);

        //TAX TOTAL
        Element elementTaxTotal = new TaxTotal.TaxTotalBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .taxAmount("49.15")
                .taxAmount_AttributeCurrencyID("EUR")
                .taxSubTotalList(taxSubTotalListFromTaxTotal)
                .build().load();

        //LEGAL MONETARY TOTAL
        Element elementLegalMonetaryTotal = new LegalMonetaryTotal.LegalMonetaryTotalBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .lineExtensionAmount("245.74")
                .lineExtensionAmount_AttributeCurrencyID("EUR")
                .taxExclusiveAmount("49.15")
                .taxExclusiveAmount_AttributeCurrencyID("EUR")
                .taxInclusiveAmount("294.89")
                .taxInclusiveAmount_AttributeCurrencyID("EUR")
                .payableAmount("294.89")
                .payableAmount_AttributeCurrencyID("EUR")
                .build().load();

        //CREDIT NOTE LINE

        //CREDIT NOTE LINE > TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY > TAX SCHEME
        List<TaxScheme> taxSchemeListCNL = new ArrayList<>();
        TaxScheme taxSchemeCNL = new TaxScheme.TaxSchemeBuilder()
                .id("VAT")
                .id_AttributeSchemeAgencyID("6")
                .id_AttributeSchemeID("UN/ECE 5153 Subset")
                .id_AttributeSchemeVersionID("D08B")
                .build();
        taxSchemeListCNL.add(taxSchemeCNL);

        //CREDIT NOTE LINE > TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY
        List<TaxCategory> taxCategoryListCNL = new ArrayList<>();
        TaxCategory taxCategoryCNL = new TaxCategory.TaxCategoryBuilder()
                .id("S")
                .id_AttributeSchemeAgencyID("6")
                .id_AttributeSchemeID("UN/ECE 5305")
                .id_AttributeSchemeVersionID("D08B")
                .percent("20")
                .taxSchemeList(taxSchemeListCNL)
                .build();
        taxCategoryListCNL.add(taxCategoryCNL);

        //CREDIT NOTE LINE > TAX TOTAL > TAX SUB TOTAL
        List<TaxSubTotal> taxSubTotalListCNL = new ArrayList<>();
        TaxSubTotal taxSubTotalCNL = new TaxSubTotal.TaxSubTotalBuilder()
                .taxableAmount("109.24")
                .taxableAmount_AttributeCurrencyID("EUR")
                .taxAmount("21.85")
                .taxAmount_AttributeCurrencyID("EUR")
                .calculationSequenceNumeric("1")
                .taxCategoryList(taxCategoryListCNL)
                .build();
        taxSubTotalListCNL.add(taxSubTotalCNL);

        //CREDIT NOTE LINE > TAX TOTAL
        List<TaxTotal> taxTotalListCNL = new ArrayList<>();
        TaxTotal taxTotalCNL = new TaxTotal.TaxTotalBuilder()
                .taxAmount("21.85")
                .taxAmount_AttributeCurrencyID("EUR")
                .taxSubTotalList(taxSubTotalListCNL)
                .build();
        taxTotalListCNL.add(taxTotalCNL);

        //CREDIT NOTE LINE > ITEM > SELLERS ITEM IDENTIFICATION
        List<SellersItemIdentification> sellersItemIdentificationListCNL = new ArrayList<>();
        SellersItemIdentification sellersItemIdentificationCNL = new SellersItemIdentification.SellersItemIdentificationBuilder()
                .id("129")
                .build();
        sellersItemIdentificationListCNL.add(sellersItemIdentificationCNL);

        //CREDIT NOTE LINE > ITEM
        List<Item> itemListCNL = new ArrayList<>();
        Item itemCNL = new Item.ItemBuilder()
                .description("PRIME")
                .name("PRIME")
                .sellersItemIdentificationList(sellersItemIdentificationListCNL)
                .build();
        itemListCNL.add(itemCNL);

        //CREDIT NOTE LINE > PRICE
        List<Price> priceListCNL = new ArrayList<>();
        Price priceCNL = new Price.PriceBuilder()
                .priceAmount("109.24")
                .priceAmount_AttributeCurrencyID("EUR")
                .baseQuantity("1")
                .baseQuantity_AttributeUnitCode("EA")
                .orderableUnitFactorRate("1")
                .build();
        priceListCNL.add(priceCNL);

        //CREDIT NOTE LINE
        Element elementCreditNoteLine = new CreditNoteLine.CreditNoteLineBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .id("1")
                .creditedQuantity("1")
                .creditedQuantity_AttributeUnitCode("EA")
                .lineExtensionAmount("109.24")
                .lineExtensionAmount_AttributeCurrencyId("EUR")
                .taxTotalList(taxTotalListCNL)
                .itemList(itemListCNL)
                .priceList(priceListCNL)
                .build().load();

        doc.generate();

        /**
         * AVEC TEMPLATE UBL CREDIT NOTE 2.0
         */

        DocumentT docUBL = new DocumentT("cars4.xml", "");
        docUBL.initialize();

        UBLVersionID ublVersionID = new UBLVersionID.ElementUBLVersionIDBuilder()
                .value("2.0")
                .attributes(new PatternScheme.PatternSchemeBuilder().build())
                .build();

        CustomizationID ublCustomizationID = new CustomizationID.CustomizationIDBuilder()
                .value("urn:tradeshift.com:ubl-2.0-customizations:2010-06")
                .attributes(new PatternScheme.PatternSchemeBuilder().build())
                .build();

        ProfileID ublProfileID = new ProfileID.ProfileIDBuilder()
                .value("urn:www.cenbii.eu:profile:bii04:ver1.0")
                .attributes(new PatternScheme.PatternSchemeBuilder()
                        .schemeAgencyID("CEN/ISSS WS/BII")
                        .schemeID("CWA 16073:2010")
                        .schemeVersionID("1")
                        .build())
                .build();

        ID ublID = new ID.IDBuilder()
                .value("038/0116297")
                .attributes(new PatternScheme.PatternSchemeBuilder().build())
                .build();

        IssueDate ublIssueDate = new IssueDate.IssueDateBuilder()
                .value("2020-01-22")
                .build();

        DocumentCurrencyCode ublDocumentCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                .value("EUR")
                .attributes(new PatternList.PatternListBuilder().build())
                .build();

        OrderReference ublOrderReference = new OrderReference.OrderReferenceBuilder()
                .id(new ID.IDBuilder()
                        .value("C180001053")
                        .attributes(new PatternScheme.PatternSchemeBuilder().build())
                        .build())
                .build();

        InvoiceDocumentReference ublInvoiceDocumentReference1A = new InvoiceDocumentReference.InvoiceDocumentReferenceBuilder()
                .id("038/0115616")
                .build();
        List<InvoiceDocumentReference> invoiceDocumentReferenceList1 = Arrays.asList(ublInvoiceDocumentReference1A);
        BillingReference ublBillingReference1 = new BillingReference.BillingReferenceBuilder()
                .invoiceDocumentReferenceList(invoiceDocumentReferenceList1)
                .build();
        List<BillingReference> billingReferenceList = Arrays.asList(ublBillingReference1);




        Element elementUBL = new UBLCreditNote20.UBLCreditNote20Builder()
                .documentLinked(docUBL.getDoc())
                .ublVersionID(ublVersionID)
                .customizationID(ublCustomizationID)
                .profileID(ublProfileID)
                .id(ublID)
                .issueDate(ublIssueDate)
                .documentCurrencyCode(ublDocumentCurrencyCode)
                .orderReference(ublOrderReference)
                .billingReferenceList(billingReferenceList)
                .build().load();


        docUBL.generate();


        /**
         * WITH UBL TEMPLATE INVOICE 2.0
         */

        DocumentT docInvoice = new DocumentT("Invoice.xml", "");
        docInvoice.initialize();

        UBLVersionID invoiceUBLVersionID = new UBLVersionID.ElementUBLVersionIDBuilder()
                .value("2.0")
                .attributes(new PatternScheme.PatternSchemeBuilder().build())
                .build();

        CustomizationID invoiceCustomizationID = new CustomizationID.CustomizationIDBuilder()
                .value("urn:tradeshift.com:ubl-2.0-customizations:2010-06")
                .attributes(new PatternScheme.PatternSchemeBuilder().build())
                .build();

        ProfileID invoiceProfileID = new ProfileID.ProfileIDBuilder()
                .value("urn:www.cenbii.eu:profile:bii04:ver1.0")
                .attributes(new PatternScheme.PatternSchemeBuilder()
                        .schemeAgencyID("CEN/ISSS WS/BII")
                        .schemeID("CWA 16073:2010")
                        .schemeVersionID("1")
                        .build())
                .build();

        ID invoiceID = new ID.IDBuilder()
                .value("038/0116560")
                .attributes(new PatternScheme.PatternSchemeBuilder().build())
                .build();

        IssueDate invoiceIssueDate = new IssueDate.IssueDateBuilder()
                .value("2021-04-30")
                .build();

        InvoiceTypeCode invoiceInvoiceTypeCode = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
                .value("380")
                .attributes(new PatternList.PatternListBuilder()
                        .listAgencyID("6")
                        .listID("UN/ECE 1001 Subset")
                        .listVersionID("D08B")
                        .build())
                .build();

        DocumentCurrencyCode invoiceDocumentCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                .value("EUR")
                .attributes(new PatternList.PatternListBuilder().build())
                .build();

        OrderReference invoiceOrderReference = new OrderReference.OrderReferenceBuilder()
                .id(new ID.IDBuilder()
                        .value("C800430638")
                        .attributes(new PatternScheme.PatternSchemeBuilder().build())
                        .build())
                .build();

        List<AdditionalDocumentReference> additionalDocumentReferenceListInvoice = new ArrayList<>();
        AdditionalDocumentReference additionalDocumentReference1 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .id("1100000 EUR")
                .documentTypeCode("SenderShareCapital")
                .documentTypeCode_AttributeListID("urn:tradeshift.com:api:1.0:documenttypecode")
                .build();
        additionalDocumentReferenceListInvoice.add(additionalDocumentReference1);
        AdditionalDocumentReference additionalDocumentReference2 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .id("")
                .documentTypeCode("File ID")
                .documentTypeCode_AttributeListID("urn:tradeshift.com:api:1.0:documenttypecode")
                .build();
        additionalDocumentReferenceListInvoice.add(additionalDocumentReference2);
        AdditionalDocumentReference additionalDocumentReference3 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .id("HALF_EVEN")
                .documentTypeCode("RoundingRule")
                .documentTypeCode_AttributeListID("urn:tradeshift.com:api:1.0:documenttypecode")
                .build();
        additionalDocumentReferenceListInvoice.add(additionalDocumentReference3);
        List<Attachment> attachmentList1 = new ArrayList<>();
        Attachment attachment1 = new Attachment.AttachmentBuilder()
                .embeddedDocumentBinaryObject("JVBERi0xLjQKJeTjz9IKMyAwI...")
                .embeddedDocumentBinaryObject_AttributeEncodingCode("Base64")
                .embeddedDocumentBinaryObject_AttributeFilename("facture eiffage 1.pdf")
                .embeddedDocumentBinaryObject_AttributeMimeCode("application/pdf")
                .build();
        attachmentList1.add(attachment1);
        AdditionalDocumentReference additionalDocumentReference4 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .id("1100000 EUR")
                .documentTypeCode("SenderShareCapital")
                .documentTypeCode_AttributeListID("urn:tradeshift.com:api:1.0:documenttypecode")
                .attachmentList(attachmentList1)
                .build();
        additionalDocumentReferenceListInvoice.add(additionalDocumentReference4);

        //ACCOUNTING SUPPLIER PARTY

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY IDENTIFICATION
        List<PartyIdentification> partyIdentificationListInvoice = new ArrayList<>();
        PartyIdentification partyIdentificationInvoice1 = new PartyIdentification.PartyIdentificationBuilder()
                .id("FR21314887126")
                .id_AttributeSchemeID("FR:VAT")
                .build();
        PartyIdentification partyIdentificationInvoice2 = new PartyIdentification.PartyIdentificationBuilder()
                .id("31488712600253")
                .id_AttributeSchemeID("FR:SIRET")
                .build();
        partyIdentificationListInvoice.add(partyIdentificationInvoice1);
        partyIdentificationListInvoice.add(partyIdentificationInvoice2);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY NAME
        List<PartyName> partyNameListInvoice = new ArrayList<>();
        PartyName partyNameInvoice1 = new PartyName.PartyNameBuilder()
                .name("Groupe SOVITRAT")
                .build();
        partyNameListInvoice.add(partyNameInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
        List<Country> countryListInvoice = new ArrayList<>();
        Country countryInvoice1 = new Country.CountryBuilder().identificationCode("FR").build();
        countryListInvoice.add(countryInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS
        List<PostalAddress> postalAddressListInvoice = new ArrayList<>();
        PostalAddress postalAddressInvoice1 = new PostalAddress.PostalAddressBuilder()
                .addressFormatCode("5")
                .addressFormatCode_AttributeListAgencyID("6")
                .addressFormatCode_AttributeListID("UN/ECE 3477")
                .addressFormatCode_AttributeListVersionID("D08B")
                .postBox("69006")
                .streetName("4 RUE DUGUESCLIN")
                .buildingNumber("")
                .cityName("LYON")
                .postalZone("69006")
                .countryList(countryListInvoice)
                .build();
        postalAddressListInvoice.add(postalAddressInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
        List<TaxScheme> taxSchemeListInvoice = new ArrayList<>();
        TaxScheme taxSchemeInvoice1 = new TaxScheme.TaxSchemeBuilder()
                .name("VAT")
                .build();
        taxSchemeListInvoice.add(taxSchemeInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME
        List<PartyTaxScheme> partyTaxSchemeListInvoice = new ArrayList<>();
        PartyTaxScheme partyTaxSchemeInvoice1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                .companyId("FR21314887126")
                .companyId_AttributeSchemeId("FR:VAT")
                .taxSchemeList(taxSchemeListInvoice)
                .build();
        partyTaxSchemeListInvoice.add(partyTaxSchemeInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > REGISTRATION ADDRESS
        List<RegistrationAddress> registrationAddressListInvoice = new ArrayList<>();
        RegistrationAddress registrationAddressInvoice1 = new RegistrationAddress.RegistrationAddressBuilder()
                .id("LYON")
                .id_AttributeSchemeId("FR:RCS")
                .addressFormatCode("5")
                .addressFormatCode_AttributeListAgencyId("6")
                .addressFormatCode_AttributeListId("UN/ECE 3477")
                .postBox("69006")
                .streetName("4 RUE DUGUESCLIN")
                .buildingNumber("NOVALI")
                .cityName("LYON")
                .postalZone("69006")
                .build();
        registrationAddressListInvoice.add(registrationAddressInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > CORPORATE REGISTRATION SCHEME
        List<CorporateRegistrationScheme> corporateRegistrationSchemeListInvoice = new ArrayList<>();
        CorporateRegistrationScheme corporateRegistrationSchemeInvoice1 = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                .id("PUBLIC_LIMITED").build();
        corporateRegistrationSchemeListInvoice.add(corporateRegistrationSchemeInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY
        List<PartyLegalEntity> partyLegalEntityListInvoice = new ArrayList<>();
        PartyLegalEntity partyLegalEntityInvoice1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                .registrationName("Groupe SOVITRAT")
                .companyId("31488712600253")
                .companyId_AttributeSchemeId("FR:SIRET")
                .registrationAddressList(registrationAddressListInvoice)
                .corporateRegistrationSchemeList(corporateRegistrationSchemeListInvoice)
                .build();
        partyLegalEntityListInvoice.add(partyLegalEntityInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > CONTACT
        List<Contact> contactListInvoice = new ArrayList<>();
        Contact contactInvoice1 = new Contact.ContactBuilder()
                .id("5a59bb3c-adf8-4b72-b45b-f4f2f33676f1")
                .id_AttributeSchemeURI("http://tradeshift.com/api/1.0/userId")
                .name("Amor BOUGHZALA")
                .telephone("0472699760")
                .electronicMail("master@sovitrat.fr")
                .note("Groupe SOVITRAT PUBLIC_LIMITED with share capital 1100000...")
                .build();
        contactListInvoice.add(contactInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PERSON
        List<Person> personListInvoice = new ArrayList<>();
        Person personInvoice1 = new Person.PersonBuilder()
                .firstName("Amor")
                .familyName("BOUGHZALA")
                .build();
        personListInvoice.add(personInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY
        List<Party> partyListInvoice = new ArrayList<>();
        Party elementPartyInvoice1 = new Party.PartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .partyIdentificationList(partyIdentificationListInvoice)
                .partyNameList(partyNameListInvoice)
                .postalAddressList(postalAddressListInvoice)
                .partyTaxSchemeList(partyTaxSchemeListInvoice)
                .partyLegalEntityList(partyLegalEntityListInvoice)
                .contactList(contactListInvoice)
                .personList(personListInvoice)
                .build();
        partyListInvoice.add(elementPartyInvoice1);

        //ACCOUNTING SUPPLIER PARTY
        AccountingSupplierParty elementAccountingSupplierPartyInvoice = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .partyList(partyListInvoice)
                .build();

        //PAYMENT MEANS

        //PAYMENT MEANS > PAYEE FINANCIAL ACCOUNT > FINANCIAL INSTITUTION BRANCH > FINANCIAL INSTITUTION
        FinancialInstitution financialInstitution1 = new FinancialInstitution.FinancialInstitutionBuilder()
                .id(new ID.IDBuilder()
                        .value("CCFRFRPP")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .build())
                        .build())
                .build();
        //PAYMENT MEANS > PAYEE FINANCIAL ACCOUNT > FINANCIAL INSTITUTION BRANCH
        FinancialInstitutionBranch financialInstitutionBranch1 = new FinancialInstitutionBranch.FinancialInstitutionBranchBuilder()
                .financialInstitution(financialInstitution1)
                .build();
        //PAYMENT MEANS > PAYEE FINANCIAL ACCOUNT
        PayeeFinancialAccount payeeFinancialAccount1 = new PayeeFinancialAccount.PayeeFinancialAccountBuilder()
                .id(new ID.IDBuilder()
                        .value("FR7630056001710171214299041")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .build())
                        .build())
                .financialInstitutionBranch(financialInstitutionBranch1)
                .build();
        //PAYMENT MEANS
        List<PaymentMeans> paymentMeansListInvoice = new ArrayList<>();
        PaymentMeans paymentMeans1 = new PaymentMeans.PaymentMeansBuilder()
                .id(new ID.IDBuilder()
                        .value("6edad297-67e3-4805-8e6d-691eb12f1138")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .build())
                        .build())
                .paymentMeansCode(new PaymentMeansCode.PaymentMeansCodeBuilder()
                        .value("31")
                        .attributes(new PatternList.PatternListBuilder()
                                .listID("urn:tradeshift.com:api:1.0:paymentmeanscode")
                                .build())
                        .build())
                .paymentDueDate(new PaymentDueDate.PaymentDueDateBuilder()
                        .value("2021-06-15")
                        .build())
                .paymentChannelCode(new PaymentChannelCode.PaymentChannelCodeBuilder()
                        .value("IBAN")
                        .attributes(new PatternList.PatternListBuilder()
                                .listID("urn:tradeshift.com:api:1.0:paymentchannelcode")
                                .build())
                        .build())
                .payeeFinancialAccount(payeeFinancialAccount1)
                .build();
        paymentMeansListInvoice.add(paymentMeans1);

        //TAX SCHEME
        List<TaxScheme> taxSchemeList44 = new ArrayList<>();
        TaxScheme taxSchemeInvoice44 = new TaxScheme.TaxSchemeBuilder()
                .id("VAT")
                .id_AttributeSchemeAgencyID("6")
                .id_AttributeSchemeID("UN/ECE 5153 Subset")
                .id_AttributeSchemeVersionID("D08B")
                .name("FR TVA 20")
                .build();
        taxSchemeList44.add(taxSchemeInvoice44);
        //TAX CATEGORY
        List<TaxCategory> taxCategoryList44 = new ArrayList<>();
        TaxCategory taxCategoryInvoice44 = new TaxCategory.TaxCategoryBuilder()
                .id("S")
                .id_AttributeSchemeAgencyID("6")
                .id_AttributeSchemeID("UN/ECE 5305")
                .id_AttributeSchemeVersionID("D08B")
                .percent("20")
                .taxSchemeList(taxSchemeList44)
                .build();
        taxCategoryList44.add(taxCategoryInvoice44);
        //TAX SUB TOTAL
        List<TaxSubTotal> taxSubTotalList44 = new ArrayList<>();
        TaxSubTotal taxSubTotal44 = new TaxSubTotal.TaxSubTotalBuilder()
                .taxableAmount("714.61")
                .taxableAmount_AttributeCurrencyID("EUR")
                .taxAmount("142.92")
                .taxAmount_AttributeCurrencyID("EUR")
                .calculationSequenceNumeric("1")
                .taxCategoryList(taxCategoryList44)
                .build();
        taxSubTotalList44.add(taxSubTotal44);
        //TAX TOTAL
        TaxTotal taxTotal44 = new TaxTotal.TaxTotalBuilder()
                .taxAmount("142.92")
                .taxAmount_AttributeCurrencyID("EUR")
                .taxSubTotalList(taxSubTotalList44)
                .build();
        //SELLERS ITEM IDENTIFICATION
        List<SellersItemIdentification> sellersItemIdentificationList44 = new ArrayList<>();
        SellersItemIdentification sellersItemIdentification44 = new SellersItemIdentification.SellersItemIdentificationBuilder()
                .id("001")
                .build();
        sellersItemIdentificationList44.add(sellersItemIdentification44);
        //ITEM
        Item item44 = new Item.ItemBuilder()
                .description("heures normales")
                .name("heures normales")
                .sellersItemIdentificationList(sellersItemIdentificationList44)
                .build();
        //PRICE
        Price price44 = new Price.PriceBuilder()
                .priceAmount("21.018")
                .priceAmount_AttributeCurrencyID("EUR")
                .baseQuantity("1")
                .baseQuantity_AttributeUnitCode("HUR")
                .orderableUnitFactorRate("1")
                .build();
        //INVOICE LINE
        List<InvoiceLine> invoiceLineList44 = new ArrayList<>();
        InvoiceLine invoiceLine44 = new InvoiceLine.InvoiceLineBuilder()
                .id(new ID.IDBuilder().value("1").attributes(new PatternScheme.PatternSchemeBuilder().build()).build())
                .invoicedQuantity(new InvoicedQuantity.InvoicedQuantityBuilder().value("34").attributes(new PatternCode.PatternCodeBuilder().unitCode("HUR").build()).build())
                .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder().value("714.61").attributes(new PatternCurrency.PatternCurrencyBuilder().currencyID("EUR").build()).build())
                .taxTotal(taxTotal44)
                .item(item44)
                .price(price44)
                .build();
        invoiceLineList44.add(invoiceLine44);

        Element elementInvoice = new UBLInvoice20.UBLInvoice20Builder()
                .documentLinked(docInvoice.getDoc())
                .ublVersionID(invoiceUBLVersionID)
                .customizationID(invoiceCustomizationID)
                .profileID(invoiceProfileID)
                .id(invoiceID)
                .issueDate(invoiceIssueDate)
                .invoiceTypeCode(invoiceInvoiceTypeCode)
                .documentCurrencyCode(invoiceDocumentCurrencyCode)
                .orderReference(invoiceOrderReference)
                .additionalDocumentReferenceList(additionalDocumentReferenceListInvoice)
                .accountingSupplierParty(elementAccountingSupplierPartyInvoice)
                .paymentMeansList(paymentMeansListInvoice)
                .invoiceLineList(invoiceLineList44)
                .build().load();

        docInvoice.generate();

    }
}
