package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class DocumentCurrencyCode
 */
public class DocumentCurrencyCode {

    private Document doc;
    private Element element;
    private String name = ElementsName.DOC_CURRENCY_CODE.label;
    private String value;
    private PatternList patternList;

    /**
     * <h2>Element "DocumentCurrencyCode"</h2>
     * <i>use in CreditNote <b>[0..1]</b>.</i>
     * <p>The default currency for the Credit Note. Contains :</p>
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
     *         <li>[PatternList] <b>patternList</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private DocumentCurrencyCode(DocumentCurrencyCodeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternList = builder.patternList;
    }

    /**
     * Builder DocumentCurrencyCode
     */
    public static class DocumentCurrencyCodeBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternList patternList;

        public DocumentCurrencyCodeBuilder() {}

        public DocumentCurrencyCodeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public DocumentCurrencyCodeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public DocumentCurrencyCodeBuilder value(String value){
            this.value = value;
            return this;
        }
        public DocumentCurrencyCodeBuilder attributes(PatternList patternList){
            this.patternList = patternList;
            return this;
        }
        public DocumentCurrencyCode build(){
            DocumentCurrencyCode element = new DocumentCurrencyCode(this);
            return element;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternList getPatternList() {
        return patternList;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementRoot = new ElementT(doc, element, name, value).load();
        if(!(patternList == null)){
            if(!(patternList.getListID() == null)){
                Attr elementID_Attr1 = new AttributeT(doc, elementRoot, AttributesName.LIST_ID.label, patternList.getListID()).load();
            }
            if(!(patternList.getListAgencyID() == null)){
                Attr elementID_Attr2 = new AttributeT(doc, elementRoot, AttributesName.LIST_AGENCY_ID.label, patternList.getListAgencyID()).load();
            }
            if(!(patternList.getListAgencyName() == null)){
                Attr elementID_Attr3 = new AttributeT(doc, elementRoot, AttributesName.LIST_AGENCY_NAME.label, patternList.getListAgencyName()).load();
            }
            if(!(patternList.getListName() == null)){
                Attr elementID_Attr4 = new AttributeT(doc, elementRoot, AttributesName.LIST_NAME.label, patternList.getListName()).load();
            }
            if(!(patternList.getListVersionID() == null)){
                Attr elementID_Attr5 = new AttributeT(doc, elementRoot, AttributesName.LIST_VERSION_ID.label, patternList.getListVersionID()).load();
            }
            if(!(patternList.getName() == null)){
                Attr elementID_Attr6 = new AttributeT(doc, elementRoot, AttributesName.NAME.label, patternList.getName()).load();
            }
            if(!(patternList.getLanguageID() == null)){
                Attr elementID_Attr7 = new AttributeT(doc, elementRoot, AttributesName.LANGUAGE_ID.label, patternList.getLanguageID()).load();
            }
            if(!(patternList.getListURI() == null)){
                Attr elementID_Attr6 = new AttributeT(doc, elementRoot, AttributesName.LIST_URI.label, patternList.getListURI()).load();
            }
            if(!(patternList.getListSchemeURI() == null)){
                Attr elementID_Attr7 = new AttributeT(doc, elementRoot, AttributesName.LIST_SCHEME_URI.label, patternList.getListSchemeURI()).load();
            }
        }
        return elementRoot;
    }

}
