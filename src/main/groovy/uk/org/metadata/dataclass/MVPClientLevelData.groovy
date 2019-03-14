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

            DataItem EmploymentStatus = new DataItem("Employment Status",  SharedDatasets.EmploymentStatus)
            EmploymentStatus.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems <<  EmploymentStatus

            DataItem hasCarer =  new DataItem("Has Carer", SharedDatasets.ChoiceYesNo )
            hasCarer.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << hasCarer

            DataItem clientType =  new DataItem("Client Type", SharedDatasets.DHSCClientType )
            clientType.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << clientType

            DataItem CaredForLinkedID = new DataItem("Cared For Linked ID", "[0-9]{10}")
            CaredForLinkedID.generateItems(numberOfRows, numberOfRowsFalseData)
            mvpDataItems << CaredForLinkedID

            DataItem primarySupportReason = new DataItem("Primary Support Reason",  "[a-zA-Z\\ _']{1,50}")
            primarySupportReason.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems.add(primarySupportReason)

            DataItem eventRef = new DataItem("Event Reference",  "[0-9]{10}")
            eventRef.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems.add(eventRef)

            DataItem eventDate = new DataItem("Event Date")
            eventDate.generateDates(numberOfRows,numberOfRowsFalseData)
            mvpDataItems.add(eventDate)

            DataItem routeOfAccess =  new DataItem("Client Type", SharedDatasets.DHSCRouteOfAccess )
            routeOfAccess.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << routeOfAccess

            DataItem eventType =  new DataItem("Event Type", SharedDatasets.DHSCEventType )
            eventType.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << eventType

            DataItem eventGroup =  new DataItem("Event Group", "[a-zA-Z\\ _']{1,50}" )
            eventGroup.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << eventGroup

            DataItem eventResult =  new DataItem("Event Result", "[a-zA-Z\\ _']{1,50}" )
            eventResult.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << eventResult

            DataItem startDate =  new DataItem("Start Date" )
            startDate.generateDates(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << startDate

            DataItem endDate =  new DataItem("End Date" )
            endDate.generateDates(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << endDate

            DataItem localDefinition =  new DataItem("Local Definition", "[a-zA-Z\\ _']{1,50}" )
            localDefinition.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << localDefinition

            DataItem reviewReason =  new DataItem("Review Reason", SharedDatasets.DHSCReviewReason )
            reviewReason.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << reviewReason

            DataItem serviceType =  new DataItem("Service Type", "[a-zA-Z\\ _']{1,50}" )
            serviceType.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << serviceType

            DataItem fundingType =  new DataItem("Funding Type", SharedDatasets.DHSCFundingType )
            fundingType.generateChoices(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << fundingType

            DataItem unitCost = new DataItem("Unit Cost",  "[0-9]+(\\.[0-9]{1,2})?")
            unitCost.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << unitCost

            DataItem plannedUnits = new DataItem("Planned Units",  "[0-9]{10}")
            plannedUnits.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems.add(plannedUnits)

            DataItem costFrequency = new DataItem("Cost Frequency",  "[0-9]+(\\.[0-9]{1,2})?")
            costFrequency.generateItems(numberOfRows,numberOfRowsFalseData)
            mvpDataItems << costFrequency




        }

    ArrayList<DataItem> getDataItems(){

        return mvpDataItems

    }


}
