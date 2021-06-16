package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Country {

    private Document doc;
    private Element element;
    private String identificationCode;

    private Country(CountryBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.identificationCode = builder.identificationCode;
    }

    public Country(Document doc, Element element, String identificationCode) {
        this.doc = doc;
        this.element = element;
        this.identificationCode = identificationCode;
    }

    public Country(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    /**
     * Class Builder
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

    public Element load() {
        Element elementCountry = new ElementT(doc,element, ElementsName.POSTAL_ADDRESS_COUNTRY.label).load();
        if(!Tips.stringIsNull(identificationCode)){
            Element elementIdentificationCode = new ElementT(doc, elementCountry, ElementsName.POSTAL_ADDRESS_COUNTRY_IDENTIFICATION_CODE.label, identificationCode).load();
        }
        return elementCountry;
    }
}
