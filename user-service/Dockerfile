FROM openjdk:11-jdk-stretch

WORKDIR /src/app/user

ADD /target/user-service-0.0.1-SNAPSHOT.jar  /src/app/user/user-service-0.0.1-SNAPSHOT.jar


ENTRYPOINT ["java","-jar","user-service-0.0.1-SNAPSHOT.jar"]