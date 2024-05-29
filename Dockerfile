FROM gradle:8.5-jdk17-alpine

COPY . .

RUN gradle build

EXPOSE 8080

ENTRYPOINT ["java", "-jar","build/libs/dbdherencia-0.0.1-SNAPSHOT.jar"]