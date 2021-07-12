package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternLanguage;
import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

/**
 * Class PostalAddress
 */
public class PostalAddress {

    private Document doc;
    private Element element;
    private AddressFormatCode addressFormatCode;
    private Postbox postbox;
    private StreetName streetName;
    private BuildingNumber buildingNumber;
    private CityName cityName;
    private PostalZone postalZone;
    private Country country;

    /**
     * <h2>Element "PostalAddress"</h2>
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
     *         <li>[AddressFormatCode] <b>addressFormatCode</b> <b>[0..1]</b> : A code specifying the format of this address.</li>
     *         <li>[Postbox] <b>postBox</b> <b>[0..1]</b> : A post office box number.</li>
     *         <li>[StreetName] <b>streetName</b> <b>[0..1]</b> : The name of a street.</li>
     *         <li>[BuildingNumber] <b>buildingNumber</b> <b>[0..1]</b> : The number of a building.</li>
     *         <li>[CityName] <b>cityName</b> <b>[0..1]</b> : The name of a city, town, or village.</li>
     *         <li>[PostalZone] <b>postalZone</b> <b>[0..1]</b> : The identifier for an addressable group of properties according to the relevant national postal service, such as a ZIP code or Post Code.</li>
     *         <li>[Country] <b>country</b> <b>[0..1]</b> : An association to Country.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PostalAddress(PostalAddressBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.addressFormatCode = builder.addressFormatCode;
        this.postbox = builder.postbox;
        this.streetName = builder.streetName;
        this.buildingNumber = builder.buildingNumber;
        this.cityName = builder.cityName;
        this.postalZone = builder.postalZone;
        this.country = builder.country;
    }

    /**
     * Builder PostalAddress
     */
    public static class PostalAddressBuilder {

        private Document doc;
        private Element element;
        private AddressFormatCode addressFormatCode;
        private Postbox postbox;
        private StreetName streetName;
        private BuildingNumber buildingNumber;
        private CityName cityName;
        private PostalZone postalZone;
        private Country country;

        public PostalAddressBuilder(){}

        public PostalAddressBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PostalAddressBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PostalAddressBuilder addressFormatCode(AddressFormatCode addressFormatCode){
            this.addressFormatCode = addressFormatCode;
            return this;
        }
        public PostalAddressBuilder postbox(Postbox postbox){
            this.postbox = postbox;
            return this;
        }
        public PostalAddressBuilder streetName(StreetName streetName){
            this.streetName = streetName;
            return this;
        }
        public PostalAddressBuilder buildingNumber(BuildingNumber buildingNumber){
            this.buildingNumber = buildingNumber;
            return this;
        }
        public PostalAddressBuilder cityName(CityName cityName){
            this.cityName = cityName;
            return this;
        }
        public PostalAddressBuilder postalZone(PostalZone postalZone){
            this.postalZone = postalZone;
            return this;
        }
        public PostalAddressBuilder country(Country country){
            this.country = country;
            return this;
        }
        public PostalAddress build(){
            PostalAddress postalAddress = new PostalAddress(this);
            return postalAddress;
        }
    }

    public AddressFormatCode getAddressFormatCode() {
        return addressFormatCode;
    }

    public Postbox getPostbox() {
        return postbox;
    }

    public StreetName getStreetName() {
        return streetName;
    }

    public BuildingNumber getBuildingNumber() {
        return buildingNumber;
    }

    public CityName getCityName() {
        return cityName;
    }

    public PostalZone getPostalZone() {
        return postalZone;
    }

    public Country getCountry() {
        return country;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementPostalAddress = new ElementT(doc, element, ElementsName.POSTAL_ADDRESS.label).load();
        if(!(addressFormatCode == null)) {
            if(!(addressFormatCode.getPatternList() == null)){
                Element elementAddressFormatCode = new AddressFormatCode.AddressFormatCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(addressFormatCode.getValue())
                        .attributes(new PatternList.PatternListBuilder()
                                .listID(addressFormatCode.getPatternList().getListID())
                                .listAgencyID(addressFormatCode.getPatternList().getListAgencyID())
                                .listAgencyName(addressFormatCode.getPatternList().getListAgencyName())
                                .listName(addressFormatCode.getPatternList().getListName())
                                .listVersionID(addressFormatCode.getPatternList().getListVersionID())
                                .name(addressFormatCode.getPatternList().getName())
                                .languageID(addressFormatCode.getPatternList().getLanguageID())
                                .listURI(addressFormatCode.getPatternList().getListURI())
                                .listSchemeURI(addressFormatCode.getPatternList().getListSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementAddressFormatCode = new AddressFormatCode.AddressFormatCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(addressFormatCode.getValue())
                        .build().load();
            }
        }
        if(!(postbox == null)) {
            if(!(postbox.getPatternLanguage() == null)){
                Element elementPostBox = new Postbox.PostboxBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(postbox.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(postbox.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementPostBox = new Postbox.PostboxBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(postbox.getValue())
                        .build().load();
            }
        }
        if(!(streetName == null)) {
            if(!(streetName.getPatternLanguage() == null)){
                Element elementStreetName = new StreetName.StreetNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(streetName.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(streetName.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementStreetName = new StreetName.StreetNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(streetName.getValue())
                        .build().load();
            }
        }
        if(!(buildingNumber == null)) {
            if(!(buildingNumber.getPatternLanguage() == null)){
                Element elementBuildingNumber = new BuildingNumber.BuildingNumberBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(buildingNumber.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(buildingNumber.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementBuildingNumber = new BuildingNumber.BuildingNumberBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(buildingNumber.getValue())
                        .build().load();
            }
        }
        if(!(cityName == null)) {
            if(!(cityName.getPatternLanguage() == null)){
                Element elementCityName = new CityName.CityNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(cityName.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(cityName.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementCityName = new CityName.CityNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(cityName.getValue())
                        .build().load();
            }
        }
        if(!(postalZone == null)) {
            if(!(postalZone.getPatternLanguage() == null)){
                Element elementPostalZone = new PostalZone.PostalZoneBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(postalZone.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(postalZone.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementPostalZone = new PostalZone.PostalZoneBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPostalAddress)
                        .value(postalZone.getValue())
                        .build().load();
            }
        }
        if(!(country == null)){
            Element elementCountry = new Country.CountryBuilder()
                    .documentLinked(doc)
                    .elementFather(elementPostalAddress)
                    .identificationCode(country.getIdentificationCode())
                    .name(country.getName())
                    .build().load();
        }
        return elementPostalAddress;
    }
}
