FROM jboss/keycloak

ADD diviac-realm-export.json /opt/jboss/keycloak/

CMD [ "-Dkeycloak.profile.feature.upload_scripts=enabled" ,"-Dkeycloak.migration.action=import", "-Dkeycloak.migration.provider=singleFile", "-Dkeycloak.migration.file=/opt/jboss/keycloak/diviac-realm-export.json"]

COPY custom-keycloak/ /opt/jboss/keycloak/themes/