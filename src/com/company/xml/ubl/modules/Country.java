package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Country
 */
public class Country {

    private Document doc;
    private Element element;
    private String identificationCode;

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
     *         <li>[String] <b>identificationCode</b> <b>[0..1]</b> : An identifier for the Country.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Country(CountryBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.identificationCode = builder.identificationCode;
    }

    /**
     * Builder Country
     */
    public static class CountryBuilder {

        private Document doc;
        private Element element;
        private String identificationCode;

        public CountryBuilder(){};

        public CountryBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public CountryBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public CountryBuilder identificationCode(String identificationCode){
            this.identificationCode = identificationCode;
            return this;
        }
        public Country build(){
            Country countryBuilder = new Country(this);
            return countryBuilder;
        }
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementCountry = new ElementT(doc,element, ElementsName.POSTAL_ADDRESS_COUNTRY.label).load();
        if(!Tips.stringIsNull(identificationCode)){
            Element elementIdentificationCode = new ElementT(doc, elementCountry, ElementsName.POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE.label, identificationCode).load();
        }
        return elementCountry;
    }
}
