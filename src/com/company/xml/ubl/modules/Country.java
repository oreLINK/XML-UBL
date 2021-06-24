package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternLanguage;
import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.IdentificationCode;
import com.company.xml.ubl.elements.Name;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Country
 */
public class Country {

    private Document doc;
    private Element element;
    private IdentificationCode identificationCode;
    private Name name;

    /**
     * <h2>Element "Country"</h2>
     * <i>use in PostalAddress <b>[0..1]</b>.</i>
     * <p>An association to Country. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[IdentificationCode] <b>identificationCode</b> <b>[0..1]</b> : An identifier for the Country.</li>
     *         <li>[Name] <b>name</b> <b>[0..1]</b> : The name of the Country.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Country(CountryBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.identificationCode = builder.identificationCode;
        this.name = builder.name;
    }

    /**
     * Builder Country
     */
    public static class CountryBuilder {

        private Document doc;
        private Element element;
        private IdentificationCode identificationCode;
        private Name name;

        public CountryBuilder(){};

        public CountryBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public CountryBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public CountryBuilder identificationCode(IdentificationCode identificationCode){
            this.identificationCode = identificationCode;
            return this;
        }
        public CountryBuilder name(Name name){
            this.name = name;
            return this;
        }
        public Country build(){
            Country countryBuilder = new Country(this);
            return countryBuilder;
        }
    }

    public IdentificationCode getIdentificationCode() {
        return identificationCode;
    }

    public Name getName() {
        return name;
    }

    public boolean isNull() {
        if(identificationCode.isNull() && name.isNull()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementCountry = new ElementT(doc,element, ElementsName.POSTAL_ADDRESS_COUNTRY.label).load();
        if(!(identificationCode == null)) {
            if(!(identificationCode.getPatternList() == null)){
                Element elementIdentificationCode = new IdentificationCode.IdentificationCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCountry)
                        .value(identificationCode.getValue())
                        .attributes(new PatternList.PatternListBuilder()
                                .listID(identificationCode.getPatternList().getListID())
                                .listAgencyID(identificationCode.getPatternList().getListAgencyID())
                                .listAgencyName(identificationCode.getPatternList().getListAgencyName())
                                .listName(identificationCode.getPatternList().getListName())
                                .listVersionID(identificationCode.getPatternList().getListVersionID())
                                .name(identificationCode.getPatternList().getName())
                                .languageID(identificationCode.getPatternList().getLanguageID())
                                .listURI(identificationCode.getPatternList().getListURI())
                                .listSchemeURI(identificationCode.getPatternList().getListSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementIdentificationCode = new IdentificationCode.IdentificationCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCountry)
                        .value(identificationCode.getValue())
                        .build().load();
            }
        }
        if(!(name == null)){
            if(!(name.getPatternLanguage() == null)){
                Element elementName = new Name.NameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCountry)
                        .value(name.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(name.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementName = new Name.NameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCountry)
                        .value(name.getValue())
                        .build().load();
            }
        }
        return elementCountry;
    }
}
