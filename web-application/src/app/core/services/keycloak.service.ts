import { Injectable } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import jwt_decode from 'jwt-decode';

import { environment } from '../../../environments/environment';

@Injectable()
export class Keycloak {
    sessionToken: string = '';
    constructor(
        private keycloakService: KeycloakService
    ) { }

    initializer(): Promise<any> {
        return new Promise(async (resolve, reject) => {
            const { keycloakConfig } = environment;
            try {
                await this.keycloakService.init({
                    config: keycloakConfig,
                    initOptions: {
                        onLoad: 'login-required',
                        checkLoginIframe: false
                    },
                    bearerExcludedUrls: []
                });
                this.sessionToken = await this.keycloakService.getToken();
                resolve({});
            } catch (error) {
                reject(error);
            }
        });
    }

    getSessionToken(): string {
        return this.sessionToken;
    }

    getIdTokenDecoded(): any {
        return jwt_decode(String(this.keycloakService.getKeycloakInstance().idToken));
    }
}