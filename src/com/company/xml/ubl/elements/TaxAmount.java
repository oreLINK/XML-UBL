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

public class TaxAmount {

    private Document doc;
    private Element element;
    private String name = ElementsName.TAX_AMOUNT.label;
    private String value;
    private PatternCurrency patternCurrency;

    /**
     * Documentation is coming...
     */
    private TaxAmount(TaxAmountBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternCurrency = builder.patternCurrency;
    }

    /**
     * Builder TaxAmount
     */
    public static class TaxAmountBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternCurrency patternCurrency;

        public TaxAmountBuilder() {}

        public TaxAmountBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxAmountBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxAmountBuilder value(String value){
            this.value = value;
            return this;
        }
        public TaxAmountBuilder attributes(PatternCurrency patternCurrency){
            this.patternCurrency = patternCurrency;
            return this;
        }
        public TaxAmount build(){
            TaxAmount elementBuild = new TaxAmount(this);
            return elementBuild;
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
        if(!(patternCurrency == null)){
            if(!(patternCurrency.getCurrencyID() == null)){
                Attr elementRoot_Attr1 = new AttributeT(doc, elementRoot, AttributesName.CURRENCY_ID.label, patternCurrency.getCurrencyID()).load();
            }
        }
        return elementRoot;
    }

}
