package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternCode;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreditedQuantity {

    private Document doc;
    private Element element;
    private String name = ElementsName.CREDITED_QUANTITY.label;
    private String value;
    private PatternCode patternCode;

    /**
     * Documentation is coming...
     */
    private CreditedQuantity(CreditedQuantityBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternCode = builder.patternCode;
    }

    /**
     * Builder CreditedQuantity
     */
    public static class CreditedQuantityBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternCode patternCode;

        public CreditedQuantityBuilder() {}

        public CreditedQuantityBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public CreditedQuantityBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public CreditedQuantityBuilder value(String value){
            this.value = value;
            return this;
        }
        public CreditedQuantityBuilder attributes(PatternCode patternCode){
            this.patternCode = patternCode;
            return this;
        }
        public CreditedQuantity build(){
            CreditedQuantity element = new CreditedQuantity(this);
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
