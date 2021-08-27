package com.company.xml.ubl.attributes;

/**
 * Class PatternFile
 */
public class PatternCode {

    private String unitCode;

    /**
     * <h2>Attributes "PatternCode"</h2>
     * <p>Contains :</p>
     * <ul>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>unitCode</b> <b>[0..1]</b> : The unit of the quantity.</li>
     *     </ul>
     *     </li>
     * </ul>
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
