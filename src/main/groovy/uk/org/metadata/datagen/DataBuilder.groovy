package uk.org.metadata.datagen

import org.modelcatalogue.spreadsheet.builder.poi.PoiSpreadsheetBuilder
import uk.org.metadata.dataclass.CancerCohortRegistration
import uk.org.metadata.dataclass.DataClassSpreadsheet
import uk.org.metadata.dataclass.RareDiseaseConsentAndPhenotype

class DataBuilder {


    static void buildRareDiseaseRegAndPhenotypeDataset(String filename,int numberOfRows,int numberOfRowsFalseData){
        File file = new File(filename)

        int counter1 = 0
        int counter2 = 0

        RareDiseaseConsentAndPhenotype rds = new RareDiseaseConsentAndPhenotype()

        def col1 = new DataItem("Cohort Person Number", "[a-zA-Z0-9\\ _]{9}" )
        def col2 = new DataItem("Date of Birth")
        def col3 = new DataItem("Postcode", "(GIR ?0AA|[A-PR-UWYZ]([0-9]{1,2}|([A-HK-Y][0-9]([0-9ABEHMNPRV-Y])?)|[0-9][A-HJKPS-UW]) ?[0-9][ABD-HJLNP-UW-Z]{2})")
        def col4 = new DataItem("Forenames", "[a-zA-Z\\ _']{1,50}")
        def col5 = new DataItem("Surname",  "[a-zA-Z\\ _']{1,50}")
        def col6 = new DataItem("Participant ID",  "[0-9]{9}")
        def col7 = new DataItem("Family ID",  "[0-9]{9}")
        def col8 = new DataItem("Person Phenotypic Sex",  rds.PersonPhenotypicSex)
        def col9 = new DataItem("Person Karyotypic Sex",  rds.PersonKarytypicSex)
        def col10 = new DataItem("Ethnicity",  rds.Ethnicity)

        col1.generateNumbers(numberOfRows,numberOfRowsFalseData)
        col2.generateDates(numberOfRows,numberOfRowsFalseData)
        col3.generateItems(numberOfRows,numberOfRowsFalseData)
        col4.generateFirstNames(numberOfRows,numberOfRowsFalseData)
        col5.generateLastNames(numberOfRows,numberOfRowsFalseData)
        col6.generateItems(numberOfRows,numberOfRowsFalseData)
        col7.generateItems(numberOfRows,numberOfRowsFalseData)
        col8.generateChoices(numberOfRows,numberOfRowsFalseData)
        col9.generateChoices(numberOfRows,numberOfRowsFalseData)
        col10.generateChoices(numberOfRows,numberOfRowsFalseData)

        def col11 = new DataItem("Local Case Identifer", "[a-zA-Z0-9]{3,9}")
        def col12 = new DataItem("Consent Given",  rds.ChoiceYesNo)
        def col13 = new DataItem("Name and Version of Consent Form", rds.ConsentForm)
        def col14 = new DataItem("Date of Consent")
        def col15 = new DataItem("Person Taking Consent", "[a-zA-Z\\ _']{5,50}")
        def col16 = new DataItem("Do you want additional health issues looking for?", rds.ChoiceYesNo)
        def col17 = new DataItem("Do you want to be tested for carrier genes?", rds.ChoiceYesNoNR)
        def col18 = new DataItem("Participant Type" , rds.ParticipantType )
        def col19 = new DataItem("Consanguinity", rds.Consanguinity )
        def col20 = new DataItem("Mother Affected", rds.ChoiceYesNoUK )

        col11.generateItems(numberOfRows,numberOfRowsFalseData)
        col12.generateChoices(numberOfRows,numberOfRowsFalseData)
        col13.generateChoiceKeys(numberOfRows,numberOfRowsFalseData)
        col14.generateDates(numberOfRows,numberOfRowsFalseData)
        col15.generateFullNames(numberOfRows,numberOfRowsFalseData)
        col16.generateChoices(numberOfRows,numberOfRowsFalseData)
        col17.generateChoices(numberOfRows,numberOfRowsFalseData)
        col18.generateChoices(numberOfRows,numberOfRowsFalseData)
        col19.generateChoices(numberOfRows,numberOfRowsFalseData)
        col20.generateChoices(numberOfRows,numberOfRowsFalseData)

        def col21 = new DataItem("Father Affected", rds.ChoiceYesNoUK )
        def col22 = new DataItem("Penetrance" , rds.ChoiceYesNoUK)
        def col23 = new DataItem("Proband Date of Birth *")
        def col24 = new DataItem("Proband Forenames *")
        def col25 = new DataItem("Proband Surname *")
        def col26 = new DataItem("Biological Relationship to Proband *", rds.BiologicalRelationship)
        def col27 = new DataItem("Other Biological Relationship to Proband *","[a-zA-Z\\ _']{10,20}")
        def col28 = new DataItem("Full Name of Responsible Consultant *","[a-zA-Z\\ _']{10,20}")
        def col29 = new DataItem("Mothers Ethnic Origin *", rds.Ethnicity)
        def col30 = new DataItem("Mothers Ethnic Origin Other","[a-zA-Z\\ _']{10,20}")

        col21.generateChoices(numberOfRows,numberOfRowsFalseData)
        col22.generateChoices(numberOfRows,numberOfRowsFalseData)
        col23.generateDates(numberOfRows,numberOfRowsFalseData)
        col24.generateFirstNames(numberOfRows,numberOfRowsFalseData)
        col25.generateLastNames(numberOfRows,numberOfRowsFalseData)
        col26.generateChoices(numberOfRows,numberOfRowsFalseData)
        col27.generateItems(numberOfRows,numberOfRowsFalseData)
        col28.generateFullNames(numberOfRows,numberOfRowsFalseData)
        col29.generateChoices(numberOfRows,numberOfRowsFalseData)
        col30.generateItems(numberOfRows,numberOfRowsFalseData)

        def col31 = new DataItem("Mothers Other Relevant Ancestry","[a-zA-Z\\ _']{10,20}")
        def col32 = new DataItem("Fathers Ethnic Origin *", rds.Ethnicity)
        def col33 = new DataItem("Fathers Ethnic Origin Other","[a-zA-Z\\ _']{10,20}")
        def col34= new DataItem("Fathers Other Relevant Ancestry","[a-zA-Z\\ _']{10,20}")
        def col35 = new DataItem("Maternal Family History of Endocrine Tumours *",rds.ChoiceYesNoUK)
        def col36 = new DataItem("Maternal Family History of Colorectal Cancer *",rds.ChoiceYesNoUK)
        def col37 = new DataItem("Maternal Family History of Breast and/or Ovarian Cancer *",rds.ChoiceYesNoUK)
        def col38 = new DataItem("Maternal Family History of Ischaemic Heart Disease or Stroke *",rds.ChoiceYesNoUK)
        def col39 = new DataItem("Paternal Family History of Endocrine Tumours *",rds.ChoiceYesNoUK)
        def col40 = new DataItem("Paternal Family History of Ischaemic Heart Disease or Stroke *",rds.ChoiceYesNoUK)

        col31.generateItems(numberOfRows,numberOfRowsFalseData)
        col32.generateChoices(numberOfRows,numberOfRowsFalseData)
        col33.generateItems(numberOfRows,numberOfRowsFalseData)
        col34.generateItems(numberOfRows,numberOfRowsFalseData)
        col35.generateChoices(numberOfRows,numberOfRowsFalseData)
        col36.generateChoices(numberOfRows,numberOfRowsFalseData)
        col37.generateChoices(numberOfRows,numberOfRowsFalseData)
        col38.generateChoices(numberOfRows,numberOfRowsFalseData)
        col39.generateChoices(numberOfRows,numberOfRowsFalseData)
        col40.generateChoices(numberOfRows,numberOfRowsFalseData)

        def col41 = new DataItem("Paternal Family History of Colorectal Cancer *",rds.ChoiceYesNoUK)
        def col42 = new DataItem("Paternal Family History of Breast and/or Ovarian Cancer *",rds.ChoiceYesNoUK)
        def col43 = new DataItem("Group Type", rds.GroupType)
        def col44 = new DataItem("Specific Disease", rds.SpecificDisease)
        def col45 = new DataItem("Age of Onset", "0?[0-9]?[0-9]?1[0-4][0-9] ")
        col41.generateChoices(numberOfRows,numberOfRowsFalseData)
        col42.generateChoices(numberOfRows,numberOfRowsFalseData)
        col43.generateChoices(numberOfRows,numberOfRowsFalseData)
        col44.generateChoices(numberOfRows,numberOfRowsFalseData)
        col45.generateNumbers(numberOfRows,numberOfRowsFalseData)


        PoiSpreadsheetBuilder.INSTANCE.build  {
            sheet('Data Registration') {
                row {
                    cell col1.getName()
                    cell col2.getName()
                    cell col3.getName()
                    cell col4.getName()
                    cell col5.getName()
                    cell col6.getName()
                    cell col7.getName()
                    cell col8.getName()
                    cell col9.getName()
                    cell col10.getName()

                    cell col11.getName()
                    cell col12.getName()
                    cell col13.getName()
                    cell col14.getName()
                    cell col15.getName()
                    cell col16.getName()
                    cell col17.getName()
                    cell col18.getName()
                    cell col19.getName()
                    cell col20.getName()

                    cell col21.getName()
                    cell col22.getName()
                    cell col23.getName()
                    cell col24.getName()
                    cell col25.getName()
                    cell col26.getName()
                    cell col27.getName()
                    cell col28.getName()
                    cell col29.getName()
                    cell col30.getName()

                    cell col31.getName()
                    cell col32.getName()
                    cell col33.getName()
                    cell col34.getName()
                    cell col35.getName()
                    cell col36.getName()
                    cell col37.getName()
                    cell col38.getName()
                    cell col39.getName()
                    cell col40.getName()

                    cell col41.getName()
                    cell col42.getName()
                    cell col43.getName()
                    cell col44.getName()
                    cell col45.getName()


                }
                numberOfRows.times {

                    row {
                        cell col1.values.get(counter1)
                        cell col2.values.get(counter1)
                        cell col3.values.get(counter1)
                        cell col4.values.get(counter1)
                        cell col5.values.get(counter1)
                        cell col6.values.get(counter1)
                        cell col7.values.get(counter1)
                        cell col8.values.get(counter1)
                        cell col9.values.get(counter1)
                        cell col10.values.get(counter1)

                        cell col11.values.get(counter1)
                        cell col12.values.get(counter1)
                        cell col13.values.get(counter1)
                        cell col14.values.get(counter1)
                        cell col15.values.get(counter1)
                        cell col16.values.get(counter1)
                        cell col17.values.get(counter1)
                        cell col18.values.get(counter1)
                        cell col19.values.get(counter1)
                        cell col20.values.get(counter1)

                        cell col21.values.get(counter1)
                        cell col22.values.get(counter1)
                        cell col23.values.get(counter1)
                        cell col24.values.get(counter1)
                        cell col25.values.get(counter1)
                        cell col26.values.get(counter1)
                        cell col27.values.get(counter1)
                        cell col28.values.get(counter1)
                        cell col29.values.get(counter1)
                        cell col30.values.get(counter1)

                        cell col31.values.get(counter1)
                        cell col32.values.get(counter1)
                        cell col33.values.get(counter1)
                        cell col34.values.get(counter1)
                        cell col35.values.get(counter1)
                        cell col36.values.get(counter1)
                        cell col37.values.get(counter1)
                        cell col38.values.get(counter1)
                        cell col39.values.get(counter1)
                        cell col40.values.get(counter1)

                        cell col41.values.get(counter1)
                        cell col42.values.get(counter1)
                        cell col43.values.get(counter1)
                        cell col44.values.get(counter1)
                        cell col45.values.get(counter1)

                    }
                    counter1++
                }

                numberOfRowsFalseData.times {

                    row {
                        cell col1.negativeValues.get(counter2)
                        cell col2.negativeValues.get(counter2)
                        cell col3.negativeValues.get(counter2)
                        cell col4.negativeValues.get(counter2)
                        cell col5.negativeValues.get(counter2)
                        cell col6.negativeValues.get(counter2)
                        cell col7.negativeValues.get(counter2)
                        cell col8.negativeValues.get(counter2)
                        cell col9.negativeValues.get(counter2)
                        cell col10.negativeValues.get(counter2)

                        cell col11.negativeValues.get(counter2)
                        cell col12.negativeValues.get(counter2)
                        cell col13.negativeValues.get(counter2)
                        cell col14.negativeValues.get(counter2)
                        cell col15.negativeValues.get(counter2)
                        cell col16.negativeValues.get(counter2)
                        cell col17.negativeValues.get(counter2)
                        cell col18.negativeValues.get(counter2)
                        cell col19.negativeValues.get(counter2)
                        cell col20.negativeValues.get(counter2)

                        cell col21.negativeValues.get(counter2)
                        cell col22.negativeValues.get(counter2)
                        cell col23.negativeValues.get(counter2)
                        cell col24.negativeValues.get(counter2)
                        cell col25.negativeValues.get(counter2)
                        cell col26.negativeValues.get(counter2)
                        cell col27.negativeValues.get(counter2)
                        cell col28.negativeValues.get(counter2)
                        cell col29.negativeValues.get(counter2)
                        cell col30.negativeValues.get(counter2)

                        cell col31.negativeValues.get(counter2)
                        cell col32.negativeValues.get(counter2)
                        cell col33.negativeValues.get(counter2)
                        cell col34.negativeValues.get(counter2)
                        cell col35.negativeValues.get(counter2)
                        cell col36.negativeValues.get(counter2)
                        cell col37.negativeValues.get(counter2)
                        cell col38.negativeValues.get(counter2)
                        cell col39.negativeValues.get(counter2)
                        cell col40.negativeValues.get(counter2)

                        cell col41.negativeValues.get(counter2)
                        cell col42.negativeValues.get(counter2)
                        cell col43.negativeValues.get(counter2)
                        cell col44.negativeValues.get(counter2)
                        cell col45.negativeValues.get(counter2)

                    }
                    counter2++
                }
            }
        } writeTo file

    }

