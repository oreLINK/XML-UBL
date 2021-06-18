package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.ID;
import com.company.xml.ubl.elements.IssueDate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class OrderReference
 * use in CreditNote.
 */
public class OrderReference {

    private Document doc;
    private Element element;
    private ID id;

    private OrderReference(OrderReferenceBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
    }

    public static class OrderReferenceBuilder {

        private Document doc;
        private Element element;
        private ID id;

        public OrderReferenceBuilder() {}

        public OrderReferenceBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public OrderReferenceBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public OrderReferenceBuilder id(ID id){
            this.id = id;
            return this;
        }
        public OrderReference build(){
            OrderReference orderReference = new OrderReference(this);
            return orderReference;
        }

    }

    public ID getId() {
        return id;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementOrderReference = new ElementT(doc, element, ElementsName.ORDER_REFERENCE.label).load();
        if(!Tips.stringIsNull(id.getValue())){
            Element elementId = new ID.IDBuilder()
                    .documentLinked(doc)
                    .elementFather(elementOrderReference)
                    .value(id.getValue())
                    .attributes(id.getPatternScheme())
                    .build().load();
        }
        return elementOrderReference;
    }
}
