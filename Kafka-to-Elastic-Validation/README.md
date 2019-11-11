# Kafka-to-Elastic-Validation

This Application Validates alarm/PM data by comparing indexed data in elasticSearch with respect to data in DNA database.

# Requirements of application to run

## application.properties

* server.port=<applicationPortNumber>

### Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
* spring.datasource.url = <datasource_Url>
* spring.datasource.username = <db_user_name>
* spring.datasource.password = <db_password>


### Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
* spring.jpa.properties.hibernate.dialect = <db_dialect>

### Hibernate ddl auto (create, create-drop, validate, update)
* spring.jpa.hibernate.ddl-auto = <dll_type>

* spring.data.elasticsearch.cluster-name=<elastic_cluster_name>

* spring.data.elasticsearch.cluster-nodes=<elasticsearchHostandPort>

* unwantedComparison.Data=<unwanted_parameter_comparision>

```
	Mandatory Arguments : 
	
	applicationPortNumber : need to specify in which port this application should run
	datasource_Url:url to connet to specific scheme
	db_user_name:database user name
	db_password:database password
	db_dialect:dialect of db type which intended to use
	dll_type:type create/create-drop/validate/update
	clusterName : need to specify which elastic search cluster name
	elasticsearchHostandPort :need to specify host and port of elastic search in host:port format
	unwanted_parameter_comparision:comma seprated parameters which specifies not to compare those parameters
```


### Note : This application currently supports only for alaram generator 


