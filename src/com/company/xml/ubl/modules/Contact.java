package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternLanguage;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Contact
 */
public class Contact {

    private Document doc;
    private Element element;
    private ID id;
    private Name name;
    private Telephone telephone;
    private ElectronicMail electronicMail;
    private Note note;

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
     *         <li>[ID] <b>id</b> <b>[0..1]</b> : An identifier for the Contact.</li>
     *         <li>[Name] <b>name</b> <b>[0..1]</b> : The name of the Contact.</li>
     *         <li>[Telephone] <b>telephone</b> <b>[0..1]</b> : The telephone number of the Contact.</li>
     *         <li>[ElectronicMail] <b>electronicMail</b> <b>[0..1]</b> : The email address of the Contact.</li>
     *         <li>[Note] <b>note</b> <b>[0..1]</b> : A note such as 'Emergency' or 'After Hours' describing the circumstances in which the Contact can be used.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Contact(ContactBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
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
        private ID id;
        private Name name;
        private Telephone telephone;
        private ElectronicMail electronicMail;
        private Note note;

        public ContactBuilder() {}

       public ContactBuilder documentLinked(Document doc){
           this.doc = doc;
           return this;
       }
        public ContactBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public ContactBuilder id(ID id){
            this.id = id;
            return this;
        }
        public ContactBuilder name(Name name){
            this.name = name;
            return this;
        }
        public ContactBuilder telephone(Telephone telephone){
            this.telephone = telephone;
            return this;
        }
        public ContactBuilder electronicMail(ElectronicMail electronicMail){
            this.electronicMail = electronicMail;
            return this;
        }
        public ContactBuilder note(Note note){
            this.note = note;
            return this;
        }
        public Contact build(){
            Contact contact = new Contact(this);
            return contact;
        }

    }

    public ID getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public ElectronicMail getElectronicMail() {
        return electronicMail;
    }

    public Note getNote() {
        return note;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementContact = new ElementT(doc, element, ElementsName.CONTACT.label).load();
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(id.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(id.getPatternScheme().getSchemeID())
                                .schemeName(id.getPatternScheme().getSchemeName())
                                .schemeAgencyID(id.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(id.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(id.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(id.getPatternScheme().getSchemeDataURI())
                                .schemeURI(id.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(id.getValue())
                        .build().load();
            }
        }
        if(!(name == null)){
            if(!(name.getPatternLanguage() == null)){
                Element elementName = new Name.NameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(name.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(name.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementName = new Name.NameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(name.getValue())
                        .build().load();
            }
        }
        if(!(telephone == null)){
            if(!(telephone.getPatternLanguage() == null)){
                Element elementTelephone = new Telephone.TelephoneBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(telephone.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(telephone.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementTelephone = new Telephone.TelephoneBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(telephone.getValue())
                        .build().load();
            }
        }
        if(!(electronicMail == null)){
            if(!(electronicMail.getPatternLanguage() == null)){
                Element elementElectronicMail = new ElectronicMail.ElectronicMailBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(electronicMail.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(electronicMail.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementElectronicMail = new ElectronicMail.ElectronicMailBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(electronicMail.getValue())
                        .build().load();
            }
        }
        if(!(note == null)){
            if(!(note.getPatternLanguage() == null)){
                Element elementNote = new Note.NoteBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(note.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(note.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementNote = new Note.NoteBuilder()
                        .documentLinked(doc)
                        .elementFather(elementContact)
                        .value(note.getValue())
                        .build().load();
            }
        }
        return elementContact;
    }

}
