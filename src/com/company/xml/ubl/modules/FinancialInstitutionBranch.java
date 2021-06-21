package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.ID;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FinancialInstitutionBranch {

    private Document doc;
    private Element element;
    private FinancialInstitution financialInstitution;

    /**
     * Documentation is coming...
     */
    private FinancialInstitutionBranch(FinancialInstitutionBranchBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.financialInstitution = builder.financialInstitution;
    }

    public static class FinancialInstitutionBranchBuilder {

        private Document doc;
        private Element element;
        private FinancialInstitution financialInstitution;

        public FinancialInstitutionBranchBuilder() {}

        public FinancialInstitutionBranchBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public FinancialInstitutionBranchBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public FinancialInstitutionBranchBuilder financialInstitution(FinancialInstitution financialInstitution){
            this.financialInstitution = financialInstitution;
            return this;
        }
        public FinancialInstitutionBranch build(){
            FinancialInstitutionBranch element = new FinancialInstitutionBranch(this);
            return element;
        }

    }

    public FinancialInstitution getFinancialInstitution() {
        return financialInstitution;
    }

    public boolean isNull() {
        if(financialInstitution.isNull()){
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
        Element elementRoot = new ElementT(doc, element, ElementsName.FINANCIAL_INSTITUTION_BRANCH.label).load();
        if(!financialInstitution.isNull()){
            Element elementFinancialInstitution = new FinancialInstitution.FinancialInstitutionBuilder()
                    .documentLinked(doc)
                    .elementFather(elementRoot)
                    .id(financialInstitution.getId())
                    .build().load();
        }
        return elementRoot;
    }

}
