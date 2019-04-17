package uk.org.metadata.dhsc.lincolnshire

import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvDate
import com.opencsv.bean.CsvToBeanBuilder

/**
 * Class to generate fake gender, ethnicity, date of birth, date of death for each client,
 * from a table of (clientId, startDate, endDate)
 * where clientId is a unique identifier of a row,
 * where startDate is the earliest starting date of an event the client was involved in,
 * and endDate is the latest end date of an event the client was involved in.
 * The anonymised data is originally from Lincolnshire, but this approach may be generalized to other LAs.
 */
class LincolnshireFakeData {

    void lincolnshireFakeData(){
        ClassLoader classLoader  = getClass().getClassLoader()
//        ClassLoader classLoader  = ClassLoader.getSystemClassLoader()

        File file = new File(
                classLoader.getResource("uk/org/metadata/dhsc/lincolnshire/ClientId_with_EarliestStart_LatestEnd.csv").getFile()
        )
        // Should be a CSV file with three columns: clientId, startDate, endDate.
        List<String> actualData = file.collect().drop(1) // drop the header line
//        List<ClientStartEnd> clientStartEndList = actualData.take(5).collect{ ClientStartEnd.fromCsvLine(it) }
        List<ClientStartEnd> clientStartEndList = new CsvToBeanBuilder(file.newReader()).withType(ClientStartEnd.class).build().parse()
        clientStartEndList.take(5).each {println it}
    }

    static void main(String[] args) {
        LincolnshireFakeData lincolnshireFakeData = new LincolnshireFakeData()
        lincolnshireFakeData.lincolnshireFakeData()
    }


}

class ClientStartEnd {

    @CsvBindByName(column = "ClientIdLocal", required = true)
    Long clientId
    @CsvBindByName(column = "Start_Date", required = false)
    @CsvDate("yyyy-MM-dd")
    Date startDate
    @CsvBindByName(column = "End_Date", required = false)
    @CsvDate("yyyy-MM-dd")
    Date endDate

    ClientStartEnd(Long clientId, Date startDate, Date endDate) {
        this.clientId = clientId
        this.startDate = startDate
        this.endDate = endDate
    }

    ClientStartEnd() {

    }

    @Override
    String toString() {
        return "ClientStartEnd[clientId: ${clientId}, startDate: ${startDate}, endDate: ${endDate}]"
    }
}