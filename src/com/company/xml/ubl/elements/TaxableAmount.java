package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternCurrency;
import com.company.xml.ubl.attributes.PatternLanguage;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TaxableAmount {

    private Document doc;
    private Element element;
    private String name = ElementsName.TAXABLE_AMOUNT.label;
    private String value;
    private PatternCurrency patternCurrency;

    /**
     * Documentation is coming...
     */
    private TaxableAmount(TaxableAmountBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternCurrency = builder.patternCurrency;
    }

    /**
     * Builder TaxableAmount
     */
    public static class TaxableAmountBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternCurrency patternCurrency;

        public TaxableAmountBuilder() {}

        public TaxableAmountBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxableAmountBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxableAmountBuilder value(String value){
            this.value = value;
            return this;
        }
        public TaxableAmountBuilder attributes(PatternCurrency patternCurrency){
            this.patternCurrency = patternCurrency;
            return this;
        }
        public TaxableAmount build(){
            TaxableAmount elementBuild = new TaxableAmount(this);
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
