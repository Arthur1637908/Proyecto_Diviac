package pe.com.gob.diviac.support.audit.consumer.application;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.gob.diviac.support.audit.consumer.listener.KafkaConsumerListener;
import pe.com.gob.diviac.support.audit.consumer.repository.AuditRepository;
import pe.com.gob.diviac.support.audit.consumer.repository.converter.AuditDocumentConverter;
import pe.com.gob.diviac.support.audit.consumer.repository.document.AuditDocument;
import pe.com.gob.diviac.support.audit.consumer.entity.Audit;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public Function<Audit, AuditDocument> auditMessageDocumentConverter() {
        return AuditDocumentConverter.builder()
                .build();
    }

    @Bean
    public KafkaConsumerListener kafkaConsumerListener(AuditRepository auditRepository,
                                                       Function<Audit, AuditDocument> auditDocumentConverter) {
        return KafkaConsumerListener.builder()
                .auditRepository(auditRepository)
                .auditDocumentConverter(auditDocumentConverter)
                .build();
    }
}
