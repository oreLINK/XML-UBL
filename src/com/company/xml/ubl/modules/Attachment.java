package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Attachment
 */
public class Attachment {

    private Document doc;
    private Element element;
    private String embeddedDocumentBinaryObject;
    private String embeddedDocumentBinaryObject_AttributeEncodingCode;
    private String embeddedDocumentBinaryObject_AttributeFilename;
    private String embeddedDocumentBinaryObject_AttributeMimeCode;

    /**
     * <h2>Element "Attachment"</h2>
     * <i>use in AdditionalDocumentReference <b>[0..1]</b>.</i>
     * <p>An attached document, externally referred to, referred to in the MIME location, or embedded. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>embeddedDocumentBinaryObject</b> <b>[0..1]</b> : Contains an embedded document as a BLOB (binary large object).</li>
     *         <li>[String] <b>embeddedDocumentBinaryObject_AttributeEncodingCode</b> <b>[0..1]</b> : Specifies the decoding algorithm of the binary object. (Attribute)</li>
     *         <li>[String] <b>embeddedDocumentBinaryObject_AttributeFilename</b> <b>[0..1]</b> : The filename of the binary object. (Attribute)</li>
     *         <li>[String] <b>embeddedDocumentBinaryObject_AttributeMimeCode</b> <b>[1..1]</b> : The mime type of the binary object. (Attribute)</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Attachment(AttachmentBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.embeddedDocumentBinaryObject = builder.embeddedDocumentBinaryObject;
        this.embeddedDocumentBinaryObject_AttributeEncodingCode = builder.embeddedDocumentBinaryObject_AttributeEncodingCode;
        this.embeddedDocumentBinaryObject_AttributeFilename = builder.embeddedDocumentBinaryObject_AttributeFilename;
        this.embeddedDocumentBinaryObject_AttributeMimeCode = builder.embeddedDocumentBinaryObject_AttributeMimeCode;
    }

    /**
     * Builder Attachment
     */
    public static class AttachmentBuilder {

        private Document doc;
        private Element element;
        private String embeddedDocumentBinaryObject;
        private String embeddedDocumentBinaryObject_AttributeEncodingCode;
        private String embeddedDocumentBinaryObject_AttributeFilename;
        private String embeddedDocumentBinaryObject_AttributeMimeCode;

        public AttachmentBuilder() {}

        public AttachmentBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public AttachmentBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public AttachmentBuilder embeddedDocumentBinaryObject(String embeddedDocumentBinaryObject){
            this.embeddedDocumentBinaryObject = embeddedDocumentBinaryObject;
            return this;
        }
        public AttachmentBuilder embeddedDocumentBinaryObject_AttributeEncodingCode(String embeddedDocumentBinaryObject_AttributeEncodingCode){
            this.embeddedDocumentBinaryObject_AttributeEncodingCode = embeddedDocumentBinaryObject_AttributeEncodingCode;
            return this;
        }
        public AttachmentBuilder embeddedDocumentBinaryObject_AttributeFilename(String embeddedDocumentBinaryObject_AttributeFilename){
            this.embeddedDocumentBinaryObject_AttributeFilename = embeddedDocumentBinaryObject_AttributeFilename;
            return this;
        }
        public AttachmentBuilder embeddedDocumentBinaryObject_AttributeMimeCode(String embeddedDocumentBinaryObject_AttributeMimeCode){
            this.embeddedDocumentBinaryObject_AttributeMimeCode = embeddedDocumentBinaryObject_AttributeMimeCode;
            return this;
        }
        public Attachment build(){
            Attachment attachment = new Attachment(this);
            return attachment;
        }

    }

    public String getEmbeddedDocumentBinaryObject_AttributeEncodingCode() {
        return embeddedDocumentBinaryObject_AttributeEncodingCode;
    }

    public String getEmbeddedDocumentBinaryObject_AttributeFilename() {
        return embeddedDocumentBinaryObject_AttributeFilename;
    }

    public String getEmbeddedDocumentBinaryObject_AttributeMimeCode() {
        return embeddedDocumentBinaryObject_AttributeMimeCode;
    }

    public String getEmbeddedDocumentBinaryObject() {
        return embeddedDocumentBinaryObject;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementAttachment = new ElementT(doc, element, ElementsName.ATTACHMENT.label).load();
        if(!Tips.stringIsNull(embeddedDocumentBinaryObject)){
            Element elementEmbeddedDocumentBinaryObject = new ElementT(doc, elementAttachment, ElementsName.ATTACHMENT_EMBEDDED_DOCUMENT_BINARY_OBJECT.label, embeddedDocumentBinaryObject).load();
            if(!Tips.stringIsNull(embeddedDocumentBinaryObject_AttributeEncodingCode)){
                Attr elementEmbeddedDocumentBinaryObject_Attr1 = new AttributeT(doc, elementEmbeddedDocumentBinaryObject, AttributesName.ENCODING_CODE.label, embeddedDocumentBinaryObject_AttributeEncodingCode).load();
            }
            if(!Tips.stringIsNull(embeddedDocumentBinaryObject_AttributeFilename)){
                Attr elementEmbeddedDocumentBinaryObject_Attr2 = new AttributeT(doc, elementEmbeddedDocumentBinaryObject, AttributesName.FILE_NAME.label, embeddedDocumentBinaryObject_AttributeFilename).load();
            }
            if(!Tips.stringIsNull(embeddedDocumentBinaryObject_AttributeMimeCode)){
                Attr elementEmbeddedDocumentBinaryObject_Attr3 = new AttributeT(doc, elementEmbeddedDocumentBinaryObject, AttributesName.MIME_CODE.label, embeddedDocumentBinaryObject_AttributeMimeCode).load();
            }
        }
        return elementAttachment;
    }
}
