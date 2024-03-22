FROM amazoncorretto:17-alpine-jdk
COPY target/*.jar producer.jar
ENTRYPOINT ["java","-jar","/producer.jar"]