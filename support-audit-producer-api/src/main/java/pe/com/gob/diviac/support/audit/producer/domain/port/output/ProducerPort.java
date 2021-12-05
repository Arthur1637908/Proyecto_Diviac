package pe.com.gob.diviac.support.audit.producer.domain.port.output;

import pe.com.gob.diviac.support.audit.producer.entity.Audit;

public interface ProducerPort {

    void produceAuditMessage(Audit audit);
}
