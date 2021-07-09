package com.company;

import com.company.xml.ubl.attributes.*;
import com.company.xml.ubl.axioms.DocumentT;
import com.company.xml.ubl.elements.*;
import com.company.xml.ubl.modules.*;
import com.company.xml.ubl.templates.UBLCreditNote20;
import com.company.xml.ubl.templates.UBLInvoice20;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        /*Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post("https://api-sandbox.tradeshift.com/tradeshift/rest/external/documents/dispatcher?documentId=3ee5c990-67e1-422d-8935-40b12eca3ea5&documentProfileId=nes.p5.creditnote.ubl.2.1.dk")
                .header("Authorization", "OAuth oauth_consumer_key=\"OwnAccount\",oauth_token=\"RQsgfjsgXwnHFtvVU9%2B7enmXJDSA64\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1624892206\",oauth_nonce=\"P4koaCDUe3W\",oauth_version=\"1.0\",oauth_signature=\"JsFNtbIufy0GNv7ZHF6vl3Iw%2BJo%3D\"")
                .header("Content-Type", "application/xml")
                .body("<file contents here>")
                .asString();*/

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
        UBLVersionID ublVersionIDCreditNote = new UBLVersionID.UBLVersionIDBuilder()
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
                .value("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z3/2slMYC9Myj427AbxL1yd30P+FBD6+t4UZWaY+/mxJ8UusjzdVXHJW3Df4mLmdYfGCIy1TigUdgF9SFXhi48enl6vT6LOto6BTXF7HrO/IaFP7kAvKik8ZX5J89iHIQN8gJ+RzxAsXPqF8GJyY+/MyKyWTrQkl/p22Yh0Di4EXUMALpvCPhnP3jFjTQSsJgRi+fwBFTymhCTE031lqOioghs8/8AjF4+YythoqxcaDH9RxvA7iR6TLlFTLPP8JOjkJemtgU08Og478+Rn/z3QWeF2wvpMTkHtGzf7xOOrvNEzZfuiFPxXmz1/58PmzkGdULq+91vfQhT9I4O9tLPPKC388yR8FBW0eYJDzHej/AaYPtzYKZW5kc3RyZWFtCmVuZG9iagoxIDAgb2JqCjw8L1R5cGUgL1BhZ2VzCi9LaWRzIFszIDAgUiBdCi9Db3VudCAxCj4+CmVuZG9iago1IDAgb2JqCjw8L1R5cGUgL0ZvbnQKL05hbWUgL0YxCi9CYXNlRm9udCAvSGVsdmV0aWNhCi9TdWJ0eXBlIC9UeXBlMQovRW5jb2RpbmcgL1dpbkFuc2lFbmNvZGluZwo+PgplbmRvYmoKNiAwIG9iago8PC9UeXBlIC9Gb250Ci9OYW1lIC9GMgovQmFzZUZvbnQgL0hlbHZldGljYS1Cb2xkCi9TdWJ0eXBlIC9UeXBlMQovRW5jb2RpbmcgL1dpbkFuc2lFbmNvZGluZwo+PgplbmRvYmoKMiAwIG9iago8PC9Qcm9jU2V0IFsvUERGIC9UZXh0IC9JbWFnZUIgL0ltYWdlQyAvSW1hZ2VJXQovRm9udCA8PAovRjEgNSAwIFIKL0YyIDYgMCBSCj4+Cj4+CmVuZG9iago3IDAgb2JqCjw8Ci9Qcm9kdWNlciAoV2luRGV2IDE5LjAgKDE5LjAuNzYuMikpCi9DcmVhdGlvbkRhdGUgKEQ6MjAyMTA2MDExNDE1MTIpCj4+CmVuZG9iago4IDAgb2JqCjw8Ci9UeXBlIC9DYXRhbG9nCi9QYWdlcyAxIDAgUgovT3BlbkFjdGlvbiBbMyAwIFIgL0ZpdEggbnVsbF0KL1BhZ2VMYXlvdXQgL09uZUNvbHVtbgo+PgplbmRvYmoKeHJlZgowIDkKMDAwMDAwMDAwMCA2NTUzNSBmIAowMDAwMDAzODk2IDAwMDAwIG4gCjAwMDAwMDQxNzAgMDAwMDAgbiAKMDAwMDAwMDAxNSAwMDAwMCBuIAowMDAwMDAwMTUzIDAwMDAwIG4gCjAwMDAwMDM5NTMgMDAwMDAgbiAKMDAwMDAwNDA1OSAwMDAwMCBuIAowMDAwMDA0MjY4IDAwMDAwIG4gCjAwMDAwMDQzNTggMDAwMDAgbiAKdHJhaWxlcgo8PAovU2l6ZSA5Ci9Sb290IDggMCBSCi9JbmZvIDcgMCBSCi9JRFs8ZTE0YjE1YTZkOTFiYmJhZTAwY2E5OGMxOTM1MmY5NmM+PGUxNGIxNWE2ZDkxYmJiYWUwMGNhOThjMTkzNTJmOTZjPl0KPj4Kc3RhcnR4cmVmCjQ0NjEKJSVFT0YK")
                .attributes(new PatternFile.PatternFileBuilder()
                        .encodingCode("Base64")
                        .filename("avoir eiffage 1.pdf")
                        .mimeCode("application/pdf").build())
                .build();

        //ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT
        Attachment attachmentCreditNote1 = new Attachment.AttachmentBuilder()
                .embeddedDocumentBinaryObject(embeddedDocumentBinaryObjectCreditNote1)
                .build();

        //ADDITIONAL DOCUMENT REFERENCE
        List<AdditionalDocumentReference> additionalDocumentReferenceListCreditNote = new ArrayList<>();
        AdditionalDocumentReference additionalDocumentReferenceCreditNote1 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
                .id(new ID.IDBuilder()
                        .value("attachment")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .build())
                        .build())
                .documentTypeCode(new DocumentTypeCode.DocumentTypeCodeBuilder()
                        .value("attachment")
                        .attributes(new PatternList.PatternListBuilder()
                                .listID("urn:tradeshift.com:api:1.0:documenttypecode")
                                .build())
                        .build())
                .attachment(attachmentCreditNote1)
                .build();
        additionalDocumentReferenceListCreditNote.add(additionalDocumentReferenceCreditNote1);

        /**
         * Element AccountingSupplierParty
         */

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY IDENTIFICATION
        List<PartyIdentification> partyIdentificationListSupplierCreditNote = new ArrayList<>();
        PartyIdentification partyIdentification1SupplierCreditNote = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("FR21314887126")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT")
                                .build())
                        .build())
                .build();
        PartyIdentification partyIdentification2SupplierCreditNote = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("FR21314887126")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT")
                                .build())
                        .build())
                .build();
        partyIdentificationListSupplierCreditNote.add(partyIdentification1SupplierCreditNote);
        partyIdentificationListSupplierCreditNote.add(partyIdentification2SupplierCreditNote);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY NAME
        List<PartyName> partyNameListSupplierCreditNote = new ArrayList<>();
        PartyName partyNameSupplierCreditNote = new PartyName.PartyNameBuilder()
                .name(new Name.NameBuilder()
                        .value("Groupe SOVITRAT")
                        .build())
                .build();
        partyNameListSupplierCreditNote.add(partyNameSupplierCreditNote);

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
        Country countrySupplierCreditNote = new Country.CountryBuilder()
                .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                        .value("FR")
                        .build())
                .name(new Name.NameBuilder()
                        .value("LALA")
                        .build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > POSTAL ADDRESS
        PostalAddress postalAddressSupplierCreditNote = new PostalAddress.PostalAddressBuilder()
                .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                        .value("5")
                        .attributes(new PatternList.PatternListBuilder()
                                .listAgencyID("6")
                                .listID("UN/ECE 3477")
                                .listVersionID("D08B")
                                .build())
                        .build())
                .postbox(new Postbox.PostboxBuilder()
                        .value("69006")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .streetName(new StreetName.StreetNameBuilder()
                        .value("4 RUE DUGUESCLIN")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .buildingNumber(new BuildingNumber.BuildingNumberBuilder()
                        .value("")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .cityName(new CityName.CityNameBuilder()
                        .value("LYON")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .postalZone(new PostalZone.PostalZoneBuilder()
                        .value("69006")
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .build())
                        .build())
                .country(countrySupplierCreditNote)
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME > TAX SCHEME
        TaxScheme taxSchemeSupplierCreditNote = new TaxScheme.TaxSchemeBuilder()
                .id(new ID.IDBuilder()
                        .value("S")
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

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY TAX SCHEME
        List<PartyTaxScheme> partyTaxSchemeListSupplierCreditNote = new ArrayList<>();
        PartyTaxScheme partyTaxSchemeSupplierCreditNote = new PartyTaxScheme.PartyTaxSchemeBuilder()
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("FR21314887126")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT")
                                .build())
                        .build())
                .taxScheme(taxSchemeSupplierCreditNote)
                .build();
        partyTaxSchemeListSupplierCreditNote.add(partyTaxSchemeSupplierCreditNote);

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > REGISTRATION ADDRESS
        RegistrationAddress registrationAddressSupplierCreditNote = new RegistrationAddress.RegistrationAddressBuilder()
                .id(new ID.IDBuilder()
                        .value("LYON")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:RCS")
                                .build())
                        .build())
                .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                        .value("5")
                        .attributes(new PatternList.PatternListBuilder()
                                .listAgencyID("6")
                                .listID("UN/ECE 3477")
                                .build())
                        .build())
                .postBox(new Postbox.PostboxBuilder()
                        .value("69006")
                        .build())
                .streetName(new StreetName.StreetNameBuilder()
                        .value("4 RUE DUGUESCLIN")
                        .build())
                .buildingNumber(new BuildingNumber.BuildingNumberBuilder()
                        .value("NOVALI")
                        .build())
                .cityName(new CityName.CityNameBuilder()
                        .value("LYON")
                        .build())
                .postalZone(new PostalZone.PostalZoneBuilder()
                        .value("69006")
                        .build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY > CORPORATE REGISTRATION SCHEME
        CorporateRegistrationScheme corporateRegistrationSchemeSupplierCreditNote = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                .id(new ID.IDBuilder().value("PUBLIC_LIMITED").build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PARTY LEGAL ENTITY
        List<PartyLegalEntity> partyLegalEntityListSupplierCreditNote = new ArrayList<>();
        PartyLegalEntity partyLegalEntitySupplierCreditNote = new PartyLegalEntity.PartyLegalEntityBuilder()
                .registrationName(new RegistrationName.RegistrationNameBuilder()
                        .value("Groupe SOVITRAT")
                        .build())
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("31488712600253_")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:SIRET")
                                .build())
                        .build())
                .registrationAddress(registrationAddressSupplierCreditNote)
                .corporateRegistrationScheme(corporateRegistrationSchemeSupplierCreditNote)
                .build();
        partyLegalEntityListSupplierCreditNote.add(partyLegalEntitySupplierCreditNote);

        //ACCOUNTING SUPPLIER PARTY > PARTY > CONTACT
        Contact contactSupplierCreditNote = new Contact.ContactBuilder()
                .id(new ID.IDBuilder()
                        .value("5a59bb3c-adf8-4b72-b45b-f4f2f33676f1")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeURI("http://tradeshift.com/api/1.0/userId")
                                .build())
                        .build())
                .name(new Name.NameBuilder().value("Amor BOUGHZALA").build())
                .telephone(new Telephone.TelephoneBuilder().value("0472699760").build())
                .electronicMail(new ElectronicMail.ElectronicMailBuilder().value("master@sovitrat.fr").build())
                .note(new Note.NoteBuilder().value("Groupe SOVITRAT PUBLIC_LIMITED with share capi").build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY > PERSON
        Person personSupplierCreditNote = new Person.PersonBuilder()
                .firstName(new FirstName.FirstNameBuilder().value("Amor").build())
                .familyName(new FamilyName.FamilyNameBuilder().value("BOUGHZALA").build())
                .build();

        //ACCOUNTING SUPPLIER PARTY > PARTY
        Party elementSupplierCreditNote = new Party.PartyBuilder()
                .partyIdentificationList(partyIdentificationListSupplierCreditNote)
                .partyNameList(partyNameListSupplierCreditNote)
                .postalAddress(postalAddressSupplierCreditNote)
                .partyTaxSchemeList(partyTaxSchemeListSupplierCreditNote)
                .partyLegalEntityList(partyLegalEntityListSupplierCreditNote)
                .contact(contactSupplierCreditNote)
                .person(personSupplierCreditNote)
                .build();

        //ACCOUNTING SUPPLIER PARTY
        AccountingSupplierParty elementAccountingSupplierCreditNote = new AccountingSupplierParty.AccountingSupplierPartyBuilder()
                .party(elementSupplierCreditNote)
                .build();

        /**
         * Element AccountingCustomerParty
         */

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY IDENTIFICATION
        List<PartyIdentification> partyIdentificationListCreditNote = new ArrayList<>();
        PartyIdentification partyIdentificationCreditNote1 = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("FR21314887126")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT")
                                .build())
                        .build())
                .build();
        PartyIdentification partyIdentificationCreditNote2 = new PartyIdentification.PartyIdentificationBuilder()
                .id(new ID.IDBuilder()
                        .value("31488712600253")
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
                        .value("Groupe SOVITRAT")
                        .build())
                .build();
        partyNameListCreditNote.add(partyNameCreditNote1);

        //ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS > COUNTRY
        Country countryCreditNote1 = new Country.CountryBuilder()
                .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                        .value("FR")
                        .build())
                .name(new Name.NameBuilder()
                        .value("LALA")
                        .build())
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY > POSTAL ADDRESS
        PostalAddress postalAddressCreditNote1 = new PostalAddress.PostalAddressBuilder()
                .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                        .value("5")
                        .attributes(new PatternList.PatternListBuilder()
                                .listAgencyID("6")
                                .listID("UN/ECE 3477")
                                .listVersionID("D08B")
                                .build())
                        .build())
                .postbox(new Postbox.PostboxBuilder()
                        .value("69006")
                        .build())
                .streetName(new StreetName.StreetNameBuilder()
                        .value("4 RUE DUGUESCLIN")
                        .build())
                .buildingNumber(new BuildingNumber.BuildingNumberBuilder()
                        .value("")
                        .build())
                .cityName(new CityName.CityNameBuilder()
                        .value("LYON")
                        .build())
                .postalZone(new PostalZone.PostalZoneBuilder()
                        .value("69006")
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
                        .value("FR21314887126")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:VAT")
                                .build())
                        .build())
                .taxScheme(taxSchemeCreditNote1)
                .build();
        partyTaxSchemeListCreditNote.add(partyTaxSchemeCreditNote1);

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY LEGAL ENTITY > REGISTRATION ADDRESS
        RegistrationAddress registrationAddressCreditNote1 = new RegistrationAddress.RegistrationAddressBuilder()
                .id(new ID.IDBuilder()
                        .value("LYON")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:RCS")
                                .build())
                        .build())
                .addressFormatCode(new AddressFormatCode.AddressFormatCodeBuilder()
                        .value("5")
                        .attributes(new PatternList.PatternListBuilder()
                                .listAgencyID("6")
                                .listID("UN/ECE 3477")
                                .build())
                        .build())
                .postBox(new Postbox.PostboxBuilder()
                        .value("69006")
                        .build())
                .streetName(new StreetName.StreetNameBuilder()
                        .value("4 RUE DUGUESCLIN")
                        .build())
                .buildingNumber(new BuildingNumber.BuildingNumberBuilder()
                        .value("NOVALI")
                        .build())
                .cityName(new CityName.CityNameBuilder()
                        .value("LYON")
                        .build())
                .postalZone(new PostalZone.PostalZoneBuilder()
                        .value("69006")
                        .build())
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY LEGAL ENTITY > CORPORATE REGISTRATION SCHEME
        CorporateRegistrationScheme corporateRegistrationSchemeCreditNote1 = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                .id(new ID.IDBuilder()
                        .value("PUBLIC_LIMITED")
                        .build())
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY > PARTY LEGAL ENTITY
        List<PartyLegalEntity> partyLegalEntityListCreditNote = new ArrayList<>();
        PartyLegalEntity partyLegalEntityCreditNote1 = new PartyLegalEntity.PartyLegalEntityBuilder()
                .registrationName(new RegistrationName.RegistrationNameBuilder()
                        .value("Groupe SOVITRAT")
                        .build())
                .companyId(new CompanyID.CompanyIDBuilder()
                        .value("31488712600253")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID("FR:SIRET")
                                .build())
                        .build())
                .registrationAddress(registrationAddressCreditNote1)
                .corporateRegistrationScheme(corporateRegistrationSchemeCreditNote1)
                .build();
        partyLegalEntityListCreditNote.add(partyLegalEntityCreditNote1);

        //ACCOUNTING CUSTOMER PARTY > PARTY > CONTACT
        Contact contactCreditNote1 = new Contact.ContactBuilder()
                .id(new ID.IDBuilder()
                        .value("5a59bb3c-adf8-4b72-b45b-f4f2f33676f1")
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeURI("http://tradeshift.com/api/1.0/userId")
                                .build())
                        .build())
                .name(new Name.NameBuilder()
                        .value("Amor BOUGHZALA")
                        .build())
                .telephone(new Telephone.TelephoneBuilder()
                        .value("0472699760")
                        .build())
                .electronicMail(new ElectronicMail.ElectronicMailBuilder()
                        .value("master@sovitrat.fr")
                        .build())
                .note(new Note.NoteBuilder()
                        .value("Groupe SOVITRAT PUBLIC_LIMITED with share capi")
                        .build())
                .build();

        //ACCOUNTING CUSTOMER PARTY > PARTY > PERSON
        Person personCreditNote1 = new Person.PersonBuilder()
                .firstName(new FirstName.FirstNameBuilder()
                        .value("Amor")
                        .build())
                .familyName(new FamilyName.FamilyNameBuilder()
                        .value("BOUGHZALA")
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

        //TAX TOTAL > TAX SUB TOTAL > TAX CATEGORY
        TaxCategory taxCategoryCreditNote1 = new TaxCategory.TaxCategoryBuilder()
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
                .taxScheme(taxSchemeCreditNote2)
                .build();

        //TAX TOTAL > TAX SUB TOTAL
        List<TaxSubTotal> taxSubTotalListCreditNote1 = new ArrayList<>();
        TaxSubTotal taxSubTotalCreditNote1 = new TaxSubTotal.TaxSubTotalBuilder()
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
                .calculationSequenceNumeric(new CalculationSequenceNumeric.CalculationSequenceNumericBuilder().value("1").build())
                .taxCategory(taxCategoryCreditNote1)
                .build();
        taxSubTotalListCreditNote1.add(taxSubTotalCreditNote1);

        //TAX TOTAL
        List<TaxTotal> taxTotalListCreditNote = new ArrayList<>();
        TaxTotal taxTotalCreditNote1 = new TaxTotal.TaxTotalBuilder()
                .taxAmount(new TaxAmount.TaxAmountBuilder()
                        .value("21.85")
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID("EUR")
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
                .accountingSupplierParty(elementAccountingSupplierCreditNote)
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
        UBLVersionID invoiceUBLVersionID = new UBLVersionID.UBLVersionIDBuilder()
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
