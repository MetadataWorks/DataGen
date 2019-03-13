package uk.org.metadata.dataclass

import uk.org.metadata.dataclass.DataClassSpreadsheet
import uk.org.metadata.datagen.DataItem
import uk.org.metadata.datagen.SharedDatasets

class CancerSampleTrackingTestResults extends DataClassSpreadsheet{

    ArrayList<DataItem> cstTestDataItems = null

    int numberOfRows = 1
    int numberOfRowsFalseData = 1

    CancerSampleTrackingTestResults(int rows,int falseRows){

        numberOfRows = rows
        numberOfRowsFalseData = falseRows
        cstTestDataItems = new ArrayList<DataItem>()
        setupDataStructures()

    }

    int getNumberOfRows(){
        return numberOfRows
    }

    int getNumberOfRowsFalseData(){
        return numberOfRowsFalseData
    }

    void setupDataStructures(){

        SharedDatasets test = new SharedDatasets()

        DataItem SampleID = new DataItem("CSample ID", "[0-~]{1,25}")
        SampleID.generateItems(numberOfRows,numberOfRowsFalseData)
        cstTestDataItems <<  SampleID

        DataItem TestResultType = new DataItem("Test Result Type", SharedDatasets.TestResultType)
        TestResultType.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstTestDataItems <<  TestResultType

        DataItem TestResultDateTime = new DataItem("Test Result Date Time")
        TestResultDateTime.generateDateTimesAtMiddayISO8601(numberOfRows,numberOfRowsFalseData)
        cstTestDataItems <<  TestResultDateTime

        DataItem TestResultValue = new DataItem("Test Result Value", "[a-zA-Z0-9]{500}")
        TestResultValue.generateItems(numberOfRows,numberOfRowsFalseData)
        cstTestDataItems <<  TestResultValue

        DataItem partid = new DataItem("Participant ID",  "[0-9]{9}")
        partid.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstTestDataItems << partid

        DataItem LaboratoryID = new DataItem("Laboratory ID", "[a-zA-Z0-9]{5,9}")
        LaboratoryID.generateItems(numberOfRows,numberOfRowsFalseData)
        cstTestDataItems <<  LaboratoryID

        DataItem LaboratorySampleID = new DataItem("Laboratory Sample ID", "\\d{10}")
        LaboratorySampleID.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstTestDataItems <<  LaboratorySampleID

    }

    ArrayList<DataItem> getDataItems(){

        return cstTestDataItems

    }




}
