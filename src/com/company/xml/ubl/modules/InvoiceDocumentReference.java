package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.ID;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class InvoiceDocumentReference
 */
public class InvoiceDocumentReference {

    /*private Document doc;
    private Element element;
    private String id;*/
    private Document doc;
    private Element element;
    private ID id;

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
        /*this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;*/
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    /**
     * Builder InvoiceDocumentReference
     */
    public static class InvoiceDocumentReferenceBuilder {

        /*private Document doc;
        private Element element;
        private String id;*/
        private Document doc;
        private Element element;
        private ID id;

        public InvoiceDocumentReferenceBuilder() {}

        /*public InvoiceDocumentReferenceBuilder documentLinked(Document doc){
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
        }*/
        public InvoiceDocumentReferenceBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public InvoiceDocumentReferenceBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public InvoiceDocumentReferenceBuilder id(ID id){
            this.id = id;
            return this;
        }
        public InvoiceDocumentReference build(){
            InvoiceDocumentReference invoiceDocumentReference = new InvoiceDocumentReference(this);
            return invoiceDocumentReference;
        }

    }

    /*public String getId() {
        return id;
    }*/

    public ID getId() {
        return id;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    /*public Element load() {
        Element elementInvoiceDocumentReference = new ElementT(doc, element, ElementsName.INVOICE_DOCUMENT_REFERENCE.label).load();
        if(!Tips.stringIsNull(id)){
            Element elementId = new ElementT(doc, elementInvoiceDocumentReference, ElementsName.INVOICE_DOCUMENT_REFERENCE_ID.label, id).load();
        }
        return elementInvoiceDocumentReference;
    }*/
    public Element load() {
        Element elementInvoiceDocumentReference = new ElementT(doc, element, ElementsName.INVOICE_DOCUMENT_REFERENCE.label).load();
        if(!(id == null)) {
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementInvoiceDocumentReference)
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
                        .elementFather(elementInvoiceDocumentReference)
                        .value(id.getValue())
                        .build().load();
            }
        }
        return elementInvoiceDocumentReference;
    }
}
