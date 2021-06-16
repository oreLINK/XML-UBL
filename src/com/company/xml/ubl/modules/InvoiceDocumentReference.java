package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class InvoiceDocumentReference
 * use in BillingReference.
 */
public class InvoiceDocumentReference {

    private Document doc;
    private Element element;
    private String id; //obligatory

    /**
     * Constructor to declare this tag if it will be declared in another tag to declare and / or because this tag is not the only one in the other tag to declare (to put in a list)
     * @param id parameter to enter
     */
    public InvoiceDocumentReference(String id) {
        this.id = id;
    }

    /**
     * Constructor to declare this tag if it will be declared in another tag already declared
     * @param doc document where this tag will be declared
     * @param element element from which this tag will inherit
     * @param id parameter to enter (obligatory)
     */
    public InvoiceDocumentReference(Document doc, Element element, String id) {
        this.doc = doc;
        this.element = element;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element eleInvoiceDocumentReference = new ElementT(doc, element, ElementsName.INVOICE_DOCUMENT_REFERENCE.label).load();
        Element eleInvoiceDocumentReference_id = new ElementT(doc, eleInvoiceDocumentReference, ElementsName.ID.label, id).load();
        return eleInvoiceDocumentReference;
    }
}
