export class PoliceSearchForm {
    cip!: string;
    name!: string;
    documentType!: string;
    documentNumber!: string;
}

export class CreatePoliceGeneralInformationForm {
    divisionId!: string;
    firstName!: string;
    secondName!: string;
    lastName!: string;
    secondLastName!: string;
    positionId!: string;
    gradeId!: string;
    genderId!: string;
    dateOfBirth!: string;
    pseudonym!: string;
    civilStatusId!: string;
    cip!: string;
}

export class CreatePoliceSituationForm {
    situationId!: string;
    startDate!: string;
    endDate!: string;
    document!: any;
}

export class CreatePoliceIdentityDocumentForm {
    documentTypeId!: string;
    documentNumber!: string;
}