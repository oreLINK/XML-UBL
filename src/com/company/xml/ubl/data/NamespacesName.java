package com.company.xml.ubl.data;

public enum NamespacesName {
    XMLNS("xmlns"),
    CAC("cac"),
    CBC("cbc"),
    CCTS("ccts"),
    EXT("ext"),
    NS7("ns7"),
    SDT("sdt"),
    UDT("udt"),
    /* \/ NON MODIFIABLE \/ */
    XMLNS_CAC_ATTR(XMLNS.label+":"+CAC.label),
    XMLNS_CBC_ATTR(XMLNS.label+":"+CBC.label),
    XMLNS_CCTS_ATTR(XMLNS.label+":"+CCTS.label),
    XMLNS_EXT_ATTR(XMLNS.label+":"+EXT.label),
    XMLNS_NS7_ATTR(XMLNS.label+":"+NS7.label),
    XMLNS_SDT_ATTR(XMLNS.label+":"+SDT.label),
    XMLNS_UDT_ATTR(XMLNS.label+":"+UDT.label),
    XMLNS_IMPORT("urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2"),
    XMLNS_CAC_IMPORT("urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2"),
    XMLNS_CBC_IMPORT("urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2"),
    XMLNS_CCTS_IMPORT("urn:oasis:names:specification:ubl:schema:xsd:CoreComponentParameters-2"),
    XMLNS_EXT_IMPORT("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2"),
    XMLNS_NS7_IMPORT("urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2"),
    XMLNS_SDT_IMPORT("urn:oasis:names:specification:ubl:schema:xsd:SpecializedDatatypes-2"),
    XMLNS_UDT_IMPORT("urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2"),
    CAC_NAMESPACE(CAC.label+":"),
    CBC_NAMESPACE(CBC.label+":"),
    CCTS_NAMESPACE(CCTS.label+":"),
    EXT_NAMESPACE(EXT.label+":"),
    NS7_NAMESPACE(NS7.label+":"),
    SDT_NAMESPACE(SDT.label+":"),
    UDT_NAMESPACE(UDT.label+":");

    public final String label;

    private NamespacesName(String label) {
        this.label = label;
    }
}
