import { Injectable } from '@angular/core';
import {
    ActivatedRouteSnapshot,
    Router,
    RouterStateSnapshot,
    CanActivate
} from '@angular/router';
import { Keycloak } from '../services/keycloak.service';

@Injectable()
export class AuthGuard implements CanActivate {
    constructor(
        protected readonly router: Router,
        private keycloak: Keycloak
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<boolean> {
        return new Promise(async (resolve, reject) => {
            let response;
            let session_token;
            let id_token;
            response = await this.keycloak.initializer();
            session_token = this.keycloak.getSessionToken();
            if (session_token) {
                resolve(true)
            } else {
                this.router.navigate(['/']);
                reject();
            }
        })
    }
}