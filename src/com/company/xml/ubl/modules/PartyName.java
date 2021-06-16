package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PartyName {

    private Document doc;
    private Element element;
    private String name;

    private PartyName(PartyNameBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.name = builder.name;
    }

    public static class PartyNameBuilder {

        private Document doc;
        private Element element;
        private String name;

        public PartyNameBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PartyNameBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyNameBuilder name(String name){
            this.name = name;
            return this;
        }
        public PartyName build(){
            PartyName partyName = new PartyName(this);
            return partyName;
        }

    }

    public String getName() {
        return name;
    }

    public Element load() {
        Element elementPartyName = new ElementT(doc, element, ElementsName.PARTY_NAME.label).load();
        Element elementPartyNameName = new ElementT(doc, elementPartyName, ElementsName.PARTY_NAME_NAME.label, name).load();
        return elementPartyName;
    }
}
