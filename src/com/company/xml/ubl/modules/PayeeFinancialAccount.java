package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.ID;
import com.company.xml.ubl.elements.Name;
import com.company.xml.ubl.elements.PaymentMeansCode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PayeeFinancialAccount {

    private Document doc;
    private Element element;
    private ID id;
    private FinancialInstitutionBranch financialInstitutionBranch;

    /**
     * Documentation is coming...
     */
    private PayeeFinancialAccount(PayeeFinancialAccountBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.financialInstitutionBranch = builder.financialInstitutionBranch;
    }

    public static class PayeeFinancialAccountBuilder {

        private Document doc;
        private Element element;
        private ID id;
        private FinancialInstitutionBranch financialInstitutionBranch;

        public PayeeFinancialAccountBuilder() {}

        public PayeeFinancialAccountBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PayeeFinancialAccountBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PayeeFinancialAccountBuilder id(ID id){
            this.id = id;
            return this;
        }
        public PayeeFinancialAccountBuilder financialInstitutionBranch(FinancialInstitutionBranch financialInstitutionBranch){
            this.financialInstitutionBranch = financialInstitutionBranch;
            return this;
        }
        public PayeeFinancialAccount build(){
            PayeeFinancialAccount element = new PayeeFinancialAccount(this);
            return element;
        }

    }

    public ID getId() {
        return id;
    }

    public FinancialInstitutionBranch getFinancialInstitutionBranch() {
        return financialInstitutionBranch;
    }

    public boolean isNull() {
        if(id.isNull() && financialInstitutionBranch.isNull()){
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
        Element elementRoot = new ElementT(doc, element, ElementsName.PAYEE_FINANCIAL_ACCOUNT.label).load();
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
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
            } else {
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementRoot)
                        .value(id.getValue())
                        .build().load();
            }
        }
        if(!(financialInstitutionBranch == null)){
            Element elementFinancialInstitutionBranch = new FinancialInstitutionBranch.FinancialInstitutionBranchBuilder()
                    .documentLinked(doc)
                    .elementFather(elementRoot)
                    .financialInstitution(financialInstitutionBranch.getFinancialInstitution())
                    .build().load();
        }
        return elementRoot;
    }
}
