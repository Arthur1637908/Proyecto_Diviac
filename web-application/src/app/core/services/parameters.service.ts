import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiUrlConstant } from '../constants/api-url.constant';
import { HttpMethodConstant } from '../constants/http-method.constant';

import { GenericService } from './generic.service';
import { map } from 'rxjs/operators';
import { groupCode } from '../types/parameters.type';
import { ParameterModel } from '../models/parameter.model';

@Injectable({
    providedIn: 'root'
})
export class ParametersService {

    constructor(private genericService: GenericService) { }

    getParameters(groupCode: groupCode): Observable<any> {
        const url = `${ApiUrlConstant.API_PARAMETERS}?groupCode=${groupCode}`;
        return this.genericService
            .service(HttpMethodConstant.GET_HTTP_METHOD, url, null)
            .pipe(
                map((response) => {
                    return response.map((item: any) => {
                        let parameter = new ParameterModel();
                        parameter.id = item.id;
                        parameter.name = item.name;
                        parameter.state = item.state;
                        return parameter;
                    });
                })
            );
    }

}
