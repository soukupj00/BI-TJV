FROM amazoncorretto:17

COPY build/libs/server-*.jar /app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
