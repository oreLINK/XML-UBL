package com.company.xml.ubl.elements;

import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class IssueDate {

    private Document doc;
    private Element element;
    private String name = ElementsName.ISSUE_DATE.label;
    private String value;

    private IssueDate(IssueDateBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.value = builder.value;
    }

    public static class IssueDateBuilder {

        private Document doc;
        private Element element;
        private String value;

        public IssueDateBuilder() {}

        public IssueDateBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public IssueDateBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public IssueDateBuilder value(String value){
            this.value = value;
            return this;
        }
        public IssueDate build(){
            IssueDate element = new IssueDate(this);
            return element;
        }

    }

    public String getValue() {
        return value;
    }

    public Element load() {
        Element elementRoot = new ElementT(doc, element, name, value).load();
        return elementRoot;
    }

}
