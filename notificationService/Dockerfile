FROM openjdk:21-jdk

WORKDIR /productService

COPY /target/productService-0.0.1-SNAPSHOT.jar productService-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", "-jar", "productService-0.0.1-SNAPSHOT.jar"]