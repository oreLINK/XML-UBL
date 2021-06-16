package com.company.xml.ubl.modules;

import com.company.xml.ubl.axioms.AttributeT;
import com.company.xml.ubl.axioms.ElementT;
import com.company.xml.ubl.axioms.Tips;
import com.company.xml.ubl.data.AttributesName;
import com.company.xml.ubl.data.ElementsName;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class PartyLegalEntity {

    private Document doc;
    private Element element;
    private String registrationName;
    private String companyId;
    private String companyId_AttributeSchemeId;
    private List<RegistrationAddress> registrationAddressList = new ArrayList<>();
    private List<CorporateRegistrationScheme> corporateRegistrationSchemeList = new ArrayList<>();

    private PartyLegalEntity(PartyLegalEntityBuilder builder) {
        this.doc = builder.doc;
        this.element = builder.element;
        this.registrationName = builder.registrationName;
        this.companyId = builder.companyId;
        this.companyId_AttributeSchemeId = builder.companyId_AttributeSchemeId;
        this.registrationAddressList = builder.registrationAddressList;
        this.corporateRegistrationSchemeList = builder.corporateRegistrationSchemeList;
    }

    public static class PartyLegalEntityBuilder {

        private Document doc;
        private Element element;
        private String registrationName;
        private String companyId;
        private String companyId_AttributeSchemeId;
        private List<RegistrationAddress> registrationAddressList = new ArrayList<>();
        private List<CorporateRegistrationScheme> corporateRegistrationSchemeList = new ArrayList<>();

        public PartyLegalEntityBuilder(){}

        public PartyLegalEntityBuilder documentLinked(Document doc){
            this.doc = doc;
            return this;
        }
        public PartyLegalEntityBuilder elementFather(Element element){
            this.element = element;
            return this;
        }
        public PartyLegalEntityBuilder registrationName(String registrationName){
            this.registrationName = registrationName;
            return this;
        }
        public PartyLegalEntityBuilder companyId(String companyId){
            this.companyId = companyId;
            return this;
        }
        public PartyLegalEntityBuilder companyId_AttributeSchemeId(String companyId_AttributeSchemeId){
            this.companyId_AttributeSchemeId = companyId_AttributeSchemeId;
            return this;
        }
        public PartyLegalEntityBuilder registrationAddressList(List<RegistrationAddress> registrationAddressList){
            this.registrationAddressList = registrationAddressList;
            return this;
        }
        public PartyLegalEntityBuilder corporateRegistrationSchemeList(List<CorporateRegistrationScheme> corporateRegistrationSchemeList){
            this.corporateRegistrationSchemeList = corporateRegistrationSchemeList;
            return this;
        }
        public PartyLegalEntity build(){
            PartyLegalEntity partyLegalEntity = new PartyLegalEntity(this);
            return partyLegalEntity;
        }

    }

    public String getRegistrationName() {
        return registrationName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyId_AttributeSchemeId() {
        return companyId_AttributeSchemeId;
    }

    public List<RegistrationAddress> getRegistrationAddressList() {
        return registrationAddressList;
    }

    public List<CorporateRegistrationScheme> getCorporateRegistrationSchemeList() {
        return corporateRegistrationSchemeList;
    }

    public Element load() {
        //Generate root element
        Element elementPartyLegalEntity = new ElementT(doc, element, ElementsName.PARTY_LEGAL_ENTITY.label).load();

        //Generate tag "RegistrationName"
        if(!Tips.stringIsNull(registrationName)){
            Element elementRegistrationName = new ElementT(doc, elementPartyLegalEntity, ElementsName.PARTY_LEGAL_ENTITY_REGISTRATION_NAME.label, registrationName).load();
        }
        //Generate tag "CompanyID" and attribute "schemeID"
        if(!Tips.stringIsNull(companyId)){
            Element elementCompanyID = new ElementT(doc, elementPartyLegalEntity, ElementsName.PARTY_LEGAL_ENTITY_COMPANY_ID.label, companyId).load();
            if(!Tips.stringIsNull(companyId_AttributeSchemeId)){
                Attr elementCompanyID_Attr1 = new AttributeT(doc, elementCompanyID, AttributesName.PARTY_LEGAL_ENTITY_COMPANYID_ATTR_SCHEME_ID.label, companyId_AttributeSchemeId).load();
            }
        }

        //Generate element.s "RegistrationAddress"
        if(!Tips.listIsNull(registrationAddressList)){
            for (RegistrationAddress registrationAddress : registrationAddressList) {
                Element elementRegistrationAddress = new RegistrationAddress.RegistrationAddressBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyLegalEntity)
                        .id(registrationAddress.getId())
                        .id_AttributeSchemeId(registrationAddress.getId_AttributeSchemeId())
                        .addressFormatCode(registrationAddress.getAddressFormatCode())
                        .addressFormatCode_AttributeListAgencyId(registrationAddress.getAddressFormatCode_AttributeListAgencyId())
                        .addressFormatCode_AttributeListId(registrationAddress.getAddressFormatCode_AttributeListId())
                        .postBox(registrationAddress.getPostBox())
                        .streetName(registrationAddress.getStreetName())
                        .buildingNumber(registrationAddress.getBuildingNumber())
                        .cityName(registrationAddress.getCityName())
                        .postalZone(registrationAddress.getPostalZone())
                        .build().load();
            }
        }

        //Generate element.s "CorporateRegistrationScheme"
        if(!Tips.listIsNull(corporateRegistrationSchemeList)){
            for (CorporateRegistrationScheme corporateRegistrationScheme : corporateRegistrationSchemeList) {
                Element elementCorporateRegistrationScheme = new CorporateRegistrationScheme.CorporateRegistrationSchemeBuilder()
                        .documentLinked(doc)
                        .elementFather(elementPartyLegalEntity)
                        .id(corporateRegistrationScheme.getId())
                        .build().load();
            }
        }

        return elementPartyLegalEntity;
    }

}
