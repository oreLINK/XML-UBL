package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Contact
 */
public class Contact {

    private Document doc;
    private Element element;
    private String id;
    private String id_AttributeSchemeURI;
    private String name;
    private String telephone;
    private String electronicMail;
    private String note;

    /**
     * <h2>Element "Contact"</h2>
     * <i>use in Party <b>[0..1]</b>.</i>
     * <p>An association to Contact. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>id</b> <b>[0..1]</b> : An identifier for the Contact.</li>
     *         <li>[String] <b>id_AttributeSchemeURI</b> <b>[0..1]</b> : The Uniform Resource Identifier that identifies where the identification scheme is located. (Attribute)</li>
     *         <li>[String] <b>name</b> <b>[0..1]</b> : The name of the Contact.</li>
     *         <li>[String] <b>telephone</b> <b>[0..1]</b> : The telephone number of the Contact.</li>
     *         <li>[String] <b>electronicMail</b> <b>[0..1]</b> : The email address of the Contact.</li>
     *         <li>[String] <b>note</b> <b>[0..1]</b> : A note such as 'Emergency' or 'After Hours' describing the circumstances in which the Contact can be used.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Contact(ContactBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.id_AttributeSchemeURI = builder.id_AttributeSchemeURI;
        this.name = builder.name;
        this.telephone = builder.telephone;
        this.electronicMail = builder.electronicMail;
        this.note = builder.note;
    }

    /**
     * Builder Contact
     */
    public static class ContactBuilder {

        private Document doc;
        private Element element;
        private String id;
        private String id_AttributeSchemeURI;
        private String name;
        private String telephone;
        private String electronicMail;
        private String note;

        public ContactBuilder() {}

        public ContactBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public ContactBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public ContactBuilder id(String id){
            this.id = id;
            return this;
        }
        public ContactBuilder id_AttributeSchemeURI(String id_AttributeSchemeURI){
            this.id_AttributeSchemeURI = id_AttributeSchemeURI;
            return this;
        }
        public ContactBuilder name(String name){
            this.name = name;
            return this;
        }
        public ContactBuilder telephone(String telephone){
            this.telephone = telephone;
            return this;
        }
        public ContactBuilder electronicMail(String electronicMail){
            this.electronicMail = electronicMail;
            return this;
        }
        public ContactBuilder note(String note){
            this.note = note;
            return this;
        }
        public Contact build(){
            Contact contact = new Contact(this);
            return contact;
        }

    }

    public String getId() {
        return id;
    }

    public String getId_AttributeSchemeURI() {
        return id_AttributeSchemeURI;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getElectronicMail() {
        return electronicMail;
    }

    public String getNote() {
        return note;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        //Generate root element
        Element elementContact = new ElementT(doc, element, ElementsName.CONTACT.label).load();
        //Generate tag "ID" and attribute "schemeURI"
        if(!Tips.stringIsNull(id)){
            Element elementId = new ElementT(doc, elementContact, ElementsName.CONTACT_ID.label, id).load();
            if(!Tips.stringIsNull(id_AttributeSchemeURI)){
                Attr elementId_Attr1 = new AttributeT(doc, elementId, AttributesName.CONTACT_ID_SCHEME_URI.label, id_AttributeSchemeURI).load();
            }
        }
        //Generate tag "Name"
        if(!Tips.stringIsNull(name)){
            Element elementName = new ElementT(doc, elementContact, ElementsName.CONTACT_NAME.label, name).load();
        }
        //Generate tag "Telephone"
        if(!Tips.stringIsNull(telephone)){
            Element elementTelephone = new ElementT(doc, elementContact, ElementsName.CONTACT_TELEPHONE.label, telephone).load();
        }
        //Generate tag "ElectronicMail"
        if(!Tips.stringIsNull(electronicMail)){
            Element elementElectronicMail = new ElementT(doc, elementContact, ElementsName.CONTACT_ELECTRONIC_MAIL.label, electronicMail).load();
        }
        //Generate tag "Note"
        if(!Tips.stringIsNull(note)){
            Element elementNote = new ElementT(doc, elementContact, ElementsName.CONTACT_NOTE.label, note).load();
        }
        return elementContact;
    }

}
