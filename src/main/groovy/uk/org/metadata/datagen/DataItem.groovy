package uk.org.metadata.datagen

import com.github.javafaker.Faker
import com.mifmif.common.regex.Generex
import com.mifmif.common.regex.GenerexIterator

class DataItem {
    String name
    ArrayList<String> values = null
    ArrayList<String> negativeValues= null
    List<String> enumerations = null
    String regex
    String typeDetails
    Faker faker = null
    long upper = 0
    long lower = 0

    DataItem(String name){
        values = new ArrayList<String>()
        negativeValues = new ArrayList<String>()
        this.name = name
        this.faker = new Faker()
    }

    DataItem(String name, String regex){
        this.regex = regex
        values = new ArrayList<String>()
        negativeValues = new ArrayList<String>()
        this.name = name
        this.faker = new Faker()

    }

    DataItem(String name, long upper, long lower){

        values = new ArrayList<String>()
        negativeValues = new ArrayList<String>()
        this.name = name


    }

    DataItem(String name, List<DataEnum> choices){
        enumerations = choices
        values = new ArrayList<String>()
        negativeValues = new ArrayList<String>()
        this.name = name
        this.faker = new Faker()

    }

    DataItem(String name, String value, String regex, String typeDetails){
        DataItem(name, value, regex)
        this.typeDetails = typeDetails
    }

    void generateNumbersBetweenLimits(){
        this.upper

        long value
        value = Math.abs(new Random().nextInt() % this.upper) + this.lower
        values.add(value)

    }

    void generateDates(int noRows, int noFalse){

        String randDays = null
        String randMonths = null
        String randYears = null
        String date = null

        (1..noRows).each {
            randDays = Math.abs(new Random().nextInt() % 30) + 1
            randMonths= Math.abs(new Random().nextInt() % 12) + 1
            randYears = Math.abs(new Random().nextInt() % 101) + 1900
            date = randDays + "-" + randMonths + "-" + randYears
            values.add(date)
        }

        (1..noFalse).each {
            randDays = Math.abs(new Random().nextInt() % 30) + 10
            randMonths= Math.abs(new Random().nextInt() % 12) + 12
            randYears = Math.abs(new Random().nextInt() % 160) + 2050
            date = randDays + "-" + randMonths + "-" + randYears
            negativeValues.add(date)
        }
    }

    void generateDatesAfter(int noRows, int noFalse, int year){

        String randDays = null
        String randMonths = null
        String randYears = null
        String date = null
        //Get difference between limit date and now - to use as range for random year
        int yearNow = Calendar.getInstance().get(Calendar.YEAR)
        int possibleYears = yearNow - year

        (1..noRows).each {
            randDays = Math.abs(new Random().nextInt() % 30) + 1
            randMonths= Math.abs(new Random().nextInt() % 12) + 1
            randYears = Math.abs(new Random().nextInt() % possibleYears) + year
            date = randDays + "-" + randMonths + "-" + randYears
            values.add(date)
        }

        (1..noFalse).each {
            randDays = Math.abs(new Random().nextInt() % 30) + 10
            randMonths= Math.abs(new Random().nextInt() % 12) + 12
            randYears = Math.abs(new Random().nextInt() % 160) + 2050
            date = randDays + "-" + randMonths + "-" + randYears
            negativeValues.add(date)
        }
    }

    void generateDateTimesAtMidday(int noRows, int noFalse){

        String randDays = null
        String randMonths = null
        String randYears = null
        String date = null

        (1..noRows).each {
            randDays = Math.abs(new Random().nextInt() % 30) + 1
            randMonths= Math.abs(new Random().nextInt() % 12) + 1
            randYears = Math.abs(new Random().nextInt() % 160) + 1900
            date = randDays + "-" + randMonths + "-" + randYears + "T12:00:00"
            values.add(date)
        }

        (1..noFalse).each {
            randDays = Math.abs(new Random().nextInt() % 30) + 10
            randMonths= Math.abs(new Random().nextInt() % 12) + 12
            randYears = Math.abs(new Random().nextInt() % 160) + 2050
            date = randDays + "-" + randMonths + "-" + randYears + "T12:00:00"
            negativeValues.add(date)
        }
    }

