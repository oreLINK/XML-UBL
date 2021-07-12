package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.CompanyID;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class PartyTaxScheme
 */
public class PartyTaxScheme {

    private Document doc;
    private Element element;
    private CompanyID companyID;
    private TaxScheme taxScheme;

    /**
     * <h2>Element "PartyTaxScheme"</h2>
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
     *         <li>[CompanyID] <b>companyId</b> <b>[0..1]</b> : The identifier assigned for tax purposes to a party by the taxation authority.</li>
     *         <li>[TaxScheme] <b>taxScheme</b> <b>[1..1]</b> : An association to Tax Scheme.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PartyTaxScheme(PartyTaxSchemeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.companyID = builder.companyID;
        this.taxScheme = builder.taxScheme;
    }

    /**
     * Builder PartyTaxScheme
     */
    public static class PartyTaxSchemeBuilder {

        private Document doc;
        private Element element;
        private CompanyID companyID;
        private TaxScheme taxScheme;

        public PartyTaxSchemeBuilder(){}

       public PartyTaxSchemeBuilder documentLinked(Document doc){
           this.doc = doc;
           return this;
       }
        public PartyTaxSchemeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyTaxSchemeBuilder companyId(CompanyID companyID){
            this.companyID = companyID;
            return this;
        }
        public PartyTaxSchemeBuilder taxScheme(TaxScheme taxScheme){
            this.taxScheme = taxScheme;
            return this;
        }
        public PartyTaxScheme build(){
            PartyTaxScheme partyTaxScheme = new PartyTaxScheme(this);
            return partyTaxScheme;
        }

    }

    public CompanyID getCompanyID() {
        return companyID;
    }

    public TaxScheme getTaxScheme() {
        return taxScheme;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementPartyTaxScheme = new ElementT(doc,element, ElementsName.PARTY_TAX_SCHEME.label).load();
        if(!(companyID == null)){
            if(!(companyID.getPatternScheme() == null)){
                Element elementCompanyId = new CompanyID.CompanyIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyTaxScheme)
                        .value(companyID.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(companyID.getPatternScheme().getSchemeID())
                                .schemeName(companyID.getPatternScheme().getSchemeName())
                                .schemeAgencyID(companyID.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(companyID.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(companyID.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(companyID.getPatternScheme().getSchemeDataURI())
                                .schemeURI(companyID.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementCompanyId = new CompanyID.CompanyIDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyTaxScheme)
                        .value(companyID.getValue())
                        .build().load();
            }
        }
        if(!(taxScheme == null)){
            Element elementTaxScheme = new TaxScheme.TaxSchemeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementPartyTaxScheme)
                    .id(taxScheme.getId())
                    .name(taxScheme.getName())
                    .build().load();
        }
        return elementPartyTaxScheme;
    }

}
