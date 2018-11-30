package uk.org.metadata.datagen

abstract class DataClassSpreadsheet {

    abstract void setupDataStructures()
    abstract ArrayList<DataItem> getDataItems()
    abstract int getNumberOfRows()
    abstract int getNumberOfRowsFalseData()

}
