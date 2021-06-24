package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternCurrency;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TaxExclusiveAmount {

    private Document doc;
    private Element element;
    private String name = ElementsName.TAX_EXCLUSIVE_AMOUNT.label;
    private String value;
    private PatternCurrency patternCurrency;

    /**
     * Documentation is coming...
     */
    private TaxExclusiveAmount(TaxExclusiveAmountBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternCurrency = builder.patternCurrency;
    }

    /**
     * Builder TaxExclusiveAmount
     */
    public static class TaxExclusiveAmountBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternCurrency patternCurrency;

        public TaxExclusiveAmountBuilder() {}

        public TaxExclusiveAmountBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxExclusiveAmountBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxExclusiveAmountBuilder value(String value){
            this.value = value;
            return this;
        }
        public TaxExclusiveAmountBuilder attributes(PatternCurrency patternCurrency){
            this.patternCurrency = patternCurrency;
            return this;
        }
        public TaxExclusiveAmount build(){
            TaxExclusiveAmount element = new TaxExclusiveAmount(this);
            return element;
        }

    }

    public String getValue() {
        return value;
    }

    public PatternCurrency getPatternCurrency() {
        return patternCurrency;
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
        if(!Tips.stringIsNull(patternCurrency.getCurrencyID())){
            Attr elementID_Attr1 = new AttributeT(doc, elementRoot, AttributesName.CURRENCY_ID.label, patternCurrency.getCurrencyID()).load();
        }
        return elementRoot;
    }

}