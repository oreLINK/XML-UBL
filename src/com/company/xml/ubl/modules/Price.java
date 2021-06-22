package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class Price
 */
public class Price {

    private Document doc;
    private Element element;
    private String priceAmount;
    private String priceAmount_AttributeCurrencyID;
    private String baseQuantity;
    private String baseQuantity_AttributeUnitCode;
    private String orderableUnitFactorRate;

    /**
     * <h2>Element "Price"</h2>
     * <i>use in CreditNoteLine <b>[0..1]</b>.</i>
     * <p>An association to Price. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>priceAmount</b> <b>[1..1]</b> : The price amount.</li>
     *         <li>[String] <b>priceAmount_AttributeCurrencyID</b> <b>[1..1]</b> : The currency of the amount. (Attribute)</li>
     *         <li>[String] <b>baseQuantity</b> <b>[0..1]</b> : The actual quantity to which the price applies.</li>
     *         <li>[String] <b>baseQuantity_AttributeUnitCode</b> <b>[0..1]</b> : The unit of the quantity. (Attribute)</li>
     *         <li>[String] <b>orderableUnitFactorRate</b> <b>[0..1]</b> : The factor by which the base price unit can be converted to the orderable unit.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Price(PriceBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.priceAmount = builder.priceAmount;
        this.priceAmount_AttributeCurrencyID = builder.priceAmount_AttributeCurrencyID;
        this.baseQuantity = builder.baseQuantity;
        this.baseQuantity_AttributeUnitCode = builder.baseQuantity_AttributeUnitCode;
        this.orderableUnitFactorRate = builder.orderableUnitFactorRate;
    }

    /**
     * Builder Contact
     */
    public static class PriceBuilder {

        private Document doc;
        private Element element;
        private String priceAmount;
        private String priceAmount_AttributeCurrencyID;
        private String baseQuantity;
        private String baseQuantity_AttributeUnitCode;
        private String orderableUnitFactorRate;

        public PriceBuilder() {}

        public PriceBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PriceBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PriceBuilder priceAmount(String priceAmount){
            this.priceAmount = priceAmount;
            return this;
        }
        public PriceBuilder priceAmount_AttributeCurrencyID(String priceAmount_AttributeCurrencyID){
            this.priceAmount_AttributeCurrencyID = priceAmount_AttributeCurrencyID;
            return this;
        }
        public PriceBuilder baseQuantity(String baseQuantity){
            this.baseQuantity = baseQuantity;
            return this;
        }
        public PriceBuilder baseQuantity_AttributeUnitCode(String baseQuantity_AttributeUnitCode){
            this.baseQuantity_AttributeUnitCode = baseQuantity_AttributeUnitCode;
            return this;
        }
        public PriceBuilder orderableUnitFactorRate(String orderableUnitFactorRate){
            this.orderableUnitFactorRate = orderableUnitFactorRate;
            return this;
        }
        public Price build(){
            Price price = new Price(this);
            return price;
        }

    }

    public String getPriceAmount() {
        return priceAmount;
    }

    public String getPriceAmount_AttributeCurrencyID() {
        return priceAmount_AttributeCurrencyID;
    }

    public String getBaseQuantity() {
        return baseQuantity;
    }

    public String getBaseQuantity_AttributeUnitCode() {
        return baseQuantity_AttributeUnitCode;
    }

    public String getOrderableUnitFactorRate() {
        return orderableUnitFactorRate;
    }

    public boolean isNull() {
        if(Tips.stringIsNull(priceAmount) && Tips.stringIsNull(baseQuantity) && Tips.stringIsNull(orderableUnitFactorRate)){
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
        Element elementPrice = new ElementT(doc, element, ElementsName.PRICE.label).load();
        if (!Tips.stringIsNull(priceAmount)) {
            Element elementPriceAmount = new ElementT(doc, elementPrice, ElementsName.PRICE_PRICE_AMOUNT.label, priceAmount).load();
            if (!Tips.stringIsNull(priceAmount_AttributeCurrencyID)) {
                Attr elementPriceAmount_Attr1 = new AttributeT(doc, elementPriceAmount, AttributesName.CURRENCY_ID.label, priceAmount_AttributeCurrencyID).load();
            }
        }
        if (!Tips.stringIsNull(baseQuantity)) {
            Element elementBaseQuantity = new ElementT(doc, elementPrice, ElementsName.PRICE_BASE_QUANTITY.label, baseQuantity).load();
            if (!Tips.stringIsNull(baseQuantity_AttributeUnitCode)) {
                Attr elementBaseQuantity_Attr1 = new AttributeT(doc, elementBaseQuantity, AttributesName.UNIT_CODE.label, baseQuantity_AttributeUnitCode).load();
            }
        }
        if (!Tips.stringIsNull(orderableUnitFactorRate)) {
            Element elementOrderableUnitFactorRate = new ElementT(doc, elementPrice, ElementsName.PRICE_ORDERABLE_UNIT_FACTOR_RATE.label, orderableUnitFactorRate).load();
        }
        return elementPrice;
    }
}
