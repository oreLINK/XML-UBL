package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PartyTaxScheme
 */
public class PartyTaxScheme {

    private Document doc;
    private Element element;
    private String companyId;
    private String companyId_AttributeSchemeId;
    private List<TaxScheme> taxSchemeList = new ArrayList<>();

    /**
     * <h2>Element "PartyTaxScheme"</h2>
     * <i>use in Party <b>[0..*]</b>.</i>
     * <p>An association to Party Tax Scheme. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>companyId</b> <b>[0..1]</b> : The identifier assigned for tax purposes to a party by the taxation authority.</li>
     *         <li>[String] <b>companyId_AttributeSchemeId</b> <b>[0..1]</b> : The identification of the identification scheme.</li>
     *         <li>[List] <b>taxSchemeList</b> <b>[1..1]</b> : [TaxScheme] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PartyTaxScheme(PartyTaxSchemeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.companyId = builder.companyId;
        this.companyId_AttributeSchemeId = builder.companyId_AttributeSchemeId;
        this.taxSchemeList = builder.taxSchemeList;
    }

    /**
     * Builder PartyTaxScheme
     */
    public static class PartyTaxSchemeBuilder {

        private Document doc;
        private Element element;
        private String companyId;
        private String companyId_AttributeSchemeId;
        private List<TaxScheme> taxSchemeList = new ArrayList<>();

        public PartyTaxSchemeBuilder(){}

        public PartyTaxSchemeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PartyTaxSchemeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyTaxSchemeBuilder companyId(String companyId){
            this.companyId = companyId;
            return this;
        }
        public PartyTaxSchemeBuilder companyId_AttributeSchemeId(String companyId_AttributeSchemeId){
            this.companyId_AttributeSchemeId = companyId_AttributeSchemeId;
            return this;
        }
        public PartyTaxSchemeBuilder taxSchemeList(List<TaxScheme> taxSchemeList){
            this.taxSchemeList = taxSchemeList;
            return this;
        }
        public PartyTaxScheme build(){
            PartyTaxScheme partyTaxScheme = new PartyTaxScheme(this);
            return partyTaxScheme;
        }

    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyId_AttributeSchemeId() {
        return companyId_AttributeSchemeId;
    }

    public List<TaxScheme> getTaxSchemeList() {
        return taxSchemeList;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementPartyTaxScheme = new ElementT(doc,element, ElementsName.PARTY_TAX_SCHEME.label).load();
        if(!Tips.stringIsNull(companyId)){
            Element elementCompanyId = new ElementT(doc, elementPartyTaxScheme, ElementsName.PARTY_TAX_SCHEME_COMPANY_ID.label, companyId).load();
            if(!Tips.stringIsNull(companyId_AttributeSchemeId)) {
                Attr elementCompanyId_Attr1 = new AttributeT(doc, elementCompanyId, AttributesName.COMPANY_ID_SCHEME_ID.label, companyId_AttributeSchemeId).load();
            }
        }
        if(!Tips.listIsNull(taxSchemeList)){
            for (TaxScheme taxScheme : taxSchemeList) {
                Element elementTaxScheme = new TaxScheme.TaxSchemeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyTaxScheme)
                        .name(taxScheme.getName())
                        .build().load();
            }
        }
        return elementPartyTaxScheme;
    }

}
