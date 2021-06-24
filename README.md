# XML-UBL

![version](https://img.shields.io/badge/version-1.0.0-blue.svg)
[![CodeFactor](https://www.codefactor.io/repository/github/orelink/xml-ubl/badge?s=03295c42823b0c8be2bb295524bc2791b93da76d)](https://www.codefactor.io/repository/github/orelink/xml-ubl)
![contribution](https://img.shields.io/badge/contribution-yes-green.svg)

`Description coming soon...` 

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

### Version 1 (Element creation)

All code has been documented and will be used by you when creating document, element and attributes. The syntax of the code documentation has been optimized for IntelliJ. Here is the example of the documentation for the `TaxTotal` element :

![image](https://user-images.githubusercontent.com/35436186/122730536-9c984500-d27a-11eb-827c-eb747f2f1290.png)

* **Element "TaxTotal"** : *Element name.*
* **use in CreditNoteLine [0..*]** : *List of parent elements in which this child element is used, as well as the cardinality of the child element in each parent element.*
* **An association to TaxTotal** : *Element description.*
* **for build() + load()** : *List of parameters required to generate this element, not to generate an object of this element. This is traditionally `documentLinked`, the document into which this element should be inserted, and `elementFather`, the element that will become the parent of this newly generated element.*
* **for build()** : *List of parameters included in the generation of an object of this element. We indicate the expected type in square brackets (String for parameters with cardinality [0/1..1] and List for [0/1..*]), the name of the parameter, its cardinality, as well as a brief description of its usefulness.*

Since this is version 1 of element creation, the attributes are present in build () as <element_name>_Attribute<attribute_name>.

### Version 2 (Element creation)

`Documentation coming soon...`

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
*Example : The `Country` element can be called in the XML document with the module "Postal Address" as parent.*

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
        


## Array of elements

This is the list of possible elements in a UBL template, as well as some information about them in this project :
* **Name** : element name.
* **Version 2** : if this element can be implemented in version 2 of element creation (🟢yes, 🔴no).
* **Credit Note 2.0 [Cardinality]** : if this element can be implemented in the UBL CreditNote 2.0 template of the project (🟢yes, 🔴no). As well as its cardinality in this template.

| Name | Version 2 | Credit Note 2.0 [Cardinality] |
| ------- | ----------- | ------------ |
| UBLExtensions | 🔴 | 🔴 [0..1] |
| UBLVersionID | 🟢 | 🟢 [0..1] |
| ... | ... | ... |

## Release history

| Release | Description | Release date |
| ------- | ----------- | ------------ |
|  *to come up*  | **This same tool with additional features** : *Generation of a complete UBL CreditNote 2.0 template, generation of a complete Invoice 2.0 template, creation of the user manual, improvement of README...etc* | *to come up* |
|  1.0.0  | **Launch of the tool with basic functionalities** : *Generation of a partially supported UBL CreditNote version 2.0 template (the most common modules, elements and attributes are available), complete code documentation* | Jun. 18 2021 |
    
## License

The license is available [here](https://github.com/oreLINK/XML-UBL/blob/master/LICENSE.md).

## Contributors

* [oreLINK](https://github.com/oreLINK)

## Contributions

<!---*This project doesn't accept external contributions.*--->
*This project accepts external contributions.*
