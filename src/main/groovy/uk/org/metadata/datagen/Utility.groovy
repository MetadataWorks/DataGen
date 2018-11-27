package uk.org.metadata.datagen

class Utility {

    static void main(String[] args) {
        DataBuilder db = new DataBuilder()
        //db.buildRareDiseaseRegAndPhenotypeDataset("testdata3.xlsx", 100, 100)

        //db.buildTestDataset("testMoreData2.xlsx", 5, 5)

        db.buildcancerCohortsDataset("cancerCohorts.xlsx", 5, 5)

        CancerSampleTracking cst = new CancerSampleTracking()
        db.buildDataset(cst, "cancerSampleTracking.xlsx", 5, 5)
        //db.buildcancerSampleTrackingDataset("cancerCSampleTracking.xlsx", 5, 5)

    }

}
