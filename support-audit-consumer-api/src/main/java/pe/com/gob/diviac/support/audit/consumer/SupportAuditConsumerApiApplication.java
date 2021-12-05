package pe.com.gob.diviac.support.audit.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@EnableMongoRepositories(basePackages = "pe.com.gob.diviac.support.audit.consumer.repository")
public class SupportAuditConsumerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportAuditConsumerApiApplication.class, args);
	}

}
