import { Injectable } from "@angular/core";
import { HttpInterceptor, HttpHandler, HttpRequest, HttpEvent } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Keycloak } from '../services/keycloak.service';

@Injectable()
export class Interceptor implements HttpInterceptor {

    constructor(
        private keycloak: Keycloak
    ) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let headers = request.headers
            .set('Authorization', this.keycloak.getSessionToken());

        const newReq = request.clone({ headers: headers });

        return next.handle(newReq);
    }
}