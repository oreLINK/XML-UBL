package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Party
 */
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

    /**
     * <h2>Element "Party"</h2>
     * <i>use in AccountingCustomerParty <b>[0..1]</b>, AccountingSupplierParty <b>[0..1]</b>.</i>
     * <p>An association to Party. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[List] <b>partyIdentificationList</b> <b>[0..*]</b> : [PartyIdentification] elements list.</li>
     *         <li>[List] <b>partyNameList</b> <b>[0..*]</b> : [PartyName] elements list.</li>
     *         <li>[List] <b>postalAddressList</b> <b>[0..1]</b> : [PostalAddress] elements list.</li>
     *         <li>[List] <b>partyTaxSchemeList</b> <b>[0..*]</b> : [PartyTaxScheme] elements list.</li>
     *         <li>[List] <b>partyLegalEntityList</b> <b>[0..*]</b> : [PartyLegalEntity] elements list.</li>
     *         <li>[List] <b>contactList</b> <b>[0..1]</b> : [Contact] elements list.</li>
     *         <li>[List] <b>personList</b> <b>[0..1]</b> : [Person] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
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

    /**
     * Builder Party
     */
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

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
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
                Element elementPostalAddress = new PostalAddress.PostalAddressBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .addressFormatCode(postalAddress.getAddressFormatCode())
                        .addressFormatCode_AttributeListAgencyID(postalAddress.getAddressFormatCode_AttrListAgencyID())
                        .addressFormatCode_AttributeListID(postalAddress.getAddressFormatCode_AttrListID())
                        .addressFormatCode_AttributeListVersionID(postalAddress.getAddressFormatCode_AttrListVersionID())
                        .postBox(postalAddress.getPostBox())
                        .streetName(postalAddress.getStreetName())
                        .buildingNumber(postalAddress.getBuildingNumber())
                        .cityName(postalAddress.getCityName())
                        .postalZone(postalAddress.getPostalZone())
                        .countryList(postalAddress.getCountryList())
                        .build().load();
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