    static void buildCancerCohortsDataset(String filename,int numberOfRows,int numberOfRowsFalseData){
        File file = new File(filename)

        int counter1 = 0
        int counter2 = 0

        RareDiseaseConsentAndPhenotype rds = new RareDiseaseConsentAndPhenotype()

        def col1 = new DataItem("Cohort Person Number", "[a-zA-Z0-9\\ _]{9}" )
        def col2 = new DataItem("Date of Birth")
        def col3 = new DataItem("Postcode", "(GIR ?0AA|[A-PR-UWYZ]([0-9]{1,2}|([A-HK-Y][0-9]([0-9ABEHMNPRV-Y])?)|[0-9][A-HJKPS-UW]) ?[0-9][ABD-HJLNP-UW-Z]{2})")
        def col4 = new DataItem("Forenames", "[a-zA-Z\\ _']{1,50}")
        def col5 = new DataItem("Surname",  "[a-zA-Z\\ _']{1,50}")
        def col6 = new DataItem("Participant ID",  "[0-9]{9}")
        def col7 = new DataItem("Family ID",  "[0-9]{9}")
        def col8 = new DataItem("Person Phenotypic Sex",  rds.PersonPhenotypicSex)
        def col9 = new DataItem("Person Karyotypic Sex",  rds.PersonKarytypicSex)
        def col10 = new DataItem("Ethnicity",  rds.Ethnicity)

        col1.generateNumbers(numberOfRows,numberOfRowsFalseData)
        col2.generateDates(numberOfRows,numberOfRowsFalseData)
        col3.generateItems(numberOfRows,numberOfRowsFalseData)
        col4.generateFirstNames(numberOfRows,numberOfRowsFalseData)
        col5.generateLastNames(numberOfRows,numberOfRowsFalseData)
        col6.generateItems(numberOfRows,numberOfRowsFalseData)
        col7.generateItems(numberOfRows,numberOfRowsFalseData)
        col8.generateChoices(numberOfRows,numberOfRowsFalseData)
        col9.generateChoices(numberOfRows,numberOfRowsFalseData)
        col10.generateChoices(numberOfRows,numberOfRowsFalseData)

        def col11 = new DataItem("Local Case Identifer", "[a-zA-Z0-9]{3,9}")
        def col12 = new DataItem("Consent Given",  rds.ChoiceYesNo)
        def col13 = new DataItem("Name and Version of Consent Form", rds.ConsentForm)
        def col14 = new DataItem("Date of Consent")
        def col15 = new DataItem("Person Taking Consent", "[a-zA-Z\\ _']{5,50}")
        def col16 = new DataItem("Do you want additional health issues looking for?", rds.ChoiceYesNo)
        def col17 = new DataItem("Do you want to be tested for carrier genes?", rds.ChoiceYesNoNR)
        def col18 = new DataItem("Participant Type" , rds.ParticipantType )
        def col19 = new DataItem("Consanguinity", rds.Consanguinity )
        def col20 = new DataItem("Mother Affected", rds.ChoiceYesNoUK )

        col11.generateItems(numberOfRows,numberOfRowsFalseData)
        col12.generateChoices(numberOfRows,numberOfRowsFalseData)
        col13.generateChoiceKeys(numberOfRows,numberOfRowsFalseData)
        col14.generateDates(numberOfRows,numberOfRowsFalseData)
        col15.generateFullNames(numberOfRows,numberOfRowsFalseData)
        col16.generateChoices(numberOfRows,numberOfRowsFalseData)
        col17.generateChoices(numberOfRows,numberOfRowsFalseData)
        col18.generateChoices(numberOfRows,numberOfRowsFalseData)
        col19.generateChoices(numberOfRows,numberOfRowsFalseData)
        col20.generateChoices(numberOfRows,numberOfRowsFalseData)

        def col21 = new DataItem("Father Affected", rds.ChoiceYesNoUK )
        def col22 = new DataItem("Penetrance" , rds.ChoiceYesNoUK)
        def col23 = new DataItem("Proband Date of Birth *")
        def col24 = new DataItem("Proband Forenames *")
        def col25 = new DataItem("Proband Surname *")
        def col26 = new DataItem("Biological Relationship to Proband *", rds.BiologicalRelationship)
        def col27 = new DataItem("Other Biological Relationship to Proband *","[a-zA-Z\\ _']{10,20}")
        def col28 = new DataItem("Full Name of Responsible Consultant *","[a-zA-Z\\ _']{10,20}")
        def col29 = new DataItem("Mothers Ethnic Origin *", rds.Ethnicity)
        def col30 = new DataItem("Mothers Ethnic Origin Other","[a-zA-Z\\ _']{10,20}")

        col21.generateChoices(numberOfRows,numberOfRowsFalseData)
        col22.generateChoices(numberOfRows,numberOfRowsFalseData)
        col23.generateDates(numberOfRows,numberOfRowsFalseData)
        col24.generateFirstNames(numberOfRows,numberOfRowsFalseData)
        col25.generateLastNames(numberOfRows,numberOfRowsFalseData)
        col26.generateChoices(numberOfRows,numberOfRowsFalseData)
        col27.generateItems(numberOfRows,numberOfRowsFalseData)
        col28.generateFullNames(numberOfRows,numberOfRowsFalseData)
        col29.generateChoices(numberOfRows,numberOfRowsFalseData)
        col30.generateItems(numberOfRows,numberOfRowsFalseData)

        def col31 = new DataItem("Mothers Other Relevant Ancestry","[a-zA-Z\\ _']{10,20}")
        def col32 = new DataItem("Fathers Ethnic Origin *", rds.Ethnicity)
        def col33 = new DataItem("Fathers Ethnic Origin Other","[a-zA-Z\\ _']{10,20}")
        def col34= new DataItem("Fathers Other Relevant Ancestry","[a-zA-Z\\ _']{10,20}")
        def col35 = new DataItem("Maternal Family History of Endocrine Tumours *",rds.ChoiceYesNoUK)
        def col36 = new DataItem("Maternal Family History of Colorectal Cancer *",rds.ChoiceYesNoUK)
        def col37 = new DataItem("Maternal Family History of Breast and/or Ovarian Cancer *",rds.ChoiceYesNoUK)
        def col38 = new DataItem("Maternal Family History of Ischaemic Heart Disease or Stroke *",rds.ChoiceYesNoUK)
        def col39 = new DataItem("Paternal Family History of Endocrine Tumours *",rds.ChoiceYesNoUK)
        def col40 = new DataItem("Paternal Family History of Ischaemic Heart Disease or Stroke *",rds.ChoiceYesNoUK)

        col31.generateItems(numberOfRows,numberOfRowsFalseData)
        col32.generateChoices(numberOfRows,numberOfRowsFalseData)
        col33.generateItems(numberOfRows,numberOfRowsFalseData)
        col34.generateItems(numberOfRows,numberOfRowsFalseData)
        col35.generateChoices(numberOfRows,numberOfRowsFalseData)
        col36.generateChoices(numberOfRows,numberOfRowsFalseData)
        col37.generateChoices(numberOfRows,numberOfRowsFalseData)
        col38.generateChoices(numberOfRows,numberOfRowsFalseData)
        col39.generateChoices(numberOfRows,numberOfRowsFalseData)
        col40.generateChoices(numberOfRows,numberOfRowsFalseData)

        def col41 = new DataItem("Paternal Family History of Colorectal Cancer *",rds.ChoiceYesNoUK)
        def col42 = new DataItem("Paternal Family History of Breast and/or Ovarian Cancer *",rds.ChoiceYesNoUK)
        def col43 = new DataItem("Group Type", rds.GroupType)
        def col44 = new DataItem("Specific Disease", rds.SpecificDisease)
        def col45 = new DataItem("Age of Onset", "0?[0-9]?[0-9]?1[0-4][0-9] ")
        col41.generateChoices(numberOfRows,numberOfRowsFalseData)
        col42.generateChoices(numberOfRows,numberOfRowsFalseData)
        col43.generateChoices(numberOfRows,numberOfRowsFalseData)
        col44.generateChoices(numberOfRows,numberOfRowsFalseData)
        col45.generateNumbers(numberOfRows,numberOfRowsFalseData)


        PoiSpreadsheetBuilder.INSTANCE.build  {
            sheet('Data Registration') {
                row {
                    cell col1.getName()
                    cell col2.getName()
                    cell col3.getName()
                    cell col4.getName()
                    cell col5.getName()
                    cell col6.getName()
                    cell col7.getName()
                    cell col8.getName()
                    cell col9.getName()
                    cell col10.getName()

                    cell col11.getName()
                    cell col12.getName()
                    cell col13.getName()
                    cell col14.getName()
                    cell col15.getName()
                    cell col16.getName()
                    cell col17.getName()
                    cell col18.getName()
                    cell col19.getName()
                    cell col20.getName()

                    cell col21.getName()
                    cell col22.getName()
                    cell col23.getName()
                    cell col24.getName()
                    cell col25.getName()
                    cell col26.getName()
                    cell col27.getName()
                    cell col28.getName()
                    cell col29.getName()
                    cell col30.getName()

                    cell col31.getName()
                    cell col32.getName()
                    cell col33.getName()
                    cell col34.getName()
                    cell col35.getName()
                    cell col36.getName()
                    cell col37.getName()
                    cell col38.getName()
                    cell col39.getName()
                    cell col40.getName()

                    cell col41.getName()
                    cell col42.getName()
                    cell col43.getName()
                    cell col44.getName()
                    cell col45.getName()


                }
                numberOfRows.times {

                    row {
                        cell col1.values.get(counter1)
                        cell col2.values.get(counter1)
                        cell col3.values.get(counter1)
                        cell col4.values.get(counter1)
                        cell col5.values.get(counter1)
                        cell col6.values.get(counter1)
                        cell col7.values.get(counter1)
                        cell col8.values.get(counter1)
                        cell col9.values.get(counter1)
                        cell col10.values.get(counter1)

                        cell col11.values.get(counter1)
                        cell col12.values.get(counter1)
                        cell col13.values.get(counter1)
                        cell col14.values.get(counter1)
                        cell col15.values.get(counter1)
                        cell col16.values.get(counter1)
                        cell col17.values.get(counter1)
                        cell col18.values.get(counter1)
                        cell col19.values.get(counter1)
                        cell col20.values.get(counter1)

                        cell col21.values.get(counter1)
                        cell col22.values.get(counter1)
                        cell col23.values.get(counter1)
                        cell col24.values.get(counter1)
                        cell col25.values.get(counter1)
                        cell col26.values.get(counter1)
                        cell col27.values.get(counter1)
                        cell col28.values.get(counter1)
                        cell col29.values.get(counter1)
                        cell col30.values.get(counter1)

                        cell col31.values.get(counter1)
                        cell col32.values.get(counter1)
                        cell col33.values.get(counter1)
                        cell col34.values.get(counter1)
                        cell col35.values.get(counter1)
                        cell col36.values.get(counter1)
                        cell col37.values.get(counter1)
                        cell col38.values.get(counter1)
                        cell col39.values.get(counter1)
                        cell col40.values.get(counter1)

                        cell col41.values.get(counter1)
                        cell col42.values.get(counter1)
                        cell col43.values.get(counter1)
                        cell col44.values.get(counter1)
                        cell col45.values.get(counter1)

                    }
                    counter1++
                }

                numberOfRowsFalseData.times {

                    row {
                        cell col1.negativeValues.get(counter2)
                        cell col2.negativeValues.get(counter2)
                        cell col3.negativeValues.get(counter2)
                        cell col4.negativeValues.get(counter2)
                        cell col5.negativeValues.get(counter2)
                        cell col6.negativeValues.get(counter2)
                        cell col7.negativeValues.get(counter2)
                        cell col8.negativeValues.get(counter2)
                        cell col9.negativeValues.get(counter2)
                        cell col10.negativeValues.get(counter2)

                        cell col11.negativeValues.get(counter2)
                        cell col12.negativeValues.get(counter2)
                        cell col13.negativeValues.get(counter2)
                        cell col14.negativeValues.get(counter2)
                        cell col15.negativeValues.get(counter2)
                        cell col16.negativeValues.get(counter2)
                        cell col17.negativeValues.get(counter2)
                        cell col18.negativeValues.get(counter2)
                        cell col19.negativeValues.get(counter2)
                        cell col20.negativeValues.get(counter2)

                        cell col21.negativeValues.get(counter2)
                        cell col22.negativeValues.get(counter2)
                        cell col23.negativeValues.get(counter2)
                        cell col24.negativeValues.get(counter2)
                        cell col25.negativeValues.get(counter2)
                        cell col26.negativeValues.get(counter2)
                        cell col27.negativeValues.get(counter2)
                        cell col28.negativeValues.get(counter2)
                        cell col29.negativeValues.get(counter2)
                        cell col30.negativeValues.get(counter2)

                        cell col31.negativeValues.get(counter2)
                        cell col32.negativeValues.get(counter2)
                        cell col33.negativeValues.get(counter2)
                        cell col34.negativeValues.get(counter2)
                        cell col35.negativeValues.get(counter2)
                        cell col36.negativeValues.get(counter2)
                        cell col37.negativeValues.get(counter2)
                        cell col38.negativeValues.get(counter2)
                        cell col39.negativeValues.get(counter2)
                        cell col40.negativeValues.get(counter2)

                        cell col41.negativeValues.get(counter2)
                        cell col42.negativeValues.get(counter2)
                        cell col43.negativeValues.get(counter2)
                        cell col44.negativeValues.get(counter2)
                        cell col45.negativeValues.get(counter2)

                    }
                    counter2++
                }
            }
        } writeTo file



    }

