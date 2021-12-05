import { environment } from '../../../environments/environment';

const prefixChannel = 'channel';
const prefixBusiness = 'business';

export class ApiUrlConstant {

    // Division path
    static readonly API_DIVISION: string = `${environment.urlBaseDivision}/${prefixBusiness}/division-management/v1/divisions`;

    // Police path
    static readonly API_POLICE: string = `${environment.urlBasePolice}/${prefixBusiness}/police-management/v1/polices`;
    static readonly API_POLICE_GENERAL_INFORMATION: string = `${ApiUrlConstant.API_POLICE}/general-information`;
    static readonly API_POLICE_SITUATIONS: string = `${ApiUrlConstant.API_POLICE}/situations`;
    static readonly API_POLICE_IDENTITY_DOCUMENTS: string = `${ApiUrlConstant.API_POLICE}/identity-documents`;

    // Parameters path
    static readonly API_PARAMETERS: string = `${environment.urlBaseParameter}/${prefixChannel}/parameter-management/v1/parameters`;

    // Ubigeo path
    static readonly API_UBIGEO: string = `${environment.urlBaseParameter}/${prefixChannel}/parameter-management/v1/ubigeos`;
    static readonly API_UBIGEO_DEPARTMENTS: string = `${ApiUrlConstant.API_UBIGEO}/departments`;
    static readonly API_UBIGEO_PROVINCES: string = `${ApiUrlConstant.API_UBIGEO}/provinces`;
    static readonly API_UBIGEO_DISTRICTS: string = `${ApiUrlConstant.API_UBIGEO}/districts`;
}