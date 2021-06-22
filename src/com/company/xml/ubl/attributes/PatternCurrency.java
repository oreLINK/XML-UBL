package com.company.xml.ubl.attributes;

public class PatternCurrency {

    private String currencyID;

    /**
     * Documentation is coming...
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
