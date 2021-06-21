package com.company.xml.ubl.attributes;

public class PatternCode {

    private String unitCode;

    /**
     * Documentation is coming...
     */
    private PatternCode(PatternCodeBuilder builder) {
        this.unitCode = builder.unitCode;
    }

    /**
     * Builder PatternList
     */
    public static class PatternCodeBuilder {

        private String unitCode;

        public PatternCodeBuilder() {}

        public PatternCodeBuilder unitCode(String unitCode){
            this.unitCode = unitCode;
            return this;
        }
        public PatternCode build(){
            PatternCode patternCode = new PatternCode(this);
            return patternCode;
        }

    }

}
