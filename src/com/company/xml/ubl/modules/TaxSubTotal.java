package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TaxSubTotal
 */
public class TaxSubTotal {

    private Document doc;
    private Element element;
    private String taxableAmount;
    private String taxableAmount_AttributeCurrencyID;
    private String taxAmount;
    private String taxAmount_AttributeCurrencyID;
    private String calculationSequenceNumeric;
    private List<TaxCategory> taxCategoryList = new ArrayList<>();

    /**
     * <h2>Element "TaxSubTotal"</h2>
     * <i>use in TaxTotal <b>[0..*]</b>.</i>
     * <p>An association to Tax Subtotal. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>taxableAmount</b> <b>[0..1]</b> : The net amount to which the tax percent (rate) is applied to calculate the tax amount.</li>
     *         <li>[String] <b>taxableAmount_AttributeCurrencyID</b> <b>[1..1]</b> : The currency of the amount. (Attribute)</li>
     *         <li>[String] <b>taxAmount</b> <b>[1..1]</b> : The amount of tax stated explicitly.</li>
     *         <li>[String] <b>taxAmount_AttributeCurrencyID</b> <b>[1..1]</b> : The currency of the amount. (Attribute)</li>
     *         <li>[String] <b>calculationSequenceNumeric</b> <b>[0..1]</b> : Identifies the numerical order sequence in which taxes are applied when multiple taxes are attracted. If all taxes apply to the same taxable amount, CalculationSequenceNumeric will be '1' for all taxes.</li>
     *         <li>[List] <b>taxCategoryList</b> <b>[1..1]</b> : [TaxCategory] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private TaxSubTotal(TaxSubTotalBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.taxableAmount = builder.taxableAmount;
        this.taxableAmount_AttributeCurrencyID = builder.taxableAmount_AttributeCurrencyID;
        this.taxAmount = builder.taxAmount;
        this.taxAmount_AttributeCurrencyID = builder.taxAmount_AttributeCurrencyID;
        this.calculationSequenceNumeric = builder.calculationSequenceNumeric;
        this.taxCategoryList = builder.taxCategoryList;
    }

    /**
     * Builder TaxSubTotal
     */
    public static class TaxSubTotalBuilder {

        private Document doc;
        private Element element;
        private String taxableAmount;
        private String taxableAmount_AttributeCurrencyID;
        private String taxAmount;
        private String taxAmount_AttributeCurrencyID;
        private String calculationSequenceNumeric;
        private List<TaxCategory> taxCategoryList = new ArrayList<>();

        public TaxSubTotalBuilder() {}

        public TaxSubTotalBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxSubTotalBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxSubTotalBuilder taxableAmount(String taxableAmount){
            this.taxableAmount = taxableAmount;
            return this;
        }
        public TaxSubTotalBuilder taxableAmount_AttributeCurrencyID(String taxableAmount_AttributeCurrencyID){
            this.taxableAmount_AttributeCurrencyID = taxableAmount_AttributeCurrencyID;
            return this;
        }
        public TaxSubTotalBuilder taxAmount(String taxAmount){
            this.taxAmount = taxAmount;
            return this;
        }
        public TaxSubTotalBuilder taxAmount_AttributeCurrencyID(String taxAmount_AttributeCurrencyID){
            this.taxAmount_AttributeCurrencyID = taxAmount_AttributeCurrencyID;
            return this;
        }
        public TaxSubTotalBuilder calculationSequenceNumeric(String calculationSequenceNumeric){
            this.calculationSequenceNumeric = calculationSequenceNumeric;
            return this;
        }
        public TaxSubTotalBuilder taxCategoryList(List<TaxCategory> taxCategoryList){
            this.taxCategoryList = taxCategoryList;
            return this;
        }
        public TaxSubTotal build(){
            TaxSubTotal taxSubTotal = new TaxSubTotal(this);
            return taxSubTotal;
        }

    }

    public String getTaxableAmount() {
        return taxableAmount;
    }

    public String getTaxableAmount_AttributeCurrencyID() {
        return taxableAmount_AttributeCurrencyID;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public String getTaxAmount_AttributeCurrencyID() {
        return taxAmount_AttributeCurrencyID;
    }

    public String getCalculationSequenceNumeric() {
        return calculationSequenceNumeric;
    }

    public List<TaxCategory> getTaxCategoryList() {
        return taxCategoryList;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementTaxSubTotal = new ElementT(doc, element, ElementsName.TAX_SUB_TOTAL.label).load();
        if(!Tips.stringIsNull(taxableAmount)){
            Element elementTaxableAmount = new ElementT(doc, elementTaxSubTotal, ElementsName.TAX_SUB_TOTAL_TAXABLE_AMOUNT.label, taxableAmount).load();
            if(!Tips.stringIsNull(taxableAmount_AttributeCurrencyID)){
                Attr elementTaxableAmount_Attr1 = new AttributeT(doc, elementTaxableAmount, AttributesName.CURRENCY_ID.label, taxableAmount_AttributeCurrencyID).load();
            }
        }
        if(!Tips.stringIsNull(taxAmount)){
            Element elementTaxAmount = new ElementT(doc, elementTaxSubTotal, ElementsName.TAX_SUB_TOTAL_TAX_AMOUNT.label, taxAmount).load();
            if(!Tips.stringIsNull(taxAmount_AttributeCurrencyID)){
                Attr elementTaxAmount_Attr1 = new AttributeT(doc, elementTaxAmount, AttributesName.CURRENCY_ID.label, taxAmount_AttributeCurrencyID).load();
            }
        }
        if(!Tips.stringIsNull(calculationSequenceNumeric)){
            Element elementCalculationSequenceNumeric = new ElementT(doc, elementTaxSubTotal, ElementsName.TAX_SUB_TOTAL_CALCULATION_SEQUENCE_NUMERIC.label, calculationSequenceNumeric).load();
        }
        if(!Tips.listIsNull(taxCategoryList)){
            for (TaxCategory taxCategory : taxCategoryList) {
                Element elementTaxCategory = new TaxCategory.TaxCategoryBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxSubTotal)
                        .id(taxCategory.getId())
                        .id_AttributeSchemeAgencyID(taxCategory.getId_AttributeSchemeAgencyID())
                        .id_AttributeSchemeID(taxCategory.getId_AttributeSchemeID())
                        .id_AttributeSchemeVersionID(taxCategory.getId_AttributeSchemeVersionID())
                        .percent(taxCategory.getPercent())
                        .taxSchemeList(taxCategory.getTaxSchemeList())
                        .build().load();
            }
        }

        return elementTaxSubTotal;
    }


}
