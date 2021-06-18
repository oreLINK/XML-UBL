package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class PartyIdentification
 */
public class PartyIdentification {

    private Document doc;
    private Element element;
    private String id;
    private String id_AttributeSchemeID;
    private String id_AttributeSchemeName;

    /**
     * <h2>Element "PartyIdentification"</h2>
     * <i>use in Party <b>[0..*]</b>.</i>
     * <p>An association to Party Identification. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>id</b> <b>[1..1]</b> : Identifies a party.</li>
     *         <li>[String] <b>id_AttributeSchemeID</b> <b>[0..1]</b> : The identification of the identification scheme. (Attribute)</li>
     *         <li>[String] <b>id_AttributeSchemeName</b> <b>[0..1]</b> : The name of the identification scheme. (Attribute)</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PartyIdentification(PartyIdentificationBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.id_AttributeSchemeID = builder.id_AttributeSchemeID;
        this.id_AttributeSchemeName = builder.id_AttributeSchemeName;
    }

    /**
     * Builder PartyIdentification
     */
    public static class PartyIdentificationBuilder {

        private Document doc;
        private Element element;
        private String id;
        private String id_AttributeSchemeID;
        private String id_AttributeSchemeName;

        public PartyIdentificationBuilder() {}

        public PartyIdentificationBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PartyIdentificationBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyIdentificationBuilder id(String id){
            this.id = id;
            return this;
        }
        public PartyIdentificationBuilder id_AttributeSchemeID(String id_AttributeSchemeID){
            this.id_AttributeSchemeID = id_AttributeSchemeID;
            return this;
        }
        public PartyIdentificationBuilder id_AttributeSchemeName(String id_AttributeSchemeName){
            this.id_AttributeSchemeName = id_AttributeSchemeName;
            return this;
        }
        public PartyIdentification build(){
            PartyIdentification partyIdentification = new PartyIdentification(this);
            return partyIdentification;
        }

    }

    public String getId_AttributeSchemeID() {
        return id_AttributeSchemeID;
    }

    public String getId_AttributeSchemeName() {
        return id_AttributeSchemeName;
    }

    public String getId() {
        return id;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementPartyIdentification = new ElementT(doc, element, ElementsName.PARTY_IDENTIFICATION.label).load();
        if(!Tips.stringIsNull(id)) {
            Element elementID = new ElementT(doc, elementPartyIdentification, ElementsName.PARTY_IDENTIFICATION_ID.label, id).load();
            if(!Tips.stringIsNull(id_AttributeSchemeID)){
                Attr elementID_Attr1 = new AttributeT(doc, elementID, AttributesName.PARTY_IDENTIFICATION_SCHEME_ID.label, id_AttributeSchemeID).load();
            }
            if(!Tips.stringIsNull(id_AttributeSchemeName)){
                Attr elementID_Attr2 = new AttributeT(doc, elementID, AttributesName.PARTY_IDENTIFICATION_SCHEME_NAME.label, id_AttributeSchemeName).load();
            }
        }
        return elementPartyIdentification;

    }
}
