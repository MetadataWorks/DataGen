package uk.org.metadata.datagen

class Utility {

    static void main(String[] args) {
        DataBuilder db = new DataBuilder()
        db.buildRareDiseaseRegAndPhenotypeDataset("testdata12.xlsx", 50, 20)

    }

}
