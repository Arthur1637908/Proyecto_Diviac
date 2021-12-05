FROM adoptopenjdk:11-jre-hotspot

ARG JAR_FILE

COPY ${JAR_FILE} app.jar
RUN chmod 777 app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]