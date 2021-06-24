package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.ID;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class PartyIdentification
 */
public class PartyIdentification {

    private Document doc;
    private Element element;
    private ID id;

    /**
     * <h2>Element "PartyIdentification"</h2>
     * <i>use in Party <b>[0..*]</b>.</i>
     * <p>An association to Party Identification. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[ID] <b>id</b> <b>[1..1]</b> : Identifies a party.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PartyIdentification(PartyIdentificationBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    /**
     * Builder PartyIdentification
     */
    public static class PartyIdentificationBuilder {

        private Document doc;
        private Element element;
        private ID id;

        public PartyIdentificationBuilder() {}

        public PartyIdentificationBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PartyIdentificationBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyIdentificationBuilder id(ID id){
            this.id = id;
            return this;
        }
        public PartyIdentification build(){
            PartyIdentification partyIdentification = new PartyIdentification(this);
            return partyIdentification;
        }

    }

    public ID getId() {
        return id;
    }

    public boolean isNull() {
        if(id.isNull()){
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
        Element elementPartyIdentification = new ElementT(doc, element, ElementsName.PARTY_IDENTIFICATION.label).load();
        if(!(id == null)) {
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyIdentification)
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
                        .elementFather(elementPartyIdentification)
                        .value(id.getValue())
                        .build().load();
            }
        }
        return elementPartyIdentification;
    }
}
