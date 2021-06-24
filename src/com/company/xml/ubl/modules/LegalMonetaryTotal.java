package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternCurrency;
import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.LineExtensionAmount;
import com.company.xml.ubl.elements.PayableAmount;
import com.company.xml.ubl.elements.TaxExclusiveAmount;
import com.company.xml.ubl.elements.TaxInclusiveAmount;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class LegalMonetaryTotal
 */
public class LegalMonetaryTotal {

    private Document doc;
    private Element element;
    private LineExtensionAmount lineExtensionAmount;
    private TaxExclusiveAmount taxExclusiveAmount;
    private TaxInclusiveAmount taxInclusiveAmount;
    private PayableAmount payableAmount;

    /**
     * <h2>Element "LegalMonetaryTotal"</h2>
     * <i>use in CreditNote <b>[1..1]</b>.</i>
     * <p>An association to the total amount payable on the Credit Note, including Allowances, Charges, and Taxes. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[LineExtensionAmount] <b>lineExtensionAmount</b> <b>[0..1]</b> : The total of Line Extension Amounts net of tax and settlement discounts, but inclusive of any applicable rounding amount.</li>
     *         <li>[TaxExclusiveAmount] <b>taxExclusiveAmount</b> <b>[0..1]</b> : The total amount exclusive of taxes.</li>
     *         <li>[TaxInclusiveAmount] <b>taxInclusiveAmount</b> <b>[0..1]</b> : The total amount inclusive of taxes.</li>
     *         <li>[PayableAmount] <b>payableAmount</b> <b>[1..1]</b> : The total amount to be paid.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private LegalMonetaryTotal(LegalMonetaryTotalBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.lineExtensionAmount = builder.lineExtensionAmount;
        this.taxExclusiveAmount = builder.taxExclusiveAmount;
        this.taxInclusiveAmount = builder.taxInclusiveAmount;
        this.payableAmount = builder.payableAmount;
    }

    /**
     * Builder LegalMonetaryTotal
     */
    public static class LegalMonetaryTotalBuilder {

        private Document doc;
        private Element element;
        private LineExtensionAmount lineExtensionAmount;
        private TaxExclusiveAmount taxExclusiveAmount;
        private TaxInclusiveAmount taxInclusiveAmount;
        private PayableAmount payableAmount;

        public LegalMonetaryTotalBuilder() {}

           public LegalMonetaryTotalBuilder documentLinked(Document doc){
               this.doc = doc;
               return this;
           }
            public LegalMonetaryTotalBuilder elementFather(Element element){
                this.element = element;
                return this;
            }
            public LegalMonetaryTotalBuilder lineExtensionAmount(LineExtensionAmount lineExtensionAmount){
                this.lineExtensionAmount = lineExtensionAmount;
                return this;
            }
            public LegalMonetaryTotalBuilder taxExclusiveAmount(TaxExclusiveAmount taxExclusiveAmount){
                this.taxExclusiveAmount = taxExclusiveAmount;
                return this;
            }
            public LegalMonetaryTotalBuilder taxInclusiveAmount(TaxInclusiveAmount taxInclusiveAmount){
                this.taxInclusiveAmount = taxInclusiveAmount;
                return this;
            }
            public LegalMonetaryTotalBuilder payableAmount(PayableAmount payableAmount){
                this.payableAmount = payableAmount;
                return this;
            }
            public LegalMonetaryTotal build(){
                LegalMonetaryTotal legalMonetaryTotal = new LegalMonetaryTotal(this);
                return legalMonetaryTotal;
            }

    }

    public LineExtensionAmount getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public TaxExclusiveAmount getTaxExclusiveAmount() {
        return taxExclusiveAmount;
    }

    public TaxInclusiveAmount getTaxInclusiveAmount() {
        return taxInclusiveAmount;
    }

    public PayableAmount getPayableAmount() {
        return payableAmount;
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementLegalMonetaryTotal = new ElementT(doc, element, ElementsName.LEGAL_MONETARY_TOTAL.label).load();
        if(!(lineExtensionAmount == null)){
            if(!(lineExtensionAmount.getPatternCurrency() == null)){
                Element elementLineExtensionAmount = new LineExtensionAmount.LineExtensionAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementLegalMonetaryTotal)
                        .value(lineExtensionAmount.getValue())
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID(lineExtensionAmount.getPatternCurrency().getCurrencyID())
                                .build())
                        .build().load();
            } else {
                Element elementLineExtensionAmount = new LineExtensionAmount.LineExtensionAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementLegalMonetaryTotal)
                        .value(lineExtensionAmount.getValue())
                        .build().load();
            }
        }
        if(!(taxExclusiveAmount == null)){
            if(!(taxExclusiveAmount.getPatternCurrency() == null)){
                Element elementTaxExclusiveAmount = new TaxExclusiveAmount.TaxExclusiveAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementLegalMonetaryTotal)
                        .value(taxExclusiveAmount.getValue())
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID(taxExclusiveAmount.getPatternCurrency().getCurrencyID())
                                .build())
                        .build().load();
            } else {
                Element elementTaxExclusiveAmount = new TaxExclusiveAmount.TaxExclusiveAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementLegalMonetaryTotal)
                        .value(taxExclusiveAmount.getValue())
                        .build().load();
            }
        }
        if(!(taxInclusiveAmount == null)){
            if(!(taxInclusiveAmount.getPatternCurrency() == null)){
                Element elementTaxInclusiveAmount = new TaxInclusiveAmount.TaxInclusiveAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementLegalMonetaryTotal)
                        .value(taxInclusiveAmount.getValue())
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID(taxInclusiveAmount.getPatternCurrency().getCurrencyID())
                                .build())
                        .build().load();
            } else {
                Element elementTaxInclusiveAmount = new TaxInclusiveAmount.TaxInclusiveAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementLegalMonetaryTotal)
                        .value(taxInclusiveAmount.getValue())
                        .build().load();
            }
        }
        if(!(payableAmount == null)){
            if(!(payableAmount.getPatternCurrency() == null)){
                Element elementPayableAmount = new PayableAmount.PayableAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementLegalMonetaryTotal)
                        .value(payableAmount.getValue())
                        .attributes(new PatternCurrency.PatternCurrencyBuilder()
                                .currencyID(payableAmount.getPatternCurrency().getCurrencyID())
                                .build())
                        .build().load();
            } else {
                Element elementPayableAmount = new PayableAmount.PayableAmountBuilder()
                        .documentLinked(doc)
                        .elementFather(elementLegalMonetaryTotal)
                        .value(payableAmount.getValue())
                        .build().load();
            }
        }
        return elementLegalMonetaryTotal;
    }
}
