package com.company.xml.ubl.attributes;

/**
 * Class PatternFile
 */
public class PatternFile {

    private String format;
    private String mimeCode;
    private String encodingCode;
    private String characterSetCode;
    private String uri;
    private String filename;

    /**
     * <h2>Attributes "PatternScheme"</h2>
     * <p>Contains :</p>
     * <ul>
     *     <li><b>for build()</b>
     *     <ul>
     *         <li>[String] <b>format</b> <b>[0..1]</b> : The format of the binary content.</li>
     *         <li>[String] <b>mimeCode</b> <b>[1..1]</b> : The mime type of the binary object.</li>
     *         <li>[String] <b>encodingCode</b> <b>[0..1]</b> : Specifies the decoding algorithm of the binary object.</li>
     *         <li>[String] <b>characterSetCode</b> <b>[0..1]</b> : The character set of the binary object if the mime type is text.</li>
     *         <li>[String] <b>uri</b> <b>[0..1]</b> : The Uniform Resource Identifier that identifies where the binary object is located.</li>
     *         <li>[String] <b>filename</b> <b>[0..1]</b> : The filename of the binary object.</li>
     *     </ul>
     *     </li>
     * </ul>
     */
    private PatternFile(PatternFileBuilder builder) {
        this.format = builder.format;
        this.mimeCode = builder.mimeCode;
        this.encodingCode = builder.encodingCode;
        this.characterSetCode = builder.characterSetCode;
        this.uri = builder.uri;
        this.filename = builder.filename;
    }

    /**
     * Builder PatternFile
     */
    public static class PatternFileBuilder {

        private String format;
        private String mimeCode;
        private String encodingCode;
        private String characterSetCode;
        private String uri;
        private String filename;

        public PatternFileBuilder() {}

        public PatternFileBuilder format(String format){
            this.format = format;
            return this;
        }
        public PatternFileBuilder mimeCode(String mimeCode){
            this.mimeCode = mimeCode;
            return this;
        }
        public PatternFileBuilder encodingCode(String encodingCode){
            this.encodingCode = encodingCode;
            return this;
        }
        public PatternFileBuilder characterSetCode(String characterSetCode){
            this.characterSetCode = characterSetCode;
            return this;
        }
        public PatternFileBuilder uri(String uri){
            this.uri = uri;
            return this;
        }
        public PatternFileBuilder filename(String filename){
            this.filename = filename;
            return this;
        }
        public PatternFile build(){
            PatternFile patternFile = new PatternFile(this);
            return patternFile;
        }

    }

    public String getFormat() {
        return format;
    }

    public String getMimeCode() {
        return mimeCode;
    }

    public String getEncodingCode() {
        return encodingCode;
    }

    public String getCharacterSetCode() {
        return characterSetCode;
    }

    public String getUri() {
        return uri;
    }

    public String getFilename() {
        return filename;
    }
}
