FROM openjdk:8
VOLUME ["/app"]
WORKDIR /app
ADD target/Kafka-to-Elasticsearch.jar app/Kafka-to-Elasticsearch.jar
EXPOSE ${applicationPortNumber}
ENTRYPOINT ["java","-jar","Kafka-to-Elasticsearch.jar"]