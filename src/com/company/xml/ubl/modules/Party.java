package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class Party {

    private Document doc;
    private Element element;
    private List<PartyIdentification> partyIdentificationList = new ArrayList<>();
    private List<PartyName> partyNameList = new ArrayList<>();
    private List<PostalAddress> postalAddressList = new ArrayList<>();
    private List<PartyTaxScheme> partyTaxSchemeList = new ArrayList<>();
    private List<PartyLegalEntity> partyLegalEntityList = new ArrayList<>();
    private List<Contact> contactList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();

    private Party(PartyBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.partyIdentificationList = builder.partyIdentificationList;
        this.partyNameList = builder.partyNameList;
        this.postalAddressList = builder.postalAddressList;
        this.partyTaxSchemeList = builder.partyTaxSchemeList;
        this.partyLegalEntityList = builder.partyLegalEntityList;
        this.contactList = builder.contactList;
        this.personList = builder.personList;
    }

    public static class PartyBuilder {

        private Document doc;
        private Element element;
        private List<PartyIdentification> partyIdentificationList = new ArrayList<>();
        private List<PartyName> partyNameList = new ArrayList<>();
        private List<PostalAddress> postalAddressList = new ArrayList<>();
        private List<PartyTaxScheme> partyTaxSchemeList = new ArrayList<>();
        private List<PartyLegalEntity> partyLegalEntityList = new ArrayList<>();
        private List<Contact> contactList = new ArrayList<>();
        private List<Person> personList = new ArrayList<>();

        public PartyBuilder() {}

        public PartyBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PartyBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyBuilder partyIdentificationList(List<PartyIdentification> partyIdentificationList){
            this.partyIdentificationList = partyIdentificationList;
            return this;
        }
        public PartyBuilder partyNameList(List<PartyName> partyNameList){
            this.partyNameList = partyNameList;
            return this;
        }
        public PartyBuilder postalAddressList(List<PostalAddress> postalAddressList){
            this.postalAddressList = postalAddressList;
            return this;
        }
        public PartyBuilder partyTaxSchemeList(List<PartyTaxScheme> partyTaxSchemeList){
            this.partyTaxSchemeList = partyTaxSchemeList;
            return this;
        }
        public PartyBuilder partyLegalEntityList(List<PartyLegalEntity> partyLegalEntityList){
            this.partyLegalEntityList = partyLegalEntityList;
            return this;
        }
        public PartyBuilder contactList(List<Contact> contactList){
            this.contactList = contactList;
            return this;
        }
        public PartyBuilder personList(List<Person> personList){
            this.personList = personList;
            return this;
        }
        public Party build(){
            Party party = new Party(this);
            return party;
        }

    }

    public Party(Document doc, Element element, List<PartyIdentification> partyIdentificationList, List<PartyName> partyNameList, List<PostalAddress> postalAddressList, List<PartyTaxScheme> partyTaxSchemeList, List<PartyLegalEntity> partyLegalEntityList, List<Contact> contactList, List<Person> personList) {
        this.doc = doc;
        this.element = element;
        this.partyIdentificationList = partyIdentificationList;
        this.partyNameList = partyNameList;
        this.postalAddressList = postalAddressList;
        this.partyTaxSchemeList = partyTaxSchemeList;
        this.partyLegalEntityList = partyLegalEntityList;
        this.contactList = contactList;
        this.personList = personList;
    }

    public Party(List<PartyIdentification> partyIdentificationList, List<PartyName> partyNameList, List<PostalAddress> postalAddressList, List<PartyTaxScheme> partyTaxSchemeList, List<PartyLegalEntity> partyLegalEntityList, List<Contact> contactList, List<Person> personList) {
        this.partyIdentificationList = partyIdentificationList;
        this.partyNameList = partyNameList;
        this.postalAddressList = postalAddressList;
        this.partyTaxSchemeList = partyTaxSchemeList;
        this.partyLegalEntityList = partyLegalEntityList;
        this.contactList = contactList;
        this.personList = personList;
    }

    public List<PartyIdentification> getPartyIdentificationList() {
        return partyIdentificationList;
    }

    public List<PartyName> getPartyNameList() {
        return partyNameList;
    }

    public List<PostalAddress> getPostalAddressList() {
        return postalAddressList;
    }

    public List<PartyTaxScheme> getPartyTaxSchemeList() {
        return partyTaxSchemeList;
    }

    public List<PartyLegalEntity> getPartyLegalEntityList() {
        return partyLegalEntityList;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public Element load() {
        //Party (root)
        Element elementParty = new ElementT(doc,element, ElementsName.PARTY.label).load();

        //Party Identification
        if(!Tips.listIsNull(partyIdentificationList)) {
            for (PartyIdentification partyIdentification : partyIdentificationList) {
                Element elementPartyIdentification = new PartyIdentification.PartyIdentificationBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .id(partyIdentification.getId())
                        .id_AttributeSchemeID(partyIdentification.getId_AttributeSchemeID())
                        .id_AttributeSchemeName(partyIdentification.getId_AttributeSchemeName())
                        .build().load();
            }
        }

        //Party Name
        if(!Tips.listIsNull(partyNameList)) {
            for (PartyName partyName : partyNameList) {
                Element elementPartyName = new PartyName.PartyNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .name(partyName.getName())
                        .build().load();
            }
        }

        //Postal Address
        if(!Tips.listIsNull(postalAddressList)) {
            for (PostalAddress postalAddress : postalAddressList) {
                Element elementPostalAddress = new PostalAddress(
                        doc,
                        elementParty,
                        postalAddress.getAddressFormatCode(),
                        postalAddress.getAddressFormatCode_AttrListAgencyID(),
                        postalAddress.getAddressFormatCode_AttrListID(),
                        postalAddress.getAddressFormatCode_AttrListVersionID(),
                        postalAddress.getPostBox(),
                        postalAddress.getStreetName(),
                        postalAddress.getBuildingNumber(),
                        postalAddress.getCityName(),
                        postalAddress.getPostalZone(),
                        postalAddress.getCountryList()
                ).load();
            }
        }

        //Party Tax Scheme
        if(!Tips.listIsNull(partyTaxSchemeList)) {
            for (PartyTaxScheme partyTaxScheme : partyTaxSchemeList) {
                Element elementPartyTaxScheme = new PartyTaxScheme.PartyTaxSchemeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .companyId(partyTaxScheme.getCompanyId())
                        .companyId_AttributeSchemeId(partyTaxScheme.getCompanyId_AttributeSchemeId())
                        .taxSchemeList(partyTaxScheme.getTaxSchemeList())
                        .build().load();
            }
        }

        //Party Legal Entity
        if(!Tips.listIsNull(partyLegalEntityList)) {
            for (PartyLegalEntity partyLegalEntity : partyLegalEntityList) {
                Element elementPartyLegalEntity = new PartyLegalEntity.PartyLegalEntityBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .registrationName(partyLegalEntity.getRegistrationName())
                        .companyId(partyLegalEntity.getCompanyId())
                        .companyId_AttributeSchemeId(partyLegalEntity.getCompanyId_AttributeSchemeId())
                        .registrationAddressList(partyLegalEntity.getRegistrationAddressList())
                        .corporateRegistrationSchemeList(partyLegalEntity.getCorporateRegistrationSchemeList())
                        .build().load();
            }
        }

        //Contact
        if(!Tips.listIsNull(contactList)) {
            for (Contact contact : contactList) {
                Element elementContact = new Contact.ContactBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .id(contact.getId())
                        .id_AttributeSchemeURI(contact.getId_AttributeSchemeURI())
                        .name(contact.getName())
                        .telephone(contact.getTelephone())
                        .electronicMail(contact.getElectronicMail())
                        .note(contact.getNote())
                        .build().load();
            }
        }

        //Person
        if(!Tips.listIsNull(personList)) {
            for (Person person : personList) {
                Element elementPerson = new Person.PersonBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .firstName(person.getFirstName())
                        .familyName(person.getFamilyName())
                        .build().load();
            }
        }

        return elementParty;
    }
}
