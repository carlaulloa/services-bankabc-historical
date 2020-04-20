FROM adoptopenjdk/openjdk11:alpine-jre
VOLUME /tmp
EXPOSE 8093
ADD ./target/services-bankabc-historical-0.0.1-SNAPSHOT.jar bankabc-historical.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-Dspring.cloud.config.uri=http://abc-config-server:8085","-jar","/bankabc-historical.jar"]