package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.ID;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Item
 */
public class SellersItemIdentification {

    private Document doc;
    private Element element;
    private ID id;

    /**
     * <h2>Element "SellersItemIdentification"</h2>
     * <p>Associates the item with its identification according to the seller's system. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[ID] <b>id</b> <b>[1..1]</b> : An identifier for an item.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private SellersItemIdentification(SellersItemIdentificationBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    /**
     * Builder SellersItemIdentification
     */
    public static class SellersItemIdentificationBuilder {

        private Document doc;
        private Element element;
        private ID id;

        public SellersItemIdentificationBuilder() {}

        public SellersItemIdentificationBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public SellersItemIdentificationBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public SellersItemIdentificationBuilder id(ID id){
            this.id = id;
            return this;
        }
        public SellersItemIdentification build(){
            SellersItemIdentification sellersItemIdentification = new SellersItemIdentification(this);
            return sellersItemIdentification;
        }

    }

    public ID getId() {
        return id;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementSellersItemIdentification = new ElementT(doc, element, ElementsName.SELLERS_ITEM_IDENTIFICATION.label).load();
        if(!(id == null)) {
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementSellersItemIdentification)
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
                        .elementFather(elementSellersItemIdentification)
                        .value(id.getValue())
                        .build().load();
            }
        }
        return elementSellersItemIdentification;
    }

}
