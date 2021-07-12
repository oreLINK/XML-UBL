package com.company.xml.ubl.elements;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class OrderableUnitFactorRate
 */
public class OrderableUnitFactorRate {

    private Document doc;
    private Element element;
    private String name = ElementsName.ORDERABLE_UNIT_FACTOR_RATE.label;
    private String value;

    /**
     * <h2>Element "OrderableUnitFactorRate"</h2>
     * <p>The factor by which the base price unit can be converted to the orderable unit. Contains :</p>
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
    private OrderableUnitFactorRate(OrderableUnitFactorRateBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
    }

    /**
     * Builder OrderableUnitFactorRate
     */
    public static class OrderableUnitFactorRateBuilder {

        private Document doc;
        private Element element;
        private String value;

        public OrderableUnitFactorRateBuilder() {}

        public OrderableUnitFactorRateBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public OrderableUnitFactorRateBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public OrderableUnitFactorRateBuilder value(String value){
            this.value = value;
            return this;
        }
        public OrderableUnitFactorRate build(){
            OrderableUnitFactorRate element = new OrderableUnitFactorRate(this);
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
