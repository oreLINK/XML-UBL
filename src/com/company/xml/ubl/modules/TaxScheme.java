package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternLanguage;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.ID;
import com.company.xml.ubl.elements.Name;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class TaxScheme
 */
public class TaxScheme {

    private Document doc;
    private Element element;
    private ID id = null;
    private Name name;

    /**
     * <h2>Element "TaxScheme"</h2>
     * <p>An association to Tax Scheme. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[ID] <b>id</b> <b>[0..1]</b> : Identifies the tax category.</li>
     *         <li>[Name] <b>name</b> <b>[0..1]</b> : The name of the tax scheme.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private TaxScheme(TaxSchemeBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.name = builder.name;
    }

    /**
     * Builder Contact
     */
    public static class TaxSchemeBuilder {

        private Document doc;
        private Element element;
        private ID id;
        private Name name;

        public TaxSchemeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxSchemeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxSchemeBuilder id(ID id){
            this.id = id;
            return this;
        }
        public TaxSchemeBuilder name(Name name){
            this.name = name;
            return this;
        }
        public TaxScheme build(){
            TaxScheme taxScheme = new TaxScheme(this);
            return taxScheme;
        }

    }

    public ID getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementTaxScheme = new ElementT(doc,element, ElementsName.TAX_SCHEME.label).load();
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxScheme)
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
                        .elementFather(elementTaxScheme)
                        .value(id.getValue())
                        .build().load();
            }
        }
        if(!(name == null)){
            if(!(name.getPatternLanguage() == null)){
                Element elementName = new Name.NameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxScheme)
                        .value(name.getValue())
                        .attributes(new PatternLanguage.PatternLanguageBuilder()
                                .languageID(name.getPatternLanguage().getLanguageID())
                                .build())
                        .build().load();
            } else {
                Element elementName = new Name.NameBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxScheme)
                        .value(name.getValue())
                        .build().load();
            }
        }
        return elementTaxScheme;
    }

}
