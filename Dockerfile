FROM gradle:9.4.1-alpine as build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

FROM eclipse-temurin:25

WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/bff-agendador.jar

EXPOSE 8083

CMD ["java", "-jar", "/app/bff-agendador.jar"]