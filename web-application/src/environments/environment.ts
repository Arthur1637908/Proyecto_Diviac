// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

import { KeycloakConfig } from 'keycloak-js';

// Add here your keycloak setup infos
const keycloakConfig: KeycloakConfig = {
  url: 'http://localhost:8180/auth',
  realm: 'diviac-realm',
  clientId: 'web-app'
};


export const environment = {
  production: false,
  urlBase: 'http://localhost:8090',
  // urlBaseDivision: 'http://localhost:6969',
  // urlBasePolice: 'http://localhost:6969',
  // urlBaseParameter: 'http://localhost:6969',
  urlBaseDivision: 'http://localhost:8091',
  urlBasePolice: 'http://localhost:8082',
  urlBaseParameter: 'http://localhost:28080',
  keycloakConfig
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
