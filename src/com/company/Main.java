package com.company;

import com.company.xml.ubl.attributes.*;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.DocumentT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.*;
import com.company.xml.ubl.modules.*;
import com.company.xml.ubl.templates.UBLCreditNote20;
import com.company.xml.ubl.templates.UBLInvoice20;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
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


        //ADDITIONAL DOCUMENT REFERENCE

        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT > EMBEDDED DOCUMENT BINARY OBJECT
        EmbeddedDocumentBinaryObject embeddedDocumentBinaryObject22 = new EmbeddedDocumentBinaryObject.EmbeddedDocumentBinaryObjectBuilder()
                .value("JVBERi0xLjQKJeTjz_TEST")
                .attributes(new PatternFile.PatternFileBuilder()
                        .encodingCode("Base64_TEST")
                        .filename("avoir eiffage 1.pdf_TEST")
                        .mimeCode("application/pdf_TEST").build())
                .build();

        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT
        Attachment attachment22 = new Attachment.AttachmentBuilder()
                .embeddedDocumentBinaryObject(embeddedDocumentBinaryObject22)
                .build();

        //ADDITIONAL DOCUMENT REFERENCE
        Element additionalDocumentReference22 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .id(new ID.IDBuilder()
                        .value("attachment_TEST")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .build())
                        .build())
                .documentTypeCode(new DocumentTypeCode.DocumentTypeCodeBuilder()
                        .value("attachment_TEST")
                        .attributes(new PatternList.PatternListBuilder()
                                .listID("urn:tradeshift.com:api:1.0:documenttypecode_TEST")
                                .build())
                        .build())
                .attachment(attachment22)
                .build().load();


        //ACCOUNTING SUPPLIER PARTY

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY IDENTIFICATION
        List<PartyIdentification> partyIdentificationList = new ArrayList<>();
        PartyIdentification partyIdentification1 = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("FR21314887126_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT")
                                .build())
                        .build())
                .build();
        PartyIdentification partyIdentification2 = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("31488712600253_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:SIRET")
                                .build())
                        .build())
                .build();
        partyIdentificationList.add(partyIdentification1);
        partyIdentificationList.add(partyIdentification2);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY NAME
        List<PartyName> partyNameList = new ArrayList<>();
        PartyName partyName1 = new PartyName.PartyNameBuilder()
                .name(new Name.NameBuilder()
                        .value("Groupe SOVITRAT_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .build();
        partyNameList.add(partyName1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
        Country country1 = new Country.CountryBuilder()
                .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                        .value("FR_VERSION2")
                        .attributes(new PatternList.PatternListBuilder()
                                .build())
                        .build())
                .name(new Name.NameBuilder()
                        .value("LALA_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS
        PostalAddress postalAddress1 = new PostalAddress.PostalAddressBuilder()
                .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                        .value("5_VERSION2")
                        .attributes(new PatternList.PatternListBuilder()
                                .listAgencyID("6_VERSION2")
                                .listID("UN/ECE 3477_VERSION2")
                                .listVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .postbox(new Postbox.PostboxBuilder()
                        .value("69006_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .streetName(new StreetName.StreetNameBuilder()
                        .value("4 RUE DUGUESCLIN_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .buildingNumber(new BuildingNumber.BuildingNumberBuilder()
                        .value("_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .cityName(new CityName.CityNameBuilder()
                        .value("LYON_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .postalZone(new PostalZone.PostalZoneBuilder()
                        .value("69006_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .country(country1)
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
        TaxScheme taxScheme1 = new TaxScheme.TaxSchemeBuilder()
                .name(new Name.NameBuilder()
                        .value("VATfdgdfgdfgdfgdfg")
                        .build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME
        List<PartyTaxScheme> partyTaxSchemeList = new ArrayList<>();
        PartyTaxScheme partyTaxScheme1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("FR21314887126_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT_VERSION2")
                                .build())
                        .build())
                .taxScheme(taxScheme1)
                .build();
        partyTaxSchemeList.add(partyTaxScheme1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > REGISTRATION ADDRESS
        RegistrationAddress registrationAddress1 = new RegistrationAddress.RegistrationAddressBuilder()
                .id(new ID.IDBuilder()
                        .value("LYON_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:RCS_VERSION2")
                                .build())
                        .build())
                .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                        .value("5")
                        .attributes(new PatternList.PatternListBuilder()
                                .listAgencyID("6_VERSION2")
                                .listID("UN/ECE 3477_VERSION2")
                                .build())
                        .build())
                .postBox(new Postbox.PostboxBuilder()
                        .value("69006_VERSION2")
                        .build())
                .streetName(new StreetName.StreetNameBuilder()
                        .value("4 RUE DUGUESCLIN_VERSION2")
                        .build())
                .buildingNumber(new BuildingNumber.BuildingNumberBuilder()
                        .value("NOVALI_VERSION2")
                        .build())
                .cityName(new CityName.CityNameBuilder()
                        .value("LYON_VERSION2")
                        .build())
                .postalZone(new PostalZone.PostalZoneBuilder()
                        .value("69006_VERSION2")
                        .build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > CORPORATE REGISTRATION SCHEME
        CorporateRegistrationScheme corporateRegistrationScheme1 = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                .id(new ID.IDBuilder().value("PUBLIC_LIMITED_VERSION2").build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY
        List<PartyLegalEntity> partyLegalEntityList = new ArrayList<>();
        PartyLegalEntity partyLegalEntity1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                .registrationName(new RegistrationName.RegistrationNameBuilder()
                        .value("Groupe SOVITRAT_VERSION2")
                        .build())
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("31488712600253_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:SIRET_VERSION2")
                                .build())
                        .build())
                .registrationAddress(registrationAddress1)
                .corporateRegistrationScheme(corporateRegistrationScheme1)
                .build();
        partyLegalEntityList.add(partyLegalEntity1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > CONTACT
        Contact contact1 = new Contact.ContactBuilder()
                .id(new ID.IDBuilder()
                        .value("5a59bb3c-adf8-4b72-b45b-f4f2f33676f1_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeURI("http://tradeshift.com/api/1.0/userId_VERSION2")
                                .build())
                        .build())
                .name(new Name.NameBuilder().value("Amor BOUGHZALA_VERSION2").build())
                .telephone(new Telephone.TelephoneBuilder().value("0472699760_VERSION2").build())
                .electronicMail(new ElectronicMail.ElectronicMailBuilder().value("master@sovitrat.fr_VERSION2").build())
                .note(new Note.NoteBuilder().value("Groupe SOVITRAT PUBLIC_LIMITED with share capi_VERSION2").build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PERSON
        Person person1 = new Person.PersonBuilder()
                .firstName(new FirstName.FirstNameBuilder().value("Amor_VERSION2").build())
                .familyName(new FamilyName.FamilyNameBuilder().value("BOUGHZALA_VERSION2").build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY
        Party elementParty = new Party.PartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .partyIdentificationList(partyIdentificationList)
                .partyNameList(partyNameList)
                .postalAddress(postalAddress1)
                .partyTaxSchemeList(partyTaxSchemeList)
                .partyLegalEntityList(partyLegalEntityList)
                .contact(contact1)
                .person(person1)
                .build();

        //ACCOUNTING SUPPLIER PARTY
        Element elementAccountingSupplierParty = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .party(elementParty)
                .build().load();

        //TAX TOTAL

        //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY > TAX SCHEME
        TaxScheme taxScheme10 = new TaxScheme.TaxSchemeBuilder()
                .id(new ID.IDBuilder()
                        .value("VAT_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6_VERSION2")
                                .schemeID("UN/ECE 5153 Subset_VERSION2")
                                .schemeVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .name(new Name.NameBuilder()
                        .value("FR TVA 20%_VERSION2")
                        .build())
                .build();

        //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY
        TaxCategory taxCategory1 = new TaxCategory.TaxCategoryBuilder()
                .id(new ID.IDBuilder()
                        .value("S_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6_VERSION2")
                                .schemeID("UN/ECE 5305_VERSION2")
                                .schemeVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .percent(new Percent.PercentBuilder().value("20_VERSION2").build())
                .taxScheme(taxScheme10)
                .build();

        //TAX TOTAL > TAX SUB TOTAL
        List<TaxSubTotal> taxSubTotalListFromTaxTotal = new ArrayList<>();
        TaxSubTotal taxSubTotal1 = new TaxSubTotal.TaxSubTotalBuilder()
                .taxableAmount(new TaxableAmount.TaxableAmountBuilder()
                        .value("109.24_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .calculationSequenceNumeric(new CalculationSequenceNumeric.CalculationSequenceNumericBuilder().value("1").build())
                .taxCategory(taxCategory1)
                .build();
        taxSubTotalListFromTaxTotal.add(taxSubTotal1);

        //TAX TOTAL
        Element elementTaxTotal = new TaxTotal.TaxTotalBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .taxSubTotalList(taxSubTotalListFromTaxTotal)
                .build().load();

        /**
         * TODO LATER
         */
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
        TaxScheme taxSchemeCNL = new TaxScheme.TaxSchemeBuilder()
                .id(new ID.IDBuilder()
                        .value("VAT_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6_VERSION2")
                                .schemeID("UN/ECE 5153 Subset_VERSION2")
                                .schemeVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .build();

        //CREDIT NOTE LINE > TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY
        TaxCategory taxCategoryCNL = new TaxCategory.TaxCategoryBuilder()
                .id(new ID.IDBuilder()
                        .value("S_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6_VERSION2")
                                .schemeID("UN/ECE 5305_VERSION2")
                                .schemeVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .percent(new Percent.PercentBuilder().value("20_VERSION2").build())
                .taxScheme(taxSchemeCNL)
                .build();

        //CREDIT NOTE LINE > TAX TOTAL > TAX SUB TOTAL
        List<TaxSubTotal> taxSubTotalListCNL = new ArrayList<>();
        TaxSubTotal taxSubTotalCNL = new TaxSubTotal.TaxSubTotalBuilder()
                .taxableAmount(new TaxableAmount.TaxableAmountBuilder()
                        .value("109.24_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .calculationSequenceNumeric(new CalculationSequenceNumeric.CalculationSequenceNumericBuilder().value("1").build())
                .taxCategory(taxCategoryCNL)
                .build();
        taxSubTotalListCNL.add(taxSubTotalCNL);

        //CREDIT NOTE LINE > TAX TOTAL
        List<TaxTotal> taxTotalListCNL = new ArrayList<>();
        TaxTotal taxTotalCNL = new TaxTotal.TaxTotalBuilder()
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .taxSubTotalList(taxSubTotalListCNL)
                .build();
        taxTotalListCNL.add(taxTotalCNL);

        //CREDIT NOTE LINE > ITEM > SELLERS ITEM IDENTIFICATION
        SellersItemIdentification sellersItemIdentificationCNL = new SellersItemIdentification.SellersItemIdentificationBuilder()
                .id("129_VERSION2")
                .build();

        /**
         * TODO
         */
        //CREDIT NOTE LINE > ITEM > DESCRIPTION
        List<Description> descriptionListCNL = new ArrayList<>();
        Description descriptionCNL = new Description.DescriptionBuilder()
                .value("heures normales_VERSION2")
                .build();
        descriptionListCNL.add(descriptionCNL);

        //CREDIT NOTE LINE > ITEM
        /*List<Item> itemListCNL = new ArrayList<>();
        Item itemCNL = new Item.ItemBuilder()
                .description("PRIME")
                .name("PRIME")
                .sellersItemIdentificationList(sellersItemIdentificationListCNL)
                .build();
        itemListCNL.add(itemCNL);*/
        List<Item> itemListCNL = new ArrayList<>();
        Item itemCNL = new Item.ItemBuilder()
                .descriptionList(descriptionListCNL)
                .name(new Name.NameBuilder()
                        .value("heures normales_VERSION2")
                        .build())
                .sellersItemIdentification(sellersItemIdentificationCNL)
                .build();
        itemListCNL.add(itemCNL);

        //CREDIT NOTE LINE > PRICE
        List<Price> priceListCNL = new ArrayList<>();
        Price priceCNL = new Price.PriceBuilder()
                .priceAmount(new PriceAmount.PriceAmountBuilder()
                        .value("21.018_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .baseQuantity(new BaseQuantity.BaseQuantityBuilder()
                        .value("1_VERSION2")
                        .attributes(new PatternCode.PatternCodeBuilder()
                                .unitCode("HUR_VERSION2")
                                .build())
                        .build())
                .orderableUnitFactorRate(new OrderableUnitFactorRate.OrderableUnitFactorRateBuilder()
                        .value("1_VERSION2")
                        .build())
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
         * WITH UBL TEMPLATE INVOICE 2.0 (VERSION 2 IN PROGRESS)
         */

        DocumentT docInvoice = new DocumentT("Invoice.xml", "");
        docInvoice.initialize();

        //UBL VERSION ID (VERSION 2)
        UBLVersionID invoiceUBLVersionID = new UBLVersionID.ElementUBLVersionIDBuilder()
                .value("2.0")
                .build();

        //CUSTOMIZATION ID (VERSION 2)
        CustomizationID invoiceCustomizationID = new CustomizationID.CustomizationIDBuilder()
                .value("urn:tradeshift.com:ubl-2.0-customizations:2010-06")
                .build();

        //PROFILE ID (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        ProfileID invoiceProfileID = new ProfileID.ProfileIDBuilder()
                .value("urn:www.cenbii.eu:profile:bii04:ver1.0")
                .attributes(new PatternScheme.PatternSchemeBuilder()
                        .schemeAgencyID("CEN/ISSS WS/BII")
                        .schemeID("CWA 16073:2010")
                        .schemeVersionID("1")
                        .build())
                .build();

        //INVOICE ID (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        ID invoiceID = new ID.IDBuilder()
                .value("038/0116560")
                .attributes(new PatternScheme.PatternSchemeBuilder().build())
                .build();

        //ISSUE DATE (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        IssueDate invoiceIssueDate = new IssueDate.IssueDateBuilder()
                .value("2021-04-30")
                .build();

        //INVOICE TYPE CODE (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        InvoiceTypeCode invoiceInvoiceTypeCode = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
                .value("380")
                .attributes(new PatternList.PatternListBuilder()
                        .listAgencyID("6")
                        .listID("UN/ECE 1001 Subset")
                        .listVersionID("D08B")
                        .build())
                .build();

        //DOCUMENT CURRENCY CODE (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        DocumentCurrencyCode invoiceDocumentCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                .value("EUR")
                .attributes(new PatternList.PatternListBuilder().build())
                .build();

        //ORDER REFERENCE (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        OrderReference invoiceOrderReference = new OrderReference.OrderReferenceBuilder()
                .id(new ID.IDBuilder()
                        .value("C800430638")
                        .attributes(new PatternScheme.PatternSchemeBuilder().build())
                        .build())
                .build();


        //ADDITIONAL DOCUMENT REFERENCE (VERSION 2)

        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT > EMBEDDED DOCUMENT BINARY OBJECT (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        EmbeddedDocumentBinaryObject embeddedDocumentBinaryObject44 = new EmbeddedDocumentBinaryObject.EmbeddedDocumentBinaryObjectBuilder()
                .value("JVBERi0xLjQKJeTjz_TEST")
                .attributes(new PatternFile.PatternFileBuilder()
                        .encodingCode("Base64_TEST")
                        .filename("avoir eiffage 1.pdf_TEST")
                        .mimeCode("application/pdf_TEST").build())
                .build();
        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        Attachment attachment44 = new Attachment.AttachmentBuilder()
                .embeddedDocumentBinaryObject(embeddedDocumentBinaryObject44)
                .build();
        //ADDITIONAL DOCUMENT REFERENCE (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        List<AdditionalDocumentReference> additionalDocumentReferenceListInvoice = new ArrayList<>();
        AdditionalDocumentReference additionalDocumentReference44 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .id(new ID.IDBuilder()
                        .value("attachment_TEST")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .build())
                        .build())
                .documentTypeCode(new DocumentTypeCode.DocumentTypeCodeBuilder()
                        .value("attachment_TEST")
                        .attributes(new PatternList.PatternListBuilder()
                                .listID("urn:tradeshift.com:api:1.0:documenttypecode_TEST")
                                .build())
                        .build())
                .attachment(attachment44)
                .build();
        additionalDocumentReferenceListInvoice.add(additionalDocumentReference44);


        //ACCOUNTING SUPPLIER PARTY (VERSION 2 IN PROGRESS)

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY IDENTIFICATION (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        List<PartyIdentification> partyIdentificationListInvoice = new ArrayList<>();
        PartyIdentification partyIdentification1Invoice = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("FR21314887126_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT")
                                .build())
                        .build())
                .build();
        PartyIdentification partyIdentification2Invoice = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("FR21314887126_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT")
                                .build())
                        .build())
                .build();
        partyIdentificationListInvoice.add(partyIdentification1Invoice);
        partyIdentificationListInvoice.add(partyIdentification2Invoice);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY NAME (VERSION 2) - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        List<PartyName> partyNameListInvoice = new ArrayList<>();
        PartyName partyNameInvoice1 = new PartyName.PartyNameBuilder()
                .name(new Name.NameBuilder()
                        .value("Groupe SOVITRAT_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .build();
        partyNameListInvoice.add(partyNameInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS > COUNTRY - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        Country countryInvoice1 = new Country.CountryBuilder()
                .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                        .value("FR_VERSION2")
                        .attributes(new PatternList.PatternListBuilder()
                                .build())
                        .build())
                .name(new Name.NameBuilder()
                        .value("LALA_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS - A FAIRE LE CHANGEMENT COMME CUSTOMIZATION ID
        PostalAddress postalAddressInvoice1 = new PostalAddress.PostalAddressBuilder()
                .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                        .value("5_VERSION2")
                        .attributes(new PatternList.PatternListBuilder()
                                .listAgencyID("6_VERSION2")
                                .listID("UN/ECE 3477_VERSION2")
                                .listVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .postbox(new Postbox.PostboxBuilder()
                        .value("69006_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .streetName(new StreetName.StreetNameBuilder()
                        .value("4 RUE DUGUESCLIN_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .buildingNumber(new BuildingNumber.BuildingNumberBuilder()
                        .value("_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .cityName(new CityName.CityNameBuilder()
                        .value("LYON_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .postalZone(new PostalZone.PostalZoneBuilder()
                        .value("69006_VERSION2")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .country(countryInvoice1)
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
        List<TaxScheme> taxSchemeListInvoice = new ArrayList<>();
        TaxScheme taxSchemeInvoice1 = new TaxScheme.TaxSchemeBuilder()
                .id(new ID.IDBuilder()
                        .value("S_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6_VERSION2")
                                .schemeID("UN/ECE 5153 Subset_VERSION2")
                                .schemeVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .name(new Name.NameBuilder()
                        .value("FR TVA 20%_VERSION2")
                        .build())
                .build();
        taxSchemeListInvoice.add(taxSchemeInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME
        List<PartyTaxScheme> partyTaxSchemeListInvoice = new ArrayList<>();
        PartyTaxScheme partyTaxSchemeInvoice1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("FR21314887126_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT_VERSION2")
                                .build())
                        .build())
                .taxScheme(taxScheme1)
                .build();
        partyTaxSchemeListInvoice.add(partyTaxSchemeInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > REGISTRATION ADDRESS
        RegistrationAddress registrationAddressInvoice1 = new RegistrationAddress.RegistrationAddressBuilder()
                .id(new ID.IDBuilder()
                        .value("LYON_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:RCS_VERSION2")
                                .build())
                        .build())
                .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                        .value("5")
                        .attributes(new PatternList.PatternListBuilder()
                                .listAgencyID("6_VERSION2")
                                .listID("UN/ECE 3477_VERSION2")
                                .build())
                        .build())
                .postBox(new Postbox.PostboxBuilder()
                        .value("69006_VERSION2")
                        .build())
                .streetName(new StreetName.StreetNameBuilder()
                        .value("4 RUE DUGUESCLIN_VERSION2")
                        .build())
                .buildingNumber(new BuildingNumber.BuildingNumberBuilder()
                        .value("NOVALI_VERSION2")
                        .build())
                .cityName(new CityName.CityNameBuilder()
                        .value("LYON_VERSION2")
                        .build())
                .postalZone(new PostalZone.PostalZoneBuilder()
                        .value("69006_VERSION2")
                        .build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > CORPORATE REGISTRATION SCHEME
        CorporateRegistrationScheme corporateRegistrationSchemeInvoice1 = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                .id(new ID.IDBuilder().value("PUBLIC_LIMITED_VERSION2").build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY
        List<PartyLegalEntity> partyLegalEntityListInvoice = new ArrayList<>();
        PartyLegalEntity partyLegalEntityInvoice1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                .registrationName(new RegistrationName.RegistrationNameBuilder()
                        .value("Groupe SOVITRAT_VERSION2")
                        .build())
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("31488712600253_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:SIRET_VERSION2")
                                .build())
                        .build())
                .registrationAddress(registrationAddressInvoice1)
                .corporateRegistrationScheme(corporateRegistrationSchemeInvoice1)
                .build();
        partyLegalEntityListInvoice.add(partyLegalEntityInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > CONTACT
        Contact contactInvoice1 = new Contact.ContactBuilder()
                .id(new ID.IDBuilder()
                        .value("5a59bb3c-adf8-4b72-b45b-f4f2f33676f1_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeURI("http://tradeshift.com/api/1.0/userId_VERSION2")
                                .build())
                        .build())
                .name(new Name.NameBuilder().value("Amor BOUGHZALA_VERSION2").build())
                .telephone(new Telephone.TelephoneBuilder().value("0472699760_VERSION2").build())
                .electronicMail(new ElectronicMail.ElectronicMailBuilder().value("master@sovitrat.fr_VERSION2").build())
                .note(new Note.NoteBuilder().value("Groupe SOVITRAT PUBLIC_LIMITED with share capi_VERSION2").build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PERSON
        Person personInvoice1 = new Person.PersonBuilder()
                .firstName(new FirstName.FirstNameBuilder().value("Amor_VERSION2").build())
                .familyName(new FamilyName.FamilyNameBuilder().value("BOUGHZALA_VERSION2").build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY
        Party elementPartyInvoice1 = new Party.PartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .partyIdentificationList(partyIdentificationListInvoice)
                .partyNameList(partyNameListInvoice)
                .postalAddress(postalAddressInvoice1)
                .partyTaxSchemeList(partyTaxSchemeListInvoice)
                .partyLegalEntityList(partyLegalEntityListInvoice)
                .contact(contactInvoice1)
                .person(personInvoice1)
                .build();

        //ACCOUNTING SUPPLIER PARTY
        AccountingSupplierParty elementAccountingSupplierPartyInvoice = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(elementCreditNote)
                .party(elementPartyInvoice1)
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
        TaxScheme taxSchemeInvoice44 = new TaxScheme.TaxSchemeBuilder()
                .id(new ID.IDBuilder()
                        .value("VAT_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6_VERSION2")
                                .schemeID("UN/ECE 5153 Subset_VERSION2")
                                .schemeVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .name(new Name.NameBuilder()
                        .value("FR TVA 20%_VERSION2")
                        .build())
                .build();

        //TAX CATEGORY
        TaxCategory taxCategoryInvoice44 = new TaxCategory.TaxCategoryBuilder()
                .id(new ID.IDBuilder()
                        .value("S_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6_VERSION2")
                                .schemeID("UN/ECE 5305_VERSION2")
                                .schemeVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .percent(new Percent.PercentBuilder().value("20_VERSION2").build())
                .taxScheme(taxSchemeInvoice44)
                .build();

        //TAX SUB TOTAL
        List<TaxSubTotal> taxSubTotalList44 = new ArrayList<>();
        TaxSubTotal taxSubTotal44 = new TaxSubTotal.TaxSubTotalBuilder()
                .taxableAmount(new TaxableAmount.TaxableAmountBuilder()
                        .value("109.24_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .calculationSequenceNumeric(new CalculationSequenceNumeric.CalculationSequenceNumericBuilder().value("1").build())
                .taxCategory(taxCategoryInvoice44)
                .build();
        taxSubTotalList44.add(taxSubTotal44);


        //TAX TOTAL
        TaxTotal taxTotal44 = new TaxTotal.TaxTotalBuilder()
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .taxSubTotalList(taxSubTotalList44)
                .build();

        //SELLERS ITEM IDENTIFICATION
        SellersItemIdentification sellersItemIdentification44 = new SellersItemIdentification.SellersItemIdentificationBuilder()
                .id("001_VERSION2")
                .build();

        /**
         * TODO
         */
        //CREDIT NOTE LINE > ITEM > DESCRIPTION
        List<Description> descriptionList44 = new ArrayList<>();
        Description description44 = new Description.DescriptionBuilder()
                .value("heures normales_VERSION2")
                .build();
        descriptionList44.add(description44);

        //ITEM
        /*Item item44 = new Item.ItemBuilder()
                .description("heures normales")
                .name("heures normales")
                .sellersItemIdentificationList(sellersItemIdentificationList44)
                .build();*/
        Item item44 = new Item.ItemBuilder()
                .descriptionList(descriptionList44)
                .name(new Name.NameBuilder()
                        .value("heures normales_VERSION2")
                        .build())
                .sellersItemIdentification(sellersItemIdentification44)
                .build();

        //PRICE
        Price price44 = new Price.PriceBuilder()
                .priceAmount(new PriceAmount.PriceAmountBuilder()
                        .value("21.018_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .baseQuantity(new BaseQuantity.BaseQuantityBuilder()
                        .value("1_VERSION2")
                        .attributes(new PatternCode.PatternCodeBuilder()
                                .unitCode("HUR_VERSION2")
                                .build())
                        .build())
                .orderableUnitFactorRate(new OrderableUnitFactorRate.OrderableUnitFactorRateBuilder()
                        .value("1_VERSION2")
                        .build())
                .build();

        //INVOICE LINE
        List<InvoiceLine> invoiceLineList44 = new ArrayList<>();
        InvoiceLine invoiceLine44 = new InvoiceLine.InvoiceLineBuilder()
                .id(new ID.IDBuilder()
                        .value("1")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .build())
                        .build())
                .invoicedQuantity(new InvoicedQuantity.InvoicedQuantityBuilder()
                        .value("34")
                        .attributes(new PatternCode.PatternCodeBuilder()
                                .unitCode("HUR")
                                .build()).build())
                .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                        .value("714.61")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
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
