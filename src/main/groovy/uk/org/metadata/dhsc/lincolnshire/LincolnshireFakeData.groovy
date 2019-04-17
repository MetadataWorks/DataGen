package uk.org.metadata.dhsc.lincolnshire

import com.github.javafaker.Faker
import com.opencsv.bean.CsvBindByName
import com.opencsv.bean.CsvDate
import com.opencsv.bean.CsvToBeanBuilder
import com.opencsv.bean.StatefulBeanToCsv
import com.opencsv.bean.StatefulBeanToCsvBuilder

import java.util.concurrent.TimeUnit

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

        File file = new File(
                classLoader.getResource("uk/org/metadata/dhsc/lincolnshire/ClientId_with_EarliestStart_LatestEnd.csv").getFile()
        )
        // Should be a CSV file with three columns: clientId, startDate, endDate.
        List<String> actualData = file.collect().drop(1) // drop the header line

        List<ClientStartEnd> clientStartEndList = new CsvToBeanBuilder(file.newReader()).withType(ClientStartEnd.class).build().parse()
        // TODO: Validate that each clientStartEnd's startDate <= endDate

        List<ClientGenderEtcFormatted> clientGenderEtcFormattedList = clientStartEndList.collect{ ClientGenderEtcFormatted.from(ClientGenderEtc.from(it)) }
        // TODO: Parallelize conversion (e.g. with ExecutorService)
        println ("Finished converting at ${new Date()}")
        Writer writer = new FileWriter("lincolnshireFakeDataOutput.csv")
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build()
        beanToCsv.write(clientGenderEtcFormattedList)
        writer.close()

    }

    static void main(String[] args) {
        LincolnshireFakeData lincolnshireFakeData = new LincolnshireFakeData()
        lincolnshireFakeData.lincolnshireFakeData()
    }


}

/**
 * Data to be extracted from a CSV table of (clientId, startDate, endDate)
 *  * where clientId is a unique identifier of a row,
 *  * where startDate is the earliest starting date of an event the client was involved in,
 *  * and endDate is the latest end date of an event the client was involved in.
 */
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

/**
 * (Fake) gender, ethnicity, date of birth, date of death for each client.
 */
class ClientGenderEtc {

    Long clientId
    Gender gender
    Ethnicity ethnicity
    Date dateOfBirth
    Date dateOfDeath

    static ClientGenderEtc from(ClientStartEnd clientStartEnd) {

        Faker faker = new Faker()

        Long clientId = clientStartEnd.clientId
        Gender gender = Gender.random()
        Ethnicity ethnicity = Ethnicity.random()
        Date dateOfBirth = clientStartEnd.startDate ?
                faker.date().past(100 * 365, TimeUnit.DAYS, clientStartEnd.startDate) : // before startDate
                (clientStartEnd.endDate ?
                        faker.date().past(100 * 365, TimeUnit.DAYS, clientStartEnd.endDate) : // before endDate
                        faker.date().past(100 * 365, TimeUnit.DAYS)) // before NOW
        Date dateOfDeath
        if (new Random().nextInt(2)) {
            dateOfDeath = null // maybe not dead yet...
        }
        else {
            dateOfDeath = clientStartEnd.endDate ?
                    faker.date().between(clientStartEnd.endDate, new Date()) : // between latest event date and now
                    (clientStartEnd.startDate ?
                            faker.date().between(clientStartEnd.startDate, new Date()) : // between earliest start date and now
                            faker.date().between(dateOfBirth, new Date())) // between DOB and now

        }
        new ClientGenderEtc(clientId, gender, ethnicity, dateOfBirth, dateOfDeath)
    }


    ClientGenderEtc() {
    }

    ClientGenderEtc(Long clientId, Gender gender, Ethnicity ethnicity, Date dateOfBirth, Date dateOfDeath) {
        this.clientId = clientId
        this.gender = gender
        this.ethnicity = ethnicity
        this.dateOfBirth = dateOfBirth
        this.dateOfDeath = dateOfDeath
    }

    @Override
    public String toString() {
        return "ClientGenderEtc[clientId: ${clientId}, gender: ${gender}, ethnicity: ${ethnicity}, dateOfBirth: ${dateOfBirth}, dateOfDeath: ${dateOfDeath}]"
    }
}

class ClientGenderEtcFormatted {
    String clientId
    String gender
    String ethnicity
    String dateOfBirth
    String dateOfDeath

    ClientGenderEtcFormatted(String clientId, String gender, String ethnicity, String dateOfBirth, String dateOfDeath) {
        this.clientId = clientId
        this.gender = gender
        this.ethnicity = ethnicity
        this.dateOfBirth = dateOfBirth
        this.dateOfDeath = dateOfDeath
    }

    static ClientGenderEtcFormatted from(ClientGenderEtc clientGenderEtc) {
        println "Formatting ${clientGenderEtc}"
        new ClientGenderEtcFormatted(
                clientGenderEtc.clientId.toString(),
                clientGenderEtc.gender.name,
                clientGenderEtc.ethnicity.name,
                clientGenderEtc.dateOfBirth?.format("yyyy-MM-dd"),
                clientGenderEtc.dateOfDeath?.format("yyyy-MM-dd")
        )
    }
}

enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    NOT_KNOWN("Not Known")

    final String name

    Gender(String name) {
        this.name = name
    }

    static Gender random() {
        values()[(new Random()).nextInt(values().size())]
    }
}

enum Ethnicity {
    White_English_Welsh_Scottish_Northern_Irish_British("White (English / Welsh / Scottish / Northern Irish / British)"),
    White_Irish("White Irish"),
    White_Gypsy_or_Irish_Traveller("White (Gypsy or Irish Traveller)"),
    Any_other_White_background("Any other White background"),
    White_and_Black_Caribbean("White and Black Caribbean"),
    White_and_Black_African("White and Black African"),
    White_and_Asian("White and Asian"),
    Any_other_mixed_multiple_ethnic_background("Any other mixed / multiple ethnic background"),
    Indian("Indian"),
    Pakistani("Pakistani"),
    Bangladeshi("Bangladeshi"),
    Chinese("Chinese"),
    Any_other_Asian_background("Any other Asian background"),
    African("African"),
    Caribbean("Caribbean"),
    Any_other_Black_African_Caribbean_background("Any other Black / African / Caribbean background"),
    Arab("Arab"),
    Any_other_ethnic_group("Any other ethnic group"),
    Refused("Refused"),
    Undeclared_Not_known("Undeclared / Not known")

    final String name

    Ethnicity(String name) {
        this.name = name
    }
    static Ethnicity random() {
        values()[(new Random()).nextInt(values().size())]
    }
}