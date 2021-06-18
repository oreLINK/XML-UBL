package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Person
 */
public class Person {

    private Document doc;
    private Element element;
    private String firstName;
    private String familyName;

    /**
     * <h2>Element "Person"</h2>
     * <i>use in Party <b>[0..1]</b>.</i>
     * <p>An association to a person. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>firstName</b> <b>[0..1]</b> : A person's forename or first name.</li>
     *         <li>[String] <b>familyName</b> <b>[0..1]</b> : A person's surname or family name.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Person(PersonBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.firstName = builder.firstName;
        this.familyName = builder.familyName;
    }

    /**
     * Builder Person
     */
    public static class PersonBuilder {

        private Document doc;
        private Element element;
        private String firstName;
        private String familyName;

        public PersonBuilder() {}

        public PersonBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PersonBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PersonBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public PersonBuilder familyName(String familyName){
            this.familyName = familyName;
            return this;
        }
        public Person build(){
            Person person = new Person(this);
            return person;
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        //Generate root element
        Element elementPerson = new ElementT(doc, element, ElementsName.PERSON.label).load();
        //Generate tag "FirstName"
        if(!Tips.stringIsNull(firstName)){
            Element elementFirstName = new ElementT(doc, elementPerson, ElementsName.PERSON_FIRST_NAME.label, firstName).load();
        }
        //Generate tag "FamilyName"
        if(!Tips.stringIsNull(familyName)){
            Element elementFamilyName = new ElementT(doc, elementPerson, ElementsName.PERSON_FAMILY_NAME.label, familyName).load();
        }
        return elementPerson;
    }

}
