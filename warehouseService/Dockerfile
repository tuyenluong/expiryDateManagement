FROM openjdk:21-jdk

WORKDIR /warehouseService

COPY /target/warehouse-0.0.1-SNAPSHOT.jar warehouse-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "warehouse-0.0.1-SNAPSHOT.jar"]