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
 * Class TaxTotal
 */
public class TaxTotal {

    private Document doc;
    private Element element;
    private String taxAmount;
    private String taxAmount_AttributeCurrencyID;
    private List<TaxSubTotal> taxSubTotalList = new ArrayList<>();

    /**
     * <h2>Element "TaxTotal"</h2>
     * <i>use in CreditNoteLine <b>[0..*]</b>.</i>
     * <p>An association to Tax Total. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>taxAmount</b> <b>[1..1]</b> : The total tax amount for particular tax scheme e.g. VAT; the sum of each of the tax subtotals for each tax category within the tax scheme.</li>
     *         <li>[String] <b>taxAmount_AttributeCurrencyID</b> <b>[1..1]</b> : The currency of the amount. (Attribute)</li>
     *         <li>[List] <b>taxSubTotalList</b> <b>[0..*]</b> : [TaxSubTotal] elements list.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private TaxTotal(TaxTotalBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.taxAmount = builder.taxAmount;
        this.taxAmount_AttributeCurrencyID = builder.taxAmount_AttributeCurrencyID;
        this.taxSubTotalList = builder.taxSubTotalList;
    }

    /**
     * Builder TaxTotal
     */
    public static class TaxTotalBuilder {

        private Document doc;
        private Element element;
        private String taxAmount;
        private String taxAmount_AttributeCurrencyID;
        private List<TaxSubTotal> taxSubTotalList = new ArrayList<>();

        public TaxTotalBuilder() {}

        public TaxTotalBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public TaxTotalBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public TaxTotalBuilder taxAmount(String taxAmount){
            this.taxAmount = taxAmount;
            return this;
        }
        public TaxTotalBuilder taxAmount_AttributeCurrencyID(String taxAmount_AttributeCurrencyID){
            this.taxAmount_AttributeCurrencyID = taxAmount_AttributeCurrencyID;
            return this;
        }
        public TaxTotalBuilder taxSubTotalList(List<TaxSubTotal> taxSubTotalList){
            this.taxSubTotalList = taxSubTotalList;
            return this;
        }
        public TaxTotal build(){
            TaxTotal taxTotal = new TaxTotal(this);
            return taxTotal;
        }

    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public String getTaxAmount_AttributeCurrencyID() {
        return taxAmount_AttributeCurrencyID;
    }

    public List<TaxSubTotal> getTaxSubTotalList() {
        return taxSubTotalList;
    }

    public boolean isNull() {
        if(Tips.stringIsNull(taxAmount)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function that will return a fully generated element (attributes, inheritances, other elements if there are any) on the chosen document and the defined parent element.
     * @return the generated element
     */
    public Element load() {
        Element elementTaxTotal = new ElementT(doc, element, ElementsName.TAX_TOTAL.label).load();
        if (!Tips.stringIsNull(taxAmount)) {
            Element elementTaxAmount = new ElementT(doc, elementTaxTotal, ElementsName.TAX_TOTAL_TAX_AMOUNT.label, taxAmount).load();
            if (!Tips.stringIsNull(taxAmount_AttributeCurrencyID)) {
                Attr elementTaxAmount_Attr1 = new AttributeT(doc, elementTaxAmount, AttributesName.CURRENCY_ID.label, taxAmount_AttributeCurrencyID).load();
            }
        }
        if (!Tips.listIsNull(taxSubTotalList)) {
            for (TaxSubTotal taxSubTotal : taxSubTotalList) {
                Element elementTaxSubTotal = new TaxSubTotal.TaxSubTotalBuilder()
                        .documentLinked(doc)
                        .elementFather(elementTaxTotal)
                        .taxableAmount(taxSubTotal.getTaxableAmount())
                        .taxableAmount_AttributeCurrencyID(taxSubTotal.getTaxableAmount_AttributeCurrencyID())
                        .taxAmount(taxSubTotal.getTaxAmount())
                        .taxAmount_AttributeCurrencyID(taxSubTotal.getTaxAmount_AttributeCurrencyID())
                        .calculationSequenceNumeric(taxSubTotal.getCalculationSequenceNumeric())
                        .taxCategoryList(taxSubTotal.getTaxCategoryList())
                        .build().load();
            }
        }
        return elementTaxTotal;
    }
}
