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
 * Class RegistrationAddress
 */
public class RegistrationAddress {

    private Document doc;
    private Element element;
    private String id;
    private String id_AttributeSchemeId;
    private String addressFormatCode;
    private String addressFormatCode_AttributeListAgencyId;
    private String addressFormatCode_AttributeListId;
    private String postBox;
    private String streetName;
    private String buildingNumber;
    private String cityName;
    private String postalZone;

    /**
     * <h2>Element "RegistrationAddress"</h2>
     * <i>use in PartyLegalEntity <b>[0..1]</b>.</i>
     * <p>Associates with the registered address of the party within a Corporate Registration Scheme. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>id</b> <b>[0..1]</b> : An identifier for a specific address within a scheme of registered addresses.</li>
     *         <li>[String] <b>id_AttributeSchemeId</b> <b>[0..1]</b> : The identification of the identification scheme. (Attribute)</li>
     *         <li>[String] <b>addressFormatCode</b> <b>[0..1]</b> : A code specifying the format of this address.</li>
     *         <li>[String] <b>addressFormatCode_AttributeListAgencyId</b> <b>[0..1]</b> : An agency that maintains one or more lists of codes. (Attribute)</li>
     *         <li>[String] <b>addressFormatCode_AttributeListId</b> <b>[0..1]</b> : The identification of a list of codes. (Attribute)</li>
     *         <li>[String] <b>postBox</b> <b>[0..1]</b> : A post office box number.</li>
     *         <li>[String] <b>streetName</b> <b>[0..1]</b> : The name of a street.</li>
     *         <li>[String] <b>buildingNumber</b> <b>[0..1]</b> : The number of a building.</li>
     *         <li>[String] <b>cityName</b> <b>[0..1]</b> : The name of a city, town, or village.</li>
     *         <li>[String] <b>postalZone</b> <b>[0..1]</b> : The identifier for an addressable group of properties according to the relevant national postal service, such as a ZIP code or Post Code.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private RegistrationAddress(RegistrationAddressBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.id_AttributeSchemeId = builder.id_AttributeSchemeId;
        this.addressFormatCode = builder.addressFormatCode;
        this.addressFormatCode_AttributeListAgencyId = builder.addressFormatCode_AttributeListAgencyId;
        this.addressFormatCode_AttributeListId = builder.addressFormatCode_AttributeListId;
        this.postBox = builder.postBox;
        this.streetName = builder.streetName;
        this.buildingNumber = builder.buildingNumber;
        this.cityName = builder.cityName;
        this.postalZone = builder.postalZone;
    }

    /**
     * Builder RegistrationAddress
     */
    public static class RegistrationAddressBuilder {

        private Document doc;
        private Element element;
        private String id;
        private String id_AttributeSchemeId;
        private String addressFormatCode;
        private String addressFormatCode_AttributeListAgencyId;
        private String addressFormatCode_AttributeListId;
        private String postBox;
        private String streetName;
        private String buildingNumber;
        private String cityName;
        private String postalZone;

        public RegistrationAddressBuilder(){}

        public RegistrationAddressBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public RegistrationAddressBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public RegistrationAddressBuilder id(String id){
            this.id = id;
            return this;
        }
        public RegistrationAddressBuilder id_AttributeSchemeId(String id_AttributeSchemeId){
            this.id_AttributeSchemeId = id_AttributeSchemeId;
            return this;
        }
        public RegistrationAddressBuilder addressFormatCode(String addressFormatCode){
            this.addressFormatCode = addressFormatCode;
            return this;
        }
        public RegistrationAddressBuilder addressFormatCode_AttributeListAgencyId(String addressFormatCode_AttributeListAgencyId){
            this.addressFormatCode_AttributeListAgencyId = addressFormatCode_AttributeListAgencyId;
            return this;
        }
        public RegistrationAddressBuilder addressFormatCode_AttributeListId(String addressFormatCode_AttributeListId){
            this.addressFormatCode_AttributeListId = addressFormatCode_AttributeListId;
            return this;
        }
        public RegistrationAddressBuilder postBox(String postBox){
            this.postBox = postBox;
            return this;
        }
        public RegistrationAddressBuilder streetName(String streetName){
            this.streetName = streetName;
            return this;
        }
        public RegistrationAddressBuilder buildingNumber(String buildingNumber){
            this.buildingNumber = buildingNumber;
            return this;
        }
        public RegistrationAddressBuilder cityName(String cityName){
            this.cityName = cityName;
            return this;
        }
        public RegistrationAddressBuilder postalZone(String postalZone){
            this.postalZone = postalZone;
            return this;
        }
        public RegistrationAddress build(){
            RegistrationAddress registrationAddress = new RegistrationAddress(this);
            return registrationAddress;
        }

    }

