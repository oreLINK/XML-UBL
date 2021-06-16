package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Person {

    private Document doc;
    private Element element;
    private String firstName;
    private String familyName;

    private Person(PersonBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.firstName = builder.firstName;
        this.familyName = builder.familyName;
    }

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
