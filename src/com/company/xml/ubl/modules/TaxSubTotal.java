package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternCurrency;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.CalculationSequenceNumeric;
import com.company.xml.ubl.elements.TaxAmount;
import com.company.xml.ubl.elements.TaxableAmount;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class TaxSubTotal
 */
public class TaxSubTotal {

    private Document doc;
    private Element element;
    private TaxableAmount taxableAmount;
    private TaxAmount taxAmount;
    private CalculationSequenceNumeric calculationSequenceNumeric;
    private TaxCategory taxCategory;

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
        this.taxAmount = builder.taxAmount;
        this.calculationSequenceNumeric = builder.calculationSequenceNumeric;
        this.taxCategory = builder.taxCategory;
    }

    /**
     * Builder TaxSubTotal
     */
    public static class TaxSubTotalBuilder {

        private Document doc;
        private Element element;
        private TaxableAmount taxableAmount;
        private TaxAmount taxAmount;
        private CalculationSequenceNumeric calculationSequenceNumeric;
        private TaxCategory taxCategory;

        public TaxSubTotalBuilder() {}

        public TaxSubTotalBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxSubTotalBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxSubTotalBuilder taxableAmount(TaxableAmount taxableAmount){
            this.taxableAmount = taxableAmount;
            return this;
        }
        public TaxSubTotalBuilder taxAmount(TaxAmount taxAmount){
            this.taxAmount = taxAmount;
            return this;
        }
        public TaxSubTotalBuilder calculationSequenceNumeric(CalculationSequenceNumeric calculationSequenceNumeric){
            this.calculationSequenceNumeric = calculationSequenceNumeric;
            return this;
        }
        public TaxSubTotalBuilder taxCategory(TaxCategory taxCategory){
            this.taxCategory = taxCategory;
            return this;
        }
        public TaxSubTotal build(){
            TaxSubTotal taxSubTotal = new TaxSubTotal(this);
            return taxSubTotal;
        }

    }

    public TaxableAmount getTaxableAmount() {
        return taxableAmount;
    }

    public TaxAmount getTaxAmount() {
        return taxAmount;
    }

    public CalculationSequenceNumeric getCalculationSequenceNumeric() {
        return calculationSequenceNumeric;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementTaxSubTotal = new ElementT(doc, element, ElementsName.TAX_SUB_TOTAL.label).load();
        if(!(taxableAmount == null)){
            if(!(taxableAmount.getPatternCurrency() == null)){
                Element elementTaxableAmount = new TaxableAmount.TaxableAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxSubTotal)
                        .value(taxableAmount.getValue())
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID(taxableAmount.getPatternCurrency().getCurrencyID())
                                .build())
                        .build().load();
            } else {
                Element elementTaxableAmount = new TaxableAmount.TaxableAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxSubTotal)
                        .value(taxableAmount.getValue())
                        .build().load();
            }
        }
        if(!(taxAmount == null)){
            if(!(taxAmount.getPatternCurrency() == null)){
                Element elementTaxAmount = new TaxAmount.TaxAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxSubTotal)
                        .value(taxAmount.getValue())
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID(taxAmount.getPatternCurrency().getCurrencyID())
                                .build())
                        .build().load();
            } else {
                Element elementTaxAmount = new TaxAmount.TaxAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxSubTotal)
                        .value(taxAmount.getValue())
                        .build().load();
            }
        }
        if(!(calculationSequenceNumeric == null)){
            Element elementCalculationSequenceNumeric = new CalculationSequenceNumeric.CalculationSequenceNumericBuilder()
                    .documentLinked(doc)
                    .elementFather(elementTaxSubTotal)
                    .value(calculationSequenceNumeric.getValue())
                    .build().load();
        }
        if(!(taxCategory == null)){
            Element elementTaxCategory = new TaxCategory.TaxCategoryBuilder()
                    .documentLinked(doc)
                    .elementFather(elementTaxSubTotal)
                    .id(taxCategory.getId())
                    .percent(taxCategory.getPercent())
                    .taxScheme(taxCategory.getTaxScheme())
                    .build().load();
        }
        return elementTaxSubTotal;
    }


}
