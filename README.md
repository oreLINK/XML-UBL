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

### Document creation

This is the first level, the document, which contains all the other tools to generate a UBL template.<br>
You must first declare and initialize the desired document by entering its name (in .xml) and the path in which it must be saved.
```java
DocumentT doc = new DocumentT("<name>.xml", "<path>");
doc.initialize();
```

### Element creation

This is the second level, the elements are contained in a document and possibly have a parent element.<br>
To create an element, there are two versions, version 1, the oldest and the more generic version 2 which will eventually replace version 1. Only a few elements are compatible with version 2. To find them out, refer to array of elements.

> During creation, since this is a nesting of child elements within parent elements, we always start by declaring the child elements before the parent element, and this recursively until it is not 'there is more than the value of the element, and (optionally) its attributes.

#### Version 1

This version 1 implements a few attributes of each element by hand. It is not very generic and is set to disappear. Here is how to generate the `TaxTotal` element which also contains another optional element, `TaxSubTotal`.

1. First, because the cardinality of `TaxSubTotal` in `TaxTotal` is [0..*], it is a list. We must therefore initialize the list (for cardinality type [0/1..1] it will only be String).

```java
List<TaxSubTotal> taxSubTotalListCNL = new ArrayList<>();
```

2. Second, you have to create the `TaxSubTotal` object only via `build()`, because you don't want a generated element but an object that can be manipulated by its parent elements. Only parent elements N-1 (direct children of the root element) can generate the elements and therefore use the `load()` function.<br>
In this example, we assume that a list of `TaxCategory` objects has already been created with the name `taxCategoryList`, and so on...

```java
TaxSubTotal taxSubTotalCNL = new TaxSubTotal.TaxSubTotalBuilder()
        .taxableAmount("109.24")
        .taxableAmount_AttributeCurrencyID("EUR")
        .taxAmount("21.85")
        .taxAmount_AttributeCurrencyID("EUR")
        .calculationSequenceNumeric("1")
        .taxCategoryList(taxCategoryListCNL)
        .build();
```

3. Third, we add the `TaxSubTotal` object to the previously created list.

```java
taxSubTotalListCNL.add(taxSubTotalCNL);
```

`Documentation coming soon...`

#### Version 2

`Documentation coming soon...`

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
