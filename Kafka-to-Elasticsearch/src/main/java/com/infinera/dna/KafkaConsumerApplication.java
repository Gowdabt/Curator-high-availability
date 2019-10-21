package com.infinera.dna;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Harshith Gowda B T
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@EnableElasticsearchRepositories
public class KafkaConsumerApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}
}
