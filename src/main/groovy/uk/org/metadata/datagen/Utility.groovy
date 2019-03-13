package uk.org.metadata.datagen

import uk.org.metadata.dataclass.CancerSampleTrackingTestResults
import uk.org.metadata.dataclass.DataClassSpreadsheet
import uk.org.metadata.dataclass.MVPClientLevelData

class Utility {

    static void main(String[] args) {
        DataBuilder db = new DataBuilder()
        //db.buildRareDiseaseRegAndPhenotypeDataset("testdata3.xlsx", 100, 100)

        //db.buildTestDataset("testMoreData2.xlsx", 5, 5)

        //db.buildcancerCohortsDataset("cancerCohorts.xlsx", 5, 5)

        //DataClassSpreadsheet cst = new CancerSampleTrackingTestResults(200, 20)
        DataClassSpreadsheet cst = new MVPClientLevelData(200, 20)
        db.buildDataset(cst, "Data - Sample Metadata","mvpSampleData.xlsx" )


    }

}
