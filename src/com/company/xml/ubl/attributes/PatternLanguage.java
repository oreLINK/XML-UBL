package com.company.xml.ubl.attributes;

public class PatternLanguage {

    private String languageID;

    /**
     * Documentation is coming...
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
