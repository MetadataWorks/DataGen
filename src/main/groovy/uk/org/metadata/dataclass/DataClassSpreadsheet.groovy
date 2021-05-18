package uk.org.metadata.dataclass

import uk.org.metadata.datagen.DataItem

/**
 * Class representing data that will go into a spreadsheet
 */
abstract class DataClassSpreadsheet {

    /**
     * Method called internally to generate fake data
     */
    abstract void setupDataStructures()
    /**
     * Method called externally to get generated data
     * @return generated data as a list of DataItems (columns)
     */
    abstract ArrayList<DataItem> getDataItems()

    /**
     * Number of rows of correct/valid data to generate
     */
    abstract int getNumberOfRows()

    /**
     * Number of rows of incorrect data to generate
     */
    abstract int getNumberOfRowsFalseData()

}
