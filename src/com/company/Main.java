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
         * ---
         * UBL TEMPLATE CREDIT NOTE 2.0
         * v1.1.0
         * ---
         */

        DocumentT docCreditNote = new DocumentT("CreditNoteExample.xml", "");
        docCreditNote.initialize();

        /**
         * Element UBLVersionID
         */
        UBLVersionID ublVersionIDCreditNote = new UBLVersionID.ElementUBLVersionIDBuilder()
                .value("2.0")
                .build();

        /**
         * Element CustomizationID
         */
        CustomizationID customizationIDCreditNote = new CustomizationID.CustomizationIDBuilder()
                .value("urn:tradeshift.com:ubl-2.0-customizations:2010-06")
                .build();

        /**
         * Element ProfileID
         */
        ProfileID profileIDCreditNote = new ProfileID.ProfileIDBuilder()
                .value("urn:www.cenbii.eu:profile:bii04:ver1.0")
                .attributes(new PatternScheme.PatternSchemeBuilder()
                        .schemeAgencyID("CEN/ISSS WS/BII")
                        .schemeID("CWA 16073:2010")
                        .schemeVersionID("1")
                        .build())
                .build();

        /**
         * Element ID
         */
        ID iDCreditNote = new ID.IDBuilder()
                .value("038/0116297")
                .build();

        /**
         * Element IssueDate
         */
        IssueDate issueDateCreditNote = new IssueDate.IssueDateBuilder()
                .value("2020-01-22")
                .build();

        /**
         * Element DocumentCurrencyCode
         */
        DocumentCurrencyCode documentCurrencyCodeCreditNote = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                .value("EUR")
                .build();

        /**
         * Element OrderReference
         */
        OrderReference ublOrderReference = new OrderReference.OrderReferenceBuilder()
                .id(new ID.IDBuilder()
                        .value("C180001053")
                        .build())
                .build();

        /**
         * Element BillingReference [List]
         */
        InvoiceDocumentReference invoiceDocumentReferenceCreditNote = new InvoiceDocumentReference.InvoiceDocumentReferenceBuilder()
                .id(new ID.IDBuilder()
                        .value("038/0115616")
                        .build())
                .build();

        List<BillingReference> billingReferenceListCreditNote = new ArrayList<>();
        BillingReference billingReferenceCreditNote1 = new BillingReference.BillingReferenceBuilder()
                .invoiceDocumentReference(invoiceDocumentReferenceCreditNote)
                .build();
        billingReferenceListCreditNote.add(billingReferenceCreditNote1);

        /**
         * Element AdditionalDocumentReference [List]
         */

        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT > EMBEDDED DOCUMENT BINARY OBJECT
        EmbeddedDocumentBinaryObject embeddedDocumentBinaryObjectCreditNote1 = new EmbeddedDocumentBinaryObject.EmbeddedDocumentBinaryObjectBuilder()
                .value("JVBERi0xLjQKJeTjz_TEST")
                .attributes(new PatternFile.PatternFileBuilder()
                        .encodingCode("Base64_TEST")
                        .filename("avoir eiffage 1.pdf_TEST")
                        .mimeCode("application/pdf_TEST").build())
                .build();

        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT
        Attachment attachmentCreditNote1 = new Attachment.AttachmentBuilder()
                .embeddedDocumentBinaryObject(embeddedDocumentBinaryObjectCreditNote1)
                .build();

        //ADDITIONAL DOCUMENT REFERENCE
        List<AdditionalDocumentReference> additionalDocumentReferenceListCreditNote = new ArrayList<>();
        AdditionalDocumentReference additionalDocumentReferenceCreditNote1 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
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
                .attachment(attachmentCreditNote1)
                .build();
        additionalDocumentReferenceListCreditNote.add(additionalDocumentReferenceCreditNote1);

        /**
         * Element AccountingSupplierParty
         */

        //TODO

        /**
         * Element AccountingCustomerParty
         */

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY IDENTIFICATION
        List<PartyIdentification> partyIdentificationListCreditNote = new ArrayList<>();
        PartyIdentification partyIdentificationCreditNote1 = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("FR21314887126_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT")
                                .build())
                        .build())
                .build();
        PartyIdentification partyIdentificationCreditNote2 = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("31488712600253_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:SIRET")
                                .build())
                        .build())
                .build();
        partyIdentificationListCreditNote.add(partyIdentificationCreditNote1);
        partyIdentificationListCreditNote.add(partyIdentificationCreditNote2);

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY NAME
        List<PartyName> partyNameListCreditNote = new ArrayList<>();
        PartyName partyNameCreditNote1 = new PartyName.PartyNameBuilder()
                .name(new Name.NameBuilder()
                        .value("Groupe SOVITRAT_VERSION2")
                        .build())
                .build();
        partyNameListCreditNote.add(partyNameCreditNote1);

        //ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
        Country countryCreditNote1 = new Country.CountryBuilder()
                .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                        .value("FR_VERSION2")
                        .build())
                .name(new Name.NameBuilder()
                        .value("LALA_VERSION2")
                        .build())
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS
        PostalAddress postalAddressCreditNote1 = new PostalAddress.PostalAddressBuilder()
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
                        .build())
                .streetName(new StreetName.StreetNameBuilder()
                        .value("4 RUE DUGUESCLIN_VERSION2")
                        .build())
                .buildingNumber(new BuildingNumber.BuildingNumberBuilder()
                        .value("_VERSION2")
                        .build())
                .cityName(new CityName.CityNameBuilder()
                        .value("LYON_VERSION2")
                        .build())
                .postalZone(new PostalZone.PostalZoneBuilder()
                        .value("69006_VERSION2")
                        .build())
                .country(countryCreditNote1)
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
        TaxScheme taxSchemeCreditNote1 = new TaxScheme.TaxSchemeBuilder()
                .name(new Name.NameBuilder()
                        .value("VATfdgdfgdfgdfgdfg")
                        .build())
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY TAX SCHEME
        List<PartyTaxScheme> partyTaxSchemeListCreditNote = new ArrayList<>();
        PartyTaxScheme partyTaxSchemeCreditNote1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("FR21314887126_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT_VERSION2")
                                .build())
                        .build())
                .taxScheme(taxSchemeCreditNote1)
                .build();
        partyTaxSchemeListCreditNote.add(partyTaxSchemeCreditNote1);

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY LEGAL ENTITY > REGISTRATION ADDRESS
        RegistrationAddress registrationAddressCreditNote1 = new RegistrationAddress.RegistrationAddressBuilder()
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

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY LEGAL ENTITY > CORPORATE REGISTRATION SCHEME
        CorporateRegistrationScheme corporateRegistrationSchemeCreditNote1 = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                .id(new ID.IDBuilder()
                        .value("PUBLIC_LIMITED_VERSION2")
                        .build())
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY LEGAL ENTITY
        List<PartyLegalEntity> partyLegalEntityListCreditNote = new ArrayList<>();
        PartyLegalEntity partyLegalEntityCreditNote1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                .registrationName(new RegistrationName.RegistrationNameBuilder()
                        .value("Groupe SOVITRAT_VERSION2")
                        .build())
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("31488712600253_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:SIRET_VERSION2")
                                .build())
                        .build())
                .registrationAddress(registrationAddressCreditNote1)
                .corporateRegistrationScheme(corporateRegistrationSchemeCreditNote1)
                .build();
        partyLegalEntityListCreditNote.add(partyLegalEntityCreditNote1);

        //ACCOUNTING CUSTOMER PARTY > PARTY > CONTACT
        Contact contactCreditNote1 = new Contact.ContactBuilder()
                .id(new ID.IDBuilder()
                        .value("5a59bb3c-adf8-4b72-b45b-f4f2f33676f1_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeURI("http://tradeshift.com/api/1.0/userId_VERSION2")
                                .build())
                        .build())
                .name(new Name.NameBuilder()
                        .value("Amor BOUGHZALA_VERSION2")
                        .build())
                .telephone(new Telephone.TelephoneBuilder()
                        .value("0472699760_VERSION2")
                        .build())
                .electronicMail(new ElectronicMail.ElectronicMailBuilder()
                        .value("master@sovitrat.fr_VERSION2")
                        .build())
                .note(new Note.NoteBuilder()
                        .value("Groupe SOVITRAT PUBLIC_LIMITED with share capi_VERSION2")
                        .build())
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY > PERSON
        Person personCreditNote1 = new Person.PersonBuilder()
                .firstName(new FirstName.FirstNameBuilder()
                        .value("Amor_VERSION2")
                        .build())
                .familyName(new FamilyName.FamilyNameBuilder()
                        .value("BOUGHZALA_VERSION2")
                        .build())
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY
        Party elementPartyCreditNote = new Party.PartyBuilder()
                .partyIdentificationList(partyIdentificationListCreditNote)
                .partyNameList(partyNameListCreditNote)
                .postalAddress(postalAddressCreditNote1)
                .partyTaxSchemeList(partyTaxSchemeListCreditNote)
                .partyLegalEntityList(partyLegalEntityListCreditNote)
                .contact(contactCreditNote1)
                .person(personCreditNote1)
                .build();

        //ACCOUNTING CUSTOMER PARTY
        AccountingCustomerParty elementAccountingCustomerPartyCreditNote = new AccountingCustomerParty.AccountingCustomerPartyBuilder()
                .party(elementPartyCreditNote)
                .build();

        /**
         * Element TaxTotal [List]
         */

        //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY > TAX SCHEME
        TaxScheme taxSchemeCreditNote2 = new TaxScheme.TaxSchemeBuilder()
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
        TaxCategory taxCategoryCreditNote1 = new TaxCategory.TaxCategoryBuilder()
                .id(new ID.IDBuilder()
                        .value("S_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6_VERSION2")
                                .schemeID("UN/ECE 5305_VERSION2")
                                .schemeVersionID("D08B_VERSION2")
                                .build())
                        .build())
                .percent(new Percent.PercentBuilder()
                        .value("20_VERSION2")
                        .build())
                .taxScheme(taxSchemeCreditNote2)
                .build();

        //TAX TOTAL > TAX SUB TOTAL
        List<TaxSubTotal> taxSubTotalListCreditNote1 = new ArrayList<>();
        TaxSubTotal taxSubTotalCreditNote1 = new TaxSubTotal.TaxSubTotalBuilder()
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
                .taxCategory(taxCategoryCreditNote1)
                .build();
        taxSubTotalListCreditNote1.add(taxSubTotalCreditNote1);

        //TAX TOTAL
        List<TaxTotal> taxTotalListCreditNote = new ArrayList<>();
        TaxTotal taxTotalCreditNote1 = new TaxTotal.TaxTotalBuilder()
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85_VERSION2")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR_VERSION2")
                                .build())
                        .build())
                .taxSubTotalList(taxSubTotalListCreditNote1)
                .build();
        taxTotalListCreditNote.add(taxTotalCreditNote1);

        /**
         * Element LegalMonetaryTotal
         */

        LegalMonetaryTotal legalMonetaryTotalCreditNote = new LegalMonetaryTotal.LegalMonetaryTotalBuilder()
                .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                        .value("774.15")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .taxExclusiveAmount(new TaxExclusiveAmount.TaxExclusiveAmountBuilder()
                        .value("154.83")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .taxInclusiveAmount(new TaxInclusiveAmount.TaxInclusiveAmountBuilder()
                        .value("928.98")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .payableAmount(new PayableAmount.PayableAmountBuilder()
                        .value("928.98")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .build();

        /**
         * Element CreditNoteLine [List]
         */

        TaxScheme taxSchemeCreditNoteLine1 = new TaxScheme.TaxSchemeBuilder()
                .id(new ID.IDBuilder()
                        .value("VAT")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6")
                                .schemeID("UN/ECE 5153 Subset")
                                .schemeVersionID("D08B")
                                .build())
                        .build())
                .name(new Name.NameBuilder()
                        .value("FR TVA 20%")
                        .build())
                .build();

        TaxCategory taxCategoryCreditNoteLine1 = new TaxCategory.TaxCategoryBuilder()
                .id(new ID.IDBuilder()
                        .value("S")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeAgencyID("6")
                                .schemeID("UN/ECE 5305")
                                .schemeVersionID("D08B")
                                .build())
                        .build())
                .percent(new Percent.PercentBuilder()
                        .value("20")
                        .build())
                .taxScheme(taxSchemeCreditNoteLine1)
                .build();

        List<TaxSubTotal> taxSubTotalListCreditNoteLine = new ArrayList<>();
        TaxSubTotal taxSubTotalCreditNoteLine1 = new TaxSubTotal.TaxSubTotalBuilder()
                .taxableAmount(new TaxableAmount.TaxableAmountBuilder()
                        .value("109.24")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .calculationSequenceNumeric(new CalculationSequenceNumeric.CalculationSequenceNumericBuilder()
                        .value("1")
                        .build())
                .taxCategory(taxCategoryCreditNoteLine1)
                .build();
        taxSubTotalListCreditNoteLine.add(taxSubTotalCreditNoteLine1);

        List<TaxTotal> taxTotalListCreditNoteLine = new ArrayList<>();
        TaxTotal taxTotalCreditNoteLine1 = new TaxTotal.TaxTotalBuilder()
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .taxSubTotalList(taxSubTotalListCreditNoteLine)
                .build();
        taxTotalListCreditNoteLine.add(taxTotalCreditNoteLine1);

        List<Description> descriptionListCreditNoteLine = new ArrayList<>();
        Description descriptionCreditNoteLine1 = new Description.DescriptionBuilder()
                .value("PRIME")
                .build();
        descriptionListCreditNoteLine.add(descriptionCreditNoteLine1);

        SellersItemIdentification sellersItemIdentificationCreditNoteLine = new SellersItemIdentification.SellersItemIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("129")
                        .build())
                .build();

        Item itemCreditNoteLine = new Item.ItemBuilder()
                .descriptionList(descriptionListCreditNoteLine)
                .name(new Name.NameBuilder()
                        .value("PRIME")
                        .build())
                .sellersItemIdentification(sellersItemIdentificationCreditNoteLine)
                .build();

        Price priceCreditNoteLine = new Price.PriceBuilder()
                .priceAmount(new PriceAmount.PriceAmountBuilder()
                        .value("109.24")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .baseQuantity(new BaseQuantity.BaseQuantityBuilder()
                        .value("1")
                        .attributes(new PatternCode.PatternCodeBuilder()
                                .unitCode("EA")
                                .build())
                        .build())
                .orderableUnitFactorRate(new OrderableUnitFactorRate.OrderableUnitFactorRateBuilder()
                        .value("1")
                        .build())
                .build();

        List<CreditNoteLine> creditNoteLineListCreditNote = new ArrayList<>();
        CreditNoteLine creditNoteLineCreditNote = new CreditNoteLine.CreditNoteLineBuilder()
                .id(new ID.IDBuilder()
                        .value("1")
                        .build())
                .creditedQuantity(new CreditedQuantity.CreditedQuantityBuilder()
                        .value("109.24")
                        .attributes(new PatternCode.PatternCodeBuilder()
                                .unitCode("EA")
                                .build())
                        .build())
                .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                        .value("109.24")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .taxTotalList(taxTotalListCreditNoteLine)
                .item(itemCreditNoteLine)
                .price(priceCreditNoteLine)
                .build();
        creditNoteLineListCreditNote.add(creditNoteLineCreditNote);

        /**
         * Element ROOT
         */

        Element elementUBLCreditNote = new UBLCreditNote20.UBLCreditNote20Builder()
                .documentLinked(docCreditNote.getDoc())
                .ublVersionID(ublVersionIDCreditNote)
                .customizationID(customizationIDCreditNote)
                .profileID(profileIDCreditNote)
                .id(iDCreditNote)
                .issueDate(issueDateCreditNote)
                .documentCurrencyCode(documentCurrencyCodeCreditNote)
                .orderReference(ublOrderReference)
                .billingReferenceList(billingReferenceListCreditNote)
                .additionalDocumentReferenceList(additionalDocumentReferenceListCreditNote)
                .accountingCustomerParty(elementAccountingCustomerPartyCreditNote)
                .taxTotalList(taxTotalListCreditNote)
                .legalMonetaryTotal(legalMonetaryTotalCreditNote)
                .creditNoteLineList(creditNoteLineListCreditNote)
                .build().load();

        docCreditNote.generate();


        /**
         * ---
         * UBL TEMPLATE INVOICE 2.0
         * v1.1.0
         * ---
         */

        DocumentT docInvoice = new DocumentT("InvoiceExample.xml", "");
        docInvoice.initialize();

        /**
         * Element UBLVersionID
         */
        UBLVersionID invoiceUBLVersionID = new UBLVersionID.ElementUBLVersionIDBuilder()
                .value("2.0")
                .build();

        /**
         * Element CustomizationID
         */
        CustomizationID invoiceCustomizationID = new CustomizationID.CustomizationIDBuilder()
                .value("urn:tradeshift.com:ubl-2.0-customizations:2010-06")
                .build();

        /**
         * Element ProfileID
         */
        ProfileID invoiceProfileID = new ProfileID.ProfileIDBuilder()
                .value("urn:www.cenbii.eu:profile:bii04:ver1.0")
                .attributes(new PatternScheme.PatternSchemeBuilder()
                        .schemeAgencyID("CEN/ISSS WS/BII")
                        .schemeID("CWA 16073:2010")
                        .schemeVersionID("1")
                        .build())
                .build();

        /**
         * Element ID
         */
        ID invoiceID = new ID.IDBuilder()
                .value("038/0116560")
                .build();

        /**
         * Element IssueDate
         */
        IssueDate invoiceIssueDate = new IssueDate.IssueDateBuilder()
                .value("2021-04-30")
                .build();

        /**
         * Element InvoiceTypeCode
         */
        InvoiceTypeCode invoiceInvoiceTypeCode = new InvoiceTypeCode.InvoiceTypeCodeBuilder()
                .value("380")
                .attributes(new PatternList.PatternListBuilder()
                        .listAgencyID("6")
                        .listID("UN/ECE 1001 Subset")
                        .listVersionID("D08B")
                        .build())
                .build();

        /**
         * Element DocumentCurrencyCode
         */
        DocumentCurrencyCode invoiceDocumentCurrencyCode = new DocumentCurrencyCode.DocumentCurrencyCodeBuilder()
                .value("EUR")
                .build();

        /**
         * Element OrderReference
         */
        OrderReference invoiceOrderReference = new OrderReference.OrderReferenceBuilder()
                .id(new ID.IDBuilder()
                        .value("C800430638")
                        .build())
                .build();


        /**
         * Element AdditionalDocumentReference [List]
         */

        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT > EMBEDDED DOCUMENT BINARY OBJECT
        EmbeddedDocumentBinaryObject embeddedDocumentBinaryObject44 = new EmbeddedDocumentBinaryObject.EmbeddedDocumentBinaryObjectBuilder()
                .value("JVBERi0xLjQKJeTjz_TEST")
                .attributes(new PatternFile.PatternFileBuilder()
                        .encodingCode("Base64_TEST")
                        .filename("avoir eiffage 1.pdf_TEST")
                        .mimeCode("application/pdf_TEST").build())
                .build();
        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT
        Attachment attachment44 = new Attachment.AttachmentBuilder()
                .embeddedDocumentBinaryObject(embeddedDocumentBinaryObject44)
                .build();
        //ADDITIONAL DOCUMENT REFERENCE
        List<AdditionalDocumentReference> additionalDocumentReferenceListInvoice = new ArrayList<>();
        AdditionalDocumentReference additionalDocumentReference44 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .id(new ID.IDBuilder()
                        .value("attachment_TEST")
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


        /**
         * Element AccountingSupplierParty
         */

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY IDENTIFICATION
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

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY NAME
        List<PartyName> partyNameListInvoice = new ArrayList<>();
        PartyName partyNameInvoice1 = new PartyName.PartyNameBuilder()
                .name(new Name.NameBuilder()
                        .value("Groupe SOVITRAT_VERSION2")
                        .build())
                .build();
        partyNameListInvoice.add(partyNameInvoice1);

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
        Country countryInvoice1 = new Country.CountryBuilder()
                .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                        .value("FR_VERSION2")
                        .build())
                .name(new Name.NameBuilder()
                        .value("LALA_VERSION2")
                        .build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS
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

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME
        List<PartyTaxScheme> partyTaxSchemeListInvoice = new ArrayList<>();
        PartyTaxScheme partyTaxSchemeInvoice1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("FR21314887126_VERSION2")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT_VERSION2")
                                .build())
                        .build())
                .taxScheme(taxSchemeInvoice1)
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
                .party(elementPartyInvoice1)
                .build();

        /**
         * Element AccountingCustomerParty
         */

        //TODO

        /**
         * Element PaymentMeans [List]
         */

        //PAYMENT MEANS > PAYEE FINANCIAL ACCOUNT > FINANCIAL INSTITUTION BRANCH > FINANCIAL INSTITUTION
        FinancialInstitution financialInstitution1 = new FinancialInstitution.FinancialInstitutionBuilder()
                .id(new ID.IDBuilder()
                        .value("CCFRFRPP")
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
                        .build())
                .financialInstitutionBranch(financialInstitutionBranch1)
                .build();
        //PAYMENT MEANS
        List<PaymentMeans> paymentMeansListInvoice = new ArrayList<>();
        PaymentMeans paymentMeans1 = new PaymentMeans.PaymentMeansBuilder()
                .id(new ID.IDBuilder()
                        .value("6edad297-67e3-4805-8e6d-691eb12f1138")
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

        /**
         * Element TaxTotal [List]
         */

        //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY > TAX SCHEME
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

        //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY
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

        //TAX TOTAL > TAX SUB TOTAL
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

        /**
         * Element LegalMonetaryTotal
         */

        LegalMonetaryTotal legalMonetaryTotalInvoice1 = new LegalMonetaryTotal.LegalMonetaryTotalBuilder()
                .lineExtensionAmount(new LineExtensionAmount.LineExtensionAmountBuilder()
                        .value("774.15")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .taxExclusiveAmount(new TaxExclusiveAmount.TaxExclusiveAmountBuilder()
                        .value("154.83")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .taxInclusiveAmount(new TaxInclusiveAmount.TaxInclusiveAmountBuilder()
                        .value("928.98")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .payableAmount(new PayableAmount.PayableAmountBuilder()
                        .value("928.98")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
                                .build())
                        .build())
                .build();

        /**
         * Element InvoiceLine [List]
         */

        //INVOICE LINE > ITEM > SELLERS ITEM IDENTIFICATION
        SellersItemIdentification sellersItemIdentification44 = new SellersItemIdentification.SellersItemIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("129_VERSION2")
                        .build())
                .build();

        //INVOICE LINE > ITEM > DESCRIPTION
        List<Description> descriptionList44 = new ArrayList<>();
        Description description44 = new Description.DescriptionBuilder()
                .value("heures normales_VERSION2")
                .build();
        descriptionList44.add(description44);

        //INVOICE LINE > ITEM
        Item item44 = new Item.ItemBuilder()
                .descriptionList(descriptionList44)
                .name(new Name.NameBuilder()
                        .value("heures normales_VERSION2")
                        .build())
                .sellersItemIdentification(sellersItemIdentification44)
                .build();

        //INVOICE LINE > PRICE
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

        /**
         * Element ROOT
         */

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
                .legalMonetaryTotal(legalMonetaryTotalInvoice1)
                .invoiceLineList(invoiceLineList44)
                .build().load();

        docInvoice.generate();

    }
}
