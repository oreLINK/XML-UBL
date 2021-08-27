package com.company.xml.ubl.attributes;

/**
 * Class PatternList
 */
public class PatternList {

    private String listID;
    private String listAgencyID;
    private String listAgencyName;
    private String listName;
    private String listVersionID;
    private String name;
    private String languageID;
    private String listURI;
    private String listSchemeURI;

    /**
     * <h2>Attributes "PatternList"</h2>
     * <p>Contains :</p>
     * <ul>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>listID</b> <b>[0..1]</b> : No description.</li>
     *         <li>[String] <b>listAgencyID</b> <b>[0..1]</b> : Defaults to the UN/EDIFACT data element 3055 code list.</li>
     *         <li>[String] <b>listAgencyName</b> <b>[0..1]</b> : No description.</li>
     *         <li>[String] <b>listName</b> <b>[0..1]</b> : No description.</li>
     *         <li>[String] <b>listVersionID</b> <b>[0..1]</b> : No description.</li>
     *         <li>[String] <b>name</b> <b>[0..1]</b> : No description.</li>
     *         <li>[String] <b>languageID</b> <b>[0..1]</b> : No description.</li>
     *         <li>[String] <b>listURI</b> <b>[0..1]</b> : No description.</li>
     *         <li>[String] <b>listSchemeURI</b> <b>[0..1]</b> : No description.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PatternList(PatternListBuilder builder) {
        this.listID = builder.listID;
        this.listAgencyID = builder.listAgencyID;
        this.listAgencyName = builder.listAgencyName;
        this.listName = builder.listName;
        this.listVersionID = builder.listVersionID;
        this.name = builder.name;
        this.languageID = builder.languageID;
        this.listURI = builder.listURI;
        this.listSchemeURI = builder.listSchemeURI;
    }

    /**
     * Builder PatternList
     */
    public static class PatternListBuilder {

        private String listID;
        private String listAgencyID;
        private String listAgencyName;
        private String listName;
        private String listVersionID;
        private String name;
        private String languageID;
        private String listURI;
        private String listSchemeURI;

        public PatternListBuilder() {}

        public PatternListBuilder listID(String listID){
            this.listID = listID;
            return this;
        }
        public PatternListBuilder listAgencyID(String listAgencyID){
            this.listAgencyID = listAgencyID;
            return this;
        }
        public PatternListBuilder listAgencyName(String listAgencyName){
            this.listAgencyName = listAgencyName;
            return this;
        }
        public PatternListBuilder listName(String listName){
            this.listName = listName;
            return this;
        }
        public PatternListBuilder listVersionID(String listVersionID){
            this.listVersionID = listVersionID;
            return this;
        }
        public PatternListBuilder name(String name){
            this.name = name;
            return this;
        }
        public PatternListBuilder languageID(String languageID){
            this.languageID = languageID;
            return this;
        }
        public PatternListBuilder listURI(String listURI){
            this.listURI = listURI;
            return this;
        }
        public PatternListBuilder listSchemeURI(String listSchemeURI){
            this.listSchemeURI = listSchemeURI;
            return this;
        }
        public PatternList build(){
            PatternList patternList = new PatternList(this);
            return patternList;
        }

    }

    public String getListID() {
        return listID;
    }

    public String getListAgencyID() {
        return listAgencyID;
    }

    public String getListAgencyName() {
        return listAgencyName;
    }

    public String getListName() {
        return listName;
    }

    public String getListVersionID() {
        return listVersionID;
    }

    public String getName() {
        return name;
    }

    public String getLanguageID() {
        return languageID;
    }

    public String getListURI() {
        return listURI;
    }

    public String getListSchemeURI() {
        return listSchemeURI;
    }
}
