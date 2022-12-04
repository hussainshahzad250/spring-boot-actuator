FROM openjdk:11.0
ADD target/spring-boot-actuator-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
