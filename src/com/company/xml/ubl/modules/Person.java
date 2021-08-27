package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternLanguage;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.FamilyName;
import com.company.xml.ubl.elements.FirstName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Person
 */
public class Person {

    private Document doc;
    private Element element;
    private FirstName firstName;
    private FamilyName familyName;

    /**
     * <h2>Element "Person"</h2>
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
     *         <li>[FirstName] <b>firstName</b> <b>[0..1]</b> : A person's forename or first name.</li>
     *         <li>[FamilyName] <b>familyName</b> <b>[0..1]</b> : A person's surname or family name.</li>
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
        private FirstName firstName;
        private FamilyName familyName;

        public PersonBuilder() {}

        public PersonBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PersonBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PersonBuilder firstName(FirstName firstName){
            this.firstName = firstName;
            return this;
        }
        public PersonBuilder familyName(FamilyName familyName){
            this.familyName = familyName;
            return this;
        }
        public Person build(){
            Person person = new Person(this);
            return person;
        }

    }

    public FirstName getFirstName() {
        return firstName;
    }

    public FamilyName getFamilyName() {
        return familyName;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementPerson = new ElementT(doc, element, ElementsName.PERSON.label).load();
        if(!(firstName == null)){
            if(!(firstName.getPatternLanguage() == null)){
                Element elementFirstName = new FirstName.FirstNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPerson)
                        .value(firstName.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(firstName.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementFirstName = new FirstName.FirstNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPerson)
                        .value(firstName.getValue())
                        .build().load();
            }
        }
        if(!(familyName == null)){
            if(!(familyName.getPatternLanguage() == null)){
                Element elementFamilyName = new FamilyName.FamilyNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPerson)
                        .value(familyName.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(familyName.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementFamilyName = new FamilyName.FamilyNameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPerson)
                        .value(familyName.getValue())
                        .build().load();
            }
        }
        return elementPerson;
    }

}
