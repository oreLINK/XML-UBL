package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternCode;
import com.company.xml.ubl.attributes.PatternCurrency;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.ID;
import com.company.xml.ubl.elements.InvoicedQuantity;
import com.company.xml.ubl.elements.LineExtensionAmount;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class InvoiceLine
 */
public class InvoiceLine {

    private Document doc;
    private Element element;
    private ID id;
    private InvoicedQuantity invoicedQuantity;
    private LineExtensionAmount lineExtensionAmount;
    private TaxTotal taxTotal;
    private Item item;
    private Price price;

    /**
     * <h2>Element "InvoiceLine"</h2>
     * <p>The earliest version of the UBL 2 schema for this document type that defines all of the elements that might be encountered in the current instance. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[ID] <b>id</b> <b>[1..1]</b> : Identifies the Invoice Line.</li>
     *         <li>[InvoicedQuantity] <b>invoicedQuantity</b> <b>[0..1]</b> : The quantity (of Items) on the Invoice Line.</li>
     *         <li>[LineExtensionAmount] <b>lineExtensionAmount</b> <b>[1..1]</b> : The total amount for the Invoice Line, including Allowance Charges but net of taxes.</li>
     *         <li>[TaxTotal] <b>taxTotal</b> <b>[0..*]</b> : An association to Tax Total.</li>
     *         <li>[Item] <b>item</b> <b>[1..1]</b> : An association to Item.</li>
     *         <li>[Price] <b>price</b> <b>[0..1]</b> : An association to Price.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private InvoiceLine(InvoiceLineBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.invoicedQuantity = builder.invoicedQuantity;
        this.lineExtensionAmount = builder.lineExtensionAmount;
        this.taxTotal = builder.taxTotal;
        this.item = builder.item;
        this.price = builder.price;
    }

    /**
     * Builder InvoiceLine
     */
    public static class InvoiceLineBuilder {

        private Document doc;
        private Element element;
        private ID id;
        private InvoicedQuantity invoicedQuantity;
        private LineExtensionAmount lineExtensionAmount;
        private TaxTotal taxTotal;
        private Item item;
        private Price price;

        public InvoiceLineBuilder() {}

        public InvoiceLineBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public InvoiceLineBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public InvoiceLineBuilder id(ID id){
            this.id = id;
            return this;
        }
        public InvoiceLineBuilder invoicedQuantity(InvoicedQuantity invoicedQuantity){
            this.invoicedQuantity = invoicedQuantity;
            return this;
        }
        public InvoiceLineBuilder lineExtensionAmount(LineExtensionAmount lineExtensionAmount){
            this.lineExtensionAmount = lineExtensionAmount;
            return this;
        }
        public InvoiceLineBuilder taxTotal(TaxTotal taxTotal){
            this.taxTotal = taxTotal;
            return this;
        }
        public InvoiceLineBuilder item(Item item){
            this.item = item;
            return this;
        }
        public InvoiceLineBuilder price(Price price){
            this.price = price;
            return this;
        }
        public InvoiceLine build(){
            InvoiceLine invoiceLine = new InvoiceLine(this);
            return invoiceLine;
        }

    }

    public ID getId() {
        return id;
    }

    public InvoicedQuantity getInvoicedQuantity() {
        return invoicedQuantity;
    }

    public LineExtensionAmount getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public TaxTotal getTaxTotal() {
        return taxTotal;
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
        Element elementInvoiceLine = new ElementT(doc, element, ElementsName.INVOICE_LINE.label).load();
        if(!id.isNull()){
            Element elementId = new ID.IDBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoiceLine)
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
        }
        if(!invoicedQuantity.isNull()){
            Element elementInvoicedQuantity = new InvoicedQuantity.InvoicedQuantityBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoiceLine)
                    .value(invoicedQuantity.getValue())
                    .attributes(new PatternCode.PatternCodeBuilder()
                            .unitCode(invoicedQuantity.getPatternCode().getUnitCode())
                            .build())
                    .build().load();
        }
        if(!lineExtensionAmount.isNull()){
            Element elementLineExtensionAmount = new LineExtensionAmount.LineExtensionAmountBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoiceLine)
                    .value(lineExtensionAmount.getValue())
                    .attributes(new PatternCurrency.PatternCurrencyBuilder()
                            .currencyID(lineExtensionAmount.getPatternCurrency().getCurrencyID())
                            .build())
                    .build().load();
        }
        if(!(taxTotal == null)){
            Element elementTaxTotal = new TaxTotal.TaxTotalBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoiceLine)
                    .taxAmount(taxTotal.getTaxAmount())
                    .taxSubTotalList(taxTotal.getTaxSubTotalList())
                    .build().load();
        }
        if(!(item == null)){
            Element elementItem = new Item.ItemBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoiceLine)
                    .descriptionList(item.getDescriptionList())
                    .name(item.getName())
                    .sellersItemIdentification(item.getSellersItemIdentification())
                    .build().load();
        }
        if(!(price == null)){
            Element elementPrice = new Price.PriceBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoiceLine)
                    .priceAmount(price.getPriceAmount())
                    .baseQuantity(price.getBaseQuantity())
                    .orderableUnitFactorRate(price.getOrderableUnitFactorRate())
                    .build().load();
        }
        return elementInvoiceLine;
    }


}
