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

/**
 * Class UBLVersionID
 */
public class PayableAmount {

    private Document doc;
    private Element element;
    private String name = ElementsName.PAYABLE_AMOUNT.label;
    private String value;
    private PatternCurrency patternCurrency;

    /**
     * <h2>Element "PayableAmount"</h2>
     * <p>The total amount to be paid. Contains :</p>
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
     *         <li>[PatternCurrency] <b>patternCurrency</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PayableAmount(PayableAmountBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternCurrency = builder.patternCurrency;
    }

    /**
     * Builder PayableAmount
     */
    public static class PayableAmountBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternCurrency patternCurrency;

        public PayableAmountBuilder() {}

        public PayableAmountBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PayableAmountBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PayableAmountBuilder value(String value){
            this.value = value;
            return this;
        }
        public PayableAmountBuilder attributes(PatternCurrency patternCurrency){
            this.patternCurrency = patternCurrency;
            return this;
        }
        public PayableAmount build(){
            PayableAmount element = new PayableAmount(this);
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
