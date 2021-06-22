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

public class InvoiceLine {

    private Document doc;
    private Element element;
    private ID id;
    private InvoicedQuantity invoicedQuantity;
    private LineExtensionAmount lineExtensionAmount;
    private TaxTotal taxTotal;
    private Item item;
    private Price price;

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
        if(!taxTotal.isNull()){
            Element elementTaxTotal = new TaxTotal.TaxTotalBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoiceLine)
                    .taxAmount(taxTotal.getTaxAmount())
                    .taxAmount_AttributeCurrencyID(taxTotal.getTaxAmount_AttributeCurrencyID())
                    .taxSubTotalList(taxTotal.getTaxSubTotalList())
                    .build().load();
        }
        if(!item.isNull()){
            Element elementItem = new Item.ItemBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoiceLine)
                    .description(item.getDescription())
                    .name(item.getName())
                    .sellersItemIdentificationList(item.getSellersItemIdentificationList())
                    .build().load();
        }
        if(!price.isNull()){
            Element elementPrice = new Price.PriceBuilder()
                    .documentLinked(doc)
                    .elementFather(elementInvoiceLine)
                    .priceAmount(price.getPriceAmount())
                    .priceAmount_AttributeCurrencyID(price.getPriceAmount_AttributeCurrencyID())
                    .baseQuantity(price.getBaseQuantity())
                    .baseQuantity_AttributeUnitCode(price.getBaseQuantity_AttributeUnitCode())
                    .orderableUnitFactorRate(price.getOrderableUnitFactorRate())
                    .build().load();
        }
        return elementInvoiceLine;
    }


}
