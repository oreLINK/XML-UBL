package com.company.xml.ubl.attributes;

/**
 * Class PatternScheme
 */
public class PatternScheme {

    private String schemeID;
    private String schemeName;
    private String schemeAgencyID;
    private String schemeAgencyName;
    private String schemeVersionID;
    private String schemeDataURI;
    private String schemeURI;

    /**
     * Documentation is coming...
     */
    private PatternScheme(PatternSchemeBuilder builder) {
        this.schemeID = builder.schemeID;
        this.schemeName = builder.schemeName;
        this.schemeAgencyID = builder.schemeAgencyID;
        this.schemeAgencyName = builder.schemeAgencyName;
        this.schemeVersionID = builder.schemeVersionID;
        this.schemeDataURI = builder.schemeDataURI;
        this.schemeURI = builder.schemeURI;
    }

    /**
     * Builder Contact
     */
    public static class PatternSchemeBuilder {

        private String schemeID;
        private String schemeName;
        private String schemeAgencyID;
        private String schemeAgencyName;
        private String schemeVersionID;
        private String schemeDataURI;
        private String schemeURI;

        public PatternSchemeBuilder() {}

        public PatternSchemeBuilder schemeID(String schemeID){
            this.schemeID = schemeID;
            return this;
        }
        public PatternSchemeBuilder schemeName(String schemeName){
            this.schemeName = schemeName;
            return this;
        }
        public PatternSchemeBuilder schemeAgencyID(String schemeAgencyID){
            this.schemeAgencyID = schemeAgencyID;
            return this;
        }
        public PatternSchemeBuilder schemeAgencyName(String schemeAgencyName){
            this.schemeAgencyName = schemeAgencyName;
            return this;
        }
        public PatternSchemeBuilder schemeVersionID(String schemeVersionID){
            this.schemeVersionID = schemeVersionID;
            return this;
        }
        public PatternSchemeBuilder schemeDataURI(String schemeDataURI){
            this.schemeDataURI = schemeDataURI;
            return this;
        }
        public PatternSchemeBuilder schemeURI(String schemeURI){
            this.schemeURI = schemeURI;
            return this;
        }
        public PatternScheme build(){
            PatternScheme patternScheme = new PatternScheme(this);
            return patternScheme;
        }

    }

    public String getSchemeID() {
        return schemeID;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public String getSchemeAgencyID() {
        return schemeAgencyID;
    }

    public String getSchemeAgencyName() {
        return schemeAgencyName;
    }

    public String getSchemeVersionID() {
        return schemeVersionID;
    }

    public String getSchemeDataURI() {
        return schemeDataURI;
    }

    public String getSchemeURI() {
        return schemeURI;
    }
}
