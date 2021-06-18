package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class CorporateRegistrationScheme
 */
public class CorporateRegistrationScheme {

    private Document doc;
    private Element element;
    private String id;

    /**
     * <h2>Element "CorporateRegistrationScheme"</h2>
     * <i>use in PartyLegalEntity <b>[0..1]</b>.</i>
     * <p>Associates the party with a Corporate Registration Scheme. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>id</b> <b>[0..1]</b> : Identifies the scheme.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private CorporateRegistrationScheme(CorporateRegistrationSchemeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    /**
     * Builder CorporateRegistrationScheme
     */
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

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
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
