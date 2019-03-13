package uk.org.metadata.dataclass

import uk.org.metadata.datagen.DataItem

abstract class DataClassSpreadsheet {

    abstract void setupDataStructures()
    abstract ArrayList<DataItem> getDataItems()
    abstract int getNumberOfRows()
    abstract int getNumberOfRowsFalseData()

}
