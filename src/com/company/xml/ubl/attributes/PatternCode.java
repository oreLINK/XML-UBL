package com.company.xml.ubl.attributes;

public class PatternCode {

    private String unitCode;

    /**
     * Documentation is coming...
     */
    private PatternCode(PatternCodeBuilder builder) {
        this.unitCode = builder.currencyID;
    }

    /**
     * Builder PatternList
     */
    public static class PatternCodeBuilder {

        private String currencyID;

        public PatternCodeBuilder() {}

        public PatternCodeBuilder unitCode(String unitCode){
            this.currencyID = unitCode;
            return this;
        }
        public PatternCode build(){
            PatternCode patternCode = new PatternCode(this);
            return patternCode;
        }

    }

    public String getUnitCode() {
        return unitCode;
    }
}
