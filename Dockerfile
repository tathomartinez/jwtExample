FROM openjdk:17-jdk-alpine
EXPOSE 8088
RUN mkdir -p /app/
RUN mkdir -p /app/certs/
ADD build/libs/login-0.0.1-SNAPSHOT.jar /app/login-0.0.1-SNAPSHOT.jar
#COPY src/main/resources/certs/public.pem /app/certs/public.pem
#COPY src/main/resources/certs/private.pem /app/certs/private.pem
ENTRYPOINT ["java", "-jar", "/app/login-0.0.1-SNAPSHOT.jar"]