package uk.org.metadata.dhsc.lincolnshire

class LincolnshireFakeData {

    void lincolnshireFakeData(){
        ClassLoader classLoader  = getClass().getClassLoader()
//        ClassLoader classLoader  = ClassLoader.getSystemClassLoader()

        File file = new File(
                classLoader.getResource("uk/org/metadata/dhsc/lincolnshire/ClientId_with_EarliestStart_LatestEnd.csv").getFile()
        )
        // Should be a CSV file with three columns: clientId, startDate, endDate.
        List<String> firstThreeLines = file.collect().take(3)
        firstThreeLines.each{println it}

    }

    static void main(String[] args) {
        LincolnshireFakeData lincolnshireFakeData = new LincolnshireFakeData()
        lincolnshireFakeData.lincolnshireFakeData()
    }
}
