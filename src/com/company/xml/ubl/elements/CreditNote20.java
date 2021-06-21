package com.company.xml.ubl.elements;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.data.NamespacesName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class CreditNote20
 */
public class CreditNote20 {

    private Document doc;
    private String name = ElementsName.CREDIT_NOTE.label;

    /**
     * Documentation is coming...
     */
    private CreditNote20(CreditNote20Builder builder) {
        this.doc = builder.doc;
    }

    /**
     * Builder CreditNote20
     */
    public static class CreditNote20Builder {

        public CreditNote20Builder() {}

        private Document doc;

        public CreditNote20Builder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }

        public CreditNote20 build(){
            CreditNote20 creditNote20 = new CreditNote20(this);
            return creditNote20;
        }

    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document.
     * @return the generated element
     */
    public Element load() {
        Element elementCreditNote = new ElementT(doc, name).loadDoc();
        Attr attrEleCreditCard1 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS.label, NamespacesName.XMLNS_IMPORT.label).load();
        Attr attrEleCreditCard2 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_CAC_ATTR.label, NamespacesName.XMLNS_CAC_IMPORT.label).load();
        Attr attrEleCreditCard3 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_CBC_ATTR.label, NamespacesName.XMLNS_CBC_IMPORT.label).load();
        Attr attrEleCreditCard4 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_CCTS_ATTR.label, NamespacesName.XMLNS_CCTS_IMPORT.label).load();
        Attr attrEleCreditCard5 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_EXT_ATTR.label, NamespacesName.XMLNS_EXT_IMPORT.label).load();
        Attr attrEleCreditCard6 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_NS7_ATTR.label, NamespacesName.XMLNS_NS7_IMPORT.label).load();
        Attr attrEleCreditCard7 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_SDT_ATTR.label, NamespacesName.XMLNS_SDT_IMPORT.label).load();
        Attr attrEleCreditCard8 = new AttributeT(doc, elementCreditNote, NamespacesName.XMLNS_UDT_ATTR.label, NamespacesName.XMLNS_UDT_IMPORT.label).load();
        return elementCreditNote;
    }

}
