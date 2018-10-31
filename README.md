# DataGen
A Generator for Spreadsheet Testdata
  
  

## Description

run from Utility.main:

        DataBuilder db = new DataBuilder()
        db.buildRareDiseaseRegAndPhenotypeDataset("testdata2.xlsx", 100, 100)
        
        This generates a spreadsheet with 1 sheet and 43 columns of data, 100 'good' rows of data, and 100 'suspect' rows of data