package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

/**
 * Class BillingReference
 * use in CreditNote.
 */
public class BillingReference {

    private Document doc;
    private Element element;
    private List<InvoiceDocumentReference> invoiceDocumentReferenceList;

    /**
     * Constructor to declare this tag if it will be declared in another tag already declared
     * @param doc document where this tag will be declared
     * @param element element from which this tag will inherit
     * @param invoiceDocumentReferenceList parameter to enter (obligatory)
     */
    public BillingReference(Document doc, Element element, List<InvoiceDocumentReference> invoiceDocumentReferenceList) {
        this.doc = doc;
        this.element = element;
        this.invoiceDocumentReferenceList = invoiceDocumentReferenceList;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element eleBillingReference = new ElementT(doc, element, ElementsName.BILLING_REFERENCE.label).load();
        if(!invoiceDocumentReferenceList.isEmpty() && invoiceDocumentReferenceList.size() != 0) {
            for (InvoiceDocumentReference invoiceDocumentReference : invoiceDocumentReferenceList) {
                Element eleInvoiceDocumentReference = new InvoiceDocumentReference(doc, eleBillingReference, invoiceDocumentReference.getId()).load();
            }
        }
        return eleBillingReference;
    }

}
