
FROM openjdk:17-jdk

WORKDIR /app

COPY target/School-0.0.1-SNAPSHOT.jar /app/school.jar

EXPOSE 2222

CMD ["java", "-jar", "school.jar"]
