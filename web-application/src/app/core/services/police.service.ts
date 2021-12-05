import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { GenericService } from './generic.service';

import { HttpMethodConstant } from '../constants/http-method.constant';
import { ApiUrlConstant } from '../constants/api-url.constant';
import { map } from 'rxjs/operators';
import { CreatePolicePostRequest, ListPoliceGetRequest, ListPoliceGetResponse, ListPoliceSituationsGetRequest, ListPoliceSituationsGetResponde, ListPoliceIdentityDocumentsGetRequest, ListPoliceIdentityDocumentsGetResponse, CreatePoliceIdentityDocumentPostRequest } from '../models/services/police-service.model';
import { PageModel } from '../models/page.model';
import { SummaryPoliceModel } from '../models/police.model';
import { PoliceGeneralInformation } from '../models/policeGeneralInformation.model';
import { GeneralModel } from '../models/general.model';
import { PoliceSituationModel } from '../models/policeSituation.model';
import { IdentityDocumentModel } from '../models/identityDocument.model';

@Injectable({
    providedIn: 'root'
})
export class PoliceService {

    constructor(private genericService: GenericService) { }

    createPolice(police: CreatePolicePostRequest): Observable<any> {
        return this.genericService.service(HttpMethodConstant.POST_HTTP_METHOD, ApiUrlConstant.API_POLICE_GENERAL_INFORMATION, police);
    }

