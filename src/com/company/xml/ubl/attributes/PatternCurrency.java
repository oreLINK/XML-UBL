package com.company.xml.ubl.attributes;

/**
 * Class PatternCurrency
 */
public class PatternCurrency {

    private String currencyID;

    /**
     * <h2>Attributes "PatternCurrency"</h2>
     * <p>Contains :</p>
     * <ul>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>currencyID</b> <b>[0..1]</b> : The currency of the amount.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PatternCurrency(PatternCurrencyBuilder builder) {
        this.currencyID = builder.currencyID;
    }

    /**
     * Builder PatternCurrency
     */
    public static class PatternCurrencyBuilder {

        private String currencyID;

        public PatternCurrencyBuilder() {}

        public PatternCurrencyBuilder currencyID(String currencyID){
            this.currencyID = currencyID;
            return this;
        }
        public PatternCurrency build(){
            PatternCurrency patternCurrency = new PatternCurrency(this);
            return patternCurrency;
        }

    }

    public String getCurrencyID() {
        return currencyID;
    }
}
