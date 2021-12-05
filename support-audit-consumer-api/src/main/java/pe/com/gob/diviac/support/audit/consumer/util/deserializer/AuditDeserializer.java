package pe.com.gob.diviac.support.audit.consumer.util.deserializer;

import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.common.serialization.Deserializer;

import pe.com.gob.diviac.support.audit.consumer.entity.Audit;
import pe.com.gob.diviac.support.audit.consumer.util.ByteUtils;

@Slf4j
public class AuditDeserializer implements Deserializer<Audit> {

    @Override
    public Audit deserialize(String s, byte[] bytes) {
        return ByteUtils.toObject(bytes, Audit.class);
    }
}
