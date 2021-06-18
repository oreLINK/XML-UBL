package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PostalAddress
 */
public class PostalAddress {

    private Document doc;
    private Element element;
    private String addressFormatCode;
    private String addressFormatCode_AttrListAgencyID;
    private String addressFormatCode_AttrListID;
    private String addressFormatCode_AttrListVersionID;
    private String postBox;
    private String streetName;
    private String buildingNumber;
    private String cityName;
    private String postalZone;
    private List<Country> countryList = new ArrayList<>();

    /**
     * <h2>Element "PostalAddress"</h2>
     * <i>use in Party <b>[0..1]</b>.</i>
     * <p>The party's postal address. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>addressFormatCode</b> <b>[0..1]</b> : A code specifying the format of this address.</li>
     *         <li>[String] <b>addressFormatCode_AttrListAgencyID</b> <b>[0..1]</b> : An agency that maintains one or more lists of codes. (Attribute)</li>
     *         <li>[String] <b>addressFormatCode_AttrListID</b> <b>[0..1]</b> : The identification of a list of codes. (Attribute)</li>
     *         <li>[String] <b>addressFormatCode_AttrListVersionID</b> <b>[0..1]</b> :The identification of a list of codes. (Attribute)</li>
     *         <li>[String] <b>postBox</b> <b>[0..1]</b> : A post office box number.</li>
     *         <li>[String] <b>streetName</b> <b>[0..1]</b> : The name of a street.</li>
     *         <li>[String] <b>buildingNumber</b> <b>[0..1]</b> : The number of a building.</li>
     *         <li>[String] <b>cityName</b> <b>[0..1]</b> : The name of a city, town, or village.</li>
     *         <li>[String] <b>postalZone</b> <b>[0..1]</b> : The identifier for an addressable group of properties according to the relevant national postal service, such as a ZIP code or Post Code.</li>
     *         <li>[List] <b>countryList</b> <b>[0..1]</b> : [Country] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PostalAddress(PostalAddressBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.addressFormatCode = builder.addressFormatCode;
        this.addressFormatCode_AttrListAgencyID = builder.addressFormatCode_AttrListAgencyID;
        this.addressFormatCode_AttrListID = builder.addressFormatCode_AttrListID;
        this.addressFormatCode_AttrListVersionID = builder.addressFormatCode_AttrListVersionID;
        this.postBox = builder.postBox;
        this.streetName = builder.streetName;
        this.buildingNumber = builder.buildingNumber;
        this.cityName = builder.cityName;
        this.postalZone = builder.postalZone;
        this.countryList = builder.countryList;
    }

    /**
     * Builder PostalAddress
     */
    public static class PostalAddressBuilder {

        private Document doc;
        private Element element;
        private String addressFormatCode;
        private String addressFormatCode_AttrListAgencyID;
        private String addressFormatCode_AttrListID;
        private String addressFormatCode_AttrListVersionID;
        private String postBox;
        private String streetName;
        private String buildingNumber;
        private String cityName;
        private String postalZone;
        private List<Country> countryList = new ArrayList<>();

        public PostalAddressBuilder(){}

        public PostalAddressBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PostalAddressBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PostalAddressBuilder addressFormatCode(String addressFormatCode){
            this.addressFormatCode = addressFormatCode;
            return this;
        }
        public PostalAddressBuilder addressFormatCode_AttributeListAgencyID(String addressFormatCode_AttrListAgencyID){
            this.addressFormatCode_AttrListAgencyID = addressFormatCode_AttrListAgencyID;
            return this;
        }
        public PostalAddressBuilder addressFormatCode_AttributeListID(String addressFormatCode_AttrListID){
            this.addressFormatCode_AttrListID = addressFormatCode_AttrListID;
            return this;
        }
        public PostalAddressBuilder addressFormatCode_AttributeListVersionID(String addressFormatCode_AttrListVersionID){
            this.addressFormatCode_AttrListVersionID = addressFormatCode_AttrListVersionID;
            return this;
        }
        public PostalAddressBuilder postBox(String postBox){
            this.postBox = postBox;
            return this;
        }
        public PostalAddressBuilder streetName(String streetName){
            this.streetName = streetName;
            return this;
        }
        public PostalAddressBuilder buildingNumber(String buildingNumber){
            this.buildingNumber = buildingNumber;
            return this;
        }
        public PostalAddressBuilder cityName(String cityName){
            this.cityName = cityName;
            return this;
        }
        public PostalAddressBuilder postalZone(String postalZone){
            this.postalZone = postalZone;
            return this;
        }
        public PostalAddressBuilder countryList(List<Country> countryList){
            this.countryList = countryList;
            return this;
        }
        public PostalAddress build(){
            PostalAddress postalAddress = new PostalAddress(this);
            return postalAddress;
        }
    }

    public String getAddressFormatCode() {
        return addressFormatCode;
    }

    public String getAddressFormatCode_AttrListAgencyID() {
        return addressFormatCode_AttrListAgencyID;
    }

    public String getAddressFormatCode_AttrListID() {
        return addressFormatCode_AttrListID;
    }

    public String getAddressFormatCode_AttrListVersionID() {
        return addressFormatCode_AttrListVersionID;
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

    public List<Country> getCountryList() {
        return countryList;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementPostalAddress = new ElementT(doc, element, ElementsName.POSTAL_ADDRESS.label).load();
        if(!Tips.stringIsNull(addressFormatCode)) {
            Element elementAddressFormatCode = new ElementT(
                    doc,
                    elementPostalAddress,
                    ElementsName.POSTAL_ADDRESS_ADDRESS_FORMAT_CODE.label,
                    addressFormatCode
            ).load();
        }
        if(!Tips.stringIsNull(postBox)) {
            Element elementPostBox = new ElementT(
                    doc,
                    elementPostalAddress,
                    ElementsName.POSTAL_ADDRESS_POSTBOX.label,
                    postBox
            ).load();
        }
        if(!Tips.stringIsNull(streetName)) {
            Element elementStreetName = new ElementT(
                    doc,
                    elementPostalAddress,
                    ElementsName.POSTAL_ADDRESS_STREET_NAME.label,
                    streetName
            ).load();
        }
        if(!Tips.stringIsNull(buildingNumber)) {
            Element elementBuildingNumber = new ElementT(
                    doc,
                    elementPostalAddress,
                    ElementsName.POSTAL_ADDRESS_BUILDING_NUMBER.label,
                    buildingNumber
            ).load();
        }
        if(!Tips.stringIsNull(cityName)) {
            Element elementCityName = new ElementT(
                    doc,
                    elementPostalAddress,
                    ElementsName.POSTAL_ADDRESS_CITY_NAME.label,
                    cityName
            ).load();
        }
        if(!Tips.stringIsNull(postalZone)) {
            Element elementPostalZone = new ElementT(
                    doc,
                    elementPostalAddress,
                    ElementsName.POSTAL_ADDRESS_POSTAL_ZONE.label,
                    postalZone
            ).load();
        }
        if(!Tips.listIsNull(countryList)){
            for (Country country : countryList) {
                Element elementCountry = new Country.CountryBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .identificationCode(country.getIdentificationCode())
                        .build().load();
            }
        }
        return elementPostalAddress;
    }
}
