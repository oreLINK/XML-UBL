package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class InvoiceDocumentReference
 */
public class InvoiceDocumentReference {

    private Document doc;
    private Element element;
    private String id;

    /**
     * <h2>Element "InvoiceDocumentReference"</h2>
     * <i>use in BillingReference <b>[0..1]</b>.</i>
     * <p>An associative reference to Invoice. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>id</b> <b>[1..1]</b> : Identifies the document being referred to.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private InvoiceDocumentReference(InvoiceDocumentReferenceBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    /**
     * Builder InvoiceDocumentReference
     */
    public static class InvoiceDocumentReferenceBuilder {

        private Document doc;
        private Element element;
        private String id;

        public InvoiceDocumentReferenceBuilder() {}

        public InvoiceDocumentReferenceBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public InvoiceDocumentReferenceBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public InvoiceDocumentReferenceBuilder id(String id){
            this.id = id;
            return this;
        }
        public InvoiceDocumentReference build(){
            InvoiceDocumentReference invoiceDocumentReference = new InvoiceDocumentReference(this);
            return invoiceDocumentReference;
        }

    }

    public String getId() {
        return id;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementInvoiceDocumentReference = new ElementT(doc, element, ElementsName.INVOICE_DOCUMENT_REFERENCE.label).load();
        if(!Tips.stringIsNull(id)){
            Element elementId = new ElementT(doc, elementInvoiceDocumentReference, ElementsName.INVOICE_DOCUMENT_REFERENCE_ID.label, id).load();
        }
        return elementInvoiceDocumentReference;
    }
}
