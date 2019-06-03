FROM openjdk:11-jdk-stretch
WORKDIR /src/muzix
ADD /target/EurekaService-0.0.1-SNAPSHOT.jar /src/muzix/EurekaService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "EurekaService-0.0.1-SNAPSHOT.jar"]
