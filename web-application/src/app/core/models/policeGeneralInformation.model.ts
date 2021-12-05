import { GeneralModel } from "./general.model";

export class PoliceGeneralInformation {
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
    dateOfBirth!: string;
    pseudonym!: string;
    civilStatus!: GeneralModel;
}