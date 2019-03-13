package uk.org.metadata.dataclass

import uk.org.metadata.dataclass.DataClassSpreadsheet
import uk.org.metadata.datagen.DataEnum
import uk.org.metadata.datagen.DataItem
import uk.org.metadata.datagen.SharedDatasets

class CancerCohortRegistration extends DataClassSpreadsheet{

    int numberOfRows
    int numberOfRowsFalseData

    ArrayList<DataItem> ccrDataItems = null
    List<DataEnum> TestResultType = null



    List<DataEnum> PersonKarytypicSex = null
    List<DataEnum> Ethnicity = null
    List<DataEnum> ChoiceYesNo = null
    List<DataEnum> ChoiceYesNoNR = null
    List<DataEnum> ChoiceYesNoUK = null
    List<DataEnum> ConsentForm = null
    List<DataEnum> ParticipantType = null
    List<DataEnum> Consanguinity = null
    List<DataEnum> BiologicalRelationship = null
    List<DataEnum> GroupType = null
    List<DataEnum> SpecificDisease = null
    SharedDatasets sharedData = null


    CancerCohortRegistration(int noOfRows,int noOfRowsFalseData ){
        numberOfRows = noOfRows
        numberOfRowsFalseData = noOfRowsFalseData
        ccrDataItems = new ArrayList<DataItem>()
        setupDataStructures()
    }

    void setupDataStructures(){

        sharedData = new SharedDatasets()
        sharedData.setupData()

        TestResultType = new ArrayList()
        TestResultType.add(new DataEnum("2","Female"))
        TestResultType.add(new DataEnum("1","Male"))
        TestResultType.add(new DataEnum("9","Indeterminate"))




    }


