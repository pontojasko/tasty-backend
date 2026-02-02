FROM maven:4.0.0-rc-5-eclipse-temurin-25 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
CMD ["java","-jar","/app/app.jar"]

