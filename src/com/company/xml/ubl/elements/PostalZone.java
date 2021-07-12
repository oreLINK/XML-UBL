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
 * Class PostalZone
 */
public class PostalZone {

    private Document doc;
    private Element element;
    private String name = ElementsName.POSTAL_ZONE.label;
    private String value;
    private PatternLanguage patternLanguage;

    /**
     * <h2>Element "PostalZone"</h2>
     * <p>The identifier for an addressable group of properties according to the relevant national postal service, such as a ZIP code or Post Code. Contains :</p>
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
    private PostalZone(PostalZoneBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternLanguage = builder.patternLanguage;
    }

    /**
     * Builder PostalZone
     */
    public static class PostalZoneBuilder {

        private Document doc;
        private Element element;
        private String name = ElementsName.NAME.label;
        private String value;
        private PatternLanguage patternLanguage;

        public PostalZoneBuilder() {}

        public PostalZoneBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PostalZoneBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PostalZoneBuilder value(String value){
            this.value = value;
            return this;
        }
        public PostalZoneBuilder attributes(PatternLanguage patternLanguage){
            this.patternLanguage = patternLanguage;
            return this;
        }
        public PostalZone build(){
            PostalZone elementBuild = new PostalZone(this);
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
