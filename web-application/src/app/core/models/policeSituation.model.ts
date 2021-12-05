import { GeneralModel } from "./general.model";

export class PoliceSituationModel {
    id!: string;
    situationType!: GeneralModel;
    division!: GeneralModel;
    startDate!: string;
    endDate!: string;
    documentName!: string;
}