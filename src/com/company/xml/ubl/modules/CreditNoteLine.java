package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternCode;
import com.company.xml.ubl.attributes.PatternCurrency;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.CreditedQuantity;
import com.company.xml.ubl.elements.ID;
import com.company.xml.ubl.elements.LineExtensionAmount;
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
    private ID id;
    private CreditedQuantity creditedQuantity;
    private LineExtensionAmount lineExtensionAmount;
    private List<TaxTotal> taxTotalList = new ArrayList<>();
    private Item item;
    private Price price;

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
     *         <li>[ID] <b>id</b> <b>[1..1]</b> : Identifies the Credit Note Line.</li>
     *         <li>[CreditedQuantity] <b>creditedQuantity</b> <b>[0..1]</b> : The quantity of Items credited.</li>
     *         <li>[LineExtensionAmount] <b>lineExtensionAmount</b> <b>[0..1]</b> : The total amount for the Credit Note Line, including Allowance Charges but net of taxes.</li>
     *         <li>[List] <b>taxTotalList</b> <b>[0..*]</b> : [TaxTotal] elements list.</li>
     *         <li>[Item] <b>item</b> <b>[0..1]</b> : An association to Item</li>
     *         <li>[Price] <b>price</b> <b>[0..1]</b> : An association to Price.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private CreditNoteLine(CreditNoteLineBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.creditedQuantity = builder.creditedQuantity;
        this.lineExtensionAmount = builder.lineExtensionAmount;
        this.taxTotalList = builder.taxTotalList;
        this.item = builder.item;
        this.price = builder.price;
    }

    /**
     * Builder CreditNoteLine
     */
    public static class CreditNoteLineBuilder {

        private Document doc;
        private Element element;
        private ID id;
        private CreditedQuantity creditedQuantity;
        private LineExtensionAmount lineExtensionAmount;
        private List<TaxTotal> taxTotalList = new ArrayList<>();
        private Item item;
        private Price price;

        public CreditNoteLineBuilder() {}

        public CreditNoteLineBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public CreditNoteLineBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public CreditNoteLineBuilder id(ID id){
            this.id = id;
            return this;
        }
        public CreditNoteLineBuilder creditedQuantity(CreditedQuantity creditedQuantity){
            this.creditedQuantity = creditedQuantity;
            return this;
        }
        public CreditNoteLineBuilder lineExtensionAmount(LineExtensionAmount lineExtensionAmount){
            this.lineExtensionAmount = lineExtensionAmount;
            return this;
        }
        public CreditNoteLineBuilder taxTotalList(List<TaxTotal> taxTotalList){
            this.taxTotalList = taxTotalList;
            return this;
        }
        public CreditNoteLineBuilder item(Item item){
            this.item = item;
            return this;
        }
        public CreditNoteLineBuilder price(Price price){
            this.price = price;
            return this;
        }
        public CreditNoteLine build(){
            CreditNoteLine creditNoteLine = new CreditNoteLine(this);
            return creditNoteLine;
        }

    }

    public ID getId() {
        return id;
    }

    public CreditedQuantity getCreditedQuantity() {
        return creditedQuantity;
    }

    public LineExtensionAmount getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public List<TaxTotal> getTaxTotalList() {
        return taxTotalList;
    }

    public Item getItem() {
        return item;
    }

    public Price getPrice() {
        return price;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementCreditNoteLine = new ElementT(doc, element, ElementsName.CREDIT_NOTE_LINE.label).load();
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNoteLine)
                        .value(id.getValue())
                        .attributes(new PatternScheme.PatternSchemeBuilder()
                                .schemeID(id.getPatternScheme().getSchemeID())
                                .schemeName(id.getPatternScheme().getSchemeName())
                                .schemeAgencyID(id.getPatternScheme().getSchemeAgencyID())
                                .schemeAgencyName(id.getPatternScheme().getSchemeAgencyName())
                                .schemeVersionID(id.getPatternScheme().getSchemeVersionID())
                                .schemeDataURI(id.getPatternScheme().getSchemeDataURI())
                                .schemeURI(id.getPatternScheme().getSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNoteLine)
                        .value(id.getValue())
                        .build().load();
            }
        }
        if(!(creditedQuantity == null)){
            if(!(creditedQuantity.getPatternCode() == null)){
                Element elementCreditedQuantity = new CreditedQuantity.CreditedQuantityBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNoteLine)
                        .value(creditedQuantity.getValue())
                        .attributes(new PatternCode.PatternCodeBuilder()
                                .unitCode(creditedQuantity.getPatternCode().getUnitCode())
                                .build())
                        .build().load();
            } else {
                Element elementCreditedQuantity = new CreditedQuantity.CreditedQuantityBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNoteLine)
                        .value(creditedQuantity.getValue())
                        .build().load();
            }
        }
        if(!(lineExtensionAmount == null)){
            if(!(lineExtensionAmount.getPatternCurrency() == null)){
                Element elementLineExtensionAmount = new LineExtensionAmount.LineExtensionAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNoteLine)
                        .value(lineExtensionAmount.getValue())
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID(lineExtensionAmount.getPatternCurrency().getCurrencyID())
                                .build())
                        .build().load();
            } else {
                Element elementLineExtensionAmount = new LineExtensionAmount.LineExtensionAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementCreditNoteLine)
                        .value(lineExtensionAmount.getValue())
                        .build().load();
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
        if(!(item == null)){
            Element elementItem = new Item.ItemBuilder()
                    .documentLinked(doc)
                    .elementFather(elementCreditNoteLine)
                    .descriptionList(item.getDescriptionList())
                    .name(item.getName())
                    .sellersItemIdentification(item.getSellersItemIdentification())
                    .build().load();
        }
        if(!(price == null)){
            Element elementPrice = new Price.PriceBuilder()
                    .documentLinked(doc)
                    .elementFather(elementCreditNoteLine)
                    .priceAmount(price.getPriceAmount())
                    .baseQuantity(price.getBaseQuantity())
                    .orderableUnitFactorRate(price.getOrderableUnitFactorRate())
                    .build().load();
        }
        return elementCreditNoteLine;
    }

}
