FROM alpine/git as clone
WORKDIR /atm
RUN git clone https://github.com/326th/atm-web-frontend

FROM maven:3.5-jdk-8-alpine as build
WORKDIR /atm
COPY --from=clone /atm/atm-web-frontend /atm
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /atm
COPY --from=build /atm/target/atm-0.0.1-SNAPSHOT.jar /atm
EXPOSE 8090
CMD ["java", "-jar", "atm-0.0.1-SNAPSHOT.jar"]