    public String getId() {
        return id;
    }

    public String getId_AttributeSchemeId() {
        return id_AttributeSchemeId;
    }

    public String getAddressFormatCode() {
        return addressFormatCode;
    }

    public String getAddressFormatCode_AttributeListAgencyId() {
        return addressFormatCode_AttributeListAgencyId;
    }

    public String getAddressFormatCode_AttributeListId() {
        return addressFormatCode_AttributeListId;
    }

    public String getPostBox() {
        return postBox;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public String getPostalZone() {
        return postalZone;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        //Generate root element
        Element elementRegistrationAddress = new ElementT(doc, element, ElementsName.REGISTRATION_ADDRESS.label).load();

        //Generate tag "ID" and attribute "schemeID"
        if(!Tips.stringIsNull(id)){
            Element elementId = new ElementT(doc, elementRegistrationAddress, ElementsName.REGISTRATION_ADDRESS_ID.label, id).load();
            if(!Tips.stringIsNull(id_AttributeSchemeId)){
                Attr elementId_Attr1 = new AttributeT(doc, elementId, AttributesName.REGISTRATION_ADDRESS_ID_ATTR_SCHEME_ID.label, id_AttributeSchemeId).load();
            }
        }
        //Generate tag "AddressFormatCode" and attributes "listAgencyID", "listID"
        if(!Tips.stringIsNull(addressFormatCode)){
            Element elementAddressFormatCode = new ElementT(doc, elementRegistrationAddress, ElementsName.REGISTRATION_ADDRESS_ADDRESS_FORMAT_CODE.label, addressFormatCode).load();
            if(!Tips.stringIsNull(addressFormatCode_AttributeListAgencyId)){
                Attr elementAddressFormatCode_Attr1 = new AttributeT(doc, elementAddressFormatCode, AttributesName.REGISTRATION_ADDRESS_ADDRESSFORMATCODE_ATTR_LIST_AGENCY_ID.label, addressFormatCode_AttributeListAgencyId).load();
            }
            if(!Tips.stringIsNull(addressFormatCode_AttributeListId)){
                Attr elementAddressFormatCode_Attr2 = new AttributeT(doc, elementAddressFormatCode, AttributesName.REGISTRATION_ADDRESS_ADDRESSFORMATCODE_ATTR_LIST_ID.label, addressFormatCode_AttributeListId).load();
            }
        }
        //Generate tag "Postbox"
        if(!Tips.stringIsNull(postBox)){
            Element elementPostbox = new ElementT(doc, elementRegistrationAddress, ElementsName.REGISTRATION_ADDRESS_POSTBOX.label, postBox).load();
        }
        //Generate tag "StreetName"
        if(!Tips.stringIsNull(streetName)){
            Element elementStreetName = new ElementT(doc, elementRegistrationAddress, ElementsName.REGISTRATION_ADDRESS_STREET_NAME.label, streetName).load();
        }
        //Generate tag "BuildingNumber"
        if(!Tips.stringIsNull(buildingNumber)){
            Element elementBuildingNumber = new ElementT(doc, elementRegistrationAddress, ElementsName.REGISTRATION_ADDRESS_BUILDING_NUMBER.label, buildingNumber).load();
        }
        //Generate tag "CityName"
        if(!Tips.stringIsNull(cityName)){
            Element elementCityName = new ElementT(doc, elementRegistrationAddress, ElementsName.REGISTRATION_ADDRESS_CITY_NAME.label, cityName).load();
        }
        //Generate tag "PostalZone"
        if(!Tips.stringIsNull(postalZone)){
            Element elementPostalZone = new ElementT(doc, elementRegistrationAddress, ElementsName.REGISTRATION_ADDRESS_POSTAL_ZONE.label, postalZone).load();
        }
        return elementRegistrationAddress;
    }

}
