FROM bellsoft/liberica-openjdk-alpine:17

ARG JAR_FILE=build/libs/*SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

EXPOSE 3306

ENTRYPOINT ["java", "-jar", "app.jar"]