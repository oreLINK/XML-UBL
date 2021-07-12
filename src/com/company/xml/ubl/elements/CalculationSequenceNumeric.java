package com.company.xml.ubl.elements;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class CalculationSequenceNumeric
 */
public class CalculationSequenceNumeric {

    private Document doc;
    private Element element;
    private String name = ElementsName.CALCULATION_SEQUENCE_NUMERIC.label;
    private String value;

    /**
     * <h2>Element "CalculationSequenceNumeric"</h2>
     * <p>Identifies the numerical order sequence in which taxes are applied when multiple taxes are attracted. If all taxes apply to the same taxable amount, CalculationSequenceNumeric will be '1' for all taxes. Contains :</p>
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
    private CalculationSequenceNumeric(CalculationSequenceNumericBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
    }

    /**
     * Builder CalculationSequenceNumeric
     */
    public static class CalculationSequenceNumericBuilder {

        private Document doc;
        private Element element;
        private String value;

        public CalculationSequenceNumericBuilder() {}

        public CalculationSequenceNumericBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public CalculationSequenceNumericBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public CalculationSequenceNumericBuilder value(String value){
            this.value = value;
            return this;
        }
        public CalculationSequenceNumeric build(){
            CalculationSequenceNumeric elementBuild = new CalculationSequenceNumeric(this);
            return elementBuild;
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
