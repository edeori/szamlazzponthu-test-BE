FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY szamlazzponthu-parent/szamlazzponthu-app/target/*-SNAPSHOT.jar app.jar

ENV SERVER_PORT=8080 \
    APP_CORS_ALLOWED_ORIGINS=http://localhost:3000 \
    BN_DB_USER=test \
    BN_DB_PASS=test

EXPOSE 8080
ENTRYPOINT ["sh","-c","java -Dserver.port=${SERVER_PORT} -Dapp.cors.allowed-origins=${APP_CORS_ALLOWED_ORIGINS} -jar app.jar"]
