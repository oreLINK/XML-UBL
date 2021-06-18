package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class AccountingCustomerParty
 */
public class AccountingCustomerParty {

    private Document doc;
    private Element element;
    private List<Party> partyList = new ArrayList<>();

    /**
     * <h2>Element "AccountingCustomerParty"</h2>
     * <i>use in CreditNote <b>[1..1]</b>.</i>
     * <p>An association to the Accounting Customer Party. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[List] <b>partyList</b> <b>[0..1]</b> : [Party] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private AccountingCustomerParty(AccountingCustomerPartyBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.partyList = builder.partyList;
    }

    /**
     * Builder AccountingCustomerParty
     */
    public static class AccountingCustomerPartyBuilder {

        private Document doc;
        private Element element;
        private List<Party> partyList = new ArrayList<>();

        public AccountingCustomerPartyBuilder() {}

        public AccountingCustomerPartyBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public AccountingCustomerPartyBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public AccountingCustomerPartyBuilder partyList(List<Party> partyList){
            this.partyList = partyList;
            return this;
        }
        public AccountingCustomerParty build(){
            AccountingCustomerParty accountingCustomerParty = new AccountingCustomerParty(this);
            return accountingCustomerParty;
        }

    }

    public List<Party> getPartyList() {
        return partyList;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementAccountingCustomerParty = new ElementT(doc,element, ElementsName.ACCOUNTING_SUPPLIER_PARTY.label).load();
        if(!Tips.listIsNull(partyList)){
            for (Party party : partyList) {
                Element elementParty = new Party.PartyBuilder()
                        .documentLinked(doc)
                        .elementFather(elementAccountingCustomerParty)
                        .partyIdentificationList(party.getPartyIdentificationList())
                        .partyNameList(party.getPartyNameList())
                        .postalAddressList(party.getPostalAddressList())
                        .partyTaxSchemeList(party.getPartyTaxSchemeList())
                        .partyLegalEntityList(party.getPartyLegalEntityList())
                        .contactList(party.getContactList())
                        .personList(party.getPersonList())
                        .build().load();
            }
        }
        return elementAccountingCustomerParty;
    }

}
