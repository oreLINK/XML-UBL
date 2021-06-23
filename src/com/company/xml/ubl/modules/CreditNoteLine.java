package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class CreditNoteLine
 */
public class CreditNoteLine {

    private Document doc;
    private Element element;
    private String id;
    private String creditedQuantity;
    private String creditedQuantity_AttributeUnitCode;
    private String lineExtensionAmount;
    private String lineExtensionAmount_AttributeCurrencyId;
    private List<TaxTotal> taxTotalList = new ArrayList<>();
    private List<Item> itemList = new ArrayList<>();
    private List<Price> priceList = new ArrayList<>();

    /**
     * <h2>Element "CreditNoteLine"</h2>
     * <i>use in CreditNote <b>[1..*]</b>.</i>
     * <p>An association to one or more Credit Note Lines. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>id</b> <b>[1..1]</b> : Identifies the Credit Note Line.</li>
     *         <li>[String] <b>creditedQuantity</b> <b>[0..1]</b> : The quantity of Items credited.</li>
     *         <li>[String] <b>creditedQuantity_AttributeUnitCode</b> <b>[0..1]</b> : The unit of the quantity (Attribute)</li>
     *         <li>[String] <b>lineExtensionAmount</b> <b>[0..1]</b> : The total amount for the Credit Note Line, including Allowance Charges but net of taxes.</li>
     *         <li>[String] <b>lineExtensionAmount_AttributeCurrencyId</b> <b>[1..1]</b> : The currency of the amount. (Attribute)</li>
     *         <li>[List] <b>taxTotalList</b> <b>[0..*]</b> : [TaxTotal] elements list.</li>
     *         <li>[List] <b>itemList</b> <b>[0..1]</b> : [Item] elements list.</li>
     *         <li>[List] <b>priceList</b> <b>[0..1]</b> : [Price] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private CreditNoteLine(CreditNoteLineBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.creditedQuantity = builder.creditedQuantity;
        this.creditedQuantity_AttributeUnitCode = builder.creditedQuantity_AttributeUnitCode;
        this.lineExtensionAmount = builder.lineExtensionAmount;
        this.lineExtensionAmount_AttributeCurrencyId = builder.lineExtensionAmount_AttributeCurrencyId;
        this.taxTotalList = builder.taxTotalList;
        this.itemList = builder.itemList;
        this.priceList = builder.priceList;
    }

    /**
     * Builder CreditNoteLine
     */
    public static class CreditNoteLineBuilder {

        private Document doc;
        private Element element;
        private String id;
        private String creditedQuantity;
        private String creditedQuantity_AttributeUnitCode;
        private String lineExtensionAmount;
        private String lineExtensionAmount_AttributeCurrencyId;
        private List<TaxTotal> taxTotalList = new ArrayList<>();
        private List<Item> itemList = new ArrayList<>();
        private List<Price> priceList = new ArrayList<>();

        public CreditNoteLineBuilder() {}

        public CreditNoteLineBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public CreditNoteLineBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public CreditNoteLineBuilder id(String id){
            this.id = id;
            return this;
        }
        public CreditNoteLineBuilder creditedQuantity(String creditedQuantity){
            this.creditedQuantity = creditedQuantity;
            return this;
        }
        public CreditNoteLineBuilder creditedQuantity_AttributeUnitCode(String creditedQuantity_AttributeUnitCode){
            this.creditedQuantity_AttributeUnitCode = creditedQuantity_AttributeUnitCode;
            return this;
        }
        public CreditNoteLineBuilder lineExtensionAmount(String lineExtensionAmount){
            this.lineExtensionAmount = lineExtensionAmount;
            return this;
        }
        public CreditNoteLineBuilder lineExtensionAmount_AttributeCurrencyId(String lineExtensionAmount_AttributeCurrencyId){
            this.lineExtensionAmount_AttributeCurrencyId = lineExtensionAmount_AttributeCurrencyId;
            return this;
        }
        public CreditNoteLineBuilder taxTotalList(List<TaxTotal> taxTotalList){
            this.taxTotalList = taxTotalList;
            return this;
        }
        public CreditNoteLineBuilder itemList(List<Item> itemList){
            this.itemList = itemList;
            return this;
        }
        public CreditNoteLineBuilder priceList(List<Price> priceList){
            this.priceList = priceList;
            return this;
        }
        public CreditNoteLine build(){
            CreditNoteLine creditNoteLine = new CreditNoteLine(this);
            return creditNoteLine;
        }

    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementCreditNoteLine = new ElementT(doc, element, ElementsName.CREDIT_NOTE_LINE.label).load();
        if(!Tips.stringIsNull(id)){
            Element elementId = new ElementT(doc, elementCreditNoteLine, ElementsName.CREDIT_NOTE_LINE_ID.label, id).load();
        }
        if(!Tips.stringIsNull(creditedQuantity)){
            Element elementCreditedQuantity = new ElementT(doc, elementCreditNoteLine, ElementsName.CREDIT_NOTE_LINE_CREDITED_QUANTITY.label, creditedQuantity).load();
            if(!Tips.stringIsNull(creditedQuantity_AttributeUnitCode)){
                Attr elementCreditedQuantity_Attr1 = new AttributeT(doc, elementCreditedQuantity, AttributesName.UNIT_CODE.label, creditedQuantity_AttributeUnitCode).load();
            }
        }
        if(!Tips.stringIsNull(lineExtensionAmount)){
            Element elementLineExtensionAmount = new ElementT(doc, elementCreditNoteLine, ElementsName.CREDIT_NOTE_LINE_LINE_EXTENSION_AMOUNT.label, lineExtensionAmount).load();
            if(!Tips.stringIsNull(lineExtensionAmount_AttributeCurrencyId)){
                Attr elementLineExtensionAmount_Attr1 = new AttributeT(doc, elementLineExtensionAmount, AttributesName.CURRENCY_ID.label, lineExtensionAmount_AttributeCurrencyId).load();
            }
        }
        if(!Tips.listIsNull(taxTotalList)){
            for (TaxTotal taxTotal : taxTotalList) {
                Element elementTaxTotal = new TaxTotal.TaxTotalBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNoteLine)
                        .taxAmount(taxTotal.getTaxAmount())
                        .taxSubTotalList(taxTotal.getTaxSubTotalList())
                        .build().load();
            }
        }
        if(!Tips.listIsNull(itemList)){
            for (Item item : itemList) {
                Element elementItem = new Item.ItemBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNoteLine)
                        .descriptionList(item.getDescriptionList())
                        .name(item.getName())
                        .sellersItemIdentification(item.getSellersItemIdentification())
                        .build().load();
            }
        }
        if(!Tips.listIsNull(priceList)){
            for (Price price : priceList) {
                Element elementPrice = new Price.PriceBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNoteLine)
                        .priceAmount(price.getPriceAmount())
                        .baseQuantity(price.getBaseQuantity())
                        .orderableUnitFactorRate(price.getOrderableUnitFactorRate())
                        .build().load();
            }
        }
        return elementCreditNoteLine;
    }

}
