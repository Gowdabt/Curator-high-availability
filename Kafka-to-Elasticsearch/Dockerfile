FROM openjdk:8
WORKDIR /app
EXPOSE 8081
ENV applicationPortNumber=${applicationPortNumber} \
	kafkaHost=${kafkaHost} \
	kafkaPort=${kafkaPort} \
	clusterName=${clusterName} \
	elasticsearchHostandPort=${elasticsearchHostandPort} \
	KafkaTopics=${KafkaTopics}

COPY ./Kafka-to-Elasticsearch.jar /opt/
ENTRYPOINT ["java","-jar","/opt/Kafka-to-Elasticsearch.jar"]
