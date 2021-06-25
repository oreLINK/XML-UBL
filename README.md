# XML-UBL

![version](https://img.shields.io/badge/version-1.1.0-blue.svg)
[![CodeFactor](https://www.codefactor.io/repository/github/orelink/xml-ubl/badge?s=03295c42823b0c8be2bb295524bc2791b93da76d)](https://www.codefactor.io/repository/github/orelink/xml-ubl)
![contribution](https://img.shields.io/badge/contribution-yes-green.svg)

Java library for generating and downloading XML files in UBL format. The [Universal Business Language](https://en.wikipedia.org/wiki/Universal_Business_Language) (UBL) is an open library of standard electronic XML business documents for procurement and transport such as purchase orders, invoices, transport logistics and waybills. This library has been optimized to facilitate the generation of such documents and to automate the insertion of data into them.

## Prerequisites

### For the development

![IntelliJ_IDEA](https://user-images.githubusercontent.com/35436186/77335680-c769b580-6d26-11ea-87c2-344ef53d79c5.png) |
--- |
[IntelliJ IDEA](https://www.jetbrains.com/idea/) ✔ |

### For use

`Documentation coming soon...` 

## Installation

`Documentation coming soon...` 

## Demo

`Documentation coming soon...`

## Code documentation

All code has been documented and will be used by you when creating document, element and attributes. The syntax of the code documentation has been optimized for IntelliJ. Here is the example of the documentation for the `TaxTotal` element :

* **Element "TaxTotal"** : *Element name.*
* **use in CreditNoteLine [0..*]** : *List of parent elements in which this child element is used, as well as the cardinality of the child element in each parent element.*
* **An association to TaxTotal** : *Element description.*
* **for build() + load()** : *List of parameters required to generate this element, not to generate an object of this element. This is traditionally `documentLinked`, the document into which this element should be inserted, and `elementFather`, the element that will become the parent of this newly generated element.*
* **for build()** : *List of parameters included in the generation of an object of this element. We indicate the expected type in square brackets, the name of the parameter, its cardinality, as well as a brief description of its usefulness.*

![image](https://user-images.githubusercontent.com/35436186/123387437-10e32900-d598-11eb-8301-b13cb71f4e58.png)

## Utilisation

### Overall structure

Here is how your Java code will be structured to create an XML file with a UBL template :

```
<Document creation>
        <Element 1 creation>
        <Element 2 creation>    
                <Element 1.1 (from Module 1) creation>
        <Module 1 creation>   
                <Element 2.1 (from Module 2) creation>
                <Element 2.2 (from Module 2) creation>
        <Module 2 creation>
                        <Element 3.1.1 (from Module 3.1) creation>
                        <Element 3.1.2 (from Module 3.1) creation>
                <Module 3.1 (from Module 3) creation>
                <Element 3.1 (from Module 3) creation>
        <Module 3 creation>     
<Template creation>
<Document generation>           
```


### Document creation

This is the first level, the document, which contains all the other tools to generate a UBL template.<br>
You must first declare and initialize the desired document by entering its name (with .xml) and the path in which it must be saved.
```java
DocumentT doc = new DocumentT("<name>.xml", "<path>");
doc.initialize();
```

### Template creation



### Module creation



### Element creation (version 2)

The elements are the basis for creating an xml document with UBL template. These are the `<cbc>` tags. They contain these parameters :
        
| Name | Type | Obligatory ? | Description |
| ------- | ----------- | ------------ | ------- |
| value | String | 🟢 | Value for this element. |
| attributes | PatternAttribute | 🔴 | Attributes available for this element. |
        
An element can be created in only two places, either with the template itself as parent, or with a module as parent :
        
#### Template as parent
        
This declaration corresponds to <Element creation> `1` and `2` of the Overall structure section.<br>
*Example : The `UBLVersionID` element can be called in the XML document with the template itself as parent.*
        
> with attributes
        
```java
UBLVersionID ublVersionID = new UBLVersionID.UBLVersionIDBuilder()
                .value(<String>)
                .attributes(new <PatternAttribute>)
                .build();
```  
        
> without attributes
    
```java
UBLVersionID ublVersionID = new UBLVersionID.UBLVersionIDBuilder()
                .value(<String>)
                .build();
```  
        
#### Module as parent     
        
This declaration corresponds to <Element creation> `1.1`, `2.1`, `2.2`, `3.1.1.`, `3.1.2` and `3.1` of the Overall structure section.<br>
*Example : The `Country` module contains the elements `identificationCode` [0..1] and `name` [0..1]. These elements therefore have the `Country` module as parent.*

> with attributes
        
```java
Country country = new Country.CountryBuilder()
                .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                        .value(<String>)
                        .attributes(new <PatternAttribute>)
                        .build())
                .name(new Name.NameBuilder()
                        .value(<String>)
                        .attributes(new <PatternAttribute>)
                        .build())
                .build();
```  
        
> without attributes
    
```java
Country country = new Country.CountryBuilder()
                .identificationCode(new IdentificationCode.IdentificationCodeBuilder()
                        .value(<String>)
                        .build())
                .name(new Name.NameBuilder()
                        .value(<String>)
                        .build())
                .build();
```

Be sure to look at the cardinality of all the parameters of the elements. They are displayed in the code itself.
        
### Attribute creation
        
        
        
## List of templates
        
Caption :
* ❌ This module/element is not compatible with this template
* 🔴 This module/element is not yet implemented in this template.
* 🟠 This module/element is currently being implemented and will be available in a future release.
* 🟢 This module/element is implemented and can be used in this template.
        
### Credit Note 2.0

This section groups together all the modules and elements present in the Credit Note 2.0 template.
   
| Name | Condition | Cardinality | Type |
| ------- | ----------- | ------------ | ------------ |
| UBLVersionID | 🟢 | **[0..1]** | Element | 
| CustomizationID | 🟢 | **[0..1]** | Element |
| ProfileID | 🟢 | **[0..1]** | Element |
| ID | 🟢 | **[1..1]** | Element | 
| IssueDate | 🟢 | **[1..1]** | Element |
| DocumentCurrencyCode | 🟢 | **[0..1]** | Element |
| OrderReference | 🟢 | **[0..1]** | Module | 
| BillingReference | 🟢 | **[0..*]** | Module |
| AdditionalDocumentReference | 🟢 | **[0..*]** | Module |
| AccountingSupplierParty | 🟢 | **[1..1]** | Module | 
| AccountingCustomerParty | 🟢 | **[1..1]** | Module |
| TaxTotal | 🟢 | **[0..*]** | Module |
| LegalMonetaryTotal | 🟢 | **[1..1]** | Module | 
| CreditNoteLine | 🟢 | **[1..*]** | Module |
        
### Invoice 2.0

This section groups together all the modules and elements present in the Invoice 2.0 template.<br>
   
| Name | Condition | Cardinality | Type |
| ------- | ----------- | ------------ | ------------ |
| UBLVersionID | 🟢 | **[0..1]** | Element | 
| CustomizationID | 🟢 | **[0..1]** | Element |
| ProfileID | 🟢 | **[0..1]** | Element |
| ID | 🟢 | **[1..1]** | Element | 
| IssueDate | 🟢 | **[1..1]** | Element |
| InvoiceTypeCode | 🟢 | **[0..1]** | Element |
| DocumentCurrencyCode | 🟢 | **[0..1]** | Element |
| OrderReference | 🟢 | **[0..1]** | Module | 
| AdditionalDocumentReference | 🟢 | **[0..*]** | Module |
| AccountingSupplierParty | 🟢 | **[1..1]** | Module | 
| AccountingCustomerParty | 🟢 | **[1..1]** | Module |
| PaymentMeans | 🟢 | **[0..*]** | Module |
| TaxTotal | 🟢 | **[0..*]** | Module |
| LegalMonetaryTotal | 🟢 | **[1..1]** | Module | 
| InvoiceLine | 🟢 | **[1..*]** | Module |

## Example
        
In this example the cardinalities of the different elements and modules are respected. This is not the case with the cardinalities of the `CreditNote 2.0` template. Otherwise we would have had to add all the modules / elements to the cardinalities **[1..1/*]**, which would have been long and unreadable. This example repeats all of the creation sections seen previously.
        
### Java code
        
```java
//TEMPLATE DECLARATION
DocumentT docCreditNote20 = new DocumentT("CreditNote-2-0.xml", "");
        docCreditNote20.initialize();

//UBL VERSION ID
UBLVersionID ublVersionIDCreditNote20 = new UBLVersionID.UBLVersionIDBuilder()
        .value("2.0")
        .build();

//PROFILE ID
ProfileID profileIDCreditNote20 = new ProfileID.ProfileIDBuilder()
        .value("tan:www.bizbil.fr:profile:zbb09:bou1.0")
        .attributes(new PatternScheme.PatternSchemeBuilder()
                .schemeAgencyID("FRA/NASA RT/EDF")
                .schemeID("WAL 18052:2021")
                .schemeVersionID("1")
                .build())
        .build();

//ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT > EMBEDDED DOCUMENT BINARY OBJECT
EmbeddedDocumentBinaryObject embeddedDocumentBinaryObjectCreditNote20 = new EmbeddedDocumentBinaryObject.EmbeddedDocumentBinaryObjectBuilder()
        .value("dsfdsfkjslkjsd...")
        .attributes(new PatternFile.PatternFileBuilder()
                .encodingCode("Base64")
                .filename("facture_avril.pdf")
                .mimeCode("application/pdf")
                .build())
        .build();

//ADDITIONAL DOCUMENT REFERENCE > ATTACHMENT
Attachment attachmentCreditNote20 = new Attachment.AttachmentBuilder()
        .embeddedDocumentBinaryObject(embeddedDocumentBinaryObjectCreditNote20)
        .build();

//ADDITIONAL DOCUMENT REFERENCE
List<AdditionalDocumentReference> additionalDocumentReferenceCreditNote20 = new ArrayList<>();
AdditionalDocumentReference additionalDocumentReferenceCreditNote201 = new AdditionalDocumentReference.AdditionalDocumentReferenceBuilder()
        .id(new ID.IDBuilder()
                .value("attachment-2")
                .build())
        .documentTypeCode(new DocumentTypeCode.DocumentTypeCodeBuilder()
                .value("attachment")
                .attributes(new PatternList.PatternListBuilder()
                        .listID("urn:tradeshift.com:api:1.0:documenttypecode")
                        .build())
                .build())
        .attachment(attachmentCreditNote20)
        .build();
additionalDocumentReferenceCreditNote20.add(additionalDocumentReferenceCreditNote201);

//TEMPLATE CREDIT NOTE 2.0
Element elementUBLCreditNote20 = new UBLCreditNote20.UBLCreditNote20Builder()
        .documentLinked(docCreditNote20.getDoc())
        .ublVersionID(ublVersionIDCreditNote20)
        .profileID(profileIDCreditNote20)
        .additionalDocumentReferenceList(additionalDocumentReferenceCreditNote20)
        .build()
        .load();

docCreditNote20.generate();
```

### XML File
     
```xml
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<CreditNote xmlns="urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2"
            xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2"
            xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2">
    <cbc:UBLVersionID>2.0</cbc:UBLVersionID>
    <cbc:ProfileID schemeAgencyID="FRA/NASA RT/EDF" schemeID="WAL 18052:2021" schemeVersionID="1">
        tan:www.bizbil.fr:profile:zbb09:bou1.0
    </cbc:ProfileID>
    <cac:AdditionalDocumentReference>
        <cbc:ID>attachment-2</cbc:ID>
        <cbc:DocumentTypeCode listID="urn:tradeshift.com:api:1.0:documenttypecode">attachment</cbc:DocumentTypeCode>
        <cac:Attachment>
            <cbc:EmbeddedDocumentBinaryObject encodingCode="Base64" filename="facture_avril.pdf"
                                              mimeCode="application/pdf">dsfdsfkjslkjsd...
            </cbc:EmbeddedDocumentBinaryObject>
        </cac:Attachment>
    </cac:AdditionalDocumentReference>
</CreditNote>
```

## Release history

| Release | Description | Release date |
| ------- | ----------- | ------------ |
|  1.1.0  | **This same tool with additional features** : *Generation of a complete UBL CreditNote 2.0 template, generation of a complete Invoice 2.0 template, creation of the user manual, improvement of README...etc* | *to come up* |
|  1.0.0  | **Launch of the tool with basic functionalities** : *Generation of a partially supported UBL CreditNote version 2.0 template (the most common modules, elements and attributes are available), complete code documentation* | Jun. 18 2021 |
    
## License

The license is available [here](https://github.com/oreLINK/XML-UBL/blob/master/LICENSE.md).

## Contributors

* [oreLINK](https://github.com/oreLINK)

## Contributions

<!---*This project doesn't accept external contributions.*--->
*This project accepts external contributions.*
