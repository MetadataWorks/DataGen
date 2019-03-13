package uk.org.metadata.dataclass

import uk.org.metadata.datagen.DataEnum

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
    List<DataEnum> SpecificDisease = null

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

            SpecificDisease = new ArrayList()
            SpecificDisease.add(new DataEnum("10960"," Kabuki syndrome" ))
            SpecificDisease.add(new DataEnum("10964"," VACTERL-like phenotypes"))
            SpecificDisease.add(new DataEnum("11006","  Craniosynostosis syndromes"))
            SpecificDisease.add(new DataEnum("11021","  Familial Thoracic Aortic Aneurysm Disease"))
            SpecificDisease.add(new DataEnum("11022","  Brugada syndrome"))
            SpecificDisease.add(new DataEnum("11023","  Long QT syndrome"))
            SpecificDisease.add(new DataEnum("11024","  Catecholaminergic Polymorphic Ventricular Tachycardia"))
            SpecificDisease.add(new DataEnum("11025","  Arrhythmogenic Right Ventricular Cardiomyopathy"))
            SpecificDisease.add(new DataEnum("11027","  Dilated Cardiomyopathy and conduction defects"))
            SpecificDisease.add(new DataEnum("11028","  Hypertrophic Cardiomyopathy"))
            SpecificDisease.add(new DataEnum("11037","  Erythropoietic protoporphyria -  mild variant"))
            SpecificDisease.add(new DataEnum("11039","  Noonan syndrome"))
            SpecificDisease.add(new DataEnum("11040","  Noonan syndrome plus other features"))
            SpecificDisease.add(new DataEnum("11041","  Cardio-facio-cutaneous syndrome"))
            SpecificDisease.add(new DataEnum("11042","  LEOPARD syndrome"))
            SpecificDisease.add(new DataEnum("11043","  Costello syndrome"))
            SpecificDisease.add(new DataEnum("11044","  Legius syndrome"))
            SpecificDisease.add(new DataEnum("11045","  Balanced translocations with an unusual phenotype"))
            SpecificDisease.add(new DataEnum("11046","  Bardet-Biedl Syndrome"))
            SpecificDisease.add(new DataEnum("11047","  Primary ciliary dyskinesia"))
            SpecificDisease.add(new DataEnum("11048","  Non-CF bronchiectasis"))
            SpecificDisease.add(new DataEnum("11050","  Non-Fanconi anaemia"))
            SpecificDisease.add(new DataEnum("11051","  Vici Syndrome and other autophagy disorders"))
            SpecificDisease.add(new DataEnum("11053","  Congenital adrenal hypoplasia"))
            SpecificDisease.add(new DataEnum("11054","  Familial or syndromic hypoparathyroidism"))
            SpecificDisease.add(new DataEnum("11057","  IUGR and IGF abnormalities"))
            SpecificDisease.add(new DataEnum("11060","  Significant early-onset obesity with or without other endocrine features and short stature"))
            SpecificDisease.add(new DataEnum("11063","  Classical Beckwith-Wiedemann syndrome"))
            SpecificDisease.add(new DataEnum("11064","  Atypical Beckwith-Wiedemann syndrome"))
            SpecificDisease.add(new DataEnum("11065","  Simpson-Golabi-Behmel syndrome"))
            SpecificDisease.add(new DataEnum("11066","  Sotos syndrome"))
            SpecificDisease.add(new DataEnum("11067","  Weaver syndrome"))
            SpecificDisease.add(new DataEnum("11075","  Congenital anaemias"))
            SpecificDisease.add(new DataEnum("11076","  Congenital hearing impairment"))
            SpecificDisease.add(new DataEnum("11077","  Bilateral microtia"))
            SpecificDisease.add(new DataEnum("11078","  Choanal atresia"))
            SpecificDisease.add(new DataEnum("11079","  Hyperammonaemia"))
            SpecificDisease.add(new DataEnum("11080","  Ketotic hypoglycaemia"))
            SpecificDisease.add(new DataEnum("11081", "Lactic acidosis"))
            SpecificDisease.add(new DataEnum("11083"," Cerebral folate deficiency"))
            SpecificDisease.add(new DataEnum("11084"," Mucopolysaccharideosis -  Gaucher -  Fabry"))
            SpecificDisease.add(new DataEnum("11085"," Mitochondrial disorders"))
            SpecificDisease.add(new DataEnum("11086"," Peroxisomal biogenesis disorders"))
            SpecificDisease.add(new DataEnum("11087","Hereditary ataxia"))
            SpecificDisease.add(new DataEnum("11088"," Early onset dystonia"))
            SpecificDisease.add(new DataEnum("11089"," Hereditary spastic paraplegia"))
            SpecificDisease.add(new DataEnum("11091"," Genetic Epilepsies with Febrile Seizures Plus"))
            SpecificDisease.add(new DataEnum("11092","Familial Genetic Generalised Epilepsies"))
            SpecificDisease.add(new DataEnum("11093"," Familial Focal Epilepsies"))
            SpecificDisease.add(new DataEnum("11094"," Epileptic encephalopathy"))
            SpecificDisease.add(new DataEnum("11099"," Paediatric motor neuronopathies"))
            SpecificDisease.add(new DataEnum("11100"," Early onset and familial Parkinson's Disease"))
            SpecificDisease.add(new DataEnum("11101", "Classical tuberous sclerosis"))
            SpecificDisease.add(new DataEnum("11102", "Intellectual disability"))
            SpecificDisease.add(new DataEnum("11103", "Congenital myopathy"))
            SpecificDisease.add(new DataEnum("11104"," Distal myopathies"))
    }


}
