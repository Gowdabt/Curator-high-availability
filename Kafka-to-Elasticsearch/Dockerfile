FROM openjdk:8
ADD target/Kafka-to-Elasticsearch.jar app/Kafka-to-Elasticsearch.jar
EXPOSE ${portNumber}
ENTRYPOINT ["java","-jar","Kafka-to-Elasticsearch.jar"]