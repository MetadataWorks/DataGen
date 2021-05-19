package uk.org.metadata.dataclass

import uk.org.metadata.datagen.DataEnum
import uk.org.metadata.datagen.DataItem
import uk.org.metadata.datagen.SharedDatasets

class CancerInvestTumour extends DataClassSpreadsheet {

    List<DataEnum> TestResultType = null
    ArrayList<DataItem> cstDataItems = null

    List<DataEnum> participant_id = null
    List<DataEnum> tumour_id = null
    List<DataEnum> ovarian_ca125 = null
    List<DataEnum> prostate_pre_treatment_psa = null
    List<DataEnum> prostate_psa = null
    List<DataEnum> event_date = null
    int numberOfRows = 1
    int numberOfRowsFalseData = 1

    CancerInvestTumour(int rows,int falseRows){

        setupDataStructures()
        numberOfRows = rows
        numberOfRowsFalseData = falseRows
        cstDataItems = new ArrayList<DataItem>()
    }

    void setupDataStructures(){

        SharedDatasets test = new SharedDatasets()
        TestResultType = new ArrayList()
        TestResultType.add(new DataEnum("2","Female"))
        TestResultType.add(new DataEnum("1","Male"))
        TestResultType.add(new DataEnum("9","Indeterminate"))

    }

    ArrayList<DataItem> getDataItems() {

        DataItem partID = new DataItem("participant_id", "28000[0-9]{4}")
        partID.generateNumbers(numberOfRows, numberOfRowsFalseData)
        cstDataItems << partID

        DataItem tumourID = new DataItem("tumour_id", "21100000_[0-9]{2}")
        tumourID.generateItems(numberOfRows, numberOfRowsFalseData)
        cstDataItems << tumourID

        DataItem ovarianCA125 = new DataItem("ovarian_ca125", "[0-9]{2}")
        ovarianCA125.generateItems(numberOfRows, numberOfRowsFalseData)
        //cstDataItems << ovarianCA125

        DataItem prostatePreTreatmentPsa = new DataItem("prostate_pre_treatment_psa", "0\\.0[0-9]{1}")
        prostatePreTreatmentPsa.generateItems(numberOfRows, numberOfRowsFalseData)
        //cstDataItems << prostatePreTreatmentPsa

        splitValues(ovarianCA125,prostatePreTreatmentPsa)

        DataItem prostatePsa = new DataItem("prostate_psa", "0\\.0[0-9]{1}")
        prostatePsa.generateItems(numberOfRows, numberOfRowsFalseData)
        //cstDataItems << prostatePsa

        splitValues(ovarianCA125,prostatePsa)
        cstDataItems << ovarianCA125
        cstDataItems << prostatePreTreatmentPsa
        cstDataItems << prostatePsa


        DataItem eventDate = new DataItem("event_date")
        eventDate.generateDatesAfter(numberOfRows,numberOfRowsFalseData, 2019)
        cstDataItems << eventDate

    }

    void splitValues(DataItem valuesA, DataItem valuesB){
        int sz = valuesA.values.size()
        println sz
        boolean del = true

        for (int i = 0; i <sz; i++) {
            if(del){
                valuesA.values.set(i,0)
            }else{
                valuesB.values.set(i,0)
            }
            del = !del
        }
    }

}
