import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { GenericService } from './generic.service';

import { HttpMethodConstant } from '../constants/http-method.constant';
import { ApiUrlConstant } from '../constants/api-url.constant';
import { DivisionGetResponse, DivisionGetRequest } from '../models/services/division-service.model';
import { map } from 'rxjs/operators';
import { DivisionModel } from '../models/division.model';
import { AddressModel } from '../models/address.model';
import { ContactModel } from '../models/contact.model';
import { PageModel } from '../models/page.model';

@Injectable({
    providedIn: 'root'
})
export class DivisionService {

    constructor(private genericService: GenericService) { }

    createDivision(division: DivisionModel): Observable<any> {
        return this.genericService.service(HttpMethodConstant.POST_HTTP_METHOD, ApiUrlConstant.API_DIVISION, division);
    }

    getDivisions(divisionGetRequest: DivisionGetRequest): Observable<any> {
        const url = `${ApiUrlConstant.API_DIVISION}?name=${divisionGetRequest.name}&code=${divisionGetRequest.code}&currentPage=${divisionGetRequest.currentPage}&pageSize=${divisionGetRequest.pageSize}`;
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, url, null)
            .pipe(
                map((response) => {
                    let divisionGetResponse = new DivisionGetResponse();
                    let page = new PageModel();
                    page.numberOfPages = response.page.numberOfPages;
                    page.totalNumberOfItems = response.page.totalNumberOfItems;
                    divisionGetResponse.page = page;
                    divisionGetResponse.divisions = response.divisions.map((item: any) => {
                        let division = new DivisionModel();
                        division.id = item.id;
                        division.name = item.name;
                        division.acronym = item.acronym;
                        division.code = item.code;
                        division.description = item.description;

                        return division;
                    });

                    return divisionGetResponse;
                })
            );
    }

    getDivisionById(divisionId: string): Observable<any> {
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, ApiUrlConstant.API_DIVISION + `/${divisionId}`, null)
            .pipe(
                map((response) => {
                    let division = new DivisionModel();
                    division.id = response.id;
                    division.name = response.name;
                    division.acronym = response.acronym;
                    division.code = response.code;
                    division.description = response.description;
                    let address = new AddressModel();
                    address.departmentId = response.address.department.id;
                    address.provinceId = response.address.province.id;
                    address.districtId = response.address.district.id;
                    address.typeId = response.address.type.id;
                    address.number = response.address.number;
                    address.name = response.address.name;
                    division.address = address;
                    let contact = new ContactModel();
                    contact.annexNumber = response.contact.annexNumber
                    contact.email = response.contact.email
                    contact.phoneNumber = response.contact.phoneNumber
                    division.contact = contact

                    return division;
                })
            )
    }

    updateDivisionById(divisionId: string, division: DivisionModel): Observable<any> {
        return this.genericService
            .service(HttpMethodConstant.PUT_HTTP_METHOD, ApiUrlConstant.API_DIVISION + `/${divisionId}`, division)
            .pipe(
                map((response) => {
                    let division = new DivisionModel();
                    division.id = response.id;
                    division.name = response.name;
                    division.acronym = response.acronym;
                    division.code = response.code;
                    division.description = response.description;
                    let address = new AddressModel();
                    address.departmentId = response.address.department.id;
                    address.provinceId = response.address.province.id;
                    address.districtId = response.address.district.id;
                    address.typeId = response.address.type.id;
                    address.number = response.address.number;
                    address.name = response.address.name;
                    division.address = address;
                    let contact = new ContactModel();
                    contact.annexNumber = response.contact.annexNumber
                    contact.email = response.contact.email
                    contact.phoneNumber = response.contact.phoneNumber
                    division.contact = contact

                    return division;
                })
            )
    }

    deleteDivisionById(divisionId: string): Observable<any> {
        return this.genericService.service(HttpMethodConstant.DELETE_HTTP_METHOD, ApiUrlConstant.API_DIVISION + `/${divisionId}`, null);
    }

}
