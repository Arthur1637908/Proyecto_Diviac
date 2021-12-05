import { DivisionModel } from "../division.model";
import { IdentityDocumentModel } from "../identityDocument.model";
import { PageModel } from "../page.model";
import { SummaryPoliceModel } from "../police.model";
import { PoliceSituationModel } from "../policeSituation.model";

export class ListPoliceGetResponse {
    page!: PageModel;
    polices!: SummaryPoliceModel[];
}

export class ListPoliceGetRequest {
    cip!: string;
    name!: string;
    documentTypeId!: string;
    documentNumber!: string;
    pageSize!: number;
    currentPage!: number;
}

export class CreatePolicePostRequest {
    divisionId!: string;
    firstName!: string;
    secondName!: string;
    lastName!: string;
    secondLastName!: string;
    positionId!: number;
    gradeId!: number;
    sexId!: number;
    dateOfBirth!: string;
    pseudonym!: string;
    civilStatusId!: number;
    cip!: string;
}

export class ListPoliceSituationsGetRequest {
    policeId!: string;
    pageSize!: number;
    currentPage!: number;
}

export class ListPoliceSituationsGetResponde {
    page!: PageModel;
    situations!: PoliceSituationModel[];
}

export class CreatePoliceSituationPostRequest {
    situationTypeId!: number;
    divisionId!: string;
    startDate!: string;
    endDate!: string;
    policeId!: string;
    document!: string;
}

export class ListPoliceIdentityDocumentsGetRequest {
    policeId!: string;
    pageSize!: number;
    currentPage!: number;
}

export class ListPoliceIdentityDocumentsGetResponse {
    page!: PageModel;
    documents!: IdentityDocumentModel[];
}

export class CreatePoliceIdentityDocumentPostRequest {
    documentTypeId!: string;
    documentNumber!: string;
    policeId!: string;
}