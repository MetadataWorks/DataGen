package uk.org.metadata.datagen

class RareDiseaseConsentAndPhenotype {

    List<DataEnum> PersonPhenotypicSex = null
    List<DataEnum> PersonKarytypicSex = null
    List<DataEnum> Ethnicity = null
    List<DataEnum> ChoiceYesNo = null
    List<DataEnum> ChoiceYesNoNR = null
    List<DataEnum> ChoiceYesNoUK = null
    List<DataEnum> ConsentForm = null
    List<DataEnum> ParticipantType = null
    List<DataEnum> Consanguinity = null
    List<DataEnum> BiologicalRelationship = null
    List<DataEnum> GroupType = null

    RareDiseaseConsentAndPhenotype(){
        setupData()
    }
        void setupData(){

        PersonPhenotypicSex = new ArrayList()
        PersonPhenotypicSex.add(new DataEnum("2","Female"))
        PersonPhenotypicSex.add(new DataEnum("1","Male"))
        PersonPhenotypicSex.add(new DataEnum("9","Indeterminate"))

        PersonKarytypicSex = new ArrayList()
        PersonKarytypicSex.add(new DataEnum("XY", "XY"))
        PersonKarytypicSex.add(new DataEnum("XX","XX"))
        PersonKarytypicSex.add(new DataEnum("XO","XO"))
        PersonKarytypicSex.add(new DataEnum("XXY","XXY"))
        PersonKarytypicSex.add(new DataEnum("XYY","XYY"))
        PersonKarytypicSex.add(new DataEnum("XXX","XXX"))
        PersonKarytypicSex.add(new DataEnum("XXYY","XXYY"))
        PersonKarytypicSex.add(new DataEnum("XXXY","XXXY"))
        PersonKarytypicSex.add(new DataEnum("other","other"))
        PersonKarytypicSex.add(new DataEnum("unknown","unknown"))

                Ethnicity = new ArrayList()
        Ethnicity.add(new DataEnum("D","Mixed: White and Black Caribbean" ))
        Ethnicity.add(new DataEnum("E","Mixed: White and Black African"))
        Ethnicity.add(new DataEnum("F","Mixed: White and Asian"))
        Ethnicity.add(new DataEnum("G","Mixed: Any other mixed background"))
        Ethnicity.add(new DataEnum("A","White: British "))
        Ethnicity.add(new DataEnum("B","White: Irish"))
        Ethnicity.add(new DataEnum("C","White: Any other White background"))
        Ethnicity.add(new DataEnum("L","Asian or Asian British: Any other Asian background"))
        Ethnicity.add(new DataEnum("M","Black or Black British: Caribbean"))
        Ethnicity.add(new DataEnum("N",	"Black or Black British: African"))
        Ethnicity.add(new DataEnum("H",	"Asian or Asian British: Indian"))
        Ethnicity.add(new DataEnum("J",	"Asian or Asian British: Pakistani"))
        Ethnicity.add(new DataEnum("K",	"Asian or Asian British: Bangladeshi"))
        Ethnicity.add(new DataEnum("P",	"Black or Black British: Any other Black background"))
        Ethnicity.add(new DataEnum("S",	"Other Ethnic Groups: Any other ethnic group"))
        Ethnicity.add(new DataEnum("R",	"Other Ethnic Groups: Chinese"))
        Ethnicity.add(new DataEnum("Z",	"Not stated"))

        ChoiceYesNo = new ArrayList()
        ChoiceYesNo.add(new DataEnum("yes","Yes"))
        ChoiceYesNo.add(new DataEnum("no","No"))

        ChoiceYesNoNR = new ArrayList()
        ChoiceYesNoNR.add(new DataEnum("yes","Yes"))
        ChoiceYesNoNR.add(new DataEnum("no","No"))
        ChoiceYesNoNR.add(new DataEnum("not relevant","not relevant"))

        ChoiceYesNoUK = new ArrayList()
        ChoiceYesNoUK.add(new DataEnum("yes","Yes"))
        ChoiceYesNoUK.add(new DataEnum("no","No"))
        ChoiceYesNoUK.add(new DataEnum("unknown","Unknown"))

         ConsentForm = new ArrayList()
        ConsentForm.add(new DataEnum("R1/R2(CF)"," R1/R2 Proband adult with rare disease (or for their adult relatives joining the Project) version 2.2 and date 24/09/2015"))
        ConsentForm.add(new DataEnum("R5(CF)","	R5 Parents of child aged under 16 (versioned for rare diseases) version 2.1 and date 24/09/2015"))
        ConsentForm.add(new DataEnum("R6(CF)","	R6 Parents of a (deceased) child aged under 16, baby or fetus (versioned for rare disease) version 2.1 and date 24/09/2015"))
        ConsentForm.add(new DataEnum("R7(CF)","	R7 Personal Consultees of an adult with a rare genetic disease to advise on participation, version 2.4 and date 24/09/2015"))
        ConsentForm.add(new DataEnum("R8(CF)	","R8 Nominated representatives, relatives or friends of a (deceased) adult (versioned for rare disease only) version 2.1 and date 24/09/2015"))

         ParticipantType = new ArrayList()
        ParticipantType.add(new DataEnum("Proband","Proband"))
        ParticipantType.add(new DataEnum("Relative","Relative"))

         Consanguinity = new ArrayList()
        Consanguinity.add(new DataEnum("U","Unknown"))
        Consanguinity.add(new DataEnum("P","Possible"))
        Consanguinity.add(new DataEnum("N","No"))
        Consanguinity.add(new DataEnum("Y","Yes"))

         BiologicalRelationship = new ArrayList()
        BiologicalRelationship.add(new DataEnum("Mother","Mother"))
        BiologicalRelationship.add(new DataEnum("Father","Father"))
        BiologicalRelationship.add(new DataEnum("TwinsMonozygous","Twins-Monozygous"))
        BiologicalRelationship.add(new DataEnum("TwinsDizygous","Twins-Dizygous"))
        BiologicalRelationship.add(new DataEnum("TwinsUnknown","Twins-Unknown"))
        BiologicalRelationship.add(new DataEnum("FullSibling","FullSibling"))
        BiologicalRelationship.add(new DataEnum("FullSiblingM","Half Sibling (shared mother)"))
        BiologicalRelationship.add(new DataEnum("FullSiblingF","Half Sibling (shared father)"))
        BiologicalRelationship.add(new DataEnum("MaternalAunt","Maternal Aunt"))
        BiologicalRelationship.add(new DataEnum("PaternalAunt","Paternal Aunt"))
        BiologicalRelationship.add(new DataEnum("MaternalUncle","Maternal Uncle"))
        BiologicalRelationship.add(new DataEnum("PaternalUncle","Paternal Uncle"))
        BiologicalRelationship.add(new DataEnum("MaternalCousinSister","Maternal Cousin - child of mother's sister"))
        BiologicalRelationship.add(new DataEnum("MaternalCousinBrother","Maternal Cousin - child of mother's brother"))
        BiologicalRelationship.add(new DataEnum("PaternalCousinSister","Paternal Cousin - child of father's sister"))
        BiologicalRelationship.add(new DataEnum("PaternalCousinBrother","Paternal Cousin - child of father's brother"))
        BiologicalRelationship.add(new DataEnum("MaternalGrandmother","Maternal Grandmother"))
        BiologicalRelationship.add(new DataEnum("MaternalGrandfather","Maternal Grandfather"))
        BiologicalRelationship.add(new DataEnum("PaternalGrandmother","Paternal Grandmother"))
        BiologicalRelationship.add(new DataEnum("PaternalGrandfather","Paternal Grandfather"))
        BiologicalRelationship.add(new DataEnum("DoubleFirstCousin","Double First Cousin"))
        BiologicalRelationship.add(new DataEnum("FirstCousinOnceRemoved","First Cousin OnceRemoved"))
        BiologicalRelationship.add(new DataEnum("SecondCousin","Second Cousin"))
        BiologicalRelationship.add(new DataEnum("SecondCousinOnceRemoved","Second Cousin Once Removed"))
        BiologicalRelationship.add(new DataEnum("Son","Son"))
        BiologicalRelationship.add(new DataEnum("Daughter","Daughter"))
        BiologicalRelationship.add(new DataEnum("Other","Other (Please specify)"))

         GroupType = new ArrayList()
        GroupType.add(new DataEnum("1","Trio with Mother AND Father"))
        GroupType.add(new DataEnum("2","Trio with Mother OR Father AND other biological relative"))
        GroupType.add(new DataEnum("3","Trio with other biological relatives"))
        GroupType.add(new DataEnum("4","Duo with Mother OR Father"))
        GroupType.add(new DataEnum("5","Duo with other biological relative"))
        GroupType.add(new DataEnum("6","Families with more than 3 participants"))
        GroupType.add(new DataEnum("7","Singleton"))
        GroupType.add(new DataEnum("NOT_PROVIDED","Migration data value unknown"))
    }


}
