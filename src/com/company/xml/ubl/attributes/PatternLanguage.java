package com.company.xml.ubl.attributes;

public class PatternLanguage {

    private String languageID;

    /**
     * <h2>Attributes "PatternLanguage"</h2>
     * <p>Contains :</p>
     * <ul>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>languageID</b> <b>[0..1]</b> : The identifier of the language used in the content component.	</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PatternLanguage(PatternLanguageBuilder builder) {
        this.languageID = builder.languageID;
    }

    /**
     * Builder PatternLanguage
     */
    public static class PatternLanguageBuilder {

        private String languageID;

        public PatternLanguageBuilder() {}

        public PatternLanguageBuilder languageID(String languageID){
            this.languageID = languageID;
            return this;
        }
        public PatternLanguage build(){
            PatternLanguage patternLanguage = new PatternLanguage(this);
            return patternLanguage;
        }

    }

    public String getLanguageID() {
        return languageID;
    }
}
