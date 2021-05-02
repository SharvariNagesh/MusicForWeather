FROM openjdk:11-jre-slim
MAINTAINER test.com
COPY target/demo-0.0.1-SNAPSHOT.jar  weather-music-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/weather-music-server-1.0.0.jar"]
