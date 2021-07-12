package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternLanguage;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class FamilyName
 */
public class FamilyName {

    private Document doc;
    private Element element;
    private String name = ElementsName.FAMILY_NAME.label;
    private String value;
    private PatternLanguage patternLanguage;

    /**
     * <h2>Element "FamilyName"</h2>
     * <p>A person's surname or family name. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>value</b> <b>[1..1]</b> : Value for this element.</li>
     *         <li>[PatternLanguage] <b>patternLanguage</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private FamilyName(FamilyNameBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternLanguage = builder.patternLanguage;
    }

    /**
     * Builder FamilyName
     */
    public static class FamilyNameBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternLanguage patternLanguage;

        public FamilyNameBuilder() {}

        public FamilyNameBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public FamilyNameBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public FamilyNameBuilder value(String value){
            this.value = value;
            return this;
        }
        public FamilyNameBuilder attributes(PatternLanguage patternLanguage){
            this.patternLanguage = patternLanguage;
            return this;
        }
        public FamilyName build(){
            FamilyName elementBuild = new FamilyName(this);
            return elementBuild;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternLanguage getPatternLanguage() {
        return patternLanguage;
    }

    public boolean isNull() {
        if(Tips.stringIsNull(value)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementRoot = new ElementT(doc, element, name, value).load();
        if(!(patternLanguage == null)){
            if(!(patternLanguage.getLanguageID() == null)){
                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.LANGUAGE_ID.label, patternLanguage.getLanguageID()).load();
            }
        }
        return elementRoot;
    }

}
