import { GeneralModel } from "./general.model";

export class IdentityDocumentModel {
    id!: string;
    documentType!: GeneralModel;
    documentNumber!: string;
}