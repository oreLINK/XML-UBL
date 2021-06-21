package com.company.xml.ubl.modules;

import com.company.xml.ubl.elements.ID;
import com.company.xml.ubl.elements.InvoicedQuantity;
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

    }

    /**
     * TODO
     */



}
