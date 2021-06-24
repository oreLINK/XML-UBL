package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternCode;
import com.company.xml.ubl.attributes.PatternCurrency;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class InvoicedQuantity {

    private Document doc;
    private Element element;
    private String name = ElementsName.INVOICED_QUANTITY.label;
    private String value;
    private PatternCode patternCode;

    /**
     * Documentation is coming...
     */
    private InvoicedQuantity(InvoicedQuantityBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternCode = builder.patternCode;
    }

    /**
     * Builder InvoicedQuantity
     */
    public static class InvoicedQuantityBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternCode patternCode;

        public InvoicedQuantityBuilder() {}

        public InvoicedQuantityBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public InvoicedQuantityBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public InvoicedQuantityBuilder value(String value){
            this.value = value;
            return this;
        }
        public InvoicedQuantityBuilder attributes(PatternCode patternCode){
            this.patternCode = patternCode;
            return this;
        }
        public InvoicedQuantity build(){
            InvoicedQuantity element = new InvoicedQuantity(this);
            return element;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternCode getPatternCode() {
        return patternCode;
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
        if(!Tips.stringIsNull(patternCode.getUnitCode())){
            Attr elementID_Attr1 = new AttributeT(doc, elementRoot, AttributesName.UNIT_CODE.label, patternCode.getUnitCode()).load();
        }
        return elementRoot;
    }

}