import { DocumentModel } from "./document.model";
import { GeneralModel } from "./general.model";

export class PoliceModel {
    id!: string;
    cip!: string;
    division!: GeneralModel;
    firstName!: string;
    secondName!: string;
    lastName!: string;
    secondLastName!: string;
    position!: GeneralModel;
    grade!: GeneralModel;
    sex!: GeneralModel;
    birthOfDate!: string;
    pseudonym!: string;
    civilStatus!: GeneralModel;
}

export class SummaryPoliceModel {
    id!: string;
    cip!: string;
    names!: string;
    lastNames!: string;
    document!: DocumentModel;
    division!: GeneralModel;
}