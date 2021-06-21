package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.data.NamespacesName;
import com.company.xml.ubl.elements.ID;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FinancialInstitution {

    private Document doc;
    private Element element;
    private ID id;

    /**
     * Documentation is coming...
     */
    private FinancialInstitution(FinancialInstitutionBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    public static class FinancialInstitutionBuilder {

        private Document doc;
        private Element element;
        private ID id;

        public FinancialInstitutionBuilder() {}

        public FinancialInstitutionBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public FinancialInstitutionBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public FinancialInstitutionBuilder id(ID id){
            this.id = id;
            return this;
        }
        public FinancialInstitution build(){
            FinancialInstitution element = new FinancialInstitution(this);
            return element;
        }

    }

    public ID getId() {
        return id;
    }

    public boolean isNull() {
        if(Tips.stringIsNull(id.getValue())){
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
        Element elementRoot = new ElementT(doc, element, ElementsName.FINANCIAL_INSTITUTION.label).load();
        if(!id.isNull()){
            Element elementId = new ID.IDBuilder()
                    .documentLinked(doc)
                    .elementFather(elementRoot)
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
        }
        return elementRoot;
    }

}
