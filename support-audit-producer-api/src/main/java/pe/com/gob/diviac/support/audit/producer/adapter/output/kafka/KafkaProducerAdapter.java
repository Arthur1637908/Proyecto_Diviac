package pe.com.gob.diviac.support.audit.producer.adapter.output.kafka;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.core.KafkaFailureCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFuture;

import pe.com.gob.diviac.support.audit.producer.adapter.output.kafka.factory.TopicFactory;
import pe.com.gob.diviac.support.audit.producer.application.kafka.bean.TopicBean;
import pe.com.gob.diviac.support.audit.producer.domain.port.output.ProducerPort;
import pe.com.gob.diviac.support.audit.producer.entity.Audit;

@Slf4j
@Builder
@RequiredArgsConstructor
public class KafkaProducerAdapter implements ProducerPort {

    private final TopicFactory topicFactory;
    private final KafkaTemplate<String, Audit> kafkaTemplate;

    @Override
    @Transactional
    public void produceAuditMessage(Audit audit) {
        TopicBean topicBean;
        ListenableFuture<SendResult<String, Audit>> future;

        topicBean = topicFactory.createInstance();
        future = kafkaTemplate.send(topicBean.getName(), audit);

        future.addCallback(result -> {
            if (result != null) {
                log.info("Message delivered in partition {} with offset {}",
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            }
        }, (KafkaFailureCallback<Integer, String>) ex -> log.error("Unable to deliver message {}", ex.getMessage()));
    }
}