    getPolices(listPoliceGetRequest: ListPoliceGetRequest): Observable<any> {
        const url = `${ApiUrlConstant.API_POLICE}?cip=${listPoliceGetRequest.cip}&name=${listPoliceGetRequest.name}&documentTypeId=${listPoliceGetRequest.documentTypeId}&documentNumber=${listPoliceGetRequest.documentNumber}&pageSize=${listPoliceGetRequest.pageSize}&currentPage=${listPoliceGetRequest.currentPage}`;
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, url, null)
            .pipe(
                map((response) => {
                    let listPoliceGetResponse = new ListPoliceGetResponse();
                    let page = new PageModel();
                    page.numberOfPages = response.page.totalNumberOfItems;
                    page.totalNumberOfItems = response.page.totalNumberOfItems;

                    listPoliceGetResponse.page = page;
                    listPoliceGetResponse.polices = response.polices.map((item: SummaryPoliceModel) => {
                        let police = new SummaryPoliceModel();
                        police.cip = item.cip;
                        police.id = item.id;
                        police.names = item.names;
                        police.lastNames = item.lastNames;

                        let division = new GeneralModel();
                        division.id = item.division.id;
                        division.name = item.division.name;
                        police.division = division;

                        return police;
                    });

                    return listPoliceGetResponse;
                })
            );
    }

    getPoliceGeneralInformationById(policeId: string): Observable<any> {
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, ApiUrlConstant.API_POLICE_GENERAL_INFORMATION + `/${policeId}`, null)
            .pipe(
                map((response) => {
                    let policeGeneralInformation = new PoliceGeneralInformation();
                    policeGeneralInformation.id = response.id;
                    policeGeneralInformation.cip = response.cip;
                    policeGeneralInformation.firstName = response.firstName;
                    policeGeneralInformation.secondName = response.secondName;
                    policeGeneralInformation.lastName = response.lastName;
                    policeGeneralInformation.secondLastName = response.secondLastName;
                    policeGeneralInformation.pseudonym = response.pseudonym;
                    policeGeneralInformation.dateOfBirth = response.dateOfBirth;
                    let division = new GeneralModel();
                    division.id = response.division.id;
                    division.name = response.division.name;
                    policeGeneralInformation.division = division;
                    let position = new GeneralModel();
                    position.id = response.position.id;
                    position.name = response.position.name;
                    policeGeneralInformation.position = position;
                    let grade = new GeneralModel();
                    grade.id = response.grade.id;
                    grade.name = response.grade.name;
                    policeGeneralInformation.grade = grade;
                    let sex = new GeneralModel();
                    sex.id = response.sex.id.toString();
                    sex.name = response.sex.name;
                    policeGeneralInformation.sex = sex;
                    let civilStatus = new GeneralModel();
                    civilStatus.id = response.civilStatus.id;
                    civilStatus.name = response.civilStatus.name;
                    policeGeneralInformation.civilStatus = civilStatus;

                    return policeGeneralInformation;
                })
            )
    }

    updatePoliceGeneralInformationById(policeId: string, policeGeneralInformation: CreatePolicePostRequest): Observable<any> {
        return this.genericService.service(HttpMethodConstant.PUT_HTTP_METHOD, ApiUrlConstant.API_POLICE_GENERAL_INFORMATION + `/${policeId}`, policeGeneralInformation)
            .pipe(
                map((response) => {
                    let policeGeneralInformation = new PoliceGeneralInformation();
                    policeGeneralInformation.id = response.id;
                    policeGeneralInformation.cip = response.cip;
                    policeGeneralInformation.firstName = response.firstName;
                    policeGeneralInformation.secondName = response.secondName;
                    policeGeneralInformation.lastName = response.lastName;
                    policeGeneralInformation.secondLastName = response.secondLastName;
                    policeGeneralInformation.pseudonym = response.pseudonym;
                    policeGeneralInformation.dateOfBirth = response.dateOfBirth;
                    let division = new GeneralModel();
                    division.id = response.division.id;
                    division.name = response.division.name;
                    policeGeneralInformation.division = division;
                    let position = new GeneralModel();
                    position.id = response.position.id;
                    position.name = response.position.name;
                    policeGeneralInformation.position = position;
                    let grade = new GeneralModel();
                    grade.id = response.grade.id;
                    grade.name = response.grade.name;
                    policeGeneralInformation.grade = grade;
                    let sex = new GeneralModel();
                    sex.id = response.sex.id.toString();
                    sex.name = response.sex.name;
                    policeGeneralInformation.sex = sex;
                    let civilStatus = new GeneralModel();
                    civilStatus.id = response.civilStatus.id;
                    civilStatus.name = response.civilStatus.name;
                    policeGeneralInformation.civilStatus = civilStatus;

                    return policeGeneralInformation;
                })
            );
    }

    deletePoliceById(policeId: string): Observable<any> {
        return this.genericService.service(HttpMethodConstant.DELETE_HTTP_METHOD, ApiUrlConstant.API_POLICE + `/${policeId}`, null);
    }

    createPoliceSituation(situation: FormData): Observable<any> {
        return this.genericService.service(
            HttpMethodConstant.POST_HTTP_METHOD,
            ApiUrlConstant.API_POLICE_SITUATIONS,
            situation
        );
    }

    deleteSituation(situationId: string): Observable<any> {
        return this.genericService.service(HttpMethodConstant.DELETE_HTTP_METHOD, ApiUrlConstant.API_POLICE_SITUATIONS + `/${situationId}`, null);
    }

    getSituations(listPoliceSituationsGetRequest: ListPoliceSituationsGetRequest): Observable<any> {
        const url = `${ApiUrlConstant.API_POLICE_SITUATIONS}?policeId=${listPoliceSituationsGetRequest.policeId}&pageSize=${listPoliceSituationsGetRequest.pageSize}&currentPage=${listPoliceSituationsGetRequest.currentPage}`;
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, url, null)
            .pipe(
                map((response) => {
                    let listPoliceSituationsGetResponde = new ListPoliceSituationsGetResponde();
                    let page = new PageModel();
                    page.numberOfPages = response.page.totalNumberOfItems;
                    page.totalNumberOfItems = response.page.totalNumberOfItems;
                    listPoliceSituationsGetResponde.page = page;

                    listPoliceSituationsGetResponde.situations = response.situations.map((item: PoliceSituationModel) => {
                        let policeSituation = new PoliceSituationModel();
                        policeSituation.id = item.id;

                        let situationType = new GeneralModel();
                        situationType.id = item.situationType.id;
                        situationType.name = item.situationType.name;
                        policeSituation.situationType = situationType;

                        let division = new GeneralModel();
                        division.id = item.division.id;
                        division.name = item.division.name;
                        policeSituation.division = division;

                        policeSituation.startDate = item.startDate;
                        policeSituation.endDate = item.endDate;
                        policeSituation.documentName = item.documentName;

                        return policeSituation;
                    });

                    return listPoliceSituationsGetResponde;
                })
            );
    }

    updateSituation(situationId: string, situation: FormData): Observable<any> {
        const url = `${ApiUrlConstant.API_POLICE_SITUATIONS}/${situationId}`;
        return this.genericService.service(HttpMethodConstant.PUT_HTTP_METHOD, url, situation);
    }

    getDocumentList(listPoliceIdentityDocumentsGetRequest: ListPoliceIdentityDocumentsGetRequest): Observable<any> {
        const url = `${ApiUrlConstant.API_POLICE_IDENTITY_DOCUMENTS}?policeId=${listPoliceIdentityDocumentsGetRequest.policeId}&pageSize=${listPoliceIdentityDocumentsGetRequest.pageSize}&currentPage=${listPoliceIdentityDocumentsGetRequest.currentPage}`;
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, url, null)
            .pipe(
                map((response) => {
                    let listPoliceIdentityDocumentsGetResponse = new ListPoliceIdentityDocumentsGetResponse();
                    // let page = new PageModel();
                    // page.numberOfPages = response.page.totalNumberOfItems;
                    // page.totalNumberOfItems = response.page.totalNumberOfItems;
                    // listPoliceIdentityDocumentsGetResponse.page = page;

                    // listPoliceIdentityDocumentsGetResponse.documents = response.identityDocuments.map((item: IdentityDocumentModel) => {
                    listPoliceIdentityDocumentsGetResponse.documents = response.map((item: IdentityDocumentModel) => {
                        let identityDocument = new IdentityDocumentModel();
                        identityDocument.id = item.id;

                        let situationType = new GeneralModel();
                        situationType.id = item.documentType.id;
                        situationType.name = item.documentType.name;
                        identityDocument.documentType = situationType;

                        identityDocument.documentNumber = item.documentNumber;

                        return identityDocument;
                    });

                    return listPoliceIdentityDocumentsGetResponse;
                })
            );
    }

    createPoliceIdentityDocument(policeIdentityDocument: CreatePoliceIdentityDocumentPostRequest): Observable<any> {
        return this.genericService.service(
            HttpMethodConstant.POST_HTTP_METHOD,
            ApiUrlConstant.API_POLICE_IDENTITY_DOCUMENTS,
            policeIdentityDocument
        );
    }

    deleteIdentityDocument(identityDocumentId: string): Observable<any> {
        return this.genericService.service(HttpMethodConstant.DELETE_HTTP_METHOD, ApiUrlConstant.API_POLICE_IDENTITY_DOCUMENTS + `/${identityDocumentId}`, null);
    }

    updateIdentityDocument(identityDocumentId: string, identityDocument: CreatePoliceIdentityDocumentPostRequest): Observable<any> {
        const url = `${ApiUrlConstant.API_POLICE_IDENTITY_DOCUMENTS}/${identityDocumentId}`;
        return this.genericService.service(HttpMethodConstant.PUT_HTTP_METHOD, url, identityDocument);
    }

}
