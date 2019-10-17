FROM openjdk:8
ADD target/Kafka-to-Elasticsearch.jar app/Kafka-to-Elasticsearch.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","Kafka-to-Elasticsearch.jar"]