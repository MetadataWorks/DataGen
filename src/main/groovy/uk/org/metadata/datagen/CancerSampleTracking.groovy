package uk.org.metadata.datagen

class CancerSampleTracking {


    List<DataEnum> TestResultType = null

    ArrayList<DataItem> cstDataItems = null

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


    CancerSampleTracking(){

        setupData()

    }

        void setupData(){

        TestResultType = new ArrayList()
        TestResultType.add(new DataEnum("2","Female"))
        TestResultType.add(new DataEnum("1","Male"))
        TestResultType.add(new DataEnum("9","Indeterminate"))

    }

    ArrayList<DataItem> getDataItems(){

        DataItem partid = new DataItem("Participant ID",  "[0-9]{9}")
        partid.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems << partid

        DataItem ClinicID = new DataItem("Clinic Id", "[a-zA-Z0-9]{3,9}")
        ClinicID.generateItems(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  ClinicID

        DataItem SampleID = new DataItem("CSample ID", "[a-zA-Z0-9]{128}")
        SampleID.generateItems(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  SampleID

        DataItem clinicSampleType = new DataItem("Clinic Sample Type", SharedDatasets.GMCSampleType)
        clinicSampleType.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  clinicSampleType

        DataItem ClinicSampleDateTime = new DataItem("Clinic Sample Date Time")
        ClinicSampleDateTime.generateDates(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  ClinicSampleDateTime

        DataItem LaboratoryID = new DataItem("Laboratory ID", "[a-zA-Z0-9]{3,9}")
        LaboratoryID.generateItems(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  LaboratoryID

        DataItem SampleID = new DataItem("Sample ID", "\\d{10}")
        SampleID.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  SampleID

        DataItem LaboratorySampleVolume = new DataItem("Laboratory Sample Volume", "^[+]?\\d+([.]\\d)?$")
        LaboratorySampleVolume.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  LaboratorySampleVolume

        DataItem LaboratoryRemainingVolumeBanked = new DataItem("Laboratory Remaining Volume Banked", "^[+]?\\d+([.]\\d)?$")
        LaboratoryRemainingVolumeBanked.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  LaboratoryRemainingVolumeBanked

        DataItem  GMCSampleDispatchDate = new DataItem(" GMC Sample Dispatch Date" )
        GMCSampleDispatchDate.generateDates(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  GMCSampleDispatchDate

        DataItem GMCSampleConsignmentNumber = new DataItem("GMC Sample Consignment Number", "[a-zA-Z0-9]{2,9}-\\d{2,4}-\\d{1,2}-\\d{1,2}-([1-2]|\\d{1,2}-[1-2]([-]FT)?)")
        GMCSampleConsignmentNumber.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  GMCSampleConsignmentNumber

        DataItem GMCRackWell = new DataItem("GMC Rack Well", "[A-H][1-9]|[A-H][1][0-2]")
        GMCRackWell.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  GMCRackWell

        DataItem GMCRackID = new DataItem("GGMC Rack ID", "[a-zA-Z]{2}\\d{8}|\\d{8}|\\d{10}")
        GMCRackID.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  GMCRackID

        DataItem TumourType = new DataItem("Tumour Type", SharedDatasets.TumourType)
        TumourType.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TumourType

        DataItem ExcisionMargin = new DataItem("Excision Margin", SharedDatasets.ExcisionMargin)
        ExcisionMargin.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  ExcisionMargin

        DataItem TumourSize = new DataItem("Tumour Size", "\\d{5}")
        TumourSize.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TumourSize

        DataItem MorphologyICD = new DataItem("Morphology (ICD)", "\\d{4}/\d{1}")
        MorphologyICD.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  MorphologyICD

        DataItem MorphologySNOMEDRT = new DataItem("Morphology (SNOMEDRT)", "\\d{4}/\\d{1}")
        MorphologySNOMEDRT.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  MorphologySNOMEDRT

        DataItem MorphologySNOMEDCT = new DataItem("Morphology (SNOMEDCT)", "\\d{4}/\\d{1}")
        MorphologySNOMEDCT.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  MorphologySNOMEDCT

        DataItem TissueSource = new DataItem("Tissue Source", SharedDatasets.TissueSource)
        TissueSource.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TissueSource

        DataItem PreInvasiveElements = new DataItem("Pre-invasive Elements", "[a-zA-Z0-9]{20}")
        PreInvasiveElements.generateItems(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  PreInvasiveElements

        DataItem TopographyICD = new DataItem("Topography (ICD)", "\\d{4}/\\d{1}")
        TopographyICD.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TopographyICD

        DataItem TopographySNOMEDCT = new DataItem("Topography (SNOMEDCT)", "\\d{4}/\\d{1}")
        TopographySNOMEDCT.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TopographySNOMEDCT

        DataItem TopographySNOMEDRT = new DataItem("Topography (SNOMEDRT)", "\\d{4}/\\d{1}")
        TopographySNOMEDRT.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TopographySNOMEDRT

        DataItem Macrodissected = new DataItem("Macrodissected", SharedDatasets.ChoiceYesNo)
        Macrodissected.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  Macrodissected

        DataItem MacrodissectionDetails = new DataItem("Macrodissection Details", "[a-zA-Z0-9]{20}")
        MacrodissectionDetails.generateItems(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  MacrodissectionDetails

        DataItem SnapFreezingStartDateTime = new DataItem("Snap Freezing Start DateTime")
        SnapFreezingStartDateTime.generateDates(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  SnapFreezingStartDateTime

        DataItem TypeOfFixative = new DataItem("Tissue Source", SharedDatasets.TypeOfFixative)
        TypeOfFixative.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TypeOfFixative

        DataItem FixationStartDateTime = new DataItem("Fixation Start DateTime")
        FixationStartDateTime.generateDates(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  FixationStartDateTime

        DataItem FixationEndDateTime = new DataItem("Fixation End DateTime")
        FixationEndDateTime.generateDates(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  FixationEndDateTime

        DataItem FixationComments = new DataItem("Fixation Comments", "[a-zA-Z0-9]{20}")
        MacrodissectionDetails.generateItems(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  MacrodissectionDetails

        DataItem ProcessingSchedule = new DataItem("Processing Schedule", SharedDatasets.ProcessingSchedule)
        ProcessingSchedule.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  ProcessingSchedule

        DataItem TimeInFormalinOnProcessor = new DataItem("Time in formalin on processor", "\\d{3}")
        TimeInFormalinOnProcessor.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TimeInFormalinOnProcessor

        DataItem NumberOfBiopsies = new DataItem("Number of Biopsies", "\\d{3}")
        NumberOfBiopsies.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  NumberOfBiopsies

        DataItem GaugeOfBiopsies = new DataItem("Gauge of Biopsies", "\\d{3}")
        GaugeOfBiopsies.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  GaugeOfBiopsies

        DataItem DNAExtractionProtocol = new DataItem("DNA Extraction Protocol", SharedDatasets.DNAExtractionProtocol)
        DNAExtractionProtocol.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  DNAExtractionProtocol

        DataItem ProlongedSampleStorage = new DataItem("Prolonged Sample Storage", SharedDatasets.ProlongedSampleStorage)
        ProlongedSampleStorage.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  ProlongedSampleStorage

        DataItem TumourSampleType = new DataItem("Tumour Sample Type", SharedDatasets.TumourSampleType)
        TumourSampleType.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TumourSampleType

        DataItem ScrollThickness = new DataItem("Scroll Thickness", "^[+-]?([0-9]*[.])?[0-9]+$")
        ScrollThickness.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  ScrollThickness

        DataItem NumberOfScrolls = new DataItem("Number of Scrolls", "\\d{5}")
        NumberOfScrolls.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  NumberOfScrolls

        DataItem NumberOfSections = new DataItem("Number of Sections", "\\d{5}")
        NumberOfSections.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  NumberOfSections

        DataItem SectionThickness = new DataItem("Section Thickness", "^[+-]?([0-9]*[.])?[0-9]+$")
        SectionThickness.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  SectionThickness

        DataItem NumberOfBlocks = new DataItem("Number of Blocks", "\\d{5}")
        NumberOfBlocks.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  NumberOfBlocks

        DataItem CoreDiameter = new DataItem("Core Diameter", "\\d{5}")
        CoreDiameter.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  CoreDiameter

        DataItem NumberOfCores = new DataItem("Number of Cores", "\\d{2}")
        NumberOfCores.generateNumbers(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  NumberOfCores

        DataItem TumourID = new DataItem("Tumour ID", "[a-zA-Z]{2}[0-9]{1}_[a-zA-Z0-9]{1,16}")
        TumourID.generateItems(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  TumourID

        DataItem DiseaseType = new DataItem("Tumour Sample Type", SharedDatasets.DiseaseType)
        DiseaseType.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  DiseaseType

        DataItem DiseaseSubType = new DataItem("Tumour Sample Type", SharedDatasets.DiseaseSubType)
        DiseaseSubType.generateChoices(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  DiseaseSubType

        DataItem RetrospectiveSample = new DataItem("Retrospective sample", "[a-zA-Z]{2}[0-9]{1}_[a-zA-Z0-9]{1,16}")
        RetrospectiveSample.generateItems(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  RetrospectiveSample

        DataItem PreviousTreatment = new DataItem("Previous Treatment", "((neoadjuvant|historic_treatment|historic_treatment_other|no_previous_treatment),)*(neoadjuvant|historic_treatment|historic_treatment_other|no_previous_treatment)")
        PreviousTreatment.generateItems(numberOfRows,numberOfRowsFalseData)
        cstDataItems <<  PreviousTreatment


        //====================================================//



        return cstDataItems

    }


}
