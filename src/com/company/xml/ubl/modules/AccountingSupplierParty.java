package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class AccountingSupplierParty
 */
public class AccountingSupplierParty {

    private Document doc;
    private Element element;
    private Party party;

    /**
     * <h2>Element "AccountingSupplierParty"</h2>
     * <p>An association to the Accounting Supplier Party. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[Party] <b>party</b> <b>[0..1]</b> : An association to Party.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private AccountingSupplierParty(AccountingSupplierPartyBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.party = builder.party;
    }

    /**
     * Builder AccountingCustomerParty
     */
    public static class AccountingSupplierPartyBuilder {

        private Document doc;
        private Element element;
        private Party party;

        public AccountingSupplierPartyBuilder() {}

        public AccountingSupplierPartyBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public AccountingSupplierPartyBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public AccountingSupplierPartyBuilder party(Party party){
            this.party = party;
            return this;
        }
        public AccountingSupplierParty build(){
            AccountingSupplierParty accountingSupplierParty = new AccountingSupplierParty(this);
            return accountingSupplierParty;
        }

    }

    public Party getParty() {
        return party;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementAccountingSupplierParty = new ElementT(doc, element, ElementsName.ACCOUNTING_SUPPLIER_PARTY.label).load();
        if(!(party == null)){
            Element elementParty = new Party.PartyBuilder()
                    .documentLinked(doc)
                    .elementFather(elementAccountingSupplierParty)
                    .partyIdentificationList(party.getPartyIdentificationList())
                    .partyNameList(party.getPartyNameList())
                    .postalAddress(party.getPostalAddress())
                    .partyTaxSchemeList(party.getPartyTaxSchemeList())
                    .partyLegalEntityList(party.getPartyLegalEntityList())
                    .contact(party.getContact())
                    .person(party.getPerson())
                    .build().load();
        }
        return elementAccountingSupplierParty;
    }

}
