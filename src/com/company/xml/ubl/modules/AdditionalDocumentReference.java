package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.DocumentCurrencyCode;
import com.company.xml.ubl.elements.DocumentTypeCode;
import com.company.xml.ubl.elements.ID;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class AdditionalDocumentReference
 */
public class AdditionalDocumentReference {

    private Document doc;
    private Element element;
    private ID id;
    private DocumentTypeCode documentTypeCode;
    private Attachment attachment;

    /**
     * <h2>Element "AdditionalDocumentReference"</h2>
     * <i>use in CreditNote <b>[0..*]</b>.</i>
     * <p>An associative reference to Additional Document. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[ID] <b>id</b> <b>[1..1]</b> : Identifies the document being referred to.</li>
     *         <li>[DocumentTypeCode] <b>documentTypeCode</b> <b>[0..1]</b> : The document type, expressed as a code.</li>
     *         <li>[Attachment] <b>attachment</b> <b>[0..1]</b> : An attached document, externally referred to, referred to in the MIME location, or embedded.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private AdditionalDocumentReference(AdditionalDocumentReferenceBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.documentTypeCode = builder.documentTypeCode;
        this.attachment = builder.attachment;
    }

    /**
     * Builder AdditionalDocumentReference
     */
    public static class AdditionalDocumentReferenceBuilder {

        private Document doc;
        private Element element;
        private ID id;
        private DocumentTypeCode documentTypeCode;
        private Attachment attachment;

        public AdditionalDocumentReferenceBuilder() {}

        public AdditionalDocumentReferenceBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public AdditionalDocumentReferenceBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public AdditionalDocumentReferenceBuilder id(ID id){
            this.id = id;
            return this;
        }
        public AdditionalDocumentReferenceBuilder documentTypeCode(DocumentTypeCode documentTypeCode){
            this.documentTypeCode = documentTypeCode;
            return this;
        }
        public AdditionalDocumentReferenceBuilder attachment(Attachment attachment){
            this.attachment = attachment;
            return this;
        }
        public AdditionalDocumentReference build(){
            AdditionalDocumentReference additionalDocumentReference = new AdditionalDocumentReference(this);
            return additionalDocumentReference;
        }

    }

    public ID getId() {
        return id;
    }

    public DocumentTypeCode getDocumentTypeCode() {
        return documentTypeCode;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementAdditionalDocumentReference = new ElementT(doc, element, ElementsName.ADDITIONAL_DOCUMENT_REFERENCE.label).load();
        if(!id.isNull()){
            Element elementId = new ID.IDBuilder()
                    .documentLinked(doc)
                    .elementFather(elementAdditionalDocumentReference)
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
        }
        if(!documentTypeCode.isNull()){
            Element element = new DocumentTypeCode.DocumentTypeCodeBuilder()
                    .documentLinked(doc)
                    .elementFather(elementAdditionalDocumentReference)
                    .value(documentTypeCode.getValue())
                    .attributes(new PatternList.PatternListBuilder()
                            .listID(documentTypeCode.getPatternList().getListID())
                            .listAgencyID(documentTypeCode.getPatternList().getListAgencyID())
                            .listAgencyName(documentTypeCode.getPatternList().getListAgencyName())
                            .listName(documentTypeCode.getPatternList().getListName())
                            .listVersionID(documentTypeCode.getPatternList().getListVersionID())
                            .name(documentTypeCode.getPatternList().getName())
                            .languageID(documentTypeCode.getPatternList().getLanguageID())
                            .listURI(documentTypeCode.getPatternList().getListURI())
                            .listSchemeURI(documentTypeCode.getPatternList().getListSchemeURI())
                            .build())
                    .build().load();
        }
        if(!attachment.isNull()){
            Element elementAttachment = new Attachment.AttachmentBuilder()
                    .documentLinked(doc)
                    .elementFather(elementAdditionalDocumentReference)
                    .embeddedDocumentBinaryObject(attachment.getEmbeddedDocumentBinaryObject())
                    .build().load();
        }
        return elementAdditionalDocumentReference;
    }
}
