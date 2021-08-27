package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternFile;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EmbeddedDocumentBinaryObject {

    private Document doc;
    private Element element;
    private String name = ElementsName.EMBEDDED_DOCUMENT_BINARY_OBJECT.label;
    private String value;
    private PatternFile patternFile;

    /**
     * <h2>Element "EmbeddedDocumentBinaryObject"</h2>
     * <p>Contains an embedded document as a BLOB (binary large object). Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>value</b> <b>[1..1]</b> : Value for this element.</li>
     *         <li>[PatternFile] <b>patternFile</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private EmbeddedDocumentBinaryObject(EmbeddedDocumentBinaryObjectBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternFile = builder.patternFile;
    }

    /**
     * Builder EmbeddedDocumentBinaryObject
     */
    public static class EmbeddedDocumentBinaryObjectBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternFile patternFile;

        public EmbeddedDocumentBinaryObjectBuilder() {}

        public EmbeddedDocumentBinaryObjectBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public EmbeddedDocumentBinaryObjectBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public EmbeddedDocumentBinaryObjectBuilder value(String value){
            this.value = value;
            return this;
        }
        public EmbeddedDocumentBinaryObjectBuilder attributes(PatternFile patternFile){
            this.patternFile = patternFile;
            return this;
        }
        public EmbeddedDocumentBinaryObject build(){
            EmbeddedDocumentBinaryObject embeddedDocumentBinaryObject = new EmbeddedDocumentBinaryObject(this);
            return embeddedDocumentBinaryObject;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternFile getPatternFile() {
        return patternFile;
    }

    public boolean isNull() {
        if(Tips.stringIsNull(value)){
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
        Element elementRoot = new ElementT(doc, element, name, value).load();
        if(!(patternFile == null)){
            if(!(patternFile.getFormat() == null)){
                Attr elementID_Attr1 = new AttributeT(doc, elementRoot, AttributesName.FORMAT.label, patternFile.getFormat()).load();
            }
            if(!(patternFile.getMimeCode() == null)){
                Attr elementID_Attr2 = new AttributeT(doc, elementRoot, AttributesName.MIME_CODE.label, patternFile.getMimeCode()).load();
            }
            if(!(patternFile.getEncodingCode() == null)){
                Attr elementID_Attr3 = new AttributeT(doc, elementRoot, AttributesName.ENCODING_CODE.label, patternFile.getEncodingCode()).load();
            }
            if(!(patternFile.getCharacterSetCode() == null)){
                Attr elementID_Attr4 = new AttributeT(doc, elementRoot, AttributesName.CHARACTER_SET_CODE.label, patternFile.getCharacterSetCode()).load();
            }
            if(!(patternFile.getUri() == null)){
                Attr elementID_Attr5 = new AttributeT(doc, elementRoot, AttributesName.URI.label, patternFile.getUri()).load();
            }
            if(!(patternFile.getFilename() == null)){
                Attr elementID_Attr6 = new AttributeT(doc, elementRoot, AttributesName.FILE_NAME.label, patternFile.getFilename()).load();
            }
        }
        return elementRoot;
    }

}
