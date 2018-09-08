FROM openjdk:8-alpine

WORKDIR /service
ENV JAVA_OPTS ""
ENV SERVICE_PARAMS ""
ADD consumer-service-app/target/consumer-service-app.jar /service/
CMD java $JAVA_OPTS -jar consumer-service-app.jar $SERVICE_PARAMS