package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Contact {

    private Document doc;
    private Element element;
    private String id;
    private String id_AttributeSchemeURI;
    private String name;
    private String telephone;
    private String electronicMail;
    private String note;

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
