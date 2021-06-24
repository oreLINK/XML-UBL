package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternFile;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.EmbeddedDocumentBinaryObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Attachment
 */
public class Attachment {

    private Document doc;
    private Element element;
    private EmbeddedDocumentBinaryObject embeddedDocumentBinaryObject;

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
     *         <li>[EmbeddedDocumentBinaryObject] <b>embeddedDocumentBinaryObject</b> <b>[0..1]</b> : Contains an embedded document as a BLOB (binary large object).</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Attachment(AttachmentBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.embeddedDocumentBinaryObject = builder.embeddedDocumentBinaryObject;
    }

    /**
     * Builder Attachment
     */
    public static class AttachmentBuilder {

        private Document doc;
        private Element element;
        private EmbeddedDocumentBinaryObject embeddedDocumentBinaryObject;

        public AttachmentBuilder() {}

        public AttachmentBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public AttachmentBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public AttachmentBuilder embeddedDocumentBinaryObject(EmbeddedDocumentBinaryObject embeddedDocumentBinaryObject){
            this.embeddedDocumentBinaryObject = embeddedDocumentBinaryObject;
            return this;
        }
        public Attachment build(){
            Attachment attachment = new Attachment(this);
            return attachment;
        }

    }

    public EmbeddedDocumentBinaryObject getEmbeddedDocumentBinaryObject() {
        return embeddedDocumentBinaryObject;
    }

    public boolean isNull() {
        if(embeddedDocumentBinaryObject.isNull()){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementAttachment = new ElementT(doc, element, ElementsName.ATTACHMENT.label).load();
        if(!(embeddedDocumentBinaryObject == null)){
            if(!(embeddedDocumentBinaryObject.getPatternFile() == null)){
                Element elementEmbeddedDocumentBinaryObject = new EmbeddedDocumentBinaryObject.EmbeddedDocumentBinaryObjectBuilder()
                        .documentLinked(doc)
                        .elementFather(elementAttachment)
                        .value(embeddedDocumentBinaryObject.getValue())
                        .attributes(new PatternFile.PatternFileBuilder()
                                .format(embeddedDocumentBinaryObject.getPatternFile().getFormat())
                                .mimeCode(embeddedDocumentBinaryObject.getPatternFile().getMimeCode())
                                .encodingCode(embeddedDocumentBinaryObject.getPatternFile().getEncodingCode())
                                .characterSetCode(embeddedDocumentBinaryObject.getPatternFile().getCharacterSetCode())
                                .uri(embeddedDocumentBinaryObject.getPatternFile().getUri())
                                .filename(embeddedDocumentBinaryObject.getPatternFile().getFilename())
                                .build())
                        .build().load();
            } else {
                Element elementEmbeddedDocumentBinaryObject = new EmbeddedDocumentBinaryObject.EmbeddedDocumentBinaryObjectBuilder()
                        .documentLinked(doc)
                        .elementFather(elementAttachment)
                        .value(embeddedDocumentBinaryObject.getValue())
                        .build().load();
            }
        }
        return elementAttachment;
    }
}
