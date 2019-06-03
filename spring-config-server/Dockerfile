FROM openjdk:11-jdk-stretch
WORKDIR /src/muzix
ADD /target/spring-config-server-0.0.1-SNAPSHOT.jar /src/muzix/spring-config-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "spring-config-server-0.0.1-SNAPSHOT.jar"]
