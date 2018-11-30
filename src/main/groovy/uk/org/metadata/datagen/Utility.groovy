package uk.org.metadata.datagen

class Utility {

    static void main(String[] args) {
        DataBuilder db = new DataBuilder()
        //db.buildRareDiseaseRegAndPhenotypeDataset("testdata3.xlsx", 100, 100)

        //db.buildTestDataset("testMoreData2.xlsx", 5, 5)

        //db.buildcancerCohortsDataset("cancerCohorts.xlsx", 5, 5)

        DataClassSpreadsheet cst = new CancerSampleTracking(200, 20)
        db.buildDataset(cst, "Data - Sample Metadata","cancerSampleTracking1.xlsx", 200, 20)
        //db.buildcancerSampleTrackingDataset("cancerCSampleTracking.xlsx", 5, 5)

    }

}
