import { KeycloakConfig } from 'keycloak-js';

// Add here your keycloak setup infos
const keycloakConfig: KeycloakConfig = {
  url: 'http://192.168.1.61:8180/auth',
  realm: 'diviac-realm',
  clientId: 'web-app'
};

export const environment = {
  production: true,
  urlBase: 'http://localhost:6969',
  keycloakConfig
};
