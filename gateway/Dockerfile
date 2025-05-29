FROM openjdk:21-jdk

WORKDIR /gateway

COPY /target/apiGateway-0.0.1-SNAPSHOT.jar apiGateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "apiGateway-0.0.1-SNAPSHOT.jar"]