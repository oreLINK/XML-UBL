package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
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

    private BillingReference(BillingReferenceBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.invoiceDocumentReferenceList = builder.invoiceDocumentReferenceList;
    }

    public static class BillingReferenceBuilder {

        private Document doc;
        private Element element;
        private List<InvoiceDocumentReference> invoiceDocumentReferenceList;

        public BillingReferenceBuilder() {}

        public BillingReferenceBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public BillingReferenceBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public BillingReferenceBuilder invoiceDocumentReferenceList(List<InvoiceDocumentReference> invoiceDocumentReferenceList){
            this.invoiceDocumentReferenceList = invoiceDocumentReferenceList;
            return this;
        }
        public BillingReference build(){
            BillingReference billingReference = new BillingReference(this);
            return billingReference;
        }

    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementBillingReference = new ElementT(doc, element, ElementsName.BILLING_REFERENCE.label).load();
        if(!Tips.listIsNull(invoiceDocumentReferenceList)) {
            for (InvoiceDocumentReference invoiceDocumentReference : invoiceDocumentReferenceList) {
                Element elementInvoiceDocumentReference = new InvoiceDocumentReference.InvoiceDocumentReferenceBuilder()
                        .documentLinked(doc)
                        .elementFather(elementBillingReference)
                        .id(invoiceDocumentReference.getId())
                        .build().load();
            }
        }
        return elementBillingReference;
    }

}
