FROM openjdk:11-jdk-stretch
WORKDIR /src/muzix
ADD /target/spring-boot-zuulgatewayproxy-0.0.1-SNAPSHOT.jar /src/muzix/spring-boot-zuulgatewayproxy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "spring-boot-zuulgatewayproxy-0.0.1-SNAPSHOT.jar"]
