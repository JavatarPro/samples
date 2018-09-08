FROM openjdk:8-alpine

WORKDIR /service
ENV JAVA_OPTS ""
ENV SERVICE_PARAMS ""
ADD producer-service-app/target/producer-service-app.jar /service/
CMD java $JAVA_OPTS -jar producer-service-app.jar $SERVICE_PARAMS

