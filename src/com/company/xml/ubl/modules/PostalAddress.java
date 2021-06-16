package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

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
     * Class Builder
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

    public PostalAddress(Document doc, Element element, String addressFormatCode, String addressFormatCode_AttrListAgencyID, String addressFormatCode_AttrListID, String addressFormatCode_AttrListVersionID, String postBox, String streetName, String buildingNumber, String cityName, String postalZone, List<Country> countryList) {
        this.doc = doc;
        this.element = element;
        this.addressFormatCode = addressFormatCode;
        this.addressFormatCode_AttrListAgencyID = addressFormatCode_AttrListAgencyID;
        this.addressFormatCode_AttrListID = addressFormatCode_AttrListID;
        this.addressFormatCode_AttrListVersionID = addressFormatCode_AttrListVersionID;
        this.postBox = postBox;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.cityName = cityName;
        this.postalZone = postalZone;
        this.countryList = countryList;
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
                Element elementCountry = new ElementT(
                        doc,
                        elementPostalAddress,
                        ElementsName.POSTAL_ADDRESS_COUNTRY.label,
                        country.getIdentificationCode()
                ).load();
            }
        }
        return elementPostalAddress;
    }
}
