FROM openjdk:8-alpine

WORKDIR /service
ENV JAVA_OPTS ""
ENV SERVICE_PARAMS ""
ADD user-app/target/user-app.jar /service/
CMD java $JAVA_OPTS -jar user-app.jar $SERVICE_PARAMS