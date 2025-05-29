FROM openjdk:21-jdk

WORKDIR /fileService

COPY /target/fileService-0.0.1-SNAPSHOT.jar fileService-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "fileService-0.0.1-SNAPSHOT.jar"]