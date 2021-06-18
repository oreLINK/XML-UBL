package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Item
 */
public class Item {

    private Document doc;
    private Element element;
    private String description;
    private String name;
    private List<SellersItemIdentification> sellersItemIdentificationList = new ArrayList<>();

    /**
     * <h2>Element "Item"</h2>
     * <i>use in CreditNoteLine <b>[0..1]</b>.</i>
     * <p>An association to Item. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>description</b> <b>[0..*]</b> : Free-form field that can be used to give a text description of the item.</li>
     *         <li>[String] <b>name</b> <b>[0..1]</b> : A short name optionally given to an item, such as a name from a Catalogue, as distinct from a description.</li>
     *         <li>[List] <b>sellersItemIdentificationList</b> <b>[0..1]</b> : [SellersItemIdentification] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private Item(ItemBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.description = builder.description;
        this.name = builder.name;
        this.sellersItemIdentificationList = builder.sellersItemIdentificationList;
    }

    /**
     * Builder Item
     */
    public static class ItemBuilder {

        private Document doc;
        private Element element;
        private String description;
        private String name;
        private List<SellersItemIdentification> sellersItemIdentificationList = new ArrayList<>();

        public ItemBuilder() {}

        public ItemBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public ItemBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public ItemBuilder description(String description){
            this.description = description;
            return this;
        }
        public ItemBuilder name(String name){
            this.name = name;
            return this;
        }
        public ItemBuilder sellersItemIdentificationList(List<SellersItemIdentification> sellersItemIdentificationList){
            this.sellersItemIdentificationList = sellersItemIdentificationList;
            return this;
        }
        public Item build(){
            Item item = new Item(this);
            return item;
        }

    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public List<SellersItemIdentification> getSellersItemIdentificationList() {
        return sellersItemIdentificationList;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementItem = new ElementT(doc, element, ElementsName.ITEM.label).load();
        if(!Tips.stringIsNull(description)){
            Element elementDescription = new ElementT(doc, elementItem, ElementsName.ITEM_DESCRIPTION.label, description).load();
        }
        if(!Tips.stringIsNull(name)){
            Element elementName = new ElementT(doc, elementItem, ElementsName.ITEM_NAME.label, name).load();
        }
        if(!Tips.listIsNull(sellersItemIdentificationList)){
            for (SellersItemIdentification sellersItemIdentification : sellersItemIdentificationList) {
                Element elementSellersItemIdentificationList = new SellersItemIdentification.SellersItemIdentificationBuilder()
                        .documentLinked(doc)
                        .elementFather(elementItem)
                        .id(sellersItemIdentification.getId())
                        .build().load();
            }
        }
        return elementItem;
    }

}
