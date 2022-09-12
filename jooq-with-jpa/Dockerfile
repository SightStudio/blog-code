# Non M1
# FROM amazoncorretto:17-alpine-jdk

# M1
FROM amd64/amazoncorretto:17-alpine-jdk

EXPOSE 8080

ENTRYPOINT ["java","-jar","/applicaition.jar"]
VOLUME /tmp
ARG JAR_FILE=application/build/libs/application.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]