package com.company.xml.ubl.modules;

import com.company.xml.ubl.attributes.PatternList;
import com.company.xml.ubl.attributes.PatternScheme;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.ElementsName;
import com.company.xml.ubl.elements.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class PaymentMeans
 */
public class PaymentMeans {

    private Document doc;
    private Element element;
    private ID id;
    private PaymentMeansCode paymentMeansCode;
    private PaymentDueDate paymentDueDate;
    private PaymentChannelCode paymentChannelCode;
    private PayeeFinancialAccount payeeFinancialAccount;

    /**
     * <h2>Element "UBLVersionID"</h2>
     * <p>The earliest version of the UBL 2 schema for this document type that defines all of the elements that might be encountered in the current instance. Contains :</p>
     * <ul>
     *     <li><b>for build() + load()</b>
     *     <ul>
     *         <li>[Document] <b>documentLinked</b> : document in which this element must be written.</li>
     *         <li>[Element] <b>elementFather</b> : parent element in which this element must be written.</li>
     *     </ul>
     *     </li>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[ID] <b>id</b> <b>[0..1]</b> : Identifies the Payment Means.</li>
     *         <li>[PaymentMeansCode] <b>paymentMeansCode</b> <b>[1..1]</b> : The Payment Means expressed as a code</li>
     *         <li>[PaymentDueDate] <b>paymentDueDate</b> <b>[0..1]</b> : The date on which payment is due for the Payment Means.</li>
     *         <li>[PaymentChannelCode] <b>paymentChannelCode</b> <b>[0..1]</b> : The Payment Channel, expressed as a code.</li>
     *         <li>[PayeeFinancialAccount] <b>payeeFinancialAccount</b> <b>[0..1]</b> : An association to the payee's Financial Account.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PaymentMeans(PaymentMeansBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.id = builder.id;
        this.paymentMeansCode = builder.paymentMeansCode;
        this.paymentDueDate = builder.paymentDueDate;
        this.paymentChannelCode = builder.paymentChannelCode;
        this.payeeFinancialAccount = builder.payeeFinancialAccount;
    }

    /**
     * Builder PaymentMeans
     */
    public static class PaymentMeansBuilder {

        private Document doc;
        private Element element;
        private ID id;
        private PaymentMeansCode paymentMeansCode;
        private PaymentDueDate paymentDueDate;
        private PaymentChannelCode paymentChannelCode;
        private PayeeFinancialAccount payeeFinancialAccount;

        public PaymentMeansBuilder() {}

        public PaymentMeansBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PaymentMeansBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PaymentMeansBuilder id(ID id){
            this.id = id;
            return this;
        }
        public PaymentMeansBuilder paymentMeansCode(PaymentMeansCode paymentMeansCode){
            this.paymentMeansCode = paymentMeansCode;
            return this;
        }
        public PaymentMeansBuilder paymentDueDate(PaymentDueDate paymentDueDate){
            this.paymentDueDate = paymentDueDate;
            return this;
        }
        public PaymentMeansBuilder paymentChannelCode(PaymentChannelCode paymentChannelCode){
            this.paymentChannelCode = paymentChannelCode;
            return this;
        }
        public PaymentMeansBuilder payeeFinancialAccount(PayeeFinancialAccount payeeFinancialAccount){
            this.payeeFinancialAccount = payeeFinancialAccount;
            return this;
        }
        public PaymentMeans build(){
            PaymentMeans element = new PaymentMeans(this);
            return element;
        }

    }

    public ID getId() {
        return id;
    }

    public PaymentMeansCode getPaymentMeansCode() {
        return paymentMeansCode;
    }

    public PaymentDueDate getPaymentDueDate() {
        return paymentDueDate;
    }

    public PaymentChannelCode getPaymentChannelCode() {
        return paymentChannelCode;
    }

    public PayeeFinancialAccount getPayeeFinancialAccount() {
        return payeeFinancialAccount;
    }

    public boolean isNull() {
        if(id.isNull() && paymentMeansCode.isNull() && paymentDueDate.isNull() && paymentChannelCode.isNull() && payeeFinancialAccount.isNull()){
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
        Element elementPaymentMeans1 = new ElementT(doc, element, ElementsName.PAYMENT_MEANS.label).load();
        if(!(id == null)){
            if(!(id.getPatternScheme() == null)){
                Element elementId = new ID.IDBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPaymentMeans1)
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
                        .elementFather(elementPaymentMeans1)
                        .value(id.getValue())
                        .build().load();
            }
        }
        if(!(paymentMeansCode == null)){
            if(!(paymentMeansCode.getPatternList() == null)){
                Element paymentMeansCode1 = new PaymentMeansCode.PaymentMeansCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPaymentMeans1)
                        .value(paymentMeansCode.getValue())
                        .attributes(new PatternList.PatternListBuilder()
                                .listID(paymentMeansCode.getPatternList().getListID())
                                .listAgencyID(paymentMeansCode.getPatternList().getListAgencyID())
                                .listAgencyName(paymentMeansCode.getPatternList().getListAgencyName())
                                .listName(paymentMeansCode.getPatternList().getListName())
                                .listVersionID(paymentMeansCode.getPatternList().getListVersionID())
                                .name(paymentMeansCode.getPatternList().getName())
                                .languageID(paymentMeansCode.getPatternList().getLanguageID())
                                .listURI(paymentMeansCode.getPatternList().getListURI())
                                .listSchemeURI(paymentMeansCode.getPatternList().getListSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element paymentMeansCode1 = new PaymentMeansCode.PaymentMeansCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPaymentMeans1)
                        .value(paymentMeansCode.getValue())
                        .build().load();
            }
        }
        if(!(paymentDueDate == null)){
            Element elementPaymentDueDate = new PaymentDueDate.PaymentDueDateBuilder()
                    .documentLinked(doc)
                    .elementFather(elementPaymentMeans1)
                    .value(paymentDueDate.getValue())
                    .build().load();
        }
        if(!(paymentChannelCode == null)){
            if(!(paymentChannelCode.getPatternList() == null)){
                Element elementPaymentChannelCode = new PaymentChannelCode.PaymentChannelCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPaymentMeans1)
                        .value(paymentChannelCode.getValue())
                        .attributes(new PatternList.PatternListBuilder()
                                .listID(paymentChannelCode.getPatternList().getListID())
                                .listAgencyID(paymentChannelCode.getPatternList().getListAgencyID())
                                .listAgencyName(paymentChannelCode.getPatternList().getListAgencyName())
                                .listName(paymentChannelCode.getPatternList().getListName())
                                .listVersionID(paymentChannelCode.getPatternList().getListVersionID())
                                .name(paymentChannelCode.getPatternList().getName())
                                .languageID(paymentChannelCode.getPatternList().getLanguageID())
                                .listURI(paymentChannelCode.getPatternList().getListURI())
                                .listSchemeURI(paymentChannelCode.getPatternList().getListSchemeURI())
                                .build())
                        .build().load();
            } else {
                Element elementPaymentChannelCode = new PaymentChannelCode.PaymentChannelCodeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPaymentMeans1)
                        .value(paymentChannelCode.getValue())
                        .build().load();
            }
        }
        if(!(payeeFinancialAccount == null)){
            Element elementPayeeFinancialAccount = new PayeeFinancialAccount.PayeeFinancialAccountBuilder()
                    .documentLinked(doc)
                    .elementFather(elementPaymentMeans1)
                    .id(payeeFinancialAccount.getId())
                    .financialInstitutionBranch(payeeFinancialAccount.getFinancialInstitutionBranch())
                    .build().load();
        }
        return elementPaymentMeans1;
    }

}
