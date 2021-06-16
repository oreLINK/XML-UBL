package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SellersItemIdentification {

    private Document doc;
    private Element element;
    private String id;

    private SellersItemIdentification(SellersItemIdentificationBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    public static class SellersItemIdentificationBuilder {

        private Document doc;
        private Element element;
        private String id;

        public SellersItemIdentificationBuilder() {}

        public SellersItemIdentificationBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public SellersItemIdentificationBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public SellersItemIdentificationBuilder id(String id){
            this.id = id;
            return this;
        }
        public SellersItemIdentification build(){
            SellersItemIdentification sellersItemIdentification = new SellersItemIdentification(this);
            return sellersItemIdentification;
        }

    }

    public String getId() {
        return id;
    }

    public Element load() {
        Element elementSellersItemIdentification = new ElementT(doc, element, ElementsName.SELLERS_ITEM_IDENTIFICATION.label).load();
        if(!Tips.stringIsNull(id)){
            Element elementId = new ElementT(doc, elementSellersItemIdentification, ElementsName.SELLERS_ITEM_IDENTIFICATION_ID.label, id).load();
        }
        return elementSellersItemIdentification;
    }

}