    static void buildcancerCohortsDataset(String filename,int numberOfRows,int numberOfRowsFalseData){
        File file = new File(filename)

        int counter1 = 0
        int counter2 = 0

        CancerCohortRegistration ccr = new CancerCohortRegistration(numberOfRows,numberOfRowsFalseData)
        ArrayList<DataItem> ccrDataItems = ccr.getDataItems()

        PoiSpreadsheetBuilder.INSTANCE.build  {
            sheet('Data Registration') {
                row {
                    ccrDataItems.each{
                        cell it.getName()
                    }
                }
                numberOfRows.times {
                    row {
                        ccrDataItems.each{
                            cell it.values.get(counter1)
                        }
                    }
                    counter1++
                }

                numberOfRowsFalseData.times {
                    row {
                        row {
                            ccrDataItems.each{
                                cell it.negativeValues.get(counter2)
                            }
                        }
                    }
                    counter2++
                }
            }
        } writeTo file

    }

    static void buildDataset(DataClassSpreadsheet dataset, String sheetName, String filename ){
        File file = new File(filename)

        int counter1 = 0
        int counter2 = 0

        ArrayList<DataItem> ccrDataItems = dataset.getDataItems()
        int numberOfRows = dataset.getNumberOfRows()
        int numberOfRowsFalseData = dataset.getNumberOfRowsFalseData()

        PoiSpreadsheetBuilder.INSTANCE.build  {
            sheet(sheetName) {
                row {
                    ccrDataItems.each{
                        cell it.getName()
                    }
                }
                numberOfRows.times {
                    row {
                        ccrDataItems.each{
                            cell it.values.get(counter1)
                        }
                    }
                    counter1++
                }

                numberOfRowsFalseData.times {
                    row {
                        row {
                            ccrDataItems.each{
                                cell it.negativeValues.get(counter2)
                            }
                        }
                    }
                    counter2++
                }
            }
        } writeTo file

    }
}
