package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CorporateRegistrationScheme {

    private Document doc;
    private Element element;
    private String id;

    private CorporateRegistrationScheme(CorporateRegistrationSchemeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    public static class CorporateRegistrationSchemeBuilder {

        private Document doc;
        private Element element;
        private String id;

        public CorporateRegistrationSchemeBuilder(){}

        public CorporateRegistrationSchemeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public CorporateRegistrationSchemeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public CorporateRegistrationSchemeBuilder id(String id){
            this.id = id;
            return this;
        }
        public CorporateRegistrationScheme build(){
            CorporateRegistrationScheme corporateRegistrationScheme = new CorporateRegistrationScheme(this);
            return corporateRegistrationScheme;
        }

    }

    public String getId() {
        return id;
    }

    public Element load() {
        //Generate root element
        Element elementCorporateRegistrationScheme = new ElementT(doc, element, ElementsName.CORPORATE_REGISTRATION_SCHEME.label).load();

        //Generate tag "ID"
        if (!Tips.stringIsNull(id)) {
            Element elementId = new ElementT(doc, elementCorporateRegistrationScheme, ElementsName.CORPORATE_REGISTRATION_SCHEME_ID.label, id).load();
        }
        return elementCorporateRegistrationScheme;
    }

}