    void generateDateTimesAtMiddayISO8601(int noRows, int noFalse){

        String randDays = null
        String randMonths = null
        String randYears = null
        String date = null

        (1..noRows).each {
            randDays = Math.abs(new Random().nextInt() % 30) + 1
            if (randDays.length() < 2){
                randDays = "0" + randDays
            }
            randMonths= Math.abs(new Random().nextInt() % 12) + 1
            if (randMonths.length() < 2){
                randMonths = "0" + randMonths
            }
            randYears = Math.abs(new Random().nextInt() % 160) + 1900
            date = randDays + "-" + randMonths + "-" + randYears + "T12:00:00"
            values.add(date)
        }

        (1..noFalse).each {
            randDays = Math.abs(new Random().nextInt() % 30) + 10
            randMonths= Math.abs(new Random().nextInt() % 12) + 12
            randYears = Math.abs(new Random().nextInt() % 160) + 2050
            date = randDays + "-" + randMonths + "-" + randYears + "T12:00:00"
            negativeValues.add(date)
        }
    }

    void generateFirstNames(int noRows, int noFalse){
        (1..noRows).each {
            String firstName = faker.name().firstName()
            values.add(firstName)
        }

        (1..noFalse).each {
            String firstName = faker.name().firstName()
            List<String> symbols = new ArrayList<String>()
            symbols.add(Math.abs(new Random().nextInt() % 30) + 10 )
            symbols.add(Math.abs(new Random().nextInt() % 30) + 10)
            symbols.add("@")
            symbols.add("!")
            symbols.add("?")
            String mangle1 = String.valueOf(Math.abs(new Random().nextInt() % 30))
            String mangle2 = symbols[Math.abs(new Random().nextInt() % 5)]
            def mangle = {
                if (it == 'e') {
                    mangle1
                } else if ((it == 'g')|(it == 'i')|(it == 'a')|(it == 'r')|(it == 'h')) {
                    mangle2
                } else {
                    null
                }
            }
            firstName.collectReplacements(mangle)
            negativeValues.add(firstName)
        }

    }

    void generateLastNames(int noRows, int noFalse){
        (1..noRows).each {
            String lastName = faker.name().lastName()
            values.add(lastName)
        }

        (1..noFalse).each {
            String lastName = faker.name().lastName()
            List<String> symbols = new ArrayList<String>()
            symbols.add(Math.abs(new Random().nextInt() % 30) + 10 )
            symbols.add(Math.abs(new Random().nextInt() % 30) + 10)
            symbols.add("@")
            symbols.add("!")
            symbols.add("?")
            String mangle1 = String.valueOf(Math.abs(new Random().nextInt() % 30))
            String mangle2 = symbols[Math.abs(new Random().nextInt() % 5)]
            def mangle = {
                if (it == 'e') {
                    mangle1
                } else if ((it == 'g')|(it == 'i')|(it == 'a')|(it == 'r')|(it == 'h'))  {
                    mangle2
                } else {
                    null
                }
            }
            lastName.collectReplacements(mangle)
            negativeValues.add(lastName)
        }

    }

    void generateFullNames(int noRows, int noFalse){
        (1..noRows).each {
            String fullName = faker.name().fullName()
            values.add(fullName)
        }

        (1..noFalse).each {
            String fullName = faker.name().fullName()
            List<String> symbols = new ArrayList<String>()
            symbols.add(Math.abs(new Random().nextInt() % 30) + 10 )
            symbols.add(Math.abs(new Random().nextInt() % 30) + 10)
            symbols.add("@")
            symbols.add("!")
            symbols.add("?")

            String mangle1 = String.valueOf(Math.abs(new Random().nextInt() % 30))
            String mangle2 = symbols[Math.abs(new Random().nextInt() % 5)]
            def mangle = {
                if (it == 'e') {
                    mangle1
                } else if ((it == 'g')|(it == 'i')|(it == 'a')|(it == 'r')|(it == 'h')) {
                    mangle2
                } else {
                    null
                }
            }

            fullName.collectReplacements(mangle)
            negativeValues.add(fullName)
        }

    }

    void generateEmailAddress(int noRows, int noFalse){
        Generex generex = new Generex(regex)
        (1..noRows).each {
            String email = faker.name.firstName() + "@" + faker.hipster.word() + ".com"
            this.values.add(email)
        }

        (1..noFalse).each {
            String email = faker.name.firstName() + "@" + faker.hipster.word() + ".com"
            List alphabet = ('a'..'z').collect { it }
            int randomIndex = (new Random().nextInt() % 26) + 1
            email = email + alphabet[randomIndex]
            negativeValues.add(email)
        }
    }

    void generateAddressStreetLine(int noRows, int noFalse){
        Generex generex = new Generex(regex)
        (1..noRows).each {
            String noString = faker.address.streetName()
            this.values.add(noString)
        }

        (1..noFalse).each {
            String noString = faker.address.streetName()
            List alphabet = ('a'..'z').collect { it }
            int randomIndex = (new Random().nextInt() % 26) + 1
            noString = noString + alphabet[randomIndex]
            negativeValues.add(noString)
        }
    }

