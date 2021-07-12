package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class PaymentDueDate
 */
public class PaymentDueDate {

    private Document doc;
    private Element element;
    private String name = ElementsName.PAYMENT_DUE_DATE.label;
    private String value;

    /**
     * <h2>Element "PaymentDueDate"</h2>
     * <p>The date on which payment is due for the Payment Means. Contains :</p>
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
     *     </ul>
     *     </li>
     * </ul>
     */
    private PaymentDueDate(PaymentDueDateBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
    }

    /**
     * Builder PaymentDueDate
     */
    public static class PaymentDueDateBuilder {

        private Document doc;
        private Element element;
        private String value;

        public PaymentDueDateBuilder() {}

        public PaymentDueDateBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PaymentDueDateBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PaymentDueDateBuilder value(String value){
            this.value = value;
            return this;
        }
        public PaymentDueDate build(){
            PaymentDueDate element = new PaymentDueDate(this);
            return element;
        }

    }

    public String getValue() {
        return value;
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
        return elementRoot;
    }

}
