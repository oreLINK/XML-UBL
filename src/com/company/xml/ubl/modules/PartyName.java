package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class PartyName
 */
public class PartyName {

    private Document doc;
    private Element element;
    private String name;

    /**
     * <h2>Element "PartyName"</h2>
     * <i>use in Party <b>[0..*]</b>.</i>
     * <p>An association to Party Name. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>name</b> <b>[1..1]</b> : The name of the party.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PartyName(PartyNameBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.name = builder.name;
    }

    /**
     * Builder PartyName
     */
    public static class PartyNameBuilder {

        private Document doc;
        private Element element;
        private String name;

        public PartyNameBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PartyNameBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyNameBuilder name(String name){
            this.name = name;
            return this;
        }
        public PartyName build(){
            PartyName partyName = new PartyName(this);
            return partyName;
        }

    }

    public String getName() {
        return name;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementPartyName = new ElementT(doc, element, ElementsName.PARTY_NAME.label).load();
        Element elementPartyNameName = new ElementT(doc, elementPartyName, ElementsName.PARTY_NAME_NAME.label, name).load();
        return elementPartyName;
    }
}
