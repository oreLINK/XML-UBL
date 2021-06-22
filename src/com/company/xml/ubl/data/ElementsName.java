package com.company.xml.ubl.data;

/**
 * Class enum ElementsName
 * Here are stored all the names of the different elements to avoid duplication errors
 */
public enum ElementsName {
    CREDIT_NOTE("CreditNote"),
    UBL_VERSION_ID(NamespacesName.CBC_NAMESPACE.label+"UBLVersionID"),
    CUSTOMIZATION_ID(NamespacesName.CBC_NAMESPACE.label+"CustomizationID"),
    PROFILE_ID(NamespacesName.CBC_NAMESPACE.label+"ProfileID"),
    ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    NAME(NamespacesName.CBC_NAMESPACE.label+"Name"),
    ISSUE_DATE(NamespacesName.CBC_NAMESPACE.label+"IssueDate"),
    DOC_CURRENCY_CODE(NamespacesName.CBC_NAMESPACE.label+"DocumentCurrencyCode"),
    ORDER_REFERENCE(NamespacesName.CAC_NAMESPACE.label+"OrderReference"),
    BILLING_REFERENCE(NamespacesName.CAC_NAMESPACE.label+"BillingReference"),
    INVOICE_DOCUMENT_REFERENCE(NamespacesName.CAC_NAMESPACE.label+"InvoiceDocumentReference"),
    INVOICE_DOCUMENT_REFERENCE_ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    ADDITIONAL_DOCUMENT_REFERENCE(NamespacesName.CAC_NAMESPACE.label+"AdditionalDocumentReference"),
    ADDITIONAL_DOCUMENT_REFERENCE_DOCUMENT_TYPE_CODE(NamespacesName.CBC_NAMESPACE.label+"DocumentTypeCode"),
    ATTACHMENT(NamespacesName.CAC_NAMESPACE.label+"Attachment"),
    ATTACHMENT_EMBEDDED_DOCUMENT_BINARY_OBJECT(NamespacesName.CBC_NAMESPACE.label+"EmbeddedDocumentBinaryObject"),
    ACCOUNTING_SUPPLIER_PARTY(NamespacesName.CAC_NAMESPACE.label+"AccountingSupplierParty"),
    PARTY(NamespacesName.CAC_NAMESPACE.label+"Party"),
    PARTY_IDENTIFICATION(NamespacesName.CAC_NAMESPACE.label+"PartyIdentification"),
    PARTY_IDENTIFICATION_ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    PARTY_NAME(NamespacesName.CAC_NAMESPACE.label+"PartyName"),
    PARTY_NAME_NAME(NamespacesName.CBC_NAMESPACE.label+"Name"),
    POSTAL_ADDRESS(NamespacesName.CAC_NAMESPACE.label+"PostalAddress"),
    POSTAL_ADDRESS_ADDRESS_FORMAT_CODE(NamespacesName.CBC_NAMESPACE.label+"AddressFormatCode"),
    POSTAL_ADDRESS_POSTBOX(NamespacesName.CBC_NAMESPACE.label+"Postbox"),
    POSTAL_ADDRESS_STREET_NAME(NamespacesName.CBC_NAMESPACE.label+"StreetName"),
    POSTAL_ADDRESS_BUILDING_NUMBER(NamespacesName.CBC_NAMESPACE.label+"BuildingNumber"),
    POSTAL_ADDRESS_CITY_NAME(NamespacesName.CBC_NAMESPACE.label+"CityName"),
    POSTAL_ADDRESS_POSTAL_ZONE(NamespacesName.CBC_NAMESPACE.label+"PostalZone"),
    POSTAL_ADDRESS_COUNTRY(NamespacesName.CAC_NAMESPACE.label+"Country"),
    POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE(NamespacesName.CBC_NAMESPACE.label+"IdentificationCode"),
    PARTY_TAX_SCHEME(NamespacesName.CAC_NAMESPACE.label+"PartyTaxScheme"),
    PARTY_TAX_SCHEME_COMPANY_ID(NamespacesName.CBC_NAMESPACE.label+"CompanyID"),
    TAX_SCHEME(NamespacesName.CAC_NAMESPACE.label+"TaxScheme"),
    TAX_SCHEME_ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    TAX_SCHEME_NAME(NamespacesName.CBC_NAMESPACE.label+"Name"),
    PARTY_LEGAL_ENTITY(NamespacesName.CAC_NAMESPACE.label+"PartyLegalEntity"),
    PARTY_LEGAL_ENTITY_REGISTRATION_NAME(NamespacesName.CBC_NAMESPACE.label+"RegistrationName"),
    PARTY_LEGAL_ENTITY_COMPANY_ID(NamespacesName.CBC_NAMESPACE.label+"CompanyID"),
    REGISTRATION_ADDRESS(NamespacesName.CAC_NAMESPACE.label+"RegistrationAddress"),
    REGISTRATION_ADDRESS_ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    REGISTRATION_ADDRESS_ADDRESS_FORMAT_CODE(NamespacesName.CBC_NAMESPACE.label+"AddressFormatCode"),
    REGISTRATION_ADDRESS_POSTBOX(NamespacesName.CBC_NAMESPACE.label+"Postbox"),
    REGISTRATION_ADDRESS_STREET_NAME(NamespacesName.CBC_NAMESPACE.label+"StreetName"),
    REGISTRATION_ADDRESS_BUILDING_NUMBER(NamespacesName.CBC_NAMESPACE.label+"BuildingNumber"),
    REGISTRATION_ADDRESS_CITY_NAME(NamespacesName.CBC_NAMESPACE.label+"CityName"),
    REGISTRATION_ADDRESS_POSTAL_ZONE(NamespacesName.CBC_NAMESPACE.label+"PostalZone"),
    CORPORATE_REGISTRATION_SCHEME(NamespacesName.CAC_NAMESPACE.label+"CorporateRegistrationScheme"),
    CORPORATE_REGISTRATION_SCHEME_ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    CONTACT(NamespacesName.CAC_NAMESPACE.label+"Contact"),
    CONTACT_ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    CONTACT_NAME(NamespacesName.CBC_NAMESPACE.label+"Name"),
    CONTACT_TELEPHONE(NamespacesName.CBC_NAMESPACE.label+"Telephone"),
    CONTACT_ELECTRONIC_MAIL(NamespacesName.CBC_NAMESPACE.label+"ElectronicMail"),
    CONTACT_NOTE(NamespacesName.CBC_NAMESPACE.label+"Note"),
    PERSON(NamespacesName.CAC_NAMESPACE.label+"Person"),
    PERSON_FIRST_NAME(NamespacesName.CBC_NAMESPACE.label+"FirstName"),
    PERSON_FAMILY_NAME(NamespacesName.CBC_NAMESPACE.label+"FamilyName"),
    TAX_CATEGORY(NamespacesName.CAC_NAMESPACE.label+"TaxCategory"),
    TAX_CATEGORY_ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    TAX_CATEGORY_PERCENT(NamespacesName.CBC_NAMESPACE.label+"Percent"),
    TAX_SUB_TOTAL(NamespacesName.CAC_NAMESPACE.label+"TaxSubtotal"),
    TAX_SUB_TOTAL_TAXABLE_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"TaxableAmount"),
    TAX_SUB_TOTAL_TAX_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"TaxAmount"),
    TAX_SUB_TOTAL_CALCULATION_SEQUENCE_NUMERIC(NamespacesName.CBC_NAMESPACE.label+"CalculationSequenceNumeric"),
    TAX_TOTAL(NamespacesName.CAC_NAMESPACE.label+"TaxTotal"),
    TAX_TOTAL_TAX_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"TaxAmount"),
    LEGAL_MONETARY_TOTAL(NamespacesName.CAC_NAMESPACE.label+"LegalMonetaryTotal"),
    LEGAL_MONETARY_TOTAL_LINE_EXTENSION_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"LineExtensionAmount"),
    LEGAL_MONETARY_TOTAL_TAX_EXCLUSIVE_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"TaxExclusiveAmount"),
    LEGAL_MONETARY_TOTAL_TAX_INCLUSIVE_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"TaxInclusiveAmount"),
    LEGAL_MONETARY_TOTAL_PAYABLE_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"PayableAmount"),
    CREDIT_NOTE_LINE(NamespacesName.CAC_NAMESPACE.label+"CreditNoteLine"),
    CREDIT_NOTE_LINE_ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    CREDIT_NOTE_LINE_CREDITED_QUANTITY(NamespacesName.CBC_NAMESPACE.label+"CreditedQuantity"),
    CREDIT_NOTE_LINE_LINE_EXTENSION_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"LineExtensionAmount"),
    SELLERS_ITEM_IDENTIFICATION(NamespacesName.CAC_NAMESPACE.label+"SellersItemIdentification"),
    SELLERS_ITEM_IDENTIFICATION_ID(NamespacesName.CBC_NAMESPACE.label+"ID"),
    ITEM(NamespacesName.CAC_NAMESPACE.label+"Item"),
    ITEM_DESCRIPTION(NamespacesName.CBC_NAMESPACE.label+"Description"),
    ITEM_NAME(NamespacesName.CBC_NAMESPACE.label+"Name"),
    PRICE(NamespacesName.CAC_NAMESPACE.label+"Price"),
    PRICE_PRICE_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"PriceAmount"),
    PRICE_BASE_QUANTITY(NamespacesName.CBC_NAMESPACE.label+"BaseQuantity"),
    PRICE_ORDERABLE_UNIT_FACTOR_RATE(NamespacesName.CBC_NAMESPACE.label+"OrderableUnitFactorRate"),
    INVOICE("Invoice"),
    INVOICE_TYPE_CODE(NamespacesName.CBC_NAMESPACE.label+"InvoiceTypeCode"),
    PAYMENT_MEANS_CODE(NamespacesName.CBC_NAMESPACE.label+"PaymentMeansCode"),
    PAYMENT_DUE_DATE(NamespacesName.CBC_NAMESPACE.label+"PaymentDueDate"),
    PAYMENT_CHANNEL_CODE(NamespacesName.CBC_NAMESPACE.label+"PaymentChannelCode"),
    FINANCIAL_INSTITUTION(NamespacesName.CAC_NAMESPACE.label+"FinancialInstitution"),
    FINANCIAL_INSTITUTION_BRANCH(NamespacesName.CAC_NAMESPACE.label+"FinancialInstitutionBranch"),
    PAYEE_FINANCIAL_ACCOUNT(NamespacesName.CAC_NAMESPACE.label+"PayeeFinancialAccount"),
    PAYMENT_MEANS(NamespacesName.CAC_NAMESPACE.label+"PaymentMeans"),
    LINE_EXTENSION_AMOUNT(NamespacesName.CBC_NAMESPACE.label+"LineExtensionAmount"),
    INVOICED_QUANTITY(NamespacesName.CBC_NAMESPACE.label+"InvoicedQuantity"),
    INVOICE_LINE(NamespacesName.CAC_NAMESPACE.label+"InvoiceLine");

    public final String label;

    private ElementsName(String label) {
        this.label = label;
    }
}
