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
     * <h2>Attributes "PatternScheme"</h2>
     * <p>Contains :</p>
     * <ul>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>schemeID</b> <b>[0..1]</b> : The identification of the identification scheme.</li>
     *         <li>[String] <b>schemeName</b> <b>[0..1]</b> : The name of the identification scheme.</li>
     *         <li>[String] <b>schemeAgencyID</b> <b>[0..1]</b> : The identification of the agency that maintains the identification scheme.</li>
     *         <li>[String] <b>schemeAgencyName</b> <b>[0..1]</b> : The name of the agency that maintains the identification scheme.</li>
     *         <li>[String] <b>schemeVersionID</b> <b>[0..1]</b> : The version of the identification scheme.</li>
     *         <li>[String] <b>schemeDataURI</b> <b>[0..1]</b> : The Uniform Resource Identifier that identifies where the identification scheme data is located.</li>
     *         <li>[String] <b>schemeURI</b> <b>[0..1]</b> : The Uniform Resource Identifier that identifies where the identification scheme is located.</li>
     *     </ul>
     *     </li>
     * </ul>
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
