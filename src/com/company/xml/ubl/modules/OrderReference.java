package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class OrderReference
 * use in CreditNote.
 */
public class OrderReference {

    private Document doc;
    private Element element;
    private String ID;

    /**
     * Constructor to declare this tag if it will be declared in another tag already declared
     * @param doc document where this tag will be declared
     * @param element element from which this tag will inherit
     * @param ID parameter to enter (obligatory)
     */
    public OrderReference(Document doc, Element element, String ID) {
        this.doc = doc;
        this.element = element;
        this.ID = ID;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element eleOrderReference = new ElementT(doc, element, ElementsName.ORDER_REFERENCE.label).load();
        Element eleOrderReference_id = new ElementT(doc, eleOrderReference, ElementsName.ID.label, ID).load();
        return eleOrderReference;
    }
}
