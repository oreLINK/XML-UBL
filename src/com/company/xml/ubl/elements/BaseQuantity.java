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

/**
 * Class BaseQuantity
 */
public class BaseQuantity {

    private Document doc;
    private Element element;
    private String name = ElementsName.BASE_QUANTITY.label;
    private String value;
    private PatternCode patternCode;

    /**
     * <h2>Element "BaseQuantity"</h2>
     * <p>The actual quantity to which the price applies. Contains :</p>
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
     *         <li>[PatternCode] <b>patternCode</b> <b>[0..1]</b> : Attributes available for this element.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private BaseQuantity(BaseQuantityBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
        this.patternCode = builder.patternCode;
    }

    /**
     * Builder BaseQuantity
     */
    public static class BaseQuantityBuilder {

        private Document doc;
        private Element element;
        private String value;
        private PatternCode patternCode;

        public BaseQuantityBuilder() {}

        public BaseQuantityBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public BaseQuantityBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public BaseQuantityBuilder value(String value){
            this.value = value;
            return this;
        }
        public BaseQuantityBuilder attributes(PatternCode patternCode){
            this.patternCode = patternCode;
            return this;
        }
        public BaseQuantity build(){
            BaseQuantity element = new BaseQuantity(this);
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
