# Kafka-to-Elasticsearch

This Spring boot application enables read messages(Notification/Alarms) continuously from Kafka broker  and format those data according to our requirement and helps to index data to elasticsearch

*Notification/Performance data generator scripts will generate data for particular interval of time and those data's are pushed to Kafka broker for particular topic 
*As Kafka to Elasticsearch application subscribed to Kafka topics and it consumes messages as it arrives in broker
*Once data found those messages are red and processed/formatted based on requirement and indexed to specified index name

#Requirements of application to run

##application.properties

*server.port=<portnumber>

*kafka.host=<kafkahost>

*kafka.port=<kafkaport>

*spring.data.elasticsearch.cluster-name=<cluster name>

*spring.data.elasticsearch.cluster-nodes=<elasticsearchHostandport>

*kafka.topic=<topics>

```
	Mandatory Arguments : 
	
	portnumber : need to specify in which port this application should run
	kafkahost : specify from which host server this application need to subscribe
	kafkaport : port of kafka server
	cluster name : need to specify which elastic search cluster name
	elasticsearchHostandport :need to specify host and port of elastic search in host:port format
	topics :specify kafka topics delimited by , to which this application need to subscribe
```

### Note : This application currently supports only for alaram generator and performance generator