FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN chmod +x mvnw
RUN ./mvnw -B -v dependency:go-offline

COPY src ./src
RUN ./mvnw -B clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENV JAVA_OPTS=""

EXPOSE 8080
CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]
