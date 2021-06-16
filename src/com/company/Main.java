package com.company;

import com.company.xml.ubl.axioms.*;
import com.company.xml.ubl.data.*;
import com.company.xml.ubl.modules.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DocumentT doc = new DocumentT("cars3.xml","");
        doc.initialize();

        Element eleCreditNote = new ElementT(doc.getDoc(), ElementsName.CREDIT_CARD.label).loadDoc();
        Attr attrEleCreditCard1 = new AttributeT(doc.getDoc(), eleCreditNote, NamespacesName.XMLNS.label,NamespacesName.XMLNS_IMPORT.label).load();
        Attr attrEleCreditCard2 = new AttributeT(doc.getDoc(), eleCreditNote, NamespacesName.XMLNS_CAC_ATTR.label, NamespacesName.XMLNS_CAC_IMPORT.label).load();
        Attr attrEleCreditCard3 = new AttributeT(doc.getDoc(), eleCreditNote, NamespacesName.XMLNS_CBC_ATTR.label,NamespacesName.XMLNS_CBC_IMPORT.label).load();
        Attr attrEleCreditCard4 = new AttributeT(doc.getDoc(), eleCreditNote, NamespacesName.XMLNS_CCTS_ATTR.label,NamespacesName.XMLNS_CCTS_IMPORT.label).load();
        Attr attrEleCreditCard5 = new AttributeT(doc.getDoc(), eleCreditNote, NamespacesName.XMLNS_EXT_ATTR.label,NamespacesName.XMLNS_EXT_IMPORT.label).load();
        Attr attrEleCreditCard6 = new AttributeT(doc.getDoc(), eleCreditNote, NamespacesName.XMLNS_NS7_ATTR.label,NamespacesName.XMLNS_NS7_IMPORT.label).load();
        Attr attrEleCreditCard7 = new AttributeT(doc.getDoc(), eleCreditNote, NamespacesName.XMLNS_SDT_ATTR.label,NamespacesName.XMLNS_SDT_IMPORT.label).load();
        Attr attrEleCreditCard8 = new AttributeT(doc.getDoc(), eleCreditNote, NamespacesName.XMLNS_UDT_ATTR.label,NamespacesName.XMLNS_UDT_IMPORT.label).load();

        Element eleUBLVersionId = new ElementT(doc.getDoc(), eleCreditNote, ElementsName.UBL_VERSION_ID.label,"2.0").load();
        Element eleCustomizationId = new ElementT(doc.getDoc(), eleCreditNote, ElementsName.CUSTOMIZATION_ID.label,"urn:tradeshift.com:ubl-2.0-customizations:2010-06").load();

        Element eleProfileID = new ElementT(doc.getDoc(), eleCreditNote, ElementsName.PROFILE_ID.label,"urn:www.cenbii.eu:profile:bii04:ver1.0").load();
        Attr attrEleProfileID1 = new AttributeT(doc.getDoc(), eleProfileID, AttributesName.PROFIL_ID_SCHEMA_AGENCY_ID.label,"CEN/ISSS WS/BII").load();
        Attr attrEleProfileID2 = new AttributeT(doc.getDoc(), eleProfileID, AttributesName.PROFIL_ID_SCHEMA_ID.label,"CWA 16073:2010").load();
        Attr attrEleProfileID3 = new AttributeT(doc.getDoc(), eleProfileID, AttributesName.PROFIL_ID_SCHEMA_VERSION_ID.label, "urn:www.cenbii.eu:profile:bii04:ver1.0").load();

        Element eleID = new ElementT(doc.getDoc(), eleCreditNote, ElementsName.ID.label,"038/0116297").load();

        Element eleIssueDate = new ElementT(doc.getDoc(), eleCreditNote, ElementsName.ISSUE_DATE.label, "2020-01-22").load();
        Element eleDocCurrencyCode = new ElementT(doc.getDoc(), eleCreditNote, ElementsName.DOC_CURRENCY_CODE.label, "EUR").load();

        /*Element eleOrderReference = new ElementT(doc.getDoc(), eleCreditNote, ElementsName.ORDER_REFERENCE.label).load();
        Element eleOrderReference_id = new ElementT(doc.getDoc(), eleOrderReference, ElementsName.ID.label, "C180001053").load();*/

        Element eleOrderReference = new OrderReference(doc.getDoc(), eleCreditNote, "C180001053").load();

        List<InvoiceDocumentReference> invoiceDocumentReferenceList = new ArrayList<>();
        InvoiceDocumentReference invoiceDocumentReference = new InvoiceDocumentReference("038/0115616");
        invoiceDocumentReferenceList.add(invoiceDocumentReference);
        Element eleBillingReference = new BillingReference(doc.getDoc(), eleCreditNote, invoiceDocumentReferenceList).load();

        //ADDITIONAL DOCUMENT REFERENCE
        Element eleAdditionalDocumentReference1 = new AdditionalDocumentReference(doc.getDoc(), eleCreditNote, "1100000 EUR", "SenderShareCapital").load();
        List<Attachment> attachmentList = new ArrayList<>();
        Attachment attachment1 = new Attachment("avoir eiffage 1.pdf","application/pdf","JVBERi0xLjQKJeTjz9IKMyAwIG9iago8PC9U...");
        attachmentList.add(attachment1);
        Element eleAdditionalDocumentReference2 = new AdditionalDocumentReference(doc.getDoc(), eleCreditNote, "attachment-0", "attachment",attachmentList).load();
        Element eleAdditionalDocumentReference3 = new AdditionalDocumentReference(doc.getDoc(), eleCreditNote, "HALF_EVEN", "RoundingRule").load();

        /**
         * PARTY
         */
        //PARTY IDENTIFICATION
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

        //PARTY NAME
        List<PartyName> partyNameList = new ArrayList<>();
        PartyName partyName1 = new PartyName.PartyNameBuilder()
                .name("Groupe Sovitrat")
                .build();
        partyNameList.add(partyName1);

        //POSTAL ADDRESS
        List<Country> countryList = new ArrayList<>();
        Country country1 = new Country.CountryBuilder().identificationCode("FR").build();
        countryList.add(country1);
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

        //PARTY TAX SCHEME
        List<TaxScheme> taxSchemeList = new ArrayList<>();
        TaxScheme taxScheme1 = new TaxScheme.TaxSchemeBuilder()
                .name("VAT")
                .build();
        taxSchemeList.add(taxScheme1);

        List<PartyTaxScheme> partyTaxSchemeList = new ArrayList<>();
        PartyTaxScheme partyTaxScheme1 = new PartyTaxScheme.PartyTaxSchemeBuilder()
                .companyId("FR21314887126")
                .companyId_AttributeSchemeId("FR:VAT")
                .taxSchemeList(taxSchemeList)
                .build();
        partyTaxSchemeList.add(partyTaxScheme1);

        //PARTY LEGAL ENTITY
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

        List<CorporateRegistrationScheme> corporateRegistrationSchemeList = new ArrayList<>();
        CorporateRegistrationScheme corporateRegistrationScheme1 = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                .id("PUBLIC_LIMITED").build();
        corporateRegistrationSchemeList.add(corporateRegistrationScheme1);

        List<PartyLegalEntity> partyLegalEntityList = new ArrayList<>();
        PartyLegalEntity partyLegalEntity1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                .registrationName("Groupe SOVITRAT")
                .companyId("31488712600253")
                .companyId_AttributeSchemeId("FR:SIRET")
                .registrationAddressList(registrationAddressList)
                .corporateRegistrationSchemeList(corporateRegistrationSchemeList)
                .build();
        partyLegalEntityList.add(partyLegalEntity1);

        //CONTACT
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

        //PERSON
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person.PersonBuilder()
                .firstName("Amor")
                .familyName("BOUGHZALA")
                .build();
        personList.add(person1);

        List<Party> partyList = new ArrayList<>();
        Party elementParty = new Party.PartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(eleCreditNote)
                .partyIdentificationList(partyIdentificationList)
                .partyNameList(partyNameList)
                .postalAddressList(postalAddressList)
                .partyTaxSchemeList(partyTaxSchemeList)
                .partyLegalEntityList(partyLegalEntityList)
                .contactList(contactList)
                .personList(personList)
                .build();
        partyList.add(elementParty);

        Element elementAccountingSupplierParty = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(eleCreditNote)
                .partyList(partyList)
                .build().load();

        /**
         * TAX TOTAL
         */
        List<TaxScheme> taxSchemeListFromTaxTotal = new ArrayList<>();
        TaxScheme taxScheme10 = new TaxScheme.TaxSchemeBuilder()
                .id("VAT")
                .id_AttributeSchemeAgencyID("6")
                .id_AttributeSchemeID("UN/ECE 5153 Subset")
                .id_AttributeSchemeVersionID("D08B")
                .name("FR TVA 20%")
                .build();
        taxSchemeList.add(taxScheme10);

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

        List<TaxSubTotal> taxSubTotalListFromTaxTotal = new ArrayList<>();
        TaxSubTotal taxSubTotal1 = new TaxSubTotal.TaxSubTotalBuilder()
                .taxableAmount("245.74")
                .taxableAmount_AttributeCurrencyID("EUR")
                .taxAmount("49.15")
                .taxAmount_AttributeCurrencyID("EUR")
                .taxCategoryList(taxCategoryListFromTaxTotal)
                .build();
        taxSubTotalListFromTaxTotal.add(taxSubTotal1);

        Element elementTaxTotal = new TaxTotal.TaxTotalBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(eleCreditNote)
                .taxAmount("49.15")
                .taxAmount_AttributeCurrencyID("EUR")
                .taxSubTotalList(taxSubTotalListFromTaxTotal)
                .build().load();

        Element elementTest = new TaxCategory.TaxCategoryBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(eleCreditNote)
                .id("S")
                .id_AttributeSchemeAgencyID("6")
                .id_AttributeSchemeID("UN/ECE 5305")
                .id_AttributeSchemeVersionID("D08B")
                .percent("20")
                .taxSchemeList(taxSchemeListFromTaxTotal)
                .build()
                .load();

        /**
         * LEGAL MONETARY TOTAL
         */

        Element elementLegalMonetaryTotal = new LegalMonetaryTotal.LegalMonetaryTotalBuilder()
                .documentLinked(doc.getDoc())
                .elementFather(eleCreditNote)
                .lineExtensionAmount("245.74")
                .lineExtensionAmount_AttributeCurrencyID("EUR")
                .taxExclusiveAmount("49.15")
                .taxExclusiveAmount_AttributeCurrencyID("EUR")
                .taxInclusiveAmount("294.89")
                .taxInclusiveAmount_AttributeCurrencyID("EUR")
                .payableAmount("294.89")
                .payableAmount_AttributeCurrencyID("EUR")
                .build().load();

        /**
         * CREDIT NOTE LINE
         */

        //TAX TOTAL
        List<TaxScheme> taxSchemeListCNL = new ArrayList<>();
        TaxScheme taxSchemeCNL = new TaxScheme.TaxSchemeBuilder()
                .id("VAT")
                .id_AttributeSchemeAgencyID("6")
                .id_AttributeSchemeID("UN/ECE 5153 Subset")
                .id_AttributeSchemeVersionID("D08B")
                .build();
        taxSchemeListCNL.add(taxSchemeCNL);

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

        List<TaxTotal> taxTotalListCNL = new ArrayList<>();
        TaxTotal taxTotalCNL = new TaxTotal.TaxTotalBuilder()
                .taxAmount("21.85")
                .taxAmount_AttributeCurrencyID("EUR")
                .taxSubTotalList(taxSubTotalListCNL)
                .build();
        taxTotalListCNL.add(taxTotalCNL);

        //ITEM
        List<SellersItemIdentification> sellersItemIdentificationListCNL = new ArrayList<>();
        SellersItemIdentification sellersItemIdentificationCNL = new SellersItemIdentification.SellersItemIdentificationBuilder()
                .id("129")
                .build();
        sellersItemIdentificationListCNL.add(sellersItemIdentificationCNL);

        List<Item> itemListCNL = new ArrayList<>();
        Item itemCNL = new Item.ItemBuilder()
                .description("PRIME")
                .name("PRIME")
                .sellersItemIdentificationList(sellersItemIdentificationListCNL)
                .build();
        itemListCNL.add(itemCNL);

        //PRICE
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
                .elementFather(eleCreditNote)
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
    }
}