    void generateAddressCityLine(int noRows, int noFalse){
        Generex generex = new Generex(regex)
        (1..noRows).each {
            String noString = faker.address.cityName()
            this.values.add(noString)
        }

        (1..noFalse).each {
            String noString = faker.address.cityName()
            List alphabet = ('a'..'z').collect { it }
            int randomIndex = (new Random().nextInt() % 26) + 1
            noString = noString + alphabet[randomIndex]
            negativeValues.add(noString)
        }
    }

    void generateAddressStateLine(int noRows, int noFalse){
        Generex generex = new Generex(regex)
        (1..noRows).each {
            String noString = faker.address.state()
            this.values.add(noString)
        }

        (1..noFalse).each {
            String noString = faker.address.state()
            List alphabet = ('a'..'z').collect { it }
            int randomIndex = (new Random().nextInt() % 26) + 1
            noString = noString + alphabet[randomIndex]
            negativeValues.add(noString)
        }
    }

    void generateAddressCountryLine(int noRows, int noFalse){
        Generex generex = new Generex(regex)
        (1..noRows).each {
            String noString = faker.address.country()
            this.values.add(noString)
        }

        (1..noFalse).each {
            String noString = faker.address.country()
            List alphabet = ('a'..'z').collect { it }
            int randomIndex1 = (new Random().nextInt() % 26) + 1
            int randomIndex2 = (new Random().nextInt() % 26) + 1
            noString =  alphabet[randomIndex1] + noString + alphabet[randomIndex2]
            negativeValues.add(noString)
        }
    }

    void generatePhoneNumber(int noRows, int noFalse){
        Generex generex = new Generex(regex)
        (1..noRows).each {
            String noString = faker.phoneNumber.cellPhone()
            this.values.add(noString)
        }

        (1..noFalse).each {
            String noString = faker.phoneNumber.cellPhone()
            List alphabet = ('a'..'z').collect { it }
            int randomIndex1 = (new Random().nextInt() % 26) + 1
            int randomIndex2 = (new Random().nextInt() % 26) + 1
            noString =  alphabet[randomIndex1] + noString + alphabet[randomIndex2]
            negativeValues.add(noString)
        }
    }

    void generateChoices(int noRows, int noFalse){

        (1..noRows).each {
            int randChoice = Math.abs(new Random().nextInt() % (enumerations.size()))
            values.add(enumerations.get(randChoice).getValue())
        }

        (1..noFalse).each {
            int randChoice = Math.abs(new Random().nextInt() % (enumerations.size()))
            String choice = enumerations.get(randChoice).getValue()
            int randomNo = new Random().nextInt() % 30
            randomNo.times{
                List alphabet = ('a'..'z').collect { it }
                int randomIndex = (new Random().nextInt() % 26) + 1
                choice = choice + alphabet[randomIndex]

            }

            negativeValues.add(choice)
        }

    }

    void generateChoiceKeys(int noRows, int noFalse){

        (1..noRows).each {
            int randChoice = Math.abs(new Random().nextInt() % (enumerations.size()))
            values.add(enumerations.get(randChoice).getKey())
        }

        (1..noFalse).each {
            int randChoice = Math.abs(new Random().nextInt() % (enumerations.size()))
            String choice = enumerations.get(randChoice).getKey()
            int randomNo = new Random().nextInt() % 30
            randomNo.times{
                List alphabet = ('a'..'z').collect { it }
                int randomIndex = (new Random().nextInt() % 26) + 1
                choice = choice + alphabet[randomIndex]

            }

            negativeValues.add(choice)
        }

    }



    void generateNumbers(int noRows, int noFalse){
        Generex generex = new Generex(regex)
        (1..noRows).each {
             String noString = generex.random()
            this.values.add(noString)
        }

        (1..noFalse).each {
            String noString = generex.random()
            List alphabet = ('a'..'z').collect { it }
            int randomIndex = (new Random().nextInt() % 26) + 1
            noString = noString + alphabet[randomIndex]
            negativeValues.add(noString)
        }
    }

    void generateItems(int noRows, int noFalse) {

        if((name.substring(0, 4) == "Date")|(name.substring(name.length() - 4, name.length()) == "Date")){
            generateDates(noRows)
        }else{
            Generex generex = new Generex(regex)
            (1..noRows).each {

                String secondString = generex.random()
                this.values.add(secondString)
            }
            (1..noFalse).each {
                String noString = generex.random()
                List alphabet = ('a'..'z').collect { it }
                int randomIndex = (new Random().nextInt() % 26) + 1
                noString = noString + alphabet[randomIndex]
                negativeValues.add(noString)
            }
        }

    }




}
