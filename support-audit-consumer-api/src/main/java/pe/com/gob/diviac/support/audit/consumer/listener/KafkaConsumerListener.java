package pe.com.gob.diviac.support.audit.consumer.listener;

import java.util.function.Function;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import pe.com.gob.diviac.support.audit.consumer.entity.Audit;
import pe.com.gob.diviac.support.audit.consumer.repository.AuditRepository;
import pe.com.gob.diviac.support.audit.consumer.repository.document.AuditDocument;

@Slf4j
@Builder
@RequiredArgsConstructor
public class KafkaConsumerListener {

    private final AuditRepository auditRepository;
    private final Function<Audit, AuditDocument> auditDocumentConverter;

    @KafkaListener(id = "default-consumer", topicPartitions = {
            @TopicPartition(topic = "default-topic", partitions = { "0" })})
    public void consumeMessage(
            final @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            final @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
            final @Payload Audit audit) {
        AuditDocument auditDocument;

        log.info("Consume message: [Topic: {}, Partition: {}, Message: {}]", topic, partition, audit);

        auditDocument = auditDocumentConverter.apply(audit);
        auditRepository.save(auditDocument);
    }
}
