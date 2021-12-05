package pe.com.gob.diviac.support.audit.producer.application.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import pe.com.gob.diviac.support.audit.producer.adapter.output.kafka.KafkaProducerAdapter;
import pe.com.gob.diviac.support.audit.producer.adapter.output.kafka.factory.TopicFactory;
import pe.com.gob.diviac.support.audit.producer.domain.interactor.ProducerInteractor;
import pe.com.gob.diviac.support.audit.producer.domain.port.input.ProducerUseCase;
import pe.com.gob.diviac.support.audit.producer.domain.port.output.ProducerPort;
import pe.com.gob.diviac.support.audit.producer.entity.Audit;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public ProducerPort producerPort(KafkaTemplate<String, Audit> kafkaTemplate,
                                  TopicFactory topicFactory) {
        return KafkaProducerAdapter.builder()
                .kafkaTemplate(kafkaTemplate)
                .topicFactory(topicFactory)
                .build();
    }

    @Bean
    public ProducerUseCase producerUseCase(ProducerPort producerPort) {
        return ProducerInteractor.builder()
                .producerPort(producerPort)
                .build();
    }
}