    ArrayList<DataItem> getDataItems(){

        //GetFirstElementFromREST()
        DataItem partid = new DataItem("Participant ID",  "[0-9]{9}")
        partid.generateNumbers(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << partid

        DataItem dob = new DataItem("Date of Birth")
        dob.generateDates(numberOfRows,numberOfRowsFalseData)
        ccrDataItems.add(dob)
        DataItem surname = new DataItem("Surname",  "[a-zA-Z\\ _']{1,50}")
        surname.generateLastNames(numberOfRows,numberOfRowsFalseData)
        ccrDataItems.add(surname)
        DataItem forename = new DataItem("Forenames", "[a-zA-Z\\ _']{1,50}")
        forename.generateFirstNames(numberOfRows,numberOfRowsFalseData)
        ccrDataItems.add(forename)
        DataItem NHSNumber = new DataItem("NHS Number", "[0-9]{10}" )
        NHSNumber.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  NHSNumber

        DataItem CHINumber = new DataItem("CHI Number", "[0-9]{10}" )
        CHINumber.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  CHINumber
        DataItem HealthCareNumber = new DataItem("Health & Car Number", "[0-9]{10}" )
        HealthCareNumber.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  HealthCareNumber
        DataItem CohortPersonNumber = new DataItem("Cohort Person Number", "[a-zA-Z0-9\\ _]{9}" )
        CohortPersonNumber.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  CohortPersonNumber
        DataItem RegistrationDate = new DataItem("Registration Date")
        RegistrationDate.generateDates(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  RegistrationDate
        DataItem RegistrationReference = new DataItem("Registration Reference", "[a-zA-Z\\ _']{1,50}")
        RegistrationReference.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  RegistrationReference
        DataItem SurnameAtBirth = new DataItem("Surname at Birth", "[a-zA-Z\\ _']{1,50}")
        SurnameAtBirth.generateLastNames(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  SurnameAtBirth
        DataItem PersonStatedGender = new DataItem( "Person Stated Gender", SharedDatasets.PersonStatedGender)
        PersonStatedGender.generateChoices(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  PersonStatedGender
        DataItem PersonPhenotypicSex = new DataItem("Person Phenotypic Sex",  SharedDatasets.PersonPhenotypicSex)
        PersonPhenotypicSex.generateChoices(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  PersonPhenotypicSex
        DataItem Ethnicity = new DataItem("Ethnicity",  SharedDatasets.Ethnicity)
        Ethnicity.generateChoices(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  Ethnicity
        DataItem RecruitingTrustId = new DataItem("Recruiting Trust Id", "[a-zA-Z0-9]{3,9}")
        RecruitingTrustId.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems <<  RecruitingTrustId

        DataItem ParticipantEmailAddress = new DataItem("Participant Email Address", "[a-zA-Z\\ _']{1,50}")
        ParticipantEmailAddress.generateEmailAddress(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ParticipantEmailAddress
        DataItem ParticipantHomeTelephone = new DataItem("Participant Home Telephone", "[a-zA-Z\\ _']{1,50}")
        ParticipantHomeTelephone.generatePhoneNumber(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ParticipantHomeTelephone
        DataItem ParticipantMobileTelephone =  new DataItem("Participant Mobile Telephone", "[a-zA-Z\\ _']{1,50}")
        ParticipantMobileTelephone.generatePhoneNumber(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ParticipantMobileTelephone
        DataItem AddressLine1 = new DataItem("Address Line 1", "[a-zA-Z\\ _']{1,50}")
        AddressLine1.generateAddressStreetLine(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << AddressLine1
        DataItem AddressLine2 =  new DataItem("Address Line 2", "[a-zA-Z\\ _']{1,50}")
        AddressLine2.generateAddressStreetLine(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << AddressLine2
        DataItem AddressLine3 =  new DataItem("Address Line 3", "[a-zA-Z\\ _']{1,50}")
        AddressLine3.generateAddressStreetLine(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << AddressLine3
        DataItem AddressLine4 =  new DataItem("Address Line 4", "[a-zA-Z\\ _']{1,50}")
        AddressLine4.generateAddressCityLine(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << AddressLine4
        DataItem AddressLine5 =  new DataItem("Address Line 5", "[a-zA-Z\\ _']{1,50}")
        AddressLine5.generateAddressCountryLine(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << AddressLine5
        DataItem Postcode =  new DataItem("Postcode", "(GIR ?0AA|[A-PR-UWYZ]([0-9]{1,2}|([A-HK-Y][0-9]([0-9ABEHMNPRV-Y])?)|[0-9][A-HJKPS-UW]) ?[0-9][ABD-HJLNP-UW-Z]{2})")
        Postcode.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << Postcode

        DataItem FullNameofResponsibleConsultant =  new DataItem("Full Name of Responsible Consultant", "[a-zA-Z\\ _']{1,50}")
        FullNameofResponsibleConsultant.generateFullNames(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << FullNameofResponsibleConsultant
        DataItem ConsultantGMCNumber =  new DataItem("Consultant GMC Number", "[a-zA-Z0-9]{6,8}")
        ConsultantGMCNumber.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ConsultantGMCNumber
        DataItem FullNameNotConsultant =  new DataItem("Full Name Not Consultant", "[a-zA-Z\\ _']{8,50}")
        FullNameNotConsultant.generateFullNames(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << FullNameNotConsultant
        DataItem ContactNumber =  new DataItem("Contact Number", "[a-zA-Z\\ _']{1,50}")
        ContactNumber.generatePhoneNumber(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ContactNumber
        DataItem HospitalofResponsibleConsultant =  new DataItem("Hospital of Responsible Consultant", "[a-zA-Z0-9]{8,9}")
        HospitalofResponsibleConsultant.generateFullNames(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << HospitalofResponsibleConsultant


        DataItem ConsentDate =  new DataItem("Consent Date", "[a-zA-Z\\ _']{1,50}")
        ConsentDate.generateDates(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ConsentDate
        DataItem ConsentReference =  new DataItem("Consent Reference Event Reference", "[a-zA-Z\\ _']{5,10}")
        ConsentReference.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ConsentReference
        DataItem NameandVersionofConsentForm =  new DataItem("Name and Version of Consent Form", "[a-zA-Z\\ _']{10,12}")
        NameandVersionofConsentForm.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << NameandVersionofConsentForm
        DataItem ConsentGiven =  new DataItem("Consent Given", SharedDatasets.ChoiceYesNo )
        ConsentGiven.generateChoices(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ConsentGiven
        DataItem ConsentForm =  new DataItem("Consent Form", "[a-zA-Z0-9]{9}")
        ConsentForm.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ConsentForm
        DataItem PersonTakingConsent =  new DataItem("Person Taking Consent", "[a-zA-Z\\ _']{20,50}")
        PersonTakingConsent.generateFullNames(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << PersonTakingConsent
        DataItem NameandVersionofParticipantInformationSheet =  new DataItem("Name and Version of Participant Information Sheet", "[a-zA-Z0-9]{10,20}")
        NameandVersionofParticipantInformationSheet.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << NameandVersionofParticipantInformationSheet
        DataItem NameandVerisonofAssentForm =  new DataItem("Name and Verison of Assent Form", "[a-zA-Z\\ _']{10,20}")
        NameandVerisonofAssentForm.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << NameandVerisonofAssentForm
        DataItem AssentForm = new DataItem("Assent Form", "[a-zA-Z\\ _']{10,20}")
        AssentForm.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << AssentForm
        DataItem AdditionalOptionalConsentMaterials = new DataItem("Additional Optional Consent Materials", "[a-zA-Z\\ _']{10,20}")
        AdditionalOptionalConsentMaterials.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << AdditionalOptionalConsentMaterials
        DataItem ReproductiveAdditionalFindings =  new DataItem("Reproductive Additional Findings", "[a-zA-Z\\ _']{10,20}")
        ReproductiveAdditionalFindings.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << ReproductiveAdditionalFindings
        DataItem HealthRelatedAdditionalFindings =  new DataItem("Health Related Additional Findings", "[a-zA-Z\\ _']{10,20}")
        HealthRelatedAdditionalFindings.generateItems(numberOfRows,numberOfRowsFalseData)
        ccrDataItems << HealthRelatedAdditionalFindings

        return ccrDataItems

    }

}
