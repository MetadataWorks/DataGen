package uk.org.metadata.dataclass

import uk.org.metadata.datagen.DataEnum
import uk.org.metadata.datagen.DataItem
import uk.org.metadata.datagen.SharedDatasets

class MVPClientLevelData extends DataClassSpreadsheet{

    int numberOfRows
    int numberOfRowsFalseData
    ArrayList<DataItem> mvpDataItems = null

    MVPClientLevelData(int rows, int falseRows) {

        numberOfRows = rows
        numberOfRowsFalseData = falseRows
        mvpDataItems = new ArrayList<DataItem>()
        setupDataStructures()

    }

        int getNumberOfRows() {
            return numberOfRows
        }

        int getNumberOfRowsFalseData() {
            return numberOfRowsFalseData
        }

        void setupDataStructures() {

            SharedDatasets test = new SharedDatasets()

            DataItem ClientIdLocal = new DataItem("ClientIdLocal", "[0-9]{10}")
            ClientIdLocal.generateItems(numberOfRows, numberOfRowsFalseData)
            mvpDataItems << ClientIdLocal

            DataItem NHSNumber = new DataItem("NHS Number", "[0-9]{10}" )
            NHSNumber.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems <<  NHSNumber

            DataItem firstName = new DataItem("Forenames", "[a-zA-Z\\ _']{1,50}")
            firstName.generateFirstNames(numberOfRows,numberOfRowsFalseData)
            mvpDataItems.add(firstName)

            DataItem lastName = new DataItem("Surname",  "[a-zA-Z\\ _']{1,50}")
            lastName.generateLastNames(numberOfRows,numberOfRowsFalseData)
            mvpDataItems.add(lastName)

            DataItem Gender = new DataItem( "Gender", SharedDatasets.PersonStatedGender)
            Gender.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems <<  Gender

            DataItem Ethnicity = new DataItem("Ethnicity",  SharedDatasets.Ethnicity)
            Ethnicity.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems <<  Ethnicity

            DataItem DateOfBirth =  new DataItem("Date Of Birth", "[a-zA-Z\\ _']{1,50}")
            DateOfBirth.generateDates(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << DateOfBirth

            DataItem DateOfDeath =  new DataItem("Date Of Death", "[a-zA-Z\\ _']{1,50}")
            DateOfDeath.generateDatesAfter(numberOfRows,numberOfRowsFalseData, 2003)
            mvpDataItems << DateOfDeath

            DataItem Postcode =  new DataItem("Postcode", "(GIR ?0AA|[A-PR-UWYZ]([0-9]{1,2}|([A-HK-Y][0-9]([0-9ABEHMNPRV-Y])?)|[0-9][A-HJKPS-UW]) ?[0-9][ABD-HJLNP-UW-Z]{2})")
            Postcode.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << Postcode

            DataItem AccommodationStatus = new DataItem("Accommodation Status",  SharedDatasets.AccommodationStatus)
            AccommodationStatus.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems <<  AccommodationStatus




        }

    ArrayList<DataItem> getDataItems(){

        return mvpDataItems

    }


}
