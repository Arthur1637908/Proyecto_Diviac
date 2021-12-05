#! /bin/sh.

BOLD_GREEN='\033[1;32m'
RESET='\033[0m'
PWD_DIRECTORY=0
BITBUCKET_USER=geinnertuctoh

#------------------------------------------------------------------------------------------------------------------------------------------------
# APIs REPOSITORIES
#------------------------------------------------------------------------------------------------------------------------------------------------
# Container resource repository
CONTAINER_SERVICE_RESOURCE_REPO=https://${BITBUCKET_USER}@bitbucket.org/bcrg1993/container-service-resources.git

# Database repository
DATABASE_RESOURCE_REPO=https://${BITBUCKET_USER}@bitbucket.org/bcrg1993/database-resources.git

# Support APIs repositories
SUPPORT_AUDIT_PRODUCER_API_REPO=https://${BITBUCKET_USER}@bitbucket.org/bcrg1993/support-audit-producer-api.git
SUPPORT_AUDIT_CONSUMER_API_REPO=https://${BITBUCKET_USER}@bitbucket.org/bcrg1993/support-audit-consumer-api.git

# Business APIs repositories
BUSINESS_PARAMETER_API_REPO=https://${BITBUCKET_USER}@bitbucket.org/bcrg1993/business-parameter-api.git
BUSINESS_DIVISION_API_REPO=https://${BITBUCKET_USER}@bitbucket.org/bcrg1993/business-division-api.git
BUSINESS_POLICE_API_REPO=https://${BITBUCKET_USER}@bitbucket.org/bcrg1993/business-police-api.git

# Channel APIs repositories
CHANNEL_PARAMETER_API_REPO=https://${BITBUCKET_USER}@bitbucket.org/bcrg1993/channel-parameter-api.git
CHANNEL_ADMINISTRATION_API_REPO=https://${BITBUCKET_USER}@bitbucket.org/bcrg1993/channel-administration-api.git
#------------------------------------------------------------------------------------------------------------------------------------------------
# APIs STABLE BRANCHS
#------------------------------------------------------------------------------------------------------------------------------------------------
# Container service resource branch
CONTAINER_SERVICE_RESOURCE_BRANCH=develop

# Database resource branch
DATABASE_RESOURCE_BRANCH=develop

# Support APIs branchs
SUPPORT_AUDIT_PRODUCER_API_BRANCH=develop
SUPPORT_AUDIT_CONSUMER_API_BRANCH=develop

# Business APIs branchs
BUSINESS_PARAMETER_API_BRANCH=develop
BUSINESS_DIVISION_API_BRANCH=develop
BUSINESS_POLICE_API_BRANCH=develop

# Channel APIs branchs
CHANNEL_PARAMETER_API_BRANCH=develop
CHANNEL_ADMINISTRATION_API_BRANCH=develop
#------------------------------------------------------------------------------------------------------------------------------------------------

echo "Do you wish to clone the application components?"
select yn in "Yes" "No"; do
    case $yn in
        Yes ) 
        git clone ${CONTAINER_SERVICE_RESOURCE_REPO}
        git clone ${DATABASE_RESOURCE_REPO}
        git clone ${SUPPORT_AUDIT_PRODUCER_API_REPO}
        git clone ${SUPPORT_AUDIT_CONSUMER_API_REPO}
        git clone ${BUSINESS_PARAMETER_API_REPO}
        git clone ${BUSINESS_DIVISION_API_REPO}
        git clone ${BUSINESS_POLICE_API_REPO}
        git clone ${CHANNEL_PARAMETER_API_REPO}
        git clone ${CHANNEL_ADMINISTRATION_API_REPO}
        break;;

        No ) break;;
    esac
done

echo "\nDo you wish to build the application components?"
select yn in "Yes" "No"; do
    case $yn in
        Yes ) 
        cd container-service-resources/ && git pull --rebase && git checkout ${CONTAINER_SERVICE_RESOURCE_BRANCH} && cd keycloak/ && docker build -t keycloak-diviac:v1 .
        cd ../../database-resources/ && git pull --rebase && git checkout ${DATABASE_RESOURCE_BRANCH}
        cd order_db && rm -f 1_create_db_diviac.sql 92_insert_data_division.sql
        cd ../../support-audit-producer-api/ && git pull --rebase && git checkout ${SUPPORT_AUDIT_PRODUCER_API_BRANCH} && mvn clean install
        cd ../support-audit-consumer-api/ && git pull --rebase && git checkout ${SUPPORT_AUDIT_CONSUMER_API_BRANCH} && mvn clean install
        cd ../business-parameter-api/ && git pull --rebase && git checkout ${BUSINESS_PARAMETER_API_BRANCH} && mvn clean install
        cd ../business-division-api/ && git pull --rebase && git checkout ${BUSINESS_DIVISION_API_BRANCH} && mvn clean install && cd envoy/ && docker build -t envoy-division:v1 .
        cd ../../business-police-api/ && git pull --rebase && git checkout ${BUSINESS_POLICE_API_BRANCH} && mvn clean install
        cd ../channel-parameter-api/ && git pull --rebase && git checkout ${CHANNEL_PARAMETER_API_BRANCH} && mvn clean install
        cd ../channel-administration-api/ && git pull --rebase && git checkout ${CHANNEL_ADMINISTRATION_API_BRANCH} && mvn clean install
        PWD_DIRECTORY=1

        echo "\n------------------------------------------------------------------------"
        echo "${BOLD_GREEN}SHOWING CREATED IMAGES:${RESET}"
        echo "------------------------------------------------------------------------\n"
        docker images

        break;;

        No ) break;;
    esac
done

echo "\nDo you wish to deploy the application components?"
select yn in "Yes" "No"; do
    case $yn in
        Yes ) 
        if [ ${PWD_DIRECTORY} -eq 1 ]
        then
            cd ..
        fi
        docker-compose -f docker-compose.yml up -d
        break;;

        No ) exit;;
    esac
done
