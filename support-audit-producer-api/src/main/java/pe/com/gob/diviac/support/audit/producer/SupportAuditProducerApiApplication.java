package pe.com.gob.diviac.support.audit.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class SupportAuditProducerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportAuditProducerApiApplication.class, args);
	}

}
