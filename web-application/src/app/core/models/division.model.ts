import { AddressModel } from "./address.model";
import { ContactModel } from "./contact.model";

export class DivisionModel {
    id!: string;
    code!: string;
    name!: string;
    acronym!: string;
    description!: string;
    address!: AddressModel;
    contact!: ContactModel;
}