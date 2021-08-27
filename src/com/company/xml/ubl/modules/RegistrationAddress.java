package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternLanguage;
import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class RegistrationAddress
 */
public class RegistrationAddress {

    private Document doc;
    private Element element;
    private ID id;
    private AddressFormatCode addressFormatCode;
    private Postbox postbox;
    private StreetName streetName;
    private BuildingNumber buildingNumber;
    private CityName cityName;
    private PostalZone postalZone;

    /**
     * <h2>Element "RegistrationAddress"</h2>
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
     *         <li>[ID] <b>id</b> <b>[0..1]</b> : An identifier for a specific address within a scheme of registered addresses.</li>
     *         <li>[AddressFormatCode] <b>addressFormatCode</b> <b>[0..1]</b> : A code specifying the format of this address.</li>
     *         <li>[Postbox] <b>postBox</b> <b>[0..1]</b> : A post office box number.</li>
     *         <li>[StreetName] <b>streetName</b> <b>[0..1]</b> : The name of a street.</li>
     *         <li>[BuildingNumber] <b>buildingNumber</b> <b>[0..1]</b> : The number of a building.</li>
     *         <li>[CityName] <b>cityName</b> <b>[0..1]</b> : The name of a city, town, or village.</li>
     *         <li>[PostalZone] <b>postalZone</b> <b>[0..1]</b> : The identifier for an addressable group of properties according to the relevant national postal service, such as a ZIP code or Post Code.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private RegistrationAddress(RegistrationAddressBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.addressFormatCode = builder.addressFormatCode;
        this.postbox = builder.postbox;
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
        private ID id;
        private AddressFormatCode addressFormatCode;
        private Postbox postbox;
        private StreetName streetName;
        private BuildingNumber buildingNumber;
        private CityName cityName;
        private PostalZone postalZone;

        public RegistrationAddressBuilder(){}

        public RegistrationAddressBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public RegistrationAddressBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public RegistrationAddressBuilder id(ID id){
            this.id = id;
            return this;
        }
        public RegistrationAddressBuilder addressFormatCode(AddressFormatCode addressFormatCode){
            this.addressFormatCode = addressFormatCode;
            return this;
        }
        public RegistrationAddressBuilder postBox(Postbox postBox){
            this.postbox = postbox;
            return this;
        }
        public RegistrationAddressBuilder streetName(StreetName streetName){
            this.streetName = streetName;
            return this;
        }
        public RegistrationAddressBuilder buildingNumber(BuildingNumber buildingNumber){
            this.buildingNumber = buildingNumber;
            return this;
        }
        public RegistrationAddressBuilder cityName(CityName cityName){
            this.cityName = cityName;
            return this;
        }
        public RegistrationAddressBuilder postalZone(PostalZone postalZone){
            this.postalZone = postalZone;
            return this;
        }
        public RegistrationAddress build(){
            RegistrationAddress registrationAddress = new RegistrationAddress(this);
            return registrationAddress;
        }

    }

    public ID getId() {
        return id;
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

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        //Generate root element
        Element elementRegistrationAddress = new ElementT(doc, element, ElementsName.REGISTRATION_ADDRESS.label).load();

        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(id.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(id.getPatternScheme().getSchemeID())
                                .schemeName(id.getPatternScheme().getSchemeName())
                                .schemeAgencyID(id.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(id.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(id.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(id.getPatternScheme().getSchemeDataURI())
                                .schemeURI(id.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(id.getValue())
                        .build().load();
            }
        }
        if(!(addressFormatCode == null)){
            if(!(addressFormatCode.getPatternList() == null)){
                Element elementAddressFormatCode = new AddressFormatCode.AddressFormatCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
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
                        .elementFather(elementRegistrationAddress)
                        .value(addressFormatCode.getValue())
                        .build().load();
            }
        }
        if(!(postbox == null)){
            if(!(postbox.getPatternLanguage() == null)){
                Element elementPostBox = new Postbox.PostboxBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(postbox.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(postbox.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementPostBox = new Postbox.PostboxBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(postbox.getValue())
                        .build().load();
            }
        }
        if(!(streetName == null)){
            if(!(streetName.getPatternLanguage() == null)){
                Element elementStreetName = new StreetName.StreetNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(streetName.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(streetName.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementStreetName = new StreetName.StreetNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(streetName.getValue())
                        .build().load();
            }
        }
        if(!(buildingNumber == null)){
            if(!(buildingNumber.getPatternLanguage() == null)){
                Element elementBuildingNumber = new BuildingNumber.BuildingNumberBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(buildingNumber.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(buildingNumber.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementBuildingNumber = new BuildingNumber.BuildingNumberBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(buildingNumber.getValue())
                        .build().load();
            }
        }
        if(!(cityName == null)){
            if(!(cityName.getPatternLanguage() == null)){
                Element elementCityName = new CityName.CityNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(cityName.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(cityName.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementCityName = new CityName.CityNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(cityName.getValue())
                        .build().load();
            }
        }
        if(!(postalZone == null)){
            if(!(postalZone.getPatternLanguage() == null)){
                Element elementPostalZone = new PostalZone.PostalZoneBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(postalZone.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(postalZone.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementPostalZone = new PostalZone.PostalZoneBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRegistrationAddress)
                        .value(postalZone.getValue())
                        .build().load();
            }
        }
        return elementRegistrationAddress;
    }

}
