import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiUrlConstant } from '../constants/api-url.constant';
import { HttpMethodConstant } from '../constants/http-method.constant';

import { GenericService } from './generic.service';
import { map } from 'rxjs/operators';
import { UbigeoModel } from '../models/ubigeo.model';

@Injectable({
    providedIn: 'root'
})
export class UbigeoService {

    constructor(private genericService: GenericService) { }

    getDepartments(): Observable<any> {
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, ApiUrlConstant.API_UBIGEO_DEPARTMENTS, null)
            .pipe(
                map((response) => {
                    return response.map((item: any) => {
                        let ubigeo = new UbigeoModel();
                        ubigeo.id = item.id;
                        ubigeo.name = item.name;
                        return ubigeo;
                    });
                })
            );
    }

    getProvinces(departmentId: string): Observable<any> {
        const url = `${ApiUrlConstant.API_UBIGEO_PROVINCES}?departmentId=${departmentId}`;
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, url, null)
            .pipe(
                map((response) => {
                    return response.map((item: any) => {
                        let ubigeo = new UbigeoModel();
                        ubigeo.id = item.id;
                        ubigeo.name = item.name;
                        return ubigeo;
                    });
                })
            );
    }

    getDistricts(provinceId: string): Observable<any> {
        const url = `${ApiUrlConstant.API_UBIGEO_DISTRICTS}?provinceId=${provinceId}`;
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, url, null)
            .pipe(
                map((response) => {
                    return response.map((item: any) => {
                        let ubigeo = new UbigeoModel();
                        ubigeo.id = item.id;
                        ubigeo.name = item.name;
                        return ubigeo;
                    });
                })
            );
    }

}
