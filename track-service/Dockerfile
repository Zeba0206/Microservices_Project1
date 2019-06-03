FROM openjdk:11-jdk-stretch

WORKDIR /src/app/musicapp

ADD /target/userservice-0.0.1-SNAPSHOT.jar  /src/app/musicapp/userservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","userservice-0.0.1-SNAPSHOT.jar"]

