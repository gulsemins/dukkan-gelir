FROM openjdk:17-jdk-alpine
# Accept build args
ARG DB_USERNAME
ARG DB_PASSWORD


ENV DB_USERNAME=$DB_USERNAME
ENV DB_PASSWORD=$DB_PASSWORD

COPY build/libs/dukkan-gelir-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
