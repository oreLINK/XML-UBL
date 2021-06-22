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

    /*private Document doc;
    private Element element;
    private String id;
    private String id_AttributeSchemeAgencyID;
    private String id_AttributeSchemeID;
    private String id_AttributeSchemeVersionID;
    private String name;*/
    private Document doc;
    private Element element;
    private ID id = null;
    private Name name;


    /**
     * <h2>Element "TaxScheme"</h2>
     * <i>use in TaxCategory <b>[1..1]</b>.</i>
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
     *         <li>[String] <b>id</b> <b>[0..1]</b> : Identifies the tax category.</li>
     *         <li>[String] <b>id_AttributeSchemeAgencyID</b> <b>[0..1]</b> : The identification of the agency that maintains the identification scheme. (Attribute)</li>
     *         <li>[String] <b>id_AttributeSchemeID</b> <b>[0..1]</b> : The identification of the identification scheme. (Attribute)</li>
     *         <li>[String] <b>id_AttributeSchemeVersionID</b> <b>[0..1]</b> : The version of the identification scheme. (Attribute)</li>
     *         <li>[String] <b>name</b> <b>[0..1]</b> : The name of the tax scheme.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private TaxScheme(TaxSchemeBuilder builder) {
        /*this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.id_AttributeSchemeAgencyID = builder.id_AttributeSchemeAgencyID;
        this.id_AttributeSchemeID = builder.id_AttributeSchemeID;
        this.id_AttributeSchemeVersionID = builder.id_AttributeSchemeVersionID;
        this.name = builder.name;*/
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.name = builder.name;
    }

    /**
     * Builder Contact
     */
    public static class TaxSchemeBuilder {

       /* private Document doc;
        private Element element;
        private String id;
        private String id_AttributeSchemeAgencyID;
        private String id_AttributeSchemeID;
        private String id_AttributeSchemeVersionID;
        private String name;*/
        private Document doc;
        private Element element;
        private ID id;
        private Name name;

        /*public TaxSchemeBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxSchemeBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxSchemeBuilder id(String id){
            this.id = id;
            return this;
        }
        public TaxSchemeBuilder id_AttributeSchemeAgencyID(String id_AttributeSchemeAgencyID){
            this.id_AttributeSchemeAgencyID = id_AttributeSchemeAgencyID;
            return this;
        }
        public TaxSchemeBuilder id_AttributeSchemeID(String id_AttributeSchemeID){
            this.id_AttributeSchemeID = id_AttributeSchemeID;
            return this;
        }
        public TaxSchemeBuilder id_AttributeSchemeVersionID(String id_AttributeSchemeVersionID){
            this.id_AttributeSchemeVersionID = id_AttributeSchemeVersionID;
            return this;
        }
        public TaxSchemeBuilder name(String name){
            this.name = name;
            return this;
        }*/
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

    /*public String getId() {
        return id;
    }

    public String getId_AttributeSchemeAgencyID() {
        return id_AttributeSchemeAgencyID;
    }

    public String getId_AttributeSchemeID() {
        return id_AttributeSchemeID;
    }

    public String getId_AttributeSchemeVersionID() {
        return id_AttributeSchemeVersionID;
    }

    public String getName() {
        return name;
    }*/

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
    /*public Element load() {
        Element elementTaxScheme = new ElementT(doc,element, ElementsName.TAX_SCHEME.label).load();
        if(!Tips.stringIsNull(id)){
            Element elementID = new ElementT(doc, elementTaxScheme, ElementsName.TAX_SCHEME_ID.label, id).load();
            if(!Tips.stringIsNull(id_AttributeSchemeAgencyID)){
                Attr elementID_Attr1 = new AttributeT(doc, elementID, AttributesName.SCHEME_AGENCY_ID.label, id_AttributeSchemeAgencyID).load();
            }
            if(!Tips.stringIsNull(id_AttributeSchemeID)){
                Attr elementID_Attr2 = new AttributeT(doc, elementID, AttributesName.SCHEME_ID.label, id_AttributeSchemeID).load();
            }
            if(!Tips.stringIsNull(id_AttributeSchemeVersionID)){
                Attr elementID_Attr3 = new AttributeT(doc, elementID, AttributesName.SCHEME_VERSION_ID.label, id_AttributeSchemeVersionID).load();
            }
        }
        if(!Tips.stringIsNull(name)){
            Element elementName = new ElementT(doc, elementTaxScheme, ElementsName.TAX_SCHEME_NAME.label, name).load();
        }
        return elementTaxScheme;
    }*/
    public Element load() {
        Element elementTaxScheme = new ElementT(doc,element, ElementsName.TAX_SCHEME.label).load();
        /**
         * TODO TECHNIQUE POUR EMPECHER LE NULL !(id ==null)
         */
        if(!(id ==null)){
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
        }
        if(!(name ==null)){
            Element elementName = new Name.NameBuilder()
                    .documentLinked(doc)
                    .elementFather(elementTaxScheme)
                    .value(name.getValue())
                    .attributes(new PatternLanguage.PatternLanguageBuilder()
                            .languageID(name.getPatternLanguage().getLanguageID())
                            .build())
                    .build().load();
        }
        return elementTaxScheme;
    }

}
