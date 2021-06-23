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
    private PostalAddress postalAddress;
    private List<PartyTaxScheme> partyTaxSchemeList = new ArrayList<>();
    private List<PartyLegalEntity> partyLegalEntityList = new ArrayList<>();
    private Contact contact;
    private Person person;

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
     *         <li>[PostalAddress] <b>postalAddress</b> <b>[0..1]</b> : The party's postal address.</li>
     *         <li>[List] <b>partyTaxSchemeList</b> <b>[0..*]</b> : [PartyTaxScheme] elements list.</li>
     *         <li>[List] <b>partyLegalEntityList</b> <b>[0..*]</b> : [PartyLegalEntity] elements list.</li>
     *         <li>[Contact] <b>contact</b> <b>[0..1]</b> : An association to Contact.</li>
     *         <li>[Person] <b>person</b> <b>[0..1]</b> : An association to a person.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Party(PartyBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.partyIdentificationList = builder.partyIdentificationList;
        this.partyNameList = builder.partyNameList;
        this.postalAddress = builder.postalAddress;
        this.partyTaxSchemeList = builder.partyTaxSchemeList;
        this.partyLegalEntityList = builder.partyLegalEntityList;
        this.contact = builder.contact;
        this.person = builder.person;
    }

    /**
     * Builder Party
     */
    public static class PartyBuilder {

        private Document doc;
        private Element element;
        private List<PartyIdentification> partyIdentificationList = new ArrayList<>();
        private List<PartyName> partyNameList = new ArrayList<>();
        private PostalAddress postalAddress;
        private List<PartyTaxScheme> partyTaxSchemeList = new ArrayList<>();
        private List<PartyLegalEntity> partyLegalEntityList = new ArrayList<>();
        private Contact contact;
        private Person person;

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
        public PartyBuilder postalAddress(PostalAddress postalAddress){
            this.postalAddress = postalAddress;
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
        public PartyBuilder contact(Contact contact){
            this.contact = contact;
            return this;
        }
        public PartyBuilder person(Person person){
            this.person = person;
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

    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public List<PartyTaxScheme> getPartyTaxSchemeList() {
        return partyTaxSchemeList;
    }

    public List<PartyLegalEntity> getPartyLegalEntityList() {
        return partyLegalEntityList;
    }

    public Contact getContact() {
        return contact;
    }

    public Person getPerson() {
        return person;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementParty = new ElementT(doc,element, ElementsName.PARTY.label).load();
        //Party Identification
        if(!Tips.listIsNull(partyIdentificationList)) {
            for (PartyIdentification partyIdentification : partyIdentificationList) {
                Element elementPartyIdentification = new PartyIdentification.PartyIdentificationBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .id(partyIdentification.getId())
                        .build().load();
            }
        }
        if(!Tips.listIsNull(partyNameList)) {
            for (PartyName partyName : partyNameList) {
                Element elementPartyName = new PartyName.PartyNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .name(partyName.getName())
                        .build().load();
            }
        }
        if(!(postalAddress == null)){
            Element elementPostalAddress = new PostalAddress.PostalAddressBuilder()
                    .documentLinked(doc)
                    .elementFather(elementParty)
                    .addressFormatCode(postalAddress.getAddressFormatCode())
                    .postbox(postalAddress.getPostbox())
                    .streetName(postalAddress.getStreetName())
                    .buildingNumber(postalAddress.getBuildingNumber())
                    .cityName(postalAddress.getCityName())
                    .postalZone(postalAddress.getPostalZone())
                    .country(postalAddress.getCountry())
                    .build().load();
        }
        if(!Tips.listIsNull(partyTaxSchemeList)){
            for (PartyTaxScheme partyTaxScheme : partyTaxSchemeList) {
                Element elementPartyTaxScheme = new PartyTaxScheme.PartyTaxSchemeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .companyId(partyTaxScheme.getCompanyID())
                        .taxScheme(partyTaxScheme.getTaxScheme())
                        .build().load();
            }
        }
        if(!Tips.listIsNull(partyLegalEntityList)) {
            for (PartyLegalEntity partyLegalEntity : partyLegalEntityList) {
                Element elementPartyLegalEntity = new PartyLegalEntity.PartyLegalEntityBuilder()
                        .documentLinked(doc)
                        .elementFather(elementParty)
                        .registrationName(partyLegalEntity.getRegistrationName())
                        .companyId(partyLegalEntity.getCompanyID())
                        .registrationAddress(partyLegalEntity.getRegistrationAddress())
                        .corporateRegistrationScheme(partyLegalEntity.getCorporateRegistrationScheme())
                        .build().load();
            }
        }
        if(!(contact == null)){
            Element elementContact = new Contact.ContactBuilder()
                    .documentLinked(doc)
                    .elementFather(elementParty)
                    .id(contact.getId())
                    .name(contact.getName())
                    .telephone(contact.getTelephone())
                    .electronicMail(contact.getElectronicMail())
                    .note(contact.getNote())
                    .build().load();
        }
        if(!(person == null)){
            Element elementPerson = new Person.PersonBuilder()
                    .documentLinked(doc)
                    .elementFather(elementParty)
                    .firstName(person.getFirstName())
                    .familyName(person.getFamilyName())
                    .build().load();
        }
        return elementParty;
    }
}
