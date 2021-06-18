package com.company.xml.ubl.data;

public enum AttributesName {
    PROFIL_ID_SCHEMA_AGENCY_ID("schemeAgencyID"),
    PROFIL_ID_SCHEMA_ID("schemeID"),
    PROFIL_ID_SCHEMA_VERSION_ID("schemeVersionID"),
    DOCUMENT_TYPE_CODE_LIST_ID("listID"),
    EMBEDDED_DOCUMENT_BINARY_OBJECT_ENCODING_CODE("encodingCode"),
    EMBEDDED_DOCUMENT_BINARY_OBJECT_FILE_NAME("filename"),
    EMBEDDED_DOCUMENT_BINARY_OBJECT_MIME_CODE("mimeCode"),
    PARTY_IDENTIFICATION_SCHEME_ID("schemeID"),
    PARTY_IDENTIFICATION_SCHEME_NAME("schemeName"),
    COMPANY_ID_SCHEME_ID("schemeID"),
    PARTY_LEGAL_ENTITY_COMPANYID_ATTR_SCHEME_ID("schemeID"),
    REGISTRATION_ADDRESS_ID_ATTR_SCHEME_ID("schemeID"),
    REGISTRATION_ADDRESS_ADDRESSFORMATCODE_ATTR_LIST_AGENCY_ID("listAgencyID"),
    REGISTRATION_ADDRESS_ADDRESSFORMATCODE_ATTR_LIST_ID("listID"),
    CONTACT_ID_SCHEME_URI("schemeURI"),
    SCHEME_AGENCY_ID("schemeAgencyID"),
    SCHEME_AGENCY_NAME("schemeAgencyName"),
    SCHEME_DATA_URI("schemeDataURI"),
    SCHEME_ID("schemeID"),
    SCHEME_VERSION_ID("schemeVersionID"),
    SCHEME_NAME("schemeName"),
    SCHEME_URI("schemeURI"),
    CURRENCY_ID("currencyID"),
    UNIT_CODE("unitCode"),
    LIST_ID("listID"),
    LIST_AGENCY_ID("listAgencyID"),
    LIST_AGENCY_NAME("listAgencyName"),
    LIST_NAME("listName"),
    LIST_VERSION_ID("listVersionID"),
    LIST_URI("listURI"),
    LIST_SCHEME_URI("listSchemeURI"),
    NAME("name"),
    ENCODING_CODE("encodingCode"),
    FILE_NAME("filename"),
    LANGUAGE_ID("languageID"),
    MIME_CODE("mimeCode");

    public final String label;

    private AttributesName(String label) {
        this.label = label;
    }
}
