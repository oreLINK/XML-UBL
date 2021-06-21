package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
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
    private String id;
    private String documentTypeCode;
    private String documentTypeCode_AttributeListID;
    private List<Attachment> attachmentList = new ArrayList<>();

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
     *         <li>[String] <b>id</b> <b>[1..1]</b> : Identifies the document being referred to.</li>
     *         <li>[String] <b>documentTypeCode</b> <b>[0..1]</b> : The document type, expressed as a code.</li>
     *         <li>[String] <b>documentTypeCode_AttributeListID</b> <b>[0..1]</b> : The identification of a list of codes. (Attribute)</li>
     *         <li>[List] <b>attachmentList</b> <b>[0..1]</b> : [Attachment] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private AdditionalDocumentReference(AdditionalDocumentReferenceBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.documentTypeCode = builder.documentTypeCode;
        this.documentTypeCode_AttributeListID = builder.documentTypeCode_AttributeListID;
        this.attachmentList = builder.attachmentList;
    }

    /**
     * Builder AdditionalDocumentReference
     */
    public static class AdditionalDocumentReferenceBuilder {

        private Document doc;
        private Element element;
        private String id;
        private String documentTypeCode;
        private String documentTypeCode_AttributeListID;
        private List<Attachment> attachmentList = new ArrayList<>();

        public AdditionalDocumentReferenceBuilder() {}

        public AdditionalDocumentReferenceBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public AdditionalDocumentReferenceBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public AdditionalDocumentReferenceBuilder id(String id){
            this.id = id;
            return this;
        }
        public AdditionalDocumentReferenceBuilder documentTypeCode(String documentTypeCode){
            this.documentTypeCode = documentTypeCode;
            return this;
        }
        public AdditionalDocumentReferenceBuilder documentTypeCode_AttributeListID(String documentTypeCode_AttributeListID){
            this.documentTypeCode_AttributeListID = documentTypeCode_AttributeListID;
            return this;
        }
        public AdditionalDocumentReferenceBuilder attachmentList(List<Attachment> attachmentList){
            this.attachmentList = attachmentList;
            return this;
        }
        public AdditionalDocumentReference build(){
            AdditionalDocumentReference additionalDocumentReference = new AdditionalDocumentReference(this);
            return additionalDocumentReference;
        }

    }

    public String getId() {
        return id;
    }

    public String getDocumentTypeCode() {
        return documentTypeCode;
    }

    public String getDocumentTypeCode_AttributeListID() {
        return documentTypeCode_AttributeListID;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementAdditionalDocumentReference = new ElementT(doc, element, ElementsName.ADDITIONAL_DOCUMENT_REFERENCE.label).load();
        if(!Tips.stringIsNull(id)){
            Element elementId = new ElementT(doc, elementAdditionalDocumentReference, ElementsName.ID.label, id).load();
        }
        if(!Tips.stringIsNull(documentTypeCode)){
            Element elementDocumentTypeCode = new ElementT(doc, elementAdditionalDocumentReference, ElementsName.ADDITIONAL_DOCUMENT_REFERENCE_DOCUMENT_TYPE_CODE.label, documentTypeCode).load();
            if(!Tips.stringIsNull(documentTypeCode_AttributeListID)){
                Attr elementDocumentTypeCode_Attr1 = new AttributeT(doc, elementDocumentTypeCode, AttributesName.LIST_ID.label, documentTypeCode_AttributeListID).load();
            }
        }
        if(!Tips.listIsNull(attachmentList)){
            for (Attachment attachment : attachmentList) {
                Element elementAttachment = new Attachment.AttachmentBuilder()
                        .documentLinked(doc)
                        .elementFather(elementAdditionalDocumentReference)
                        .embeddedDocumentBinaryObject(attachment.getEmbeddedDocumentBinaryObject())
                        .embeddedDocumentBinaryObject_AttributeEncodingCode(attachment.getEmbeddedDocumentBinaryObject_AttributeEncodingCode())
                        .embeddedDocumentBinaryObject_AttributeFilename(attachment.getEmbeddedDocumentBinaryObject_AttributeFilename())
                        .embeddedDocumentBinaryObject_AttributeMimeCode(attachment.getEmbeddedDocumentBinaryObject_AttributeMimeCode())
                        .build().load();
            }
        }
        return elementAdditionalDocumentReference;
    }
}
