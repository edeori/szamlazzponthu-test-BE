FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /src
COPY szamlazzponthu-parent/ szamlazzponthu-parent/
RUN --mount=type=cache,target=/root/.m2 \
    mvn -f szamlazzponthu-parent/pom.xml -q -DskipTests \
       -am -pl szamlazzponthu-app package

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /src/szamlazzponthu-parent/szamlazzponthu-app/target/*-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["sh","-c","java -jar /app/app.jar"]
