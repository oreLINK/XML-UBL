package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class AccountingSupplierParty {

    private Document doc;
    private Element element;
    private List<Party> partyList = new ArrayList<>();

    private AccountingSupplierParty(AccountingSupplierPartyBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.partyList = builder.partyList;
    }

    public static class AccountingSupplierPartyBuilder {

        private Document doc;
        private Element element;
        private List<Party> partyList = new ArrayList<>();

        public AccountingSupplierPartyBuilder() {}

        public AccountingSupplierPartyBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public AccountingSupplierPartyBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public AccountingSupplierPartyBuilder partyList(List<Party> partyList){
            this.partyList = partyList;
            return this;
        }
        public AccountingSupplierParty build(){
            AccountingSupplierParty accountingSupplierParty = new AccountingSupplierParty(this);
            return accountingSupplierParty;
        }

    }

    public List<Party> getPartyList() {
        return partyList;
    }

    public Element load() {
        Element elementAccountingSupplierParty = new ElementT(doc,element, ElementsName.ACCOUNTING_SUPPLIER_PARTY.label).load();
        if(!Tips.listIsNull(partyList)){
            for (Party party : partyList) {
                Element elementParty = new Party.PartyBuilder()
                        .documentLinked(doc)
                        .elementFather(elementAccountingSupplierParty)
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
        return elementAccountingSupplierParty;
    }
}
