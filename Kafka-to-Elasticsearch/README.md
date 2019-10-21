# Kafka-to-Elasticsearch

This Spring boot application enables read messages(Notification/Alarms) continuously from Kafka broker  and format those data according to our requirement and helps to index data to elasticsearch

*Notification/Performance data generator scripts will generate data for particular interval of time and those data's are pushed to Kafka broker for particular topic 
*As Kafka to Elasticsearch application subscribed to Kafka topics and it consumes messages as it arrives in broker
*Once data found those messages are red and processed/formatted based on requirement and indexed to specified index name

#Requirements of application to run

##application.properties

*server.port=<applicationPortNumber>

*kafka.host=<kafkaHost>

*kafka.port=<kafkaPort>

*spring.data.elasticsearch.cluster-name=<clusterName>

*spring.data.elasticsearch.cluster-nodes=<elasticsearchHostandPort>

*kafka.topic=<KafkaTopics>

```
	Mandatory Arguments : 
	
	applicationPortNumber : need to specify in which port this application should run
	kafkaHost : specify from which host server this application need to subscribe
	kafkaPort : port of kafka server
	clusterName : need to specify which elastic search cluster name
	elasticsearchHostandPort :need to specify host and port of elastic search in host:port format
	KafkaTopics :specify kafka topics delimited by , to which this application need to subscribe
```

### Kafka Topic

```
KafkaTopics: EMS_KAFKA_ALARMS_TOPIC,ACHistoricPM,AsePtpHistoricPM,ATNBandCtpHistoricPM,ATNDchCtpHistoricPM,ATNOCGPTPHistoricPM,ATNOtuClientCtpHistoricPM,ATNTribPtpHistoricPM,BandCtpHistoricPM,BandPtpHistoricPM,BaseScgPtpHistoricPM,BmmOcgPtpHistoricPM,AC_BWPHistoricPM,ETHINTF_BWPHistoricPM,NWINTF_BWPHistoricPM,PW_BWPHistoricPM,CarrierCtpHistoricPM,ChannelCtpHistoricPM,ChassisHistoricPM,CmmOcgPtpHistoricPM,CmmOchPtpHistoricPM,AC_CMHistoricPM,ETHINTF_CMHistoricPM,NWINTF_CMHistoricPM,PW_CMHistoricPM,CxOcgPtpHistoricPM,CxScgPtpHistoricPM,DcfPtpHistoricPM,DchCtpHistoricPM,DigitalWrapperCtpHistoricPM,DsePtpHistoricPM,DtpCtpHistoricPM,EdfaHistoricPM,EthIntfHistoricPM,ExpnPtpHistoricPM,ExpnScgPtpHistoricPM,FANHistoricPM,FbmScgPtpHistoricPM,FcClientCtpHistoricPM,FeedPTPHistoricPM,FlexCarrierCtpHistoricPM,FmmcScgPtpHistoricPM,FmmfScgPtpHistoricPM,FrmScgPtpHistoricPM,FsmScgPtpHistoricPM,GamOcgPtpHistoricPM,GfpTpHistoricPM,GigeClientCtpHistoricPM,GroupTpHistoricPM,IdlerChannelCtpHistoricPM,IdlerPtpHistoricPM,IGccHistoricPM,LmOcgPtpHistoricPM,LmOchPtpHistoricPM,MACHistoricPM,MEPHistoricPM,MSHistoricPM,MxpScgPtpHistoricPM,NativeHistoricPM,NoHeaderHistoricPM,NwIntfHistoricPM,OchCtpHistoricPM,ODU0HistoricPM,ODU1HistoricPM,ODU2HistoricPM,ODU3HistoricPM,ODU4HistoricPM,OduClientCtpHistoricPM,OduFlexHistoricPM,OduKiCtpHistoricPM,OduKtClientCtpHistoricPM,OduKtiCtpHistoricPM,OfxScgPtpHistoricPM,OPSMPtpHistoricPM,OsaPtpHistoricPM,OscCtpHistoricPM,OscPtpHistoricPM,OsctCtpHistoricPM,OtsPtpHistoricPM,OTU0HistoricPM,OTU1HistoricPM,OTU2HistoricPM,OTU3HistoricPM,OTU4HistoricPM,OtuClientCtpHistoricPM,OtuKiCtpHistoricPM,PCSHistoricPM,PEMHistoricPM,PortHistoricPM,PWHistoricPM,RSHistoricPM,SchCtpHistoricPM,SdhClientCtpHistoricPM,SecureChannelHistoricPM,SecureEntityHistoricPM,SonetClientCtpHistoricPM,TribPtpHistoricPM,XtOcgPtpHistoricPM,XtScgPtpHistoricPM

```

### Build Docker image
```
docker build -f <DockerFileName> -t <DockerImageName> .

example : docker build -f KafkaDockerFile -t kafka-toelasticsearch .

```

### Run Docker image
```
docker run -e "ENV1=value1" -e "ENV2=value2" kafka-to-elasticsearch

example: docker run -e "applicationPortNumber=<applicationPortNumber>" -e "kafkaHost=10.220.224.66" -e "kafkaPort=9092" -e "clusterName=elasticsearch" -e "elasticsearchHostandPort=10.220.224.67:9300" -e "KafkaTopics=EMS_KAFKA_ALARMS_TOPIC,ACHistoricPM,AsePtpHistoricPM" kafka-to-elasticsearch
```

### Note : This application currently supports only for alaram generator and performance generator

