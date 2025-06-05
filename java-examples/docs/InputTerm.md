

# InputTerm

Represents an term to be mapped

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**code** | **String** | Code for the term to be mapped, e.g. \&quot;56265001\&quot; |  |
|**inputType** | [**InputTypeEnum**](#InputTypeEnum) | Expected input type of the thing being mapped.  Allowable values are detailed by the application metadata endpoint |  [optional] |
|**context** | **Map&lt;String, String&gt;** | Additional textual context for disambiguation, including other text around the text of the term |  [optional] |
|**taskId** | **String** | Task id for this term |  [optional] |
|**term** | **String** | Text value to be mapped, e.g. \&quot;heart disease\&quot; |  |
|**entityType** | [**EntityTypeEnum**](#EntityTypeEnum) | Expected entity type to be mapped to.  Allowable values are detailed by the application metadata endpoint |  [optional] |
|**terminology** | **String** | Terminology for the term to be mapped, e.g. \&quot;SNOMEDCT\&quot; or \&quot;https://loinc.org\&quot; |  |
|**tags** | [**List&lt;Tag&gt;**](Tag.md) | List of key/value tags |  [optional] |



## Enum: InputTypeEnum

| Name | Value |
|---- | -----|
| PICKLIST | &quot;picklist&quot; |
| BOOLEAN | &quot;boolean&quot; |
| STRING | &quot;string&quot; |
| PHRASE | &quot;phrase&quot; |
| FHIRCODING | &quot;fhirCoding&quot; |



## Enum: EntityTypeEnum

| Name | Value |
|---- | -----|
| GENERAL | &quot;general&quot; |
| ALLERGY | &quot;allergy&quot; |
| BODYPART | &quot;bodyPart&quot; |
| DEVICE | &quot;device&quot; |
| CONDITION | &quot;condition&quot; |
| FAMILYHISTORY | &quot;familyHistory&quot; |
| IMMUNIZATION | &quot;immunization&quot; |
| MEDICATION | &quot;medication&quot; |
| LABRESULT | &quot;labResult&quot; |
| LABRESULTUNIT | &quot;labResultUnit&quot; |
| LABRESULTVALUE | &quot;labResultValue&quot; |
| LABRESULTINTERPRETATION | &quot;labResultInterpretation&quot; |
| PROCEDURE | &quot;procedure&quot; |
| SOCIALHISTORY | &quot;socialHistory&quot; |
| SUBSTANCE | &quot;substance&quot; |
| VITALSIGN | &quot;vitalSign&quot; |
| VITALSIGNUNIT | &quot;vitalSignUnit&quot; |
| VITALSIGNVALUE | &quot;vitalSignValue&quot; |
| VITALSIGNINTERPRETATION | &quot;vitalSignInterpretation&quot; |
| BIOMARKER | &quot;biomarker&quot; |
| COURSE | &quot;course&quot; |
| GENDER | &quot;gender&quot; |
| GRADE | &quot;grade&quot; |
| HISTOLOGY | &quot;histology&quot; |
| LINEOFTHERAPY | &quot;lineOfTherapy&quot; |
| PERFORMANCESTATUS | &quot;performanceStatus&quot; |
| SEVERITY | &quot;severity&quot; |
| STAGE | &quot;stage&quot; |
| TUMORSETTING | &quot;tumorSetting&quot; |
| UNIT | &quot;unit&quot; |
| CONDITIONCLINICALSTATUS | &quot;conditionClinicalStatus&quot; |
| CONDITIONVERIFICATIONSTATUS | &quot;conditionVerificationStatus&quot; |
| CONDITIONCATEGORY | &quot;conditionCategory&quot; |
| MEDICATIONSTATUS | &quot;medicationStatus&quot; |
| MEDICATIONDOSEFORM | &quot;medicationDoseForm&quot; |
| PROCEDURESTATUS | &quot;procedureStatus&quot; |
| PROCEDURECATEGORY | &quot;procedureCategory&quot; |
| OBSERVATIONSTATUS | &quot;observationStatus&quot; |
| OBSERVATIONCATEGORY | &quot;observationCategory&quot; |
| ALLERGYCLINICALSTATUS | &quot;allergyClinicalStatus&quot; |
| ALLERGYVERIFICATIONSTATUS | &quot;allergyVerificationStatus&quot; |
| ALLERGYTYPE | &quot;allergyType&quot; |
| ALLERGYCATEGORY | &quot;allergyCategory&quot; |
| ALLERGYCRITICALITY | &quot;allergyCriticality&quot; |
| ADVERSEEVENT | &quot;adverseEvent&quot; |
| BIOMARKERINTERPRETATION | &quot;biomarkerInterpretation&quot; |
| BIOMARKERMETHOD | &quot;biomarkerMethod&quot; |
| BIOMARKERRESULT | &quot;biomarkerResult&quot; |
| DOSEFORM | &quot;doseForm&quot; |
| LABORDER | &quot;labOrder&quot; |
| LABPANEL | &quot;labPanel&quot; |
| SYMPTOM | &quot;symptom&quot; |
| MULTI | &quot;multi&quot; |
| OTHER | &quot;other&quot; |



