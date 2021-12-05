package pe.com.gob.diviac.support.audit.producer.util.serializer;

import lombok.extern.slf4j.Slf4j;

import org.apache.kafka.common.serialization.Serializer;
import pe.com.gob.diviac.support.audit.producer.entity.Audit;
import pe.com.gob.diviac.support.audit.producer.util.JsonUtils;

@Slf4j
public class AuditSerializer implements Serializer<Audit> {

    @Override
    public byte[] serialize(String s, Audit audit) {
        return JsonUtils.toBytes(audit);
    }
}
